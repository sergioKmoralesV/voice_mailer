package states;
import root.Connection;

public class ContactMenuState implements ConnectionState{
	public ConnectionState dial(String key, Connection actualConnection){
	      if (key.equals("1"))
	      {
	         /** String output = "";
	         Message m = currentMailbox.getCurrentMessage();
	         if (m == null) output += "No messages." + "\n";
	         else output += m.getText() + "\n";
	         output += messages.MESSAGE_MENU_TEXT;
	         speakToAllUIs(output);*/
	      }
	      else if (key.equals("2"))
	      {
	         /** currentMailbox.saveCurrentMessage();
	         speakToAllUIs(messages.MESSAGE_MENU_TEXT);*/
	      }
	      else if (key.equals("3"))
	      {
	         /**currentMailbox.removeCurrentMessage();
	         speakToAllUIs(messages.MESSAGE_MENU_TEXT);*/
	      }
	      else if (key.equals("4"))
	      {
	         actualConnection.speakToAllUIs(messages.MAILBOX_MENU_TEXT);
	         return new MailboxState();
	      }
	     return this;
	}
}