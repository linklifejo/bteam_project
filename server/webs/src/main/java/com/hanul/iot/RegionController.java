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
	public String local_list(Model model, HttpSession session ) {
		session.setAttribute("category", "re");
		List<LocationVO> local_list = service.local_list();
		model.addAttribute("local_list", local_list);
		return "region/list";	
	}
	//지역별산 화면 요청
	@RequestMapping("/list2.re2")
	public String local2_list(Model model, HttpSession session ) {
		session.setAttribute("category", "re2");
		List<LocationVO> local2_list = service.local2_list();
		model.addAttribute("local2_list", local2_list);
		return "region/list2";	
	}
	//지역별산 화면 요청
	@RequestMapping("/list3.re3")
	public String local3_list(Model model, HttpSession session ) {
		session.setAttribute("category", "re3");
		List<LocationVO> local3_list = service.local3_list();
		model.addAttribute("local3_list", local3_list);
		return "region/list3";	
	}
	//지역별산 화면 요청
	@RequestMapping("/list4.re4")
	public String local4_list(Model model, HttpSession session ) {
		session.setAttribute("category", "re4");
		List<LocationVO> local4_list = service.local4_list();
		model.addAttribute("local4_list", local4_list);
		return "region/list4";	
	}
	//지역별산 화면 요청
	@RequestMapping("/list5.re5")
	public String local5_list(Model model, HttpSession session ) {
		session.setAttribute("category", "re5");
		List<LocationVO> local5_list = service.local5_list();
		model.addAttribute("local5_list", local5_list);
		return "region/list5";	
	}
	//지역별산 화면 요청
	@RequestMapping("/list6.re6")
	public String local6_list(Model model, HttpSession session ) {
		session.setAttribute("category", "re6");
		List<LocationVO> local6_list = service.local6_list();
		model.addAttribute("local6_list", local6_list);
		return "region/list6";	
	}
	
	
	//선택한 고객정보화면 요청
	@RequestMapping("/info.re")
	public String info(int id, Model model) {
		//해당 고객정보를 DB에서 조회해온다
		LocationVO vo = service.location_info(id);
		//화면에 출력할 수 있도록 Model에 attribute로 담는다
		model.addAttribute("vo", vo);
		
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
