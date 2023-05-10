package location;

import java.sql.Date;
import java.util.List;

import course.CourseVO;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class LocationVO {
	private int id;
	private String type, locname, name_desc, post,address,latitude,longitude,filename,filepath,loccode,heigh,filenamed,filepathd,couname;
	private List<CourseVO> Location_id;
}
