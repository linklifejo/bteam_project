package gone;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import member.MemberVO;

@Setter @Getter
public class GoneFileVO {
	private int id, gone_id;
	private String filename, filepath, title, content, ptype, member_id;
	private List<GoneVO> gone_date;
	private List<MemberVO> salt;
}
