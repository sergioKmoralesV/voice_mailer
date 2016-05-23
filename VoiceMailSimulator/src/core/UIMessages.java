package core;

public class UIMessages {
	   public String INITIAL_PROMPT = 
	         "Enter mailbox number followed by #";      
	   public String MAILBOX_MENU_TEXT = 
	         "Enter 1 to listen to your messages\n"
	         + "Enter 2 to change your passcode\n"
	         + "Enter 3 to change your greeting\n"
	         + "Enter 4 to get into the contact menu";
	   public String MESSAGE_MENU_TEXT = 
	         "Enter 1 to listen to the current message\n"
	         + "Enter 2 to save the current message\n"
	         + "Enter 3 to delete the current message\n"
	         + "Enter 4 to return to the main menu";
	   public String CONTACT_MENU_TEXT =
			   "Enter 1 to view your contacts\n"
			  +"Enter 2 to create a new contact\n"
			  +"Enter 3 to select a contact\n"
			  +"Enter 4 to return to main menu.";
	   
	   public String CREATE_CONTACT_MENU = ""
	   		+ "Enter your contact information following the next format:\n"
			+ "FirstName, LastName, TelephoneNumber";
	   public String EDIT_CONTACT_MENU = "" 
			+ "Enter 1 to edit contact name\n" 
			+ "Enter 2 to edit contact last name\n"
			+ "Enter 3 to edit contact telephone number\n"
			+ "Enter 4 to delete contact\n"
			+ "Enter 5 to return to contact menu\n";
	   public String INCORRECT_PASSCODE = "Incorrect passcode. Try again!";
	   public String INCORRECT_MAILBOX = "Incorrect mailbox number. Try again!";
}
