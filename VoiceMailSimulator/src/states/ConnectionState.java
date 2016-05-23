package states;
import root.Connection;
import root.Contact;
import root.UIMessages;

public interface ConnectionState {
	static UIMessages messages = new UIMessages();
	   
	public ConnectionState dial(String key, Connection actualConnection);
	public ConnectionState record(String text, Connection actualConnection );
	
}
