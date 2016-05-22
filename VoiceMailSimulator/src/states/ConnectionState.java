package states;
import root.Connection;
import root.UIMessages;

public interface ConnectionState {
	static UIMessages messages = new UIMessages();
	   
	public ConnectionState dial(String key, Connection actualConnection);
}
