package weather;

import java.util.List;

public interface WeatherService {
	//CRUD(Create, Read, Update, Delete)
	/* int weather_insert(WeatherVO vo); */		//신규고객등록
	List<WeatherVO> weather_list();		//고객목록조회
	/*
	 * WeatherVO weather_info(int id); //선택한 고객정보 조회 int weather_update(WeatherVO
	 * vo); //선택한 고객변경 저장 int weather_delete(int id);
	 */ 			//선택한 고객정보 삭제
	WeatherVO weather_info();
}
