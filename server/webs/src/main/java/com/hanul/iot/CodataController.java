package com.hanul.iot;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.CommonUtility;

@Controller
public class CodataController {
	//공공데이터 키
	private String key = 
			"FPgj2NXbJw46TcGkmAfZEiYFDbxilys7KLjk3KaB7AfeJE00ZhPNM0M8unwbsI69fSmT8SNfVEimE6ZZ2U14hA%3D%3D";
		
	@Autowired private CommonUtility common;
	private String courseURL 
		= "http://api.forest.go.kr/openapi/service/trailInfoService/getforestspatialdataservice/";
	
	
	//코스 정보조회 요청
	@ResponseBody @RequestMapping("/codata/course")
	public Object course_list( int pageNo, int rows ) {
		StringBuffer url = new StringBuffer( courseURL + "mntninfourl" );
		url.append("?ServiceKey=").append(key);
		url.append("&_type=json");
		url.append("&pageNo=").append( pageNo );
		url.append("&numOfRows=").append( rows );
		return common.requestAPItoMap(url);
	}

	
	//공공데이터 목록화면 요청
	@RequestMapping("/list.da")
	public String list(HttpSession session) {
		session.setAttribute("category", "da");
		return "data/list";
	}
}
