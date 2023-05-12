package location;

import java.sql.Date;
import java.util.List;

import gone.GoneFileVO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LocationVO {
<<<<<<< HEAD
	private int id,rownum;
	private String type, locname, name_desc, post,address,latitude,longitude, filename, filepath,loccode;
=======
	private int id;
	private String type, locname, name_desc, post,address,latitude,longitude, filename, filepath,loccode,filenamed,filepathd,filenamet,filepatht;
>>>>>>> 16eac4c15e4efed825b07526d1f722807f205321
	public void setFileInfo(LocationVO files) {
		// TODO Auto-generated method stub
		
	}

}
