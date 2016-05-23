package states;
import root.Connection;

public class ChangePasscodeState implements ConnectionState{
	public ConnectionState dial(String key, Connection actualConnection){
		if (key.equals("#"))
	      {
	         actualConnection.changePasscode();
	         actualConnection.speakToAllUIs(messages.MAILBOX_MENU_TEXT);
	         actualConnection.updateAccumulatedKeys("", true);
	         return new MailboxState();
	      }
	      else
		         actualConnection.updateAccumulatedKeys(key,false);
		return this;
	}
	public ConnectionState record(String text, Connection actualConnection ){
		return this;
	}

}