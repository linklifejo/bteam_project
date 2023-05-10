package com.hanul.iot;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import common.CommonUtility;
import course.CourseVO;
import gone.GoneFileVO;
import gone.GonePageVO;
import gone.GoneServiceImpl;
import location.LocationServiceImpl;
import location.LocationVO;
import member.MemberServiceImpl;


/**
 * Handles requests for the application home page.
 */
@Controller
public class RegionController {
	@Autowired private LocationServiceImpl service;


	//지역별산 화면 요청
	@RequestMapping("/list.re")
	public String local_list(String loccode, Model model, HttpSession session ) {
		session.setAttribute("category", "re");
		List<LocationVO> local_list = service.local_list(loccode);
		model.addAttribute("local_list", local_list);
		return "region/list";	
	}
	
	
	//선택한 고객정보화면 요청
	@RequestMapping("/info.re")
	public String info(int id, int location_id, Model model) {
		//해당 고객정보를 DB에서 조회해온다
		LocationVO vo = service.location_info(id);

		CourseVO cou = service.course_info(location_id);
		//화면에 출력할 수 있도록 Model에 attribute로 담는다
				
		model.addAttribute("vo", vo);
		model.addAttribute("cou", cou);
		//응답화면연결
		return "region/info";
	}
	
//	//선택한 고객정보화면 요청
//	@RequestMapping("/info.re")
//	public String local_info(Model model, HttpSession session ) {
//		//해당 고객정보를 DB에서 조회해온다
//		List<LocationVO> vo = service.Loc_info();
//		//화면에 출력할 수 있도록 Model에 attribute로 담는다
//		model.addAttribute("vo", vo);
//		
//		//응답화면연결
//		return "region/info";
//	}
	
}
