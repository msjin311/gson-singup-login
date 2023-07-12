package net.hb.homework;

public class User {
	private String Id;
	private String pwd;
	private String name;

	public User(String id, String pwd, String name) {
		this.Id = id;
		this.pwd = pwd;
		this.name = name;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
