package core.states.mailbox_configuration;
import core.Connection;
import core.states.ConnectionState;
import core.states.MailboxState;

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
	public ConnectionState record(String text, Connection actualConnection ){
		actualConnection.addToRecording(text);
		return this;
	}

}