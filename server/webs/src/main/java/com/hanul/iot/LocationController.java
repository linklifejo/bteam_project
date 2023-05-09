package com.hanul.iot;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import common.CommonUtility;
import gone.GoneFileVO;
import gone.GoneVO;
import location.LocationServiceImpl;
import location.LocationVO;
import member.MemberServiceImpl;
import member.MemberVO;
import notice.NoticePageVO;
import notice.NoticeVO;

@Controller
public class LocationController {
	@Autowired private LocationServiceImpl service;
	
	
	//신규고객등록처리 요청
	@RequestMapping("/insert.lo")
	public String insert(LocationVO vo, MultipartFile file
			, HttpServletRequest request) {
		//첨부파일 처리
		if( file != null ) {
			LocationVO vo1 = attached_file(file, request);
			vo.setFilename(vo1.getFilename());
			vo.setFilepath(vo1.getFilepath());
		}
		//화면에서 입력한 정보로  DB에 신규삽입저장한다.
		service.location_insert(vo);
		//응답화면연결 - 고객목록
		return "redirect:list.lo";
	}
	
	//첨부한 파일정보 관리
	private LocationVO attached_file(MultipartFile file
								, HttpServletRequest request) {
		LocationVO vo = null;
		
			if( file.isEmpty() ) return null;
			if(vo==null) vo = new LocationVO();
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( 
					common.fileUpload(file, "location", request) );
	
		return vo;
	}
	
	@Autowired private CommonUtility common;
	@Autowired private MemberServiceImpl member;
	
	//신규고객등록화면 요청
	@RequestMapping("/new.lo")
	public String location(HttpSession session) {
		String id = "asdasd", pw ="ASDasd123";
		String salt = member.member_salt(id);
		pw = common.getEncrypt(pw, salt);
		
		//화면에서 입력한 아이디/비번이 일치하는 회원정보를 조회해온다
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		MemberVO vo = member.member_login(map);
		/* session.setAttribute("loginInfo", vo); */
		return "location/new";
	}

	//선택한 공지글수정저장처리 요청
	@RequestMapping("/update.lo")
	public String update(LocationVO vo
						, MultipartFile file
						, HttpServletRequest request) throws Exception{
		LocationVO location = service.location_info( vo.getId() );
		
		//파일 첨부하지 않는 경우
		if( file==null || file.isEmpty() ) {
			if( vo.getFilename()==null || vo.getFilename().isEmpty() ) {				
				//원래 첨부파일 X --> 첨부X
				//원래 첨부파일 O --> 첨부X
				common.file_delete(location.getFilepath(), request);
				
			}else {
				//원래 첨부파일 O --> 그대로 사용: 원래 정보로 담아둔다
				vo.setFilename( location.getFilename() );
				vo.setFilepath( location.getFilepath() );
			}
		
		}else {
		//파일 첨부하는 경우
		//원래 첨부파일 X --> 첨부
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( common.fileUpload(file, "location", request) );
			
		//원래 첨부파일 O --> 바꿔 첨부
			common.file_delete(location.getFilepath(), request);
		}
		
		//화면에서 변경입력한 정보로 DB에 변경저장한다
		service.location_update(vo);
		//공지글안내화면연결
		return "redirect:info.lo?id="+ vo.getId();
	}
	
	
	
	//선택한 고객정보 수정화면 요청
	@RequestMapping("/modify.lo")
	public String modify(Model model, int id) {
		//선택한 고객정보를 DB에서 조회해와
		LocationVO vo = service.location_info(id);
		//고객수정화면에서 조회한 정보를 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo", vo);
		//응답화면연결 - 고객수정
		return "location/modify";
	}
	
	
	//선택한 고객정보 삭제처리 요청
	@RequestMapping("/delete.lo")
	public String delete(int id) {
		//선택한 고객정보를 DB에서 삭제
		service.location_delete(id);
		//응답화면연결 - 고객목록
		return "redirect:list.lo";
	}
	
	
	//선택한 고객정보화면 요청
	@RequestMapping("/info.lo")
	public String info(int id, Model model) {
		//해당 고객정보를 DB에서 조회해온다
		LocationVO vo = service.location_info(id);
		//화면에 출력할 수 있도록 Model에 attribute로 담는다
		model.addAttribute("vo", vo);
		
		//응답화면연결
		return "location/info";
	}
	
	
	//고객목록화면 요청
	@RequestMapping("/list.lo")
	public String list(Model model, HttpSession session ) {
		session.setAttribute("category", "lo");
		List<LocationVO> list = service.location_list();
		model.addAttribute("list", list);
		return "location/list";
	}
	
	
	
//	// 지역별 화면 요청
//	@ResponseBody @RequestMapping(value="/selectLocal", produces="text/plain; charset=utf-8" )
//	public String selectLocal(HttpServletRequest req, Model model) {
//		String loccode = (String) req.getParameter("loccode");	
//		List<LocationVO> list = service.location_list(loccode);
//		
//		return "region_1./list";		
//	}
//	
	
	
	
	
}
