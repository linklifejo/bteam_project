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


	//고객목록화면 요청
	@RequestMapping("/list.re")
	public String list(Model model, HttpSession session ) {
		session.setAttribute("category", "ro");
		List<LocationVO> list = service.location_list();
		model.addAttribute("list", list);
		return "region/list";
	}
	
}
