package core.states.contact_states;

import core.Connection;
import core.Contact;
import core.states.ConnectionState;
import core.states.ContactMenuState;

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
	    	 actualConnection.speakToAllUIs(output);
	    	 EditContactLastNameState nextState = new EditContactLastNameState();
	    	 nextState.setActualContact(this.actualContact);
	    	 return nextState;
	      }
	      else if (key.equals("3"))
	      {
	    	  String output = "Enter the new contact number";
	    	  actualConnection.speakToAllUIs(output);
	    	  EditContactPhoneState nextState = new EditContactPhoneState();
	    	  nextState.setActualContact(this.actualContact);
	    	  return nextState;
	      }
	      else if (key.equals("4"))
	      {
	         String output = "Are you sure you want to delete this contact?\n "
	        		 + "1 [Yes]\n2 [No]\n" ;
	         actualConnection.speakToAllUIs(output);
	         DeleteContactState nextState = new DeleteContactState();
	    	  nextState.setActualContact(this.actualContact);
	    	  return nextState;
	      }
	      else  if( key.equals("5"))
		   {
	    	  actualConnection.speakToAllUIs(messages.CONTACT_MENU_TEXT);
		   	  return new ContactMenuState();
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
