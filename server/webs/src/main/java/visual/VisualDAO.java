package visual;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class VisualDAO implements VisualService{
	@Autowired @Qualifier("hr") private SqlSession sql;
	
	@Override
	public List<HashMap<String, Object>> department() {
		return sql.selectList("vi.department");
	}

	@Override
	public List<HashMap<String, Object>> hirement_year() {
		return sql.selectList("vi.hirement_year");
	}

	@Override
	public List<HashMap<String, Object>> hirement_month() {
		return sql.selectList("vi.hirement_month");
	}

	@Override
	public List<HashMap<String, Object>> hirement_top3_year() {
		return sql.selectList("vi.hirement_top3_year");
	}

	@Override
	public List<HashMap<String, Object>> hirement_top3_month() {
		return sql.selectList("vi.hirement_top3_month");
	}

}
