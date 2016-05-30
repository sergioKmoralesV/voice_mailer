import static org.junit.Assert.*;

import org.junit.Test;

import core.Mailbox;
import core.Message;

public class MailboxTest {

	@Test
	public void createsNewMailboxWithEmptyMessageQueue() {
		Mailbox mailbox = new Mailbox(1,"1234","Hola");
		assertEquals("Hola",mailbox.getGreeting());
		assertNull(null,mailbox.getCurrentMessage());
		assertEquals(true,mailbox.checkPasscode("1234"));
	}
	
	@Test
	public void changesMailboxGreetingMessage(){
		Mailbox mailbox = new Mailbox(1,"1234","Hola");
		mailbox.setGreeting("Hola como estas?");
		assertEquals("Hola como estas?",mailbox.getGreeting());
	}
	
	@Test
	public void changesMailboxPasscode(){
		Mailbox mailbox = new Mailbox(1,"1234","Hola");
		mailbox.setPasscode("567");
		assertEquals(true,mailbox.checkPasscode("567"));
	}
	
	@Test
	public void addsNewMessageToTheNewMessagesQueue(){
		Mailbox mailbox = new Mailbox(1,"1234","Hola");
		Message new_message = new Message("Buenos dias");
		mailbox.addMessage(new_message);
		assertNotEquals(null,mailbox.getCurrentMessage());
	}
	
	@Test
	public void removeMessageFromNewMessagesQueue(){
		Mailbox mailbox = new Mailbox(1,"1234","Hola");
		Message new_message = new Message("Buenos dias");
		mailbox.addMessage(new_message);
		mailbox.removeCurrentMessage();
		assertNull(null,mailbox.getCurrentMessage());
	}
	
	@Test
	public void saveCurrentMessageToKeptMessagesQueue(){
		Mailbox mailbox = new Mailbox(1,"1234","Hola");
		Message new_message = new Message("Buenos dias");
		mailbox.addMessage(new_message);
		mailbox.saveCurrentMessage();
		assertNotEquals(null,mailbox.getCurrentMessage());
	}
	
	@Test 
	public void saveCurrentMessageFromEmptyNewMessages(){
		Mailbox mailbox = new Mailbox(1,"1234","Hola");
		mailbox.saveCurrentMessage();
		assertNull(null,mailbox.getCurrentMessage());
	}
	
	@Test
	public void removesFromKeptMessagesIfEmptyNewMessages(){
		Mailbox mailbox = new Mailbox(1,"1234","Hola");
		Message new_message = new Message("Buenos dias");
		mailbox.addMessage(new_message);
		mailbox.saveCurrentMessage();
		mailbox.removeCurrentMessage();
		assertNull(null,mailbox.getCurrentMessage());
	}
}
