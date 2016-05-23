import static org.junit.Assert.*;

import org.junit.Test;

import core.Message;

public class MessageTest {

	@Test
	public void createsAMessage() {
		Message mensaje = new Message("Hola");
		assertEquals("Hola", mensaje.getText());	
	}

}
