package core.states.contact_states;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import core.Connection;
import core.Contact;
import core.Mailbox;
import core.states.ConnectionState;
import core.states.ContactMenuState;

public class CreateContactState implements ConnectionState{
	private Mailbox currentMailbox;

	public ConnectionState dial(String key, Connection actualConnection){
		return this;
	}
	
	public ConnectionState record(String text, Connection actualConnection ){
		List<String> list = new ArrayList<String>(Arrays.asList(text.split(", ")));
		Contact newContact = new Contact(list.get(0),list.get(1),list.get(2));
		String output = "";
		currentMailbox = actualConnection.getMailbox();
        if (currentMailbox != null)
        {
        	currentMailbox.addContact(newContact);
    		output = "Successfully created!\n";
        }
        else
    		output = "Something went wrong, please try again!\n";
        
	    output += messages.CONTACT_MENU_TEXT;
	    actualConnection.speakToAllUIs(output);
		return new ContactMenuState();
	}

}
