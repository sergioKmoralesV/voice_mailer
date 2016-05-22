package states;
import root.Connection;

public class MailboxState implements ConnectionState{
	public ConnectionState dial(String key, Connection actualConnection){
	      if (key.equals("1"))
	      {
	         actualConnection.speakToAllUIs(messages.MESSAGE_MENU_TEXT);
	         return new MessageMenuState();
	      }
	      else if (key.equals("2"))
	      {
	         actualConnection.speakToAllUIs("Enter new passcode followed by the # key");
	         return new ChangePasscodeState();
	      }
	      else if (key.equals("3"))
	      {
	         actualConnection.speakToAllUIs("Record your greeting, then press the # key");
	         return new ChangeGreetingState();
	         
	      }
	      else if (key.equals("4"))
	      {
	    	  actualConnection.speakToAllUIs(messages.CONTACT_MENU_TEXT);
	    	  return new ContactMenuState();
	      }	
	      return this;
	  }

}
