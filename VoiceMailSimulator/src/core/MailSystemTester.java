package core;

import java.util.Scanner;

import gui.GUITelephone;
import gui.Telephone;
import gui.UserInterface;

/**
   This program tests the mail system. A single phone
   communicates with the program through System.in/System.out.
*/
public class MailSystemTester
{
   public static void main(String[] args)
   {
	      MailSystem system = new MailSystem(MAILBOX_COUNT);
	      Scanner console = new Scanner(System.in);
	      UserInterface consola = new Telephone(console);
	      GUITelephone gui = new GUITelephone();
	      gui.setVisible(true);
	      Connection c = new Connection(system);
	      c.addUI(gui);
	      c.addUI(consola);
	      gui.addConnection(c);
	      consola.run(c);
   }

   private static final int MAILBOX_COUNT = 20;
}
