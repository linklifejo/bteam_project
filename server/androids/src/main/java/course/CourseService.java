package course;

import java.util.List;

import location.LocationVO;

public interface CourseService {
	//CRUD(Create, Read, Update, Delete)
	int course_insert(CourseVO vo);		
	
	
	
	List<CourseVO> course_list(int location_id);
	
	
	
	List<LocationVO> location_search_list(String search);
	
	CourseVO course_info(int id);	
	
	
	CourseVO course_info(String s);	
	int course_update(CourseVO vo);		
	int course_delete(int id); 	
	List<LocationVO> location_list();	
	
}
