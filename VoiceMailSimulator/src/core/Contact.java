package core;

public class Contact {
	private String name;
	private String lastname;
	private String phone;
	
	public Contact(String name, String lastname, String phone){
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
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
	}
	
	public void setNewLastname(String lastname)
	{
		this.lastname = lastname;
	}
	
	public void setNewTelephone(String phone)
	{
		this.phone = phone;
	}
}
