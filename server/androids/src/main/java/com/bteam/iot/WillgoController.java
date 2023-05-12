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

import common.CommonUtility;
import gone.GoneFileVO;
import gone.GoneServiceImpl;
import gone.GoneVO;
import gone.HomeVO;
import location.LocationVO;
import willgo.WillgoServiceImpl;
import willgo.WillgoVO;
import willgo.WillgoServiceImpl;

@Controller
public class WillgoController {
	@Autowired
	private WillgoServiceImpl service;

	// 신규고객등록처리 요청
	@RequestMapping("/insert.wi")
	public String insert(WillgoVO vo) {
		// 화면에서 입력한 정보로 DB에 신규삽입저장한다.
		service.willgo_insert(vo);
		// 응답화면연결 - 고객목록
		return "redirect:list.wi";
	}

	// 신규고객등록화면 요청
	@RequestMapping("/new.wi")
	public String willgo() {
		return "willgo/new";
	}

	// 선택한 고객정보 수정저장처리 요청
	@RequestMapping("/update.wi")
	public String update(WillgoVO vo) {
		// 화면에서 변경입력한 정보를 DB에 변경저장한다
		service.willgo_update(vo);
		// 응답화면연결-고객정보
		return "redirect:info.wi?id=" + vo.getId();
	}

	// 선택한 고객정보 수정화면 요청
	@RequestMapping("/modify.wi")
	public String modify(Model model, int id) {
		// 선택한 고객정보를 DB에서 조회해와
		WillgoVO vo = service.willgo_info(id);
		// 고객수정화면에서 조회한 정보를 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo", vo);
		// 응답화면연결 - 고객수정
		return "willgo/modify";
	}

	// 선택한 고객정보 삭제처리 요청
	@RequestMapping("/delete.wi")
	public String delete(int id) {
		// 선택한 고객정보를 DB에서 삭제
		service.willgo_delete(id);
		// 응답화면연결 - 고객목록
		return "redirect:list.wi";
	}

	// 선택한 고객정보화면 요청
	@RequestMapping("/info.wi")
	public String info(int id, Model model) {
		// 해당 고객정보를 DB에서 조회해온다
		WillgoVO vo = service.willgo_info(id);
		// 화면에 출력할 수 있도록 Model에 attribute로 담는다
		model.addAttribute("vo", vo);

		// 응답화면연결
		return "willgo/info";
	}

	// 고객목록화면 요청
	@RequestMapping("/list.wi")
	public String list(Model model, HttpSession session) {
		session.setAttribute("category", "lo");
		List<WillgoVO> list = service.willgo_list();
		model.addAttribute("list", list);
		return "willgo/list";
	}

	@Autowired private GoneServiceImpl gone;
	
	
	
	
	
	@ResponseBody @RequestMapping(value="/willGoIn", produces="text/plain; charset=utf-8" )
	public String willGoIns(HttpServletRequest req, Model model) {
		String wtype = (String) req.getParameter("wtype");		
		String member_id = (String) req.getParameter("member_id");
		Integer refid = Integer.valueOf(req.getParameter("refid"));
		
		String jjim = (String) req.getParameter("jjim");
		Integer id = Integer.valueOf(req.getParameter("refid"));
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("wtype", wtype);
		map.put("member_id", member_id);
		map.put("refid", refid);
		
		
		WillgoVO vo =(WillgoVO) service.willgo_info(map);
		
			 
				GoneFileVO file = service.gone_file_info(refid);
				if(file != null) map.put("filepath", file.getFilepath());
				
				GoneVO go = (GoneVO)service.gone_info(refid);
				if(go != null) {
					LocationVO loc = (LocationVO)service.location_info(go.getLocation_id());
					if(loc != null) 	map.put("locname", loc.getLocname());
					
				}
				
				if(jjim.equals("0") ) {
					service.willgo_delete(id);
					}
				
				else{
						service.willgo_insert(map);	
					}
				
				HashMap<String,Object> map1 = new HashMap<String, Object>();
				map1.put("id", refid);
				map1.put("jjim", jjim);
				gone.gone_jjimupdate(map1);
				
				GoneVO voo = service.gone_info(id);
				
			
				Gson gson = new Gson();
				return gson.toJson( (GoneVO)voo );		
		}
		

	

	
	@ResponseBody @RequestMapping(value="/willGo", produces="text/plain; charset=utf-8" )
	public String willGo(HttpServletRequest req, Model model) {
		String member_id = (String) req.getParameter("member_id");		
		
		
		
		
		
		
		

		ArrayList<WillgoVO> list = (ArrayList<WillgoVO>)service.willgo_list(member_id);
		
		Gson gson = new Gson();
		return gson.toJson( (ArrayList<WillgoVO>)list );	
	}
	
	
	@ResponseBody @RequestMapping(value="/willGoDelete", produces="text/plain; charset=utf-8" )
	public String willGoDelete(HttpServletRequest req, Model model) {
	
		Integer id = Integer.valueOf(req.getParameter("id")) ;
		return service.willgo_delete(id) == 1 ? "성공" : "실패";
	}
	
	// 산 정보검색
	@ResponseBody @RequestMapping(value="/willGoQuery", produces="text/plain; charset=utf-8" )
	public String willGoQuery(HttpServletRequest req, Model model) {
		String wtype = (String) req.getParameter("wtype");	
		Integer id = Integer.valueOf(req.getParameter("id")) ;
		if(wtype.equals("2")) {
			LocationVO vo = service.location_info(id);
			Gson gson = new Gson();
			return gson.toJson( (LocationVO)vo );		
		}else {
			GoneVO vo = service.gone_info(id);
			Gson gson = new Gson();
			return gson.toJson( (GoneVO)vo );		
		}

	}
}
