package model;

import java.util.List;

import dao.MutterDAO;

public class PostMutterLogic {
	
	public void execute(Mutter mutter) {
	
		MutterDAO mutterDao = new MutterDAO();
		mutterDao.create(mutter);
	}
}
