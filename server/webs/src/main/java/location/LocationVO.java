package location;

import java.sql.Date;
import java.util.List;

import gone.GoneFileVO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LocationVO {

	private int id,rownum;
<<<<<<< HEAD
	private String type, locname, name_desc, post,address,latitude,longitude, filename, filepath,loccode,filenamed,filepathd,filenamet,filepatht;
=======
	private String type, locname, name_desc, post,address,latitude,longitude, filename, filepath,loccode;
	
>>>>>>> 0014a0b25474f9acaa2d3769ef0ac1a7c15bd226
	public void setFileInfo(LocationVO files) {
		// TODO Auto-generated method stub
		
	}

}
