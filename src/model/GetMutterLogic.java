package model;

import java.util.List;

import dao.MutterDAO;

public class GetMutterLogic {

	public List<Mutter> execute() {
		
		MutterDAO mutterDao = new MutterDAO();
		
		List<Mutter> listMutter = mutterDao.findAll();
		return listMutter;
	}
	
}
