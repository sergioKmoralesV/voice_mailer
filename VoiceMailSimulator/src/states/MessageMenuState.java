package states;
import root.Connection;
import root.Mailbox;
import root.Message;

public class MessageMenuState implements ConnectionState{
	private Mailbox currentMailbox;

	public ConnectionState dial(String key, Connection actualConnection){
		currentMailbox = actualConnection.getMailbox();
	      if (key.equals("1"))
	      {
	         String output = "";
	         Message m = currentMailbox.getCurrentMessage();
	         if (m == null) output += "No messages." + "\n";
	         else output += m.getText() + "\n";
	         output += messages.MESSAGE_MENU_TEXT;
	         actualConnection.speakToAllUIs(output);
	      }
	      else if (key.equals("2"))
	      {
	         currentMailbox.saveCurrentMessage();
	         actualConnection.speakToAllUIs(messages.MESSAGE_MENU_TEXT);
	      }
	      else if (key.equals("3"))
	      {
	         currentMailbox.removeCurrentMessage();
	         actualConnection.speakToAllUIs(messages.MESSAGE_MENU_TEXT);
	      }
	      else if (key.equals("4"))
	      {
	         actualConnection.speakToAllUIs(messages.MAILBOX_MENU_TEXT);
	         return new MailboxState();
	      }
	      return this;
	}
	public ConnectionState record(String text, Connection actualConnection ){
		return this;

	}

}