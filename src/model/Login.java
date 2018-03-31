package model;

public class Login {

	private String userId;
	private String passWord;
	
	public Login(String userId, String passWord) {
		this.userId = userId;
		this.passWord = passWord;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public String getPassWord() {
		return passWord;
	}
	
}
