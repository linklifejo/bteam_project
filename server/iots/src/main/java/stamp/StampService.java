package stamp;

import java.util.HashMap;
import java.util.List;

import course.CourseVO;
import location.LocationVO;

public interface StampService {

	int stamp_insert(HashMap<String,Object> map);//스템프 새글저장
	int stamp_delete(int id); //선택한스템프 삭제
	StampVO stamp_info(HashMap<String,Object> map);		
}
