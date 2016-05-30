package core;
/**
   A message left by the caller.
*/
public class Message
{
   /**
      Construct a Message object.
      @param messageText the message text
   */
   public Message(String messageText)
   {
      text = messageText;
   }

   /**
      Get the message text.
      @return message text
   */
   public String getText()
   {
      return text;
   }
   
   public int getId(){
	   return id;
   }
   
   public void setId(int dbMessageId)
   {
	   id = dbMessageId;
   }
   private String text;
   private int id;
}
