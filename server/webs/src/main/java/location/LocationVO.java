package location;

import java.sql.Date;
import java.util.List;

import gone.GoneFileVO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LocationVO {

	private int id,rownum;
	private String type, locname, name_desc, post,address,latitude,longitude, filename, filepath,loccode;
	
	public void setFileInfo(LocationVO files) {
		// TODO Auto-generated method stub
		
	}

}
