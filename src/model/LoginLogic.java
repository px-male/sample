package model;

public class LoginLogic {

	public LoginLogic(){
		super();
	}
	
	public boolean execute(User user) {
		if (user.getPassword().equals("1234")) {
			return true;
		} else {
			return false;
		}
	}
}
