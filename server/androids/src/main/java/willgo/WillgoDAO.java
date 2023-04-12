package willgo;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class WillgoDAO implements WillgoService {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	@Override
	public int willgo_insert(HashMap<String, Object> map) {
		return sql.insert("wi.insert", map);
	}
	@Override
	public int willgo_insert(WillgoVO vo) {
		return sql.insert("wi.insert", vo);
	}

	@Override
	public List<WillgoVO> willgo_list() {
		return sql.selectList("wi.list");
	}

	@Override
	public WillgoVO willgo_info(int id) {
		return sql.selectOne("wi.info", id);
	}

	@Override
	public int willgo_update(WillgoVO vo) {
		return sql.update("wi.update", vo);
	}

	@Override
	public int willgo_delete(int id) {
		return sql.delete("wi.delete", id);
	}

	@Override
	public List<WillgoVO> willgo_list(String member_id) {
		// TODO Auto-generated method stub
		return sql.selectList("wi.local_list",member_id);
	}




}
