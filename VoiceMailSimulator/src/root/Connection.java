package root;
import java.util.ArrayList;
import java.util.List;

import gui.UserInterface;
import states.ChangeGreetingState;
import states.ConnectedState;
import states.ConnectionState;
import states.RecordingState;

/**
   Connects a phone to the mail system. The purpose of this
   class is to keep track of the state of a connection, since
   the phone itself is just a source of individual key presses.
*/
public class Connection
{
	   MailSystem system;
	   Mailbox currentMailbox;
	   String accumulatedKeys;

	   private String currentRecording;
	   private ConnectionState status;
	   private List<UserInterface> userInterfaces = new ArrayList<UserInterface>();
	   
	   
	   static UIMessages messages = new UIMessages();
	    
	   	
   /**
      Construct a Connection object.
      @param s a MailSystem object
      @param p a Telephone object
   */
	
	
	public Connection(MailSystem s)
	{
	      system = s;
	      resetConnection();
	}
	   
	   public void addUI(UserInterface ui){
		   userInterfaces.add(ui);
	   }

	   public Mailbox getMailbox(){
		   currentMailbox = system.findMailbox(accumulatedKeys);
		   return currentMailbox;
	   }
	   
	   public void updateAccumulatedKeys(String addedKey, boolean reset){
		   if(reset)
			   accumulatedKeys = "";
		   else
			   accumulatedKeys+=addedKey;
	   }
	   
	   public boolean verifyConnectionPasscode(){
		   return currentMailbox.checkPasscode(accumulatedKeys);
	   }
	   
	   public void changePasscode(){
		   currentMailbox.setPasscode(accumulatedKeys);
	   }
	   

   /**
      Respond to the user's pressing a key on the phone touchpad
      @param key the phone key pressed by the user
   */
   public void dial(String key)
   {
	  status = status.dial(key, this); 
   }


   /**
      Record voice.
      @param voice voice spoken by the user
   */
   public void record(String voice)
   {
      if (status instanceof RecordingState  || status instanceof ChangeGreetingState)
         currentRecording += voice;
   }

   /**
      The user hangs up the phone.
   */
   public void hangup()
   {
      if (status instanceof RecordingState)
         currentMailbox.addMessage(new Message(currentRecording));
     resetConnection();
   }
   
   public void setGreeting(){
       currentMailbox.setGreeting(currentRecording);

   }
   public void resetRecord(){
	   currentRecording = "";
   }
   
   /**
      Reset the connection to the initial state and prompt
      for mailbox number
   */
   private void resetConnection()
   {
      currentRecording = "";
      accumulatedKeys = "";
      status = new ConnectedState();
  	  speakToAllUIs(messages.INITIAL_PROMPT);
   }


	public void speakToAllUIs(String output) {
			for(UserInterface ui : userInterfaces) 
				ui.speak(output);
	}
  

}











