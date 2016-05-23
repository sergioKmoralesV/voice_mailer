package core.states;
import core.Connection;
import core.UIMessages;

public interface ConnectionState {
	static UIMessages messages = new UIMessages();
	   
	public ConnectionState dial(String key, Connection actualConnection);
	public ConnectionState record(String text, Connection actualConnection );
	
}
