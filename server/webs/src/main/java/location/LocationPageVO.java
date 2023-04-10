package location;

import java.util.List;

import common.PageVO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LocationPageVO extends PageVO {
	private List<LocationVO> list;
}
