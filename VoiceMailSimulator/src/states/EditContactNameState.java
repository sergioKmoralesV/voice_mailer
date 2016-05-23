package states;

import root.Connection;
import root.Contact;
import root.Mailbox;

public class EditContactNameState implements ConnectionState {
	private Mailbox currentMailbox;
	private Contact actualContact;

	@Override
	public ConnectionState dial(String key, Connection actualConnection) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ConnectionState record(String text, Connection actualConnection) {
		currentMailbox = actualConnection.getMailbox();
		actualContact.setNewName(text);
		String output = "\nContact's changes saved!\n\n";
		output += actualContact.getContact() + "\n\n" + messages.EDIT_CONTACT_MENU; 
		actualConnection.speakToAllUIs(output);
		EditContactState nextState = new EditContactState();
  	  	nextState.setActualContact(this.actualContact);
  	  	return nextState;	
  	 }
		
	public void setActualContact(Contact actualContact){
		this.actualContact = actualContact;
	}
	

}
