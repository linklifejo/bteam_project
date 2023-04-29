package weather;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherDAO implements WeatherService {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	/*
	 * @Override public int weather_insert(WeatherVO vo) { return
	 * sql.insert("we.insert", vo); }
	 */

	@Override
	public List<WeatherVO> weather_list() {
		return sql.selectList("we.list");
	}

	@Override
	public WeatherVO weather_info() {
		return sql.selectOne("we.info");
	}
	/*
	 * @Override public int weather_update(WeatherVO vo) { return
	 * sql.update("we.update", vo); }
	 * 
	 * @Override public int weather_delete(int id) { return sql.delete("we.delete",
	 * id); }
	 */

}
