package model;

public class RegisterUserLogic {

	User user;

	public RegisterUserLogic(){
		
	}
	
	public RegisterUserLogic(User user) {
		this.user = user;
	}
	
	public boolean execute(User user) {
		return true;
	}
	
}
