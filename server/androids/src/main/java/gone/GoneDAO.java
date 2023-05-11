package gone;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import course.CourseVO;
import location.LocationVO;

@Repository
public class GoneDAO implements GoneService {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	

	
	@Override
	public int gone_insert(GoneVO vo) {
		System.out.println("");
		//방명록 글을 저장한 후
		int dml = sql.insert("go.insert", vo);
		//해당 글에 첨부된 파일이 있으면 파일정보를 저장한다
		if( dml > 0 && vo.getFileInfo() != null )
			sql.insert("go.fileInsert", vo);
		return dml;
	}

	@Override
	public GonePageVO gone_list(GonePageVO vo) {
		vo.setTotalList( sql.selectOne("go.totalCount", vo) );
		vo.setList( sql.selectList("go.list", vo) );
		return vo;
	}

	@Override
	public GoneVO gone_info(int id) {
		GoneVO vo = sql.selectOne("go.info", id);
		vo.setFileInfo( sql.selectList("go.fileList", id) );
		return vo;
	}

	@Override
	public int gone_read(int id) {
		System.out.println("");
		return sql.update("go.read", id);
	}
	
	@Override
	public int gone_wroteup(GoneVO vo) {
		// TODO Auto-generated method stub
		if( vo.getFilepath()!=null )
			sql.insert("go.gonefileInsert", vo);
		
		return sql.update("go.gonewroteup",vo);
		
	}

	@Override
	public int gone_delete(int id) {
		return sql.delete("go.delete", id);
	}

	@Override
	public GoneFileVO gone_file_info(int id) {
		return sql.selectOne("go.fileInfo", id);
	}

	@Override
	public List<GoneFileVO> gone_removed_file(String removed) {
		return sql.selectList("go.fileRemoved", removed);
	}

	@Override
	public int gone_file_delete(String removed) {
		return sql.delete("go.fileDelete", removed);
	}

	@Override
	public int gone_comment_regist(GoneCommentVO vo) {
		return sql.insert("go.commentInsert", vo);
	}

	@Override
	public int gone_comment_update(GoneCommentVO vo) {
		return sql.update("go.commentUpdate", vo);
	}

	@Override
	public int gone_comment_delete(int id) {
		return sql.delete("go.commentDelete", id);
	}

	@Override
	public List<GoneCommentVO> gone_comment_list(int gone_id) {
		return sql.selectList("go.commentList", gone_id);
	}

	@Override
	public List<LocationVO> location_list() {
		// TODO Auto-generated method stub
		return sql.selectList("go.loc_list");
	}

	@Override
	public List<CourseVO> course_list() {
		// TODO Auto-generated method stub
		return sql.selectList("go.cou_list");
	}

//	@Override
//	public List<GoneFileVO> GoneFile_list() {
//		return sql.selectList("go.orderList");
//	}

	
	@Override
	public List<HomeVO> mou(HashMap<String, Object> vo) {
		// TODO Auto-generated method stub
		return sql.selectList("go.mou",vo);
	}
	

	@Override
	public List<HomeVO> homeList(HashMap<String, Object> vo) {
		// TODO Auto-generated method stub
		return sql.selectList("go.homeList",vo);
	}

	@Override
	public List<GoneVO> gone_local_list(String loccode) {
		// TODO Auto-generated method stub
		return sql.selectList("go.loc_list",loccode);
	}

	@Override
	public int gone_insert(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sql.insert("go.insert_will", map);
	}

	@Override
	public CourseVO course_info(int location_id) {
		// TODO Auto-generated method stub
		return sql.selectOne("go.cou_info", location_id);
	}

	@Override
	public List<GoneVO> gone_willgo_list(String member_id) {
		// TODO Auto-generated method stub
		return sql.selectList("go.willgo_list",member_id);
	}

	@Override
	public List<GoneVO> bolist() {
		// TODO Auto-generated method stub
		return sql.selectList("go.bolist");
	}

	@Override
	public List<HomeVO> diary(HashMap<String, Object> vo) {
		// TODO Auto-generated method stub
		return sql.selectList("go.diary",vo);
	}

	@Override
	public int gone_write(GoneVO vo) {
		// TODO Auto-generated method stub
		int insert = sql.insert("go.gonewrite",vo);
		if( vo.getFileInfo()!=null ) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("filepath", vo.getFileInfo().get(0).getFilepath());
			map.put("id", vo.getId());
			sql.insert("go.gonefileInsert",map);
		}
		return insert;
	}

	@Override
	public int gone_fileInsert(GoneFileVO vo) {
		// TODO Auto-generated method stub
		return sql.insert("go.gonefileInsert",vo);
	}

	

	@Override
	public int gone_filedelete(int id) {
		// TODO Auto-generated method stub
		return sql.delete("go.gonefileDelete",id);
	}

	@Override
	public int gone_update(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	



//	@Override
//	public List<GoneFileVO> GoneFile_people_best() {
//		// TODO Auto-generated method stub
//		return sql.selectList("go.orderList");
//	}

	


}
