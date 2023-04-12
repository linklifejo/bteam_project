package willgo;

import java.util.HashMap;
import java.util.List;

import javax.tools.DocumentationTool.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gone.GoneFileVO;
import gone.GoneVO;
import location.LocationVO;

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
	
	@Override
	public LocationVO location_info(int id) {
		return dao.location_info(id);
	}
	@Override
	public GoneFileVO gone_file_info(int id) {
		return dao.gone_file_info(id);
	}

	@Override
	public GoneVO gone_info(int id) {
		// TODO Auto-generated method stub
		return dao.gone_info(id);
	}





}
