package com.hanul.iot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import common.CommonUtility;
import course.CourseVO;
import location.LocationVO;
import notice.NoticeVO;
import course.CourseServiceImpl;

@Controller
public class CourseController {
	@Autowired private CourseServiceImpl service;
		

	@Autowired private CommonUtility common;
	//신규공지글 저장처리 요청
	@RequestMapping("/insert.co")
	public String insert(CourseVO vo, MultipartFile file
						, HttpServletRequest request) {
		//첨부파일이 있는 경우 서버의 물리적영역에 첨부된 파일을 저장
		//첨부된 파일을 물리적으로 어디에, 어떤이름으로 저장했는지를 DB에 저장
		if( ! file.isEmpty() ) {
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( 
					common.fileUpload(file, "course", request) );
		}
		
		//화면에서 입력한 정보로 DB에 신규저장
		service.course_insert(vo);
		//응답화면연결 -목록
		return "redirect:list.co";
	}
	
	//신규고객등록화면 요청
	@RequestMapping("/new.co")
	public String course(Model model) {
		List<LocationVO> list = service.location_list();
		model.addAttribute("list", list);
		return "course/new";
	}
	

	
	//선택한 고객정보 수정화면 요청
	@RequestMapping("/modify.co")
	public String modify(Model model, int id) {
		//선택한 고객정보를 DB에서 조회해와
		CourseVO vo = service.course_info(id);
		List<LocationVO> list = service.location_list();
		//고객수정화면에서 조회한 정보를 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		//응답화면연결 - 고객수정
		return "course/modify";
	}
	

	@RequestMapping("/update.co")
	public String update(CourseVO vo
						, MultipartFile file
						, HttpServletRequest request) throws Exception{
		CourseVO course = service.course_info( vo.getId() );
		
		//파일 첨부하지 않는 경우
		if( file==null || file.isEmpty() ) {
			if( vo.getFilename()==null || vo.getFilename().isEmpty() ) {				
				//원래 첨부파일 X --> 첨부X
				//원래 첨부파일 O --> 첨부X
				common.file_delete(course.getFilepath(), request);
				
			}else {
				//원래 첨부파일 O --> 그대로 사용: 원래 정보로 담아둔다
				vo.setFilename( course.getFilename() );
				vo.setFilepath( course.getFilepath() );
			}
		
		}else {
		//파일 첨부하는 경우
		//원래 첨부파일 X --> 첨부
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( common.fileUpload(file, "course", request) );
			
		//원래 첨부파일 O --> 바꿔 첨부
			common.file_delete(course.getFilepath(), request);
		}
		
		//화면에서 변경입력한 정보로 DB에 변경저장한다
		service.course_update(vo);
		//공지글안내화면연결
		return "redirect:info.co?id="+ vo.getId();
	}
	
	//선택한 고객정보 삭제처리 요청
	@RequestMapping("/delete.co")
	public String delete(int id) {
		//선택한 고객정보를 DB에서 삭제
		service.course_delete(id);
		//응답화면연결 - 고객목록
		return "redirect:list.co";
	}
	
	
	//선택한 고객정보화면 요청
	@RequestMapping("/info.co")
	public String info(int id, Model model) {
		//해당 고객정보를 DB에서 조회해온다
		CourseVO vo = service.course_info(id);
		//화면에 출력할 수 있도록 Model에 attribute로 담는다
		model.addAttribute("vo", vo);
		
		//응답화면연결
		return "course/info";
	}
	
	//고객목록화면 요청
	@RequestMapping("/list.co")
	public String list(Model model, HttpSession session ) {
		session.setAttribute("category", "cu");
		List<CourseVO> list = service.course_list();
		model.addAttribute("list", list);
		return "course/list";
	}
}
