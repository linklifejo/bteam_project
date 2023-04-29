package weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
	@Autowired private WeatherDAO dao;
	
	/*
	 * @Override public int weather_insert(WeatherVO vo) { return
	 * dao.weather_insert(vo); }
	 */

	@Override
	public List<WeatherVO> weather_list() {
		return dao.weather_list();
	}

	@Override
	public WeatherVO weather_info() {
		return dao.weather_info();
	}

	/*
	 * @Override public int weather_update(WeatherVO vo) { return
	 * dao.weather_update(vo); }
	 * 
	 * @Override public int weather_delete(int id) { return dao.weather_delete(id);
	 * }
	 */
}
