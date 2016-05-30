package core.states;
import core.Connection;
import core.Mailbox;

public class ConnectedState implements ConnectionState{
	private Mailbox currentMailbox;
	public ConnectionState dial(String key, Connection actualConnection){
		if (key.equals("#"))
	      {
	        currentMailbox = actualConnection.setMailbox();
	         if (currentMailbox != null)
	         {
	            actualConnection.speakToAllUIs(currentMailbox.getGreeting());
		        actualConnection.updateAccumulatedKeys("",true);
	            return new RecordingState();
	         }
	         else
	            actualConnection.speakToAllUIs(messages.INCORRECT_MAILBOX);
	         
	         actualConnection.updateAccumulatedKeys("",true);
	      }
	      else
	         actualConnection.updateAccumulatedKeys(key, false);
		return this;
	}
	public ConnectionState record(String text, Connection actualConnection ){
		return this;

	}

	
}
