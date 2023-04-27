package stamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import course.CourseVO;
import location.LocationVO;

@Repository
public class StampDAO implements StampService {
	@Autowired @Qualifier("bteam") private SqlSession sql;

	@Override
	public int stamp_insert(HashMap<String, Object> map) {
		int dml = sql.insert("st.insert", map);
		return dml;
	}


	@Override
	public int stamp_delete(int id) {
		// TODO Auto-generated method stub
		return sql.delete("st.delete", id);
	}


	@Override
	public StampVO stamp_info(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sql.selectOne("st.info", map);
	}

}
