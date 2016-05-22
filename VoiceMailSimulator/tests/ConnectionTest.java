import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gui.Telephone;
import gui.UserInterface;
import root.Connection;
import root.MailSystem;
import root.Mailbox;
import root.Message;
import root.UIMessages;

public class ConnectionTest {

	MailSystem mailSystem;
	UserInterface phone;
	Connection conn;
	Mailbox currentMailbox;
	List<UserInterface> uis = new ArrayList<UserInterface>();
	UIMessages messages = new UIMessages();	
	@Before
	public void setUp(){
		mailSystem = mock(MailSystem.class);
		phone = mock(Telephone.class);
		conn = new Connection(mailSystem);
		conn.addUI(phone);
		currentMailbox = mock(Mailbox.class);
	}
	
	@Test
	public void createsConnectionAndGetIntoIncorrectMailboxSoGetErrorMessage() {		
		when(mailSystem.findMailbox("20")).thenReturn(currentMailbox);
		
		sendOptionFollowedBySpecialCharacter("1");

		verify(phone).speak("Incorrect mailbox number. Try again!");
	}
	
	@Test
	public void createsConnectionButSendErrorMessageForWrongPassword() {
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("2")).thenReturn(false);
		
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("2");
		
		verify(phone).speak("Incorrect passcode. Try again!");
	}
	
	@Test
	public void createsConnectionAndSendMailboxMenuWhenEntersCorrectPassword() {
		
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true);
		
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		
		verify(phone).speak(messages.MAILBOX_MENU_TEXT);
	}
	
	@Test
	public void gettingIntoChangePasswordOption(){
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true);
		
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		sendStringToConnection("2");		
		
		verify(phone).speak("Enter new passcode followed by the # key");
	}
	
	@Test
	public void gettingIntoChangeGreetingOption(){
		String mailBoxText = "Record your greeting, then press the # key";

		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true);
		
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		sendStringToConnection("3");		
		
		verify(phone).speak(mailBoxText);
	}
	
	@Test
	public void readsMessagesFromEmptyMailbox(){
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true);

		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		sendStringToConnection("1");
		sendStringToConnection("1");

		verify(phone).speak("No messages.\n"+messages.MESSAGE_MENU_TEXT);
	}
	
	@Test 
	public void readsMessagesFromMailboxWithMessages(){
		String message = "hola";
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true);
		when(currentMailbox.getCurrentMessage()).thenReturn(new Message(message));

		sendOptionFollowedBySpecialCharacter("1");
		leavesMessageAtCurrentMailbox(message);
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		sendStringToConnection("1");
		sendStringToConnection("1");
		
		verify(phone).speak(message+"\n"+messages.MESSAGE_MENU_TEXT);	
	}
	
	@Test
	public void savesMessageFromMailboxWithOneMessage(){
		String message = "hola";
		
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true);
		when(currentMailbox.getCurrentMessage()).thenReturn( new Message(message));
		
		sendOptionFollowedBySpecialCharacter("1");
		sendStringToConnection(message);
		conn.hangup();
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		sendStringToConnection("1");
		sendStringToConnection("2");
		sendStringToConnection("1");

		verify(phone).speak(message+"\n"+messages.MESSAGE_MENU_TEXT);
	}
	
	@Test
	public void deletesMessageFromMailboxWithOneMessage(){
		String message = "hola";
		
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true);
		when(currentMailbox.removeCurrentMessage()).thenReturn(new Message(message));
		
		sendOptionFollowedBySpecialCharacter("1");
		conn.record(message);
		conn.hangup();
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		sendStringToConnection("1");
		sendStringToConnection("3");
		sendStringToConnection("1");

		verify(phone).speak("No messages.\n"+messages.MESSAGE_MENU_TEXT);
	}
	
	@Test
	public void returnsFromHearingMessagesToMailboxMenu(){
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true);
		
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		sendStringToConnection("1");
		sendStringToConnection("4");

		verify(phone, times(2)).speak(messages.MAILBOX_MENU_TEXT);
	}
	
	@Test
	public void changesPasswordAndVerifiesIt(){
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true,false);
		
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		sendStringToConnection("2");
		sendOptionFollowedBySpecialCharacter("1");
		conn.hangup();
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		
		verify(phone).speak("Enter mailbox number followed by #");
		verify(phone).speak("Incorrect passcode. Try again!");
	}
	
	@Test
	public void selectNonValidOptionOnMessageMenu(){
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true);
		
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		conn.record("1");
		sendStringToConnection("1");
		sendStringToConnection("5");

		verify(phone).speak(messages.MESSAGE_MENU_TEXT);
	}
	
	@Test
	public void selectNonValidOptionOnMailboxMenu(){
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true);
		
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		sendStringToConnection("5");

		verify(phone).speak(messages.MAILBOX_MENU_TEXT);
	}
	
	@Test
	public void changesGreetingMessageAndCheckingChangesByEnteringAgain(){
		String greeting = "Greeting";
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true);
		when(currentMailbox.getGreeting()).thenReturn(greeting);
		
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		sendStringToConnection("3");
		conn.record(greeting);
		sendStringToConnection("#");
		sendStringToConnection("h");
		sendOptionFollowedBySpecialCharacter("1");
		
		verify(phone).speak(greeting);

	}
	
	@Test
	public void changesGreetingMessageAndKeepRecording(){
		String greeting = "Greeting";
		when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
		when(currentMailbox.checkPasscode("1")).thenReturn(true);
		when(currentMailbox.getGreeting()).thenReturn(greeting);
		
		sendOptionFollowedBySpecialCharacter("1");
		sendOptionFollowedBySpecialCharacter("1");
		sendStringToConnection("3");
		conn.record(greeting);
		conn.dial(greeting);
		sendStringToConnection("#");
		sendStringToConnection("h");
		sendOptionFollowedBySpecialCharacter("1");
		
		verify(phone).speak(greeting);

	}
	
	
	private void leavesMessageAtCurrentMailbox(String option){
		sendStringToConnection(option);
		sendStringToConnection("h");
	}
	
	private void sendOptionFollowedBySpecialCharacter(String option){
		conn.dial(option);
		conn.dial("#");
	}
	

	private void sendStringToConnection(String option){
		conn.dial(option);
	}
}
