package stamp;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StampVO {
	private int id;
	private String member_id,location_id,course_id,stamp_time;
	private Date stamp_date;
	
}
