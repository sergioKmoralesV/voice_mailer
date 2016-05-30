package db;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import core.Contact;
import core.Mailbox;
import core.Message;
import core.MessageQueue;

/**
 * This class demonstrates how to connect to MySQL and run some basic commands.
 * 
 * In order to use this, you have to download the Connector/J driver and add
 * its .jar file to your build path.  You can find it here:
 * 
 * http://dev.mysql.com/downloads/connector/j/
 * 
 * You will see the following exception if it's not in your class path:
 * 
 * java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost:3306/
 * 
 * To add it to your class path:
 * 1. Right click on your project
 * 2. Go to Build Path -> Add External Archives...
 * 3. Select the file mysql-connector-java-5.1.24-bin.jar
 *    NOTE: If you have a different version of the .jar file, the name may be
 *    a little different.
 *    
 * The user name and password are both "root", which should be correct if you followed
 * the advice in the MySQL tutorial. If you want to use different credentials, you can
 * change them below. 
 * 
 * You will get the following exception if the credentials are wrong:
 * 
 * java.sql.SQLException: Access denied for user 'userName'@'localhost' (using password: YES)
 * 
 * You will instead get the following exception if MySQL isn't installed, isn't
 * running, or if your serverName or portNumber are wrong:
 * 
 * java.net.ConnectException: Connection refused
 */
public class DBConnector {

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "ssdc8671985..";

	/** The name of the computer running MySQL */
	private final String serverName = "127.0.0.1";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "voice_mail";
	
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return conn;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	
	private ResultSet getRecords ( String command) throws SQLException{
		Connection conn = this.getConnection();
		Statement stmt = null;
		 try {
		        stmt = conn.createStatement();
		        return stmt.executeQuery(command); // This will throw a SQLException if it fails
		    } finally {
		    	// This will run whether we throw an exception or not
		        if (stmt != null) {}
		    }
	}
	
	private boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	/**
	 * Connect to MySQL and do some stuff.
	 * @param mailboxCount 
	 */
	
	public ArrayList<Mailbox> getMailboxes (int mailboxCount){
	     try{ 
			String sql = "SELECT * FROM Mailbox";
			ArrayList<Mailbox> mailboxes = new ArrayList<Mailbox>();
			ResultSet results = this.getRecords(sql);
			while(results.next()){
		         //Retrieve by column name
		         int id  = results.getInt("number");
		         if(id>mailboxCount)
		        	 break;
		         String passcode = results.getString("password");
		         String greeting = results.getString("greeting_message");
		         mailboxes.add(new Mailbox(id,passcode, greeting));
		      }
		      results.close();
		      return mailboxes;
	     }catch(SQLException e){
	    	 return new ArrayList<Mailbox>();
	     }
	}
	
	public void saveMailbox(int number, String password, String greeting){
		Connection conn = null;
		try{
			conn = this.getConnection();
			String updateString =
			        "UPDATE Mailbox SET password = '" + password + "', "
			        +"greeting_message = '"+ greeting +"'"
			        		+ "WHERE number = " + Integer.toString(number) +";"; 
			this.executeUpdate(conn, updateString);
		}catch (SQLException e){
			
		}
	}
	public void createMailbox(int number, String password, String greeting){
		Connection conn = null;
		try{
			conn = this.getConnection();
			String createString =
			        "INSERT INTO Mailbox (number, password, greeting_message) VALUES  (" 
			        			+ Integer.toString(number) +", '"
			        			+ password + "', '" 
			        			+ greeting +"');"; 
			this.executeUpdate(conn, createString);
		}catch (SQLException e){
			
		}
	}
	
	public int createMessage(int mailBoxNumber, String message){
		Connection conn = null;
		try{
			conn = this.getConnection();
			String createString =
			        "INSERT INTO Message (text, status, mailbox_id) VALUES  ('" 
			        			+ message +"', '"
			        			+ "NEW" + "', " 
			        			+ Integer.toString(mailBoxNumber) +");"; 
			this.executeUpdate(conn, createString);
			String getLastId = "SELECT MAX(id) as id FROM Message WHERE mailbox_id = "
						+Integer.toString(mailBoxNumber)+";";
			ResultSet results = this.getRecords(getLastId);
			results.next();
			int lastId = results.getInt("id");
			return lastId;
			}catch (SQLException e){
			
		}
		return -1;
	}
	
