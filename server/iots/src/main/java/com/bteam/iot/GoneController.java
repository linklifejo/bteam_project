package com.bteam.iot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;

import com.google.gson.Gson;

import common.CommonUtility;
import course.CourseServiceImpl;
import course.CourseVO;
import gone.GoneCommentVO;
import gone.GoneFileVO;
import gone.GonePageVO;
import gone.GoneServiceImpl;
import gone.GoneVO;
import gone.HomeVO;
import location.LocationVO;

@Controller
public class GoneController {
	@Autowired
	private GoneServiceImpl service;


	// 방명록 새글신규저장처리 요청
	@RequestMapping("/insert.go")
	public String insert(GoneVO vo, MultipartFile[] file, HttpServletRequest request) {
		// 첨부파일 처리
		if (file.length > 1) {
			List<GoneFileVO> list = attached_file(file, request);
			vo.setFileInfo(list);
		}
		// 화면에서 입력한 정보로 DB에 신규저장
		service.gone_insert(vo);
		// 화면연결
		return "redirect:list.go";
	}

	@Autowired
	private CommonUtility common;

	// 첨부한 파일정보 관리
	private List<GoneFileVO> attached_file(MultipartFile[] file, HttpServletRequest request) {
		List<GoneFileVO> list = null;
		for (MultipartFile attached : file) {
			if (attached.isEmpty())
				continue;
			if (list == null)
				list = new ArrayList<GoneFileVO>();
			GoneFileVO fileVO = new GoneFileVO();
			fileVO.setFilename(attached.getOriginalFilename());
			fileVO.setFilepath(common.fileUpload(attached, "gone", request));
			list.add(fileVO);
		}
		return list;
	}

	// 방명록 첨부파일 다운로드 요청
	@RequestMapping("/download.go")
	public void download(int file, HttpServletRequest req, HttpServletResponse res) {
		// 해당 첨부파일정보를 DB에서 조회해온다
		GoneFileVO vo = service.gone_file_info(file);
		// 다운로드 처리한다
		common.fileDownload(vo.getFilename(), vo.getFilepath(), req, res);
	}

	// 방명록 글 수정저장처리 요청
	@RequestMapping("/update.go")
	public String update(int id, GonePageVO page, Model model, GoneVO vo, String removed, HttpServletRequest request,
			MultipartFile[] file) {
		// 첨부되어진 파일이 있다면 해당 파일 정보를 저장한다
		List<GoneFileVO> files = attached_file(file, request); // 파일목록
		vo.setFileInfo(files);

		// 화면에서 변경입력한 정보로 DB에 변경저장한다
		service.gone_update(vo);

		// 삭제하려는 대상파일정보 조회
		if (!removed.isEmpty()) {
			List<GoneFileVO> remove_files = service.gone_removed_file(removed);

			// DB에서 삭제 + 물리적인 파일 삭제
			if (service.gone_file_delete(removed) > 0) {
				for (GoneFileVO f : remove_files) {
					common.file_delete(f.getFilepath(), request);
				}
			}
		}

		// 화면연결 - 정보화면
		model.addAttribute("url", "info.go");
		model.addAttribute("page", page);
		model.addAttribute("id", id);
		return "gone/redirect";
	}

	// 방명록 글 수정화면 요청
	@RequestMapping("/modify.go")
	public String modify(Model model, int id, GonePageVO page) {
		// 선택한 글정보를 DB에서 조회한다.
		GoneVO vo = service.gone_info(id);
		// 화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		return "gone/modify";
	}

	// 방명록 글 삭제처리 요청
	@RequestMapping("/delete.go")
	public String delete(int id, GonePageVO page, Model model, HttpServletRequest request) {
		// 첨부파일정보를 조회해둔다
		List<GoneFileVO> files = service.gone_info(id).getFileInfo();

		// 선택한 글을 DB에서 삭제한다
		if (service.gone_delete(id) == 1) {
			// 첨부되어진 파일을 물리적으로 저장된 영역에서 삭제한다
			for (GoneFileVO vo : files) {
				common.file_delete(vo.getFilepath(), request);
			}
		}

		// 응답화면연결 - 목록
		// redirect 화면에서 출력할 정보를 Model에 담는다
		model.addAttribute("url", "list.go");
		model.addAttribute("id", id);
		model.addAttribute("page", page);
		return "gone/redirect";
	}

	// 방명록 새글쓰기화면 요청
	@RequestMapping("/new.go")
	public String gone(Model model) {
		List<location.LocationVO> vo = service.location_list();
		model.addAttribute("location", vo);
		List<course.CourseVO> co = service.course_list();
		model.addAttribute("course", co);
		return "gone/regist";
	}

	// 선택한 방명록 글화면 요청
	@RequestMapping("/info.go")
	public String info(Model model, int id, GonePageVO page) {
		// 조회수처리
		service.gone_read(id);
		// 선택한 글의 정보를 DB에서 조회해온다
		GoneVO vo = service.gone_info(id);
		// 화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("page", page);
		model.addAttribute("vo", vo);
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		return "gone/info";
	}

	// 방명록 댓글목록 조회 요청
	@RequestMapping("/gone/comment/list/{id}")
	public String gone_comment_list(@PathVariable int id, Model model) {
		// 해당 방명록글에 대한 댓글목록을 DB에서 조회해온다
		List<GoneCommentVO> list = service.gone_comment_list(id);
		// 화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("list", list);
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		return "gone/comment/comment_list";
	}

