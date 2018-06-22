package com.re.dto;

import java.util.Date;

public class Detail {
	private String Name;
	public void setName(String name) {
		Name = name;
	}
	private String City;
	private String Location;
	private String Phno;
	
	
	private double budget;
	private String Address;
	private String Area;
	private String Phasing;
	private int userId;
	private String photo;
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}	
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getPhno() {
		return Phno;
	}
	public void setPhno(String phno) {
		Phno = phno;
	}
	
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getPhasing() {
		return Phasing;
	}
	public void setPhasing(String phasing) {
		Phasing = phasing;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}
	
	

}
