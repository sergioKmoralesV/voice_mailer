
package core;
import java.sql.SQLException;
import java.util.ArrayList;
import db.DBConnector;

/**
   A system of voice mail boxes.
*/
public class MailSystem
{
	DBConnector conn;
   /**
      Constructs a mail system with a given number of mailboxes
      @param mailboxCount the number of mailboxes
 * @throws SQLException 
   */
   public MailSystem(int mailboxCount) 
   {
      mailboxes = new ArrayList<Mailbox>();
      conn = new DBConnector();
      // Initialize mail boxes.
      mailboxes = conn.getMailboxes(mailboxCount);
      if(mailboxes.isEmpty() || mailboxes.size() < mailboxCount)
      {
    	  for (int i = mailboxes.size(); i < mailboxCount; i++)
          {
             String passcode = "" + (i + 1);
             String greeting = "You have reached mailbox " + (i + 1)
                   + ". \nPlease leave a message now.";
        	 conn.createMailbox(i+1, passcode, greeting);
             mailboxes.add(new Mailbox(passcode, greeting));
          }  
      }
   }

   /**
      Locate a mailbox.
      @param ext the extension number
      @return the mailbox or null if not found
   */
   public Mailbox findMailbox(String ext)
   {
      int i = Integer.parseInt(ext);
      if (1 <= i && i <= mailboxes.size())
         return  mailboxes.get(i - 1);
      else return null;
   }

   private ArrayList<Mailbox> mailboxes;
}
