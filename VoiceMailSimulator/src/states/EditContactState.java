package states;

import root.Connection;
import root.Contact;

public class EditContactState implements ConnectionState {
	private Contact actualContact;
	
	public ConnectionState dial(String key, Connection actualConnection) {
		if (key.equals("1"))
	      {
	    	  String output = "Enter the new contact name";
	    	  actualConnection.speakToAllUIs(output);
	    	  EditContactNameState nextState = new EditContactNameState();
	    	  nextState.setActualContact(this.actualContact);
	    	  return nextState;
	      }
	      else if (key.equals("2"))
	      {
	    	 String output = "Enter the new contact last name";
	      }
	      else if (key.equals("3"))
	      {
	    	  String output = "Enter the new contact number";
	      }
	      else if (key.equals("4"))
	      {
	         
	      }
	      else
	      {
	    	 
	      }
	     return this;
	}

	public ConnectionState record(String text, Connection actualConnection) {
		// TODO Auto-generated method stub
		return this;
	}
	
	public void setActualContact(Contact actualContact){
		this.actualContact = actualContact;
	}
}