	public ArrayList<Message> getMessages(int number, String status){
		String sql = "SELECT id, text, status  FROM Message WHERE mailbox_id = "+Integer.toString(number)
					+" AND status = '"+status+"' ORDER BY id DESC;";
		 try{ 
			 ArrayList<Message> messages = new ArrayList<Message>();
				ResultSet results = this.getRecords(sql);
				while(results.next()){
			         //Retrieve by column name
			         Message newMessage  = new Message(results.getString("text"));
			         newMessage.setId(results.getInt("id"));
			         messages.add(newMessage);
			      }
			      results.close();
			      return messages;
		     }catch(SQLException e){
		    	 return new ArrayList<Message>();
		     }
	}
	public void saveMessage(int id, String text,String status){
		Connection conn = null;
		try{
			conn = this.getConnection();
			String updateString =
			        "UPDATE Message SET text = '" + text + "', "
			        +"status = '"+ status +"'"
			        + "WHERE id = " + Integer.toString(id) +";"; 
			this.executeUpdate(conn, updateString);
		}catch (SQLException e){
			
		}
	}
	
	public void saveContact(int id, String first_name,String last_name, String phone){
		Connection conn = null;
		try{
			conn = this.getConnection();
			String updateString =
			        "UPDATE Contact SET first_name = '" + first_name + "', "
			        +"last_name = '"+ last_name +"', "
			        +"phone_number = '"+ phone +"' "
			        + "WHERE id = " + Integer.toString(id) +";"; 
			this.executeUpdate(conn, updateString);
		}catch (SQLException e){
			
		}
	}

	public void deleteMessage(int id) {
		Connection conn = null;
		try{
			conn = this.getConnection();
			String updateString =
			        "DELETE FROM Message " 
			        + "WHERE id = " + Integer.toString(id) +";"; 
			this.executeUpdate(conn, updateString);
		}catch (SQLException e){
			
		}
	}
	
	public void deleteContact(int id) {
		Connection conn = null;
		try{
			conn = this.getConnection();
			String updateString =
			        "DELETE FROM Contact " 
			        + "WHERE id = " + Integer.toString(id) +";"; 
			this.executeUpdate(conn, updateString);
		}catch (SQLException e){
			
		}
	} 
	
	public int createContact(String first, String last, String number,int mailboxId ){
		Connection conn = null;
		try{
			conn = this.getConnection();
			String createString =
			        "INSERT INTO Contact (first_name, last_name, phone_number, mailbox_id) VALUES  ('" 
			        			+ first +"', '"
			        			+ last + "', '" 
			        			+ number +"', " 
			        			+ Integer.toString(mailboxId) +");"; 
			this.executeUpdate(conn, createString);
			String getLastId = "SELECT MAX(id) as id FROM Contact WHERE mailbox_id = "
					+Integer.toString(mailboxId)+" LIMIT 1;";
		ResultSet results = this.getRecords(getLastId);
		results.next();
		int lastId = results.getInt("id");
		return lastId;
		}catch (SQLException e){
			return -1;
		}
	}
	public ArrayList<Contact> getContacts(int mailboxNumber){
		 try{ 
				String sql = "SELECT * FROM Contact WHERE mailbox_id = " + Integer.toString(mailboxNumber) + ";";
				ArrayList<Contact> contacts = new ArrayList<Contact>();
				ResultSet results = this.getRecords(sql);
				while(results.next()){
			         //Retrieve by column name
			         int id  = results.getInt("id");
			         String first = results.getString("first_name");
			         String last = results.getString("last_name");
			         String phone = results.getString("phone_number");
			         Contact newContact =new Contact(first,last,phone);
			         newContact.setId(id);
			         contacts.add(newContact);
			      }
			      results.close();
			      return contacts;
		     }catch(SQLException e){
		    	 return new ArrayList<Contact>();
		     }
	}
}