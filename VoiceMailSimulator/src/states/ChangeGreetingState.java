package states;
import root.Connection;

public class ChangeGreetingState implements ConnectionState{
	public ConnectionState dial(String key, Connection actualConnection){
	      if (key.equals("#"))
	      {
	    	 actualConnection.setGreeting();
	         actualConnection.resetRecord();
	         actualConnection.speakToAllUIs(messages.MAILBOX_MENU_TEXT);
	         return new MailboxState();
	      }
		return this;
	}

}