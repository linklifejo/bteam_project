package willgo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WillgoVO {
	private int id,refid;
	private String wtype, member_id;
	private Date willdate;

}
