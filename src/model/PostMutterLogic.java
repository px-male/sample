package model;

import java.util.List;

public class PostMutterLogic {
	
	public void execute(Mutter mutter, List<Mutter> list) {
		list.add(0, mutter);
	}
}
