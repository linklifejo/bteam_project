package location;

import java.util.List;

public interface LocationService {
	//CRUD(Create, Read, Update, Delete)
	int location_insert(LocationVO vo);		
	List<LocationVO> location_list();	
	List<LocationVO> location_local_list(String s);	
	LocationVO location_info(int id);		
	List<LocationVO> location_image_list();	
	int location_update(LocationVO vo);		
	int location_delete(int id); 			
}
