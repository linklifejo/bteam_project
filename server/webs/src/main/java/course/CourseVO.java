package course;

import java.util.List;

import gone.GoneFileVO;
import location.LocationVO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CourseVO {
	private int id, location_id;
	private String couname, type, locname, grade,filename,filepath;
	
}
