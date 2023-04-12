package willgo;

import java.util.HashMap;
import java.util.List;

import gone.GoneFileVO;
import gone.GoneVO;
import location.LocationVO;

public interface WillgoService {
	//CRUD(Create, Read, Update, Delete)
	int willgo_insert(HashMap<String, Object> map);		
	int willgo_insert(WillgoVO vo);		
	List<WillgoVO> willgo_list();	
	WillgoVO willgo_info(int id);		
	WillgoVO willgo_info(HashMap<String, Object> map);	
	int willgo_update(WillgoVO vo);		
	int willgo_delete(int id); 	
	List<WillgoVO> willgo_list(String member_id);	
	LocationVO location_info(int id);
	GoneFileVO gone_file_info(int id); //첨부파일정보 조회
	GoneVO gone_info(int id); //첨부파일정보 조회
}
