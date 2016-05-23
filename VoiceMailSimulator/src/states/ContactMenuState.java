package states;
import root.Connection;

public class ContactMenuState implements ConnectionState{
	public ConnectionState dial(String key, Connection actualConnection){
	      if (key.equals("1"))
	      {
	    	  String output = " \n" + actualConnection.getMailbox().getContactList() + " \n" + messages.CONTACT_MENU_TEXT;
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
	         /**currentMailbox.removeCurrentMessage();
	         speakToAllUIs(messages.MESSAGE_MENU_TEXT);*/
	      }
	      else if (key.equals("4"))
	      {
	         actualConnection.speakToAllUIs(messages.MAILBOX_MENU_TEXT);
	         return new MailboxState();
	      }
	      else
	      {
	    	  actualConnection.speakToAllUIs(key);
	      }
	     return this;
	}
	
	public ConnectionState record(String text, Connection actualConnection ){
		return this;
	}

}