package stamp;

import java.util.List;

import common.PageVO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StampPageVO extends PageVO {
	private List<StampVO> list;
}
