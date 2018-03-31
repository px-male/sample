package model;

public class Account {

	private String user_id;
	private String pass;
	private String mail;
	private String name;
	private int age;
	
	public Account(String user_id, String pass, String mail, String name, int age) {
		this.user_id = user_id;
		this.pass = pass;
		this.mail = mail;
		this.name = name;
		this.age = age;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public String getPass() {
		return pass;
	}
	public String getMail() {
		return mail;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
}
