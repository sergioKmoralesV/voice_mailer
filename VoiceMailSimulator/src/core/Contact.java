package core;

import db.DBConnector;

public class Contact {
	private String name;
	private String lastname;
	private String phone;
	private int id;
	
	private DBConnector conn;
	
	public Contact(String name, String lastname, String phone){
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.conn = new DBConnector();
	}
	
	public String getContact(){
		return lastname + ", " + name + " - " + phone;
	}
	
	public void editContact(String name, String lastname, String phone){
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
	}
	
	public void setNewName(String name)
	{
		this.name = name;
		conn.saveContact(id, name, lastname, phone);

	}
	
	public void setNewLastname(String lastname)
	{
		this.lastname = lastname;
		conn.saveContact(id, name, lastname, phone);
	}
	
	public void setNewTelephone(String phone)
	{
		this.phone = phone;
		conn.saveContact(id, name, lastname, phone);

	}
	public String getName(){
		return name;
	}
	public String getLastName(){
		return lastname;
	}
	public String getPhoneNumber(){
		return phone;
	}
	public int getId(){
		return id;
	}
	public void setId(int dbId){
		id = dbId;
	}
}
