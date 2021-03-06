import static org.junit.Assert.*;

import org.junit.Test;

import core.Message;
import core.MessageQueue;

public class MessageQueueTest {

	@Test
	public void createsANewMessageQueueWithNoMessages() {
		MessageQueue queue= new MessageQueue();
		assertEquals(0,queue.size());
		assertEquals(null, queue.peek());
	}
	
	@Test
	public void addsOneElementToTheMessageQueue(){
		MessageQueue queue= new MessageQueue();
		Message new_message= new Message("Hola Mundo");
		queue.add(0, new_message);
		assertEquals(1,queue.size());
		assertNotEquals(null, queue.peek());
	}
	
	@Test 
	public void deletesOneElementFromQueue(){
		MessageQueue queue= new MessageQueue();
		Message new_message= new Message("Hola Mundo");
		queue.add(0, new_message);
		queue.add(0, new_message);
		assertEquals(2,queue.size());
		queue.remove();
		assertEquals(1,queue.size());
	}

}
