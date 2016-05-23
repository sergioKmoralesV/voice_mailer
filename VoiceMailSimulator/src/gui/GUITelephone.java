package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import core.Connection;

public class GUITelephone extends JFrame implements UserInterface {


	private JPanel contentPane;
	private static JTextField inputTextField;
	private JLabel labelForTextInput;
	private static Connection connection;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUITelephone() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		inputTextField = new JTextField();
		inputTextField.setColumns(10);

		
		JButton number1 = new JButton("1");
		number1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText( "1");
			}
		});
		
		JButton number2 = new JButton("2");
		number2.setToolTipText("");
		number2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText( "2");

			}
		});
		
		JButton number3 = new JButton("3");
		number3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText( "3");
			}
		});
		
		JButton number6 = new JButton("6");
		number6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText( "6");
			}
		});
		
		JButton number5 = new JButton("5");
		number5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText( "5");
				
			}
		});
		
		JButton number4 = new JButton("4");
		number4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText( "4");
			}
		});
		
		JButton number9 = new JButton("9");
		number9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText( "9");

			}
		});
		
		JButton number8 = new JButton("8");
		number8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText( "8");
			}
		});
		
		JButton number7 = new JButton("7");
		number7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText( "7");

			}
		});
		
		JButton button_hang_up = new JButton("Hang Up\n");
		button_hang_up.setBackground(new Color(250, 128, 114));
		button_hang_up.setForeground(new Color(0, 0, 0));
		button_hang_up.setFont(new Font("Lato", Font.PLAIN, 12));
		button_hang_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText("H");
				pressedButton();
			}
		});
		
		JButton button_hash = new JButton("#");
		button_hash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText("#");

			}
		});
		button_hash.setBackground(new Color(144, 238, 144));
		
		JButton number0 = new JButton("0");
		number0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText( "0");
			}
		});
		
		JButton button_asterisk = new JButton("*");
		button_asterisk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText( "*");
			}
		});
		button_asterisk.setBackground(new Color(144, 238, 144));
		
		JButton button_accept = new JButton("Accept");
		button_accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedButton();
			}
		});
		button_accept.setForeground(Color.BLACK);
		button_accept.setFont(new Font("Lato", Font.PLAIN, 12));
		button_accept.setBackground(new Color(250, 128, 114));
		
		JScrollPane scrollPane = new JScrollPane(labelForTextInput, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(127)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(number7, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addGap(12)
											.addComponent(number8, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(button_asterisk, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(number0, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(button_hash, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addComponent(number9, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_hang_up, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(13)
									.addComponent(button_accept, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(2))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(number1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(number2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(number3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(number4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addGap(12)
										.addComponent(number5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addGap(12)
										.addComponent(number6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addComponent(inputTextField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(inputTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(number2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(number3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(number1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(number4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(number5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(number6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(number7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(number8, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(number9, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_hash, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(number0, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_asterisk, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_hang_up, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_accept, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18))
		);
		
		labelForTextInput = new JLabel("<html>\n\t<center>\n\t\tEnter mailbox number followed by #\n\t</center>\n</html>");
		scrollPane.setViewportView(labelForTextInput);
		labelForTextInput.setToolTipText("");
		labelForTextInput.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.setLayout(gl_contentPane);
	}

	   private static final int MAILBOX_COUNT = 20;
	   
	   public void speak(String output) {
		   output = output.replaceAll("(\r\n|\n)", "<br />");
			labelForTextInput.setText("<html><center>"+ output+"</center></html>");
		}

		public void pressedButton(){
		     
		         String input = inputTextField.getText();
		         if (input == null) return;
		         if (input.equalsIgnoreCase("H"))
		            connection.hangup();
		         else if (input.equalsIgnoreCase("Q"))
		        	 this.dispose();
		        else if (input.length() == 1 && "1234567890#".indexOf(input) >= 0)
		            connection.dial(input);
		         else
		            connection.record(input);
		      
		}
		
		public void run(Connection c) {
			
		}

		public void addConnection(Connection c){
			connection = c;
		}

}
