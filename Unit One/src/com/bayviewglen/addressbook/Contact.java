package com.bayviewglen.addressbook;

public class Contact {
	
	private String lname;
	private String fname;
	private String phone;
	
	public Contact(String x,String y,String z){
		fname = x;
		lname = y;
		phone = z;
	}
	
	public String getFirstName(){
		return fname;
	}
	public void setFirstName(String x){
		fname = x;
	}
	public String getLastName(){
		return lname;
	}
	public void setLastName(String x){
		lname = x;
	}
	public String getPhoneNumber(){
		return phone;
	}
	public void setPhoneNumber(String x){
		phone = x;
	}
	
	
	
	
	


}