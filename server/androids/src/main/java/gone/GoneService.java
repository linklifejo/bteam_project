package gone;

import java.util.HashMap;
import java.util.List;

import course.CourseVO;
import location.LocationVO;
import member.MemberVO;

public interface GoneService {
	//CRUD 글쓰기
	int gone_write(GoneVO vo);
	int gone_fileInsert(GoneFileVO vo);
	
	
	int gone_insert(HashMap<String,Object> map);//방명록 새글저장
	
	int gone_jjimupdate(HashMap<String,Object> map);
	
	int gone_insert(GoneVO vo);//방명록 새글저장
	GonePageVO gone_list(GonePageVO vo); //방명록 목록 조회
	GoneVO gone_info(int id); //선택한 방명록 글 조회
	int gone_read(int id); 	//선택한 방명록 글 조회수 변경	
	
	
	
	int gone_update(HashMap<String, Object> map); //선택한 방명록 정보수정저장
	
	
	
	
	int gone_wroteup(GoneVO vo); //선택한 방명록 정보수정저장
	
	
	
	
	
	int gone_delete(int id); //선택한 방명록 정보삭제
	
	int gone_filedelete(int id);
	
	
	GoneFileVO gone_file_info(int id); //첨부파일정보 조회
	
	
	
	
	
	List<GoneFileVO> gone_removed_file( String removed ); //삭제하려는 첨부파일정보 조회
	int gone_file_delete(String removed); //변경첨부/삭제한 파일정보 삭제
	
	int gone_comment_regist(GoneCommentVO vo); //댓글신규저장
	int gone_comment_update(GoneCommentVO vo); //댓글변경저장
	int gone_comment_delete(int id); //댓글삭제
	List<GoneCommentVO> gone_comment_list(int gone_id); //댓글목록조회
	List<LocationVO> location_list(); // 선택한 방명록 글 조회
	List<CourseVO> course_list(); // 선택한 방명록 글 조회
	List<GoneVO> gone_local_list( String loccode ); //삭제하려는 첨부파일정보 조회
	CourseVO course_info(int location_id);
	// 사람들이 많이 조회한순
//	List<GoneFileVO> GoneFile_list();
	// 게시판에 올린사진 인기순
	
	//내가쓴글 
	List<HomeVO> mou(HashMap<String, Object> vo);
	
	List<HomeVO> diary(HashMap<String, Object> vo);
	
	
	
	List<HomeVO> homeList(HashMap<String, Object> vo);
	List<GoneVO> gone_willgo_list(String member_id); //방명록 목록 조회
	List<GoneVO> bolist();

}
