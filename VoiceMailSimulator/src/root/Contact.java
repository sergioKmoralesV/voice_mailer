package root;

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
}
