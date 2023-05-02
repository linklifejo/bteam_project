package course;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import location.LocationVO;

@Repository
public class CourseDAO implements CourseService {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	@Override
	public int course_insert(CourseVO vo) {
		return sql.insert("co.insert", vo);
	}

	@Override
	public List<CourseVO> course_list(int location_id) {
		return sql.selectList("co.list",location_id);
	}

	@Override
	public CourseVO course_info(int id) {
		return sql.selectOne("co.info", id);
	}

	@Override
	public int course_update(CourseVO vo) {
		return sql.update("co.update", vo);
	}

	@Override
	public int course_delete(int id) {
		return sql.delete("co.delete", id);
	}

	@Override
	public List<LocationVO> location_list() {
		// TODO Auto-generated method stub
		return sql.selectList("co.loc_list");
	}

	@Override
	public CourseVO course_info(String s) {
		// TODO Auto-generated method stub
		return sql.selectOne("co.cou_info", s);
	}

	@Override
	public List<LocationVO> location_search_list(String search) {
		// TODO Auto-generated method stub
		return sql.selectList("co.search_list",search);
	}



}
