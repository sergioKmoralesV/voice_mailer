package states;
import root.Connection;

public class RecordingState implements ConnectionState{
	public ConnectionState dial(String key, Connection actualConnection){
		if (key.equals("#"))
	      {
	         if (actualConnection.verifyConnectionPasscode())
	         {  
	            actualConnection.speakToAllUIs(messages.MAILBOX_MENU_TEXT);
	            return new MailboxState();
	         }
	         else
	            actualConnection.speakToAllUIs(messages.INCORRECT_PASSCODE);
	         	actualConnection.updateAccumulatedKeys("", true);
	      }
	      else
		         actualConnection.updateAccumulatedKeys(key, false);
		
		return this;
	}
	public ConnectionState record(String text, Connection actualConnection ){
		actualConnection.addToRecording(text);
		return this;
	}

}

