package core;
import java.util.ArrayList;
import java.util.List;

import db.DBConnector;

/**
   A mailbox contains messages that can be listed, kept or discarded.
*/
public class Mailbox
{
   /**
      Creates Mailbox object.
      @param aPasscode passcode number
      @param aGreeting greeting string
   */
	
	private MessageQueue newMessages;
	private MessageQueue keptMessages;
	private String greeting;
	private String passcode;
	private List<Contact> contacts;	  
	private DBConnector conn;
	private int number;


   public Mailbox(int aNumber, String aPasscode, String aGreeting)
   {
	  number = aNumber;
      passcode = aPasscode;
      greeting = aGreeting;
      newMessages = new MessageQueue();
      keptMessages = new MessageQueue();
  	  contacts = new ArrayList<Contact>();	   
   }

   /**
      Check if the passcode is correct.
      @param aPasscode a passcode to check
      @return true if the supplied passcode matches the mailbox passcode
   */
   public boolean checkPasscode(String aPasscode)
   {
      return aPasscode.equals(passcode);
   }

   /**
      Add a message to the mailbox.
      @param aMessage the message to be added
   */
   public void addMessage(Message aMessage)
   {
      newMessages.add(aMessage);
   }

   /**
      Get the current message.
      @return the current message
   */
   public Message getCurrentMessage()
   {
      if (newMessages.size() > 0)
         return newMessages.peek();
      else if (keptMessages.size() > 0)
         return keptMessages.peek();
      else
         return null;
   }

   /**
      Remove the current message from the mailbox.
      @return the message that has just been removed
   */
   public Message removeCurrentMessage()
   {
      if (newMessages.size() > 0)
         return newMessages.remove();
      else if (keptMessages.size() > 0)
         return keptMessages.remove();
      else
         return null;
   }

   /**
      Save the current message
   */
   public void saveCurrentMessage()
   {
      Message m = removeCurrentMessage();
      if (m != null)
         keptMessages.add(m);
   }

   /**
      Change mailbox's greeting.
      @param newGreeting the new greeting string
   */
   public void setGreeting(String newGreeting)
   {
	  conn = new DBConnector();
	  conn.saveMailbox(number, passcode, newGreeting);
      greeting = newGreeting;
   }

   /**
      Change mailbox's passcode.
      @param newPasscode the new passcode
   */
   public void setPasscode(String newPasscode)
   {
	  conn = new DBConnector();
	  conn.saveMailbox(number, newPasscode, greeting);
      passcode = newPasscode;
      
   }

   /**
      Get the mailbox's greeting.
      @return the greeting
   */
   public String getGreeting()
   {
      return greeting;
   }
   
   public String getContactList()
   {
	   
	   String output = "";
	   if(contacts.size() > 0){
		   int i = 1;
		   for(Contact contact: contacts)
		   {
			  output += i+") "+ contact.getContact()+"\n";
			  i++;
		   }
	   }
	   else
	   {
		   output="You have no contacts added!\n";
	   }
	   return output;
   }
   public void deleteContact(Contact contactToDelete){
	   contacts.remove(contactToDelete);
   }
   
   public void addContact(Contact newContact)
   {
	   contacts.add(newContact);
   }
   
   public Contact getContactFromList(int index)
   {
	   if(index<=contacts.size() && index>0)
		   return contacts.get(index-1);
	   return null;
   }
}
