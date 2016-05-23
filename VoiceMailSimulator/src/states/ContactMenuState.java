package states;
import root.Connection;

public class ContactMenuState implements ConnectionState{
	public ConnectionState dial(String key, Connection actualConnection){
	      if (key.equals("1"))
	      {
	    	  String output = " \n" + actualConnection.getMailbox().getContactList() + "\n" + messages.CONTACT_MENU_TEXT;
	    	  actualConnection.speakToAllUIs(output);
	      }
	      else if (key.equals("2"))
	      {
	    	  String output = "";
		      output += messages.CREATE_CONTACT_MENU;
		      actualConnection.speakToAllUIs(output);
		      return new CreateContactState();
	      }
	      else if (key.equals("3"))
	      {
	    	  String output;
		  	  output = " \n" + actualConnection.getMailbox().getContactList() + " \n" + 
		  			  "Please, enter the number corresponding \n to the contact want to you select"; 
		  	  actualConnection.speakToAllUIs(output);
	    	  return new SelectedContactMenu();
	    	  
	      }
	      else if (key.equals("4"))
	      {
	         actualConnection.speakToAllUIs(messages.MAILBOX_MENU_TEXT);
	         return new MailboxState();
	      }
	     return this;
	}
	
	public ConnectionState record(String text, Connection actualConnection ){
		return this;
	}

}