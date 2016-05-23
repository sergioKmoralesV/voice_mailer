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
	public ConnectionState record(String text, Connection actualConnection ){
		actualConnection.addToRecording(text);
		return this;
	}

}