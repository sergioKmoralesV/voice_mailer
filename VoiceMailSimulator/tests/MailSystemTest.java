import static org.junit.Assert.*;

import org.junit.Test;

import root.MailSystem;

public class MailSystemTest {

	@Test
	public void createsMailSystemFindMailBox1InMailboxWithSize2() {
		MailSystem mailSystem = new MailSystem(2);
		assertNull(mailSystem.findMailbox("1").getCurrentMessage());
	}

	@Test
	public void createsMailSystemFindMailBox3InMailboxWithSize2() {
		MailSystem mailSystem = new MailSystem(2);
		assertNull(mailSystem.findMailbox("3"));
	}
	
	@Test
	public void createsMailSystemFindMailBox0InMailboxWithSize2() {
		MailSystem mailSystem = new MailSystem(2);
		assertNull(mailSystem.findMailbox("0"));
	}

}
