package location;

import java.util.List;

import gone.GoneFileVO;

public interface LocationService {
	//CRUD(Create, Read, Update, Delete)
	int location_insert(LocationVO vo);		
	List<LocationVO> location_list();		
	LocationVO location_info(int id);		
	int location_update(LocationVO vo);		
	int location_delete(int id);
	List<LocationVO> Loc_info();
	List<LocationVO> location_list(String local);// 지역별산
	List<LocationVO> local_list();// 지역별산
	List<LocationVO> local2_list();// 지역별산
	List<LocationVO> local3_list();// 지역별산
	List<LocationVO> local4_list();// 지역별산
	List<LocationVO> local5_list();// 지역별산
	List<LocationVO> local6_list();// 지역별산
}
