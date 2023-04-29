package com.hanul.iot;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import customer.CustomerServiceImpl;
import customer.CustomerVO;
import weather.WeatherServiceImpl;
import weather.WeatherVO;

@Controller
public class WeatherController {
	@Autowired private WeatherServiceImpl service;
		
	
	
	
	//선택한 고객정보화면 요청
	@RequestMapping("/info.we")
	public String info(Model model, HttpSession session ) {
		//해당 고객정보를 DB에서 조회해온다
		WeatherVO vo = service.weather_info();
		//화면에 출력할 수 있도록 Model에 attribute로 담는다
		model.addAttribute("vo", vo);
		
		//응답화면연결
		return "";
	}
	
	
	//고객목록화면 요청
	@RequestMapping("/")
	public String list(Model model, HttpSession session ) {
		session.setAttribute("category", "we");
		List<WeatherVO> list = service.weather_list();
		model.addAttribute("list", list);
		return "home";
	}
}
