package gone;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.CourseVO;
import location.LocationVO;

@Service
public class GoneServiceImpl implements GoneService {

	@Autowired private GoneDAO dao;

	@Override
	public int gone_insert(GoneVO vo) {
		return dao.gone_insert(vo);
	}

	@Override
	public GonePageVO gone_list(GonePageVO vo) {
		System.out.println("");
		System.out.println("");
		return dao.gone_list(vo);
	}

	@Override
	public GoneVO gone_info(int id) {
		return dao.gone_info(id);
	}

	@Override
	public int gone_read(int id) {
		return dao.gone_read(id);
	}

	@Override
	public int gone_update(GoneVO vo) {
		return dao.gone_update(vo);
	}

	@Override
	public int gone_delete(int id) {
		return dao.gone_delete(id);
	}

	@Override
	public GoneFileVO gone_file_info(int id) {
		return dao.gone_file_info(id);
	}

	@Override
	public List<GoneFileVO> gone_removed_file(String removed) {
		return dao.gone_removed_file(removed);
	}

	@Override
	public int gone_file_delete(String removed) {
		return dao.gone_file_delete(removed);
	}

	@Override
	public int gone_comment_regist(GoneCommentVO vo) {
		return dao.gone_comment_regist(vo);
	}

	@Override
	public int gone_comment_update(GoneCommentVO vo) {
		return dao.gone_comment_update(vo);
	}

	@Override
	public int gone_comment_delete(int id) {
		return dao.gone_comment_delete(id);
	}

	@Override
	public List<GoneCommentVO> gone_comment_list(int gone_id) {
		return dao.gone_comment_list(gone_id);
	}

	@Override
	public List<LocationVO> location_list() {
		// TODO Auto-generated method stub
		return dao.location_list();
	}

	@Override
	public List<CourseVO> course_list() {
		// TODO Auto-generated method stub
		return dao.course_list();
	}


	
	@Override
	public List<HomeVO> homeList(HashMap<String, Object> vo) {
		// TODO Auto-generated method stub
		return dao.homeList(vo);
	}

	@Override
	public List<GoneVO> gone_local_list(String loccode) {
		// TODO Auto-generated method stub
		return dao.gone_local_list(loccode);
	}

	@Override
	public int gone_insert(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.gone_insert(map);
	}

	@Override
	public CourseVO course_info(int location_id) {
		// TODO Auto-generated method stub
		return dao.course_info(location_id);
	}

	@Override
	public List<GoneVO> gone_willgo_list(String member_id) {
		// TODO Auto-generated method stub
		return dao.gone_willgo_list(member_id);
	}

	@Override
	public List<GoneVO> bolist() {
		// TODO Auto-generated method stub
		return dao.bolist();
	}

	

//	@Override
//	public List<GoneFileVO> GoneFile_people_best() {
//		// TODO Auto-generated method stub
//		return dao.GoneFile_list();
//	}

}
