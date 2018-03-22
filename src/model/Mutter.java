package model;

public class Mutter {
	
	private String id;
	private String name;
	private String content;
	
	public Mutter() {
		
	}
	
	public Mutter(String id, String name, String content){
		this.id = id;
		this.name = name;
		this.content = content;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	public void setString(String content) {
		this.content = content;
	}
	
}
