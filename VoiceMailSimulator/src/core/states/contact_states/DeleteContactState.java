package core.states.contact_states;

import core.Connection;
import core.Contact;
import core.Mailbox;
import core.states.ConnectionState;
import core.states.ContactMenuState;

public class DeleteContactState implements ConnectionState {
	private Contact actualContact;
	private Mailbox currentMailbox;
	@Override
	public ConnectionState dial(String key, Connection actualConnection) {
		if (key.equals("1"))
		{
			currentMailbox = actualConnection.getMailbox();
			currentMailbox.deleteContact(actualContact);
			String output = "\nContact's succesfully deleted!\n\n";
			output +=  messages.CONTACT_MENU_TEXT; 
			actualConnection.speakToAllUIs(output);
			return new ContactMenuState();
		}
		else if (key.equals("2")){
			String output = "\n" + actualContact.getContact()+"\n\n" + messages.EDIT_CONTACT_MENU;
			actualConnection.speakToAllUIs(output);
			EditContactState nextState = new EditContactState();
	  	  	nextState.setActualContact(actualContact);
	  	  	return nextState;
		}
		return this;
	}

	@Override
	public ConnectionState record(String text, Connection actualConnection) {
		return this;	
  	 }
		
	public void setActualContact(Contact actualContact){
		this.actualContact = actualContact;
	}
	

}
