package states;

import root.Connection;
import root.Contact;

public class EditContactNameState implements ConnectionState {
	private Contact actualContact;

	@Override
	public ConnectionState dial(String key, Connection actualConnection) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ConnectionState record(String text, Connection actualConnection) {
		actualContact.setNewName(text);
		String output = "\nContact's changes saved!\n\n";
		output += actualContact.getContact() + "\n" + messages.EDIT_CONTACT_MENU; 
		actualConnection.speakToAllUIs(output);
		EditContactState nextState = new EditContactState();
  	  	nextState.setActualContact(this.actualContact);
  	  	return nextState;	
  	 }
		
	public void setActualContact(Contact actualContact){
		this.actualContact = actualContact;
	}
	

}
