package gone;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class GoneFileVO {
	private int id, gone_id;
	private String filename, filepath, title, content, ptype;
	private List<GoneVO> gone_date;
}