	// 방명록 댓글 삭제처리 요청
	@ResponseBody
	@RequestMapping("/gone/comment/delete/{id}")
	public void gone_comment_delete(@PathVariable int id) {
		// 선택한 댓글을 DB에서 삭제
		service.gone_comment_delete(id);
	}

	// 방명록 댓글 변경저장처리 요청
	@ResponseBody
	@RequestMapping(value = "/gone/comment/update", produces = "application/text; charset=utf-8")
	public String gone_comment_update(@RequestBody GoneCommentVO vo) {
		return service.gone_comment_update(vo) == 1 ? "성공" : "실패";
	}

	// 방명록 댓글 저장처리 요청
	@ResponseBody
	@RequestMapping("/gone/comment/insert")
	public boolean gone_comment_regist(GoneCommentVO vo) {
		// 화면에서 입력한 댓글정보로 DB에 신규저장
		return service.gone_comment_regist(vo) == 1 ? true : false;
	}

	// 방명록 목록화면 요청
	@RequestMapping("/list.go")
	public String gone(Model model, HttpSession session, GonePageVO page) {
//		// 임의로 관리자로 로그인해 둔다 -----------------
//		HashMap<String, String> map = new HashMap<String, String>();
//		String id = "linklife";
//		map.put("id", id);		
//		map.put("pw", "456852aa**");
//		String salt = member.member_salt(id);
//		map.put("pw", common.getEncrypt(map.get("pw"), salt) );
//		
//		MemberVO vo = member.member_login( map);
//		//session.setAttribute("loginInfo", vo);
//		//-----------------------------------------

		session.setAttribute("category", "go");
		// DB에서 방명록 목록을 조회해온다
		page = service.gone_list(page);
		// 화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("page", page);
		return "gone/list";
	}

	@ResponseBody @RequestMapping(value="/selectHome", produces="text/plain; charset=utf-8" )
	public String selectHome(HttpServletRequest req, Model model) {
		String type = (String) req.getParameter("type");		
		String ptype = (String) req.getParameter("ptype");
		Integer num = Integer.valueOf(req.getParameter("num")) ;
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("ptype", ptype);		
		map.put("num", num);	
		ArrayList<HomeVO> list = (ArrayList<HomeVO>)service.homeList(map);
		
		//model.addAttribute("list", list);
		Gson gson = new Gson();
		return gson.toJson( (ArrayList<HomeVO>)list );		
		
	}
	@ResponseBody @RequestMapping(value="/selectmou", produces="text/plain; charset=utf-8" )
	public String selectmou(HttpServletRequest req, Model model) {
		String type = (String) req.getParameter("type");		
		String ptype = (String) req.getParameter("ptype");
		Integer num = Integer.valueOf(req.getParameter("num")) ;
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("ptype", ptype);		
		map.put("num", num);	
		ArrayList<HomeVO> list = (ArrayList<HomeVO>)service.homeList(map);
		
		//model.addAttribute("list", list);
		Gson gson = new Gson();
		return gson.toJson( (ArrayList<HomeVO>)list );		
		
	}
//	// 지역별 이미지및 정보 가져오기
//	@ResponseBody @RequestMapping(value="/localImage", produces="text/plain; charset=utf-8" )
//	public String selectImage(HttpServletRequest req, Model model) {
//		
//		ArrayList<LocationVO> list = (ArrayList<LocationVO>) service.location_image_list();
//	
//		Gson gson = new Gson();
//		return gson.toJson( (ArrayList<LocationVO>) list );		
//		
//	}
	// 지역별 이미지및 정보 가져오기
	@ResponseBody @RequestMapping(value="/selectLocalx", produces="text/plain; charset=utf-8" )
	public String selectLocal(HttpServletRequest req, Model model) {
		String loccode = (String) req.getParameter("loccode");		
		List<GoneVO> list = service.gone_local_list(loccode);
	
		Gson gson = new Gson();
		return gson.toJson( (ArrayList<GoneVO>)list );		
		
	}
	@ResponseBody @RequestMapping(value="/localGo", produces="text/plain; charset=utf-8" )
	public String localGo(HttpServletRequest req, Model model) {
		String type = (String) req.getParameter("type");		
		String title = (String) req.getParameter("title");
		String content = (String) req.getParameter("content");
		String member_id = (String) req.getParameter("member_id");
		String loccode = (String) req.getParameter("loccode");
		Integer location_id = Integer.valueOf(req.getParameter("location_id")) ;
		CourseVO co =service.course_info(location_id);
		Integer course_id = co.getId() ;
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("title", title);	
		map.put("content", content);
		map.put("member_id", member_id);
		map.put("loccode", loccode);
		map.put("location_id", location_id);	
		map.put("course_id", course_id);	

		return service.gone_insert(map) == 1 ? "성공" : "실패";
	}	
	


	@ResponseBody @RequestMapping(value="/bolist", produces="text/plain; charset=utf-8" )
	public String bolist(HttpServletRequest req, Model model) {	

		ArrayList<GoneVO> list = (ArrayList<GoneVO>)service.bolist();
		
		Gson gson = new Gson();
		return gson.toJson( (ArrayList<GoneVO>)list );	
	}
	
	
		
	
	
}
