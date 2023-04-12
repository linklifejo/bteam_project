package willgo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WillgoServiceImpl implements WillgoService {
	@Autowired private WillgoDAO dao;
	
	@Override
	public int willgo_insert(HashMap<String, Object> map) {
		return dao.willgo_insert(map);
	}
	@Override
	public int willgo_insert(WillgoVO vo) {
		return dao.willgo_insert(vo);
	}

	@Override
	public List<WillgoVO> willgo_list() {
		return dao.willgo_list();
	}

	@Override
	public WillgoVO willgo_info(int id) {
		return dao.willgo_info(id);
	}

	@Override
	public int willgo_update(WillgoVO vo) {
		return dao.willgo_update(vo);
	}

	@Override
	public int willgo_delete(int id) {
		return dao.willgo_delete(id);
	}

	@Override
	public List<WillgoVO> willgo_list(String member_id) {
		// TODO Auto-generated method stub
		return dao.willgo_list(member_id);
	}





}
