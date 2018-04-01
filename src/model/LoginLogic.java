package model;

import dao.AccountDAO;

public class LoginLogic {
	public boolean execute(Login login) {
		AccountDAO dao = new AccountDAO();
		Account dao_result = dao.findByLogin(login);
		if (dao_result != null) {
			return true;
		} else {
			return false;
		}
	}
}
