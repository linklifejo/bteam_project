package gone;

import java.sql.Date;
import java.util.List;

import location.LocationVO;
import lombok.Getter;
import lombok.Setter;
import member.MemberVO;

@Getter @Setter
public class GoneVO {
	private int id,readcnt, no, filecnt,location_id,course_id;
	private String title, content,filename, filepath, type,member_id,name,locname,couname,gone_time,out_time,loccode,ptype;
	private Date gone_date;
	private List<GoneFileVO> fileInfo,gone_id;
	private List<MemberVO> salt;
	private List<LocationVO> name_desc;
	
}
