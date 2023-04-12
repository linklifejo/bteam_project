package willgo;

import java.util.HashMap;
import java.util.List;

public interface WillgoService {
	//CRUD(Create, Read, Update, Delete)
	int willgo_insert(HashMap<String, Object> map);		
	int willgo_insert(WillgoVO vo);		
	List<WillgoVO> willgo_list();	
	WillgoVO willgo_info(int id);		
	int willgo_update(WillgoVO vo);		
	int willgo_delete(int id); 	
	List<WillgoVO> willgo_list(String member_id);	
}
