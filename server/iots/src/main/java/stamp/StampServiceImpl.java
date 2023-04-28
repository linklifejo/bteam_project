package stamp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.CourseVO;
import location.LocationVO;

@Service
public class StampServiceImpl implements StampService {

	@Autowired private StampDAO dao;

	@Override
	public int stamp_delete(int id) {
		return dao.stamp_delete(id);
	}


	@Override
	public int stamp_insert(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.stamp_insert(map);
	}


	@Override
	public StampVO stamp_info(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.stamp_info(map);
	}



}
