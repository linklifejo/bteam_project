package member;

import java.util.HashMap;
import java.util.List;

public interface MemberService {
	//CRUD
	int member_join(MemberVO vo); 
	int member_logout(String id);//회원가입시 신규저장
	int member_insert(MemberVO vo);
	int member_update(MemberVO vo); //회원정보변경
	
	
	MemberVO login(HashMap<String, String> map);
	
	
	MemberVO member_myinfo(String id); //내정보보기(내프로필) 회원정보조회
	
	
	List<MemberVO> member_list(); //회원목록조회-관리자
	MemberVO member_login(HashMap<String, String> map); //로그인처리
	String member_salt(String id); //회원의 솔트조회
	int member_id_email(MemberVO vo); //아이디와 이메일 일치여부를 확인
	
	
	List<MemberVO> member_id_check(String id); //아이디 존재여부 확인.
	
	
	
	int member_change_pw(HashMap<String, String> map); //회원의 비밀번호변경
	
	
	
	
	int member_delete(String id); //회원탈퇴
	
	int member_del(String id); //회원탈퇴
	
	
	
	int member_manager(MemberVO vo); //관리자 ///////////////
}
