package core.states.contact_states;

import core.Connection;
import core.Contact;
import core.Mailbox;
import core.states.ConnectionState;
import core.states.ContactMenuState;

public class SelectedContactMenu implements ConnectionState {
	private Mailbox currentMailbox;

	@Override
	public ConnectionState dial(String key, Connection actualConnection) {
		currentMailbox = actualConnection.getMailbox();
		Contact actualContact = currentMailbox.getContactFromList(Integer.parseInt(key));
		if(actualContact == null){
			String output= "Something went wrong!\n"+
					"Please,try again!\n\n" + 
					messages.CONTACT_MENU_TEXT;
					actualConnection.speakToAllUIs(output); 
			return new ContactMenuState();
		}else
		{
			String output= actualContact.getContact() + "\n\n" + messages.EDIT_CONTACT_MENU; 
			actualConnection.speakToAllUIs(output);
			ConnectionState editContact =  new EditContactState();
			((EditContactState) editContact).setActualContact(actualContact);
			return editContact;
		}
		
	}

	@Override
	public ConnectionState record(String text, Connection actualConnection) {
		return this;
		
	}

}
