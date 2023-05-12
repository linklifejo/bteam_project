package location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.CourseVO;
import gone.GoneFileVO;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired private LocationDAO dao;
	
	
	@Override
	public int location_insert(LocationVO vo) {
		return dao.location_insert(vo);
	}

	@Override
	public List<LocationVO> location_list() {
		return dao.location_list();
	}

	@Override
	public LocationVO location_info(int id) {
		return dao.location_info(id);
	}

	@Override
	public int location_update(LocationVO vo) {
		return dao.location_update(vo);
	}

	@Override
	public int location_delete(int id) {
		return dao.location_delete(id);
	}

	@Override
	public List<LocationVO> Loc_info() {
		return dao.Loc_info();
	}

	@Override
	public List<LocationVO> location_list(String local) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocationVO> local_list(String loccode) {
		return dao.local_list(loccode);
	}

	@Override
	public List<CourseVO> course_info(int id) {
		return dao.course_info(id);
	}


}
