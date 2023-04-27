package com.bteam.iot;

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

import com.google.gson.Gson;

import gone.GoneFileVO;
import gone.GoneVO;
import gone.HomeVO;
import location.LocationVO;
import stamp.StampServiceImpl;
import stamp.StampVO;
import willgo.WillgoServiceImpl;
import willgo.WillgoVO;
import willgo.WillgoServiceImpl;

@Controller
public class StampController {
	@Autowired
	private StampServiceImpl service;

	// 선택한 고객정보 삭제처리 요청
	@RequestMapping("/delete.st")
	public String delete(int id) {
		// 선택한 고객정보를 DB에서 삭제
		service.stamp_delete(id);
		// 응답화면연결 - 고객목록
		return "redirect:list.wi";
	}



	@ResponseBody @RequestMapping(value="/stampIn", produces="text/plain; charset=utf-8" )
	public String stampIn(HttpServletRequest req, Model model) {
		String ip = (String) req.getParameter("ip");		
		String member_id = (String) req.getParameter("member_id");
		System.out.println("member_id> "+req.getParameter("member_id"));
		if( member_id.equals("undefined") ) return "스템프실패";
		
		System.out.println("location_id> "+req.getParameter("location_id"));
		System.out.println("course_id> "+req.getParameter("course_id"));
		System.out.println("loccode> "+req.getParameter("loccode"));
		System.out.println("location_id> "+req.getParameter("location_id"));
		
		Integer location_id = Integer.valueOf(req.getParameter("location_id")) ;
		Integer course_id = Integer.valueOf(req.getParameter("course_id")) ;
		String loccode = (String) req.getParameter("loccode");
	
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("ip", ip);
		map.put("member_id", member_id);
		map.put("location_id", location_id);
		map.put("course_id", course_id);
	
		
		StampVO vo =(StampVO) service.stamp_info(map);
		if(vo != null) 	return "존재합니다";
		map.put("loccode", loccode);		
			return service.stamp_insert(map) == 1 ? "스템프성공" : "스템프실패";
		}
	@ResponseBody @RequestMapping(value="/stampInfo")
	public Object stampInfo(HttpServletRequest req, Model model) {
		System.out.println("stampInfo");
//		 ip=result.ip;"; 
//	     s += " ip=result.member_id;"; 
//	     s += " ip=result.location_id;";
//	     s += " ip=result.course_id;";
//	     s += " ip=result.loccode
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("ip", "192.168.0.3");
		map.put("member_id", "linklife");
		map.put("location_id", "1111");
		map.put("course_id", "1111");
		map.put("loccode", "L01");
		
		Gson gson = new Gson();		
		return gson.toJson( map );	
			
//			return map;
//			return service.stamp_insert(map) == 1 ? "스템프성공" : "스템프실패";
		}		

	
	
}
