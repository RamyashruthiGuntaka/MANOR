package com.re.dto;

public class User {
	private int user_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	private String Name;
	private String Mail_id;
	private String password;
	private String Phno;
	public String getPhno() {
		return Phno;
	}
	public void setPhno(String phno) {
		Phno = phno;
	}	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getMail_id() {
		return Mail_id;
	}
	public void setMail_id(String Mail_id ) {
		this.Mail_id = Mail_id;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "user [Name=" + Name + ", Mail_id=" + Mail_id + ", password=" + password + ",Phno="+Phno+"]";
	}
	
}
