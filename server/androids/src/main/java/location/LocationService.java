package location;

import java.util.List;

public interface LocationService {
	//CRUD(Create, Read, Update, Delete)
	int location_insert(LocationVO vo);		
	List<LocationVO> location_list();	
	LocationVO location_info(int id);		
	int location_update(LocationVO vo);		
	int location_delete(int id); 	
	List<LocationVO> location_list(String local);	
	
	
	
	
	List<LocationVO> location_search_list(String search);	
}
