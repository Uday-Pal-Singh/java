package assignment;

/*
Programmer: ENTER YOUR NAME
Course: Programming Fundamentals COIT 11222 T319
File: RockyCateringGUI.java
Purpose: Assignment Two -- Rocky Catering Service windowed application
Date: ENTER THE DATE
*/

import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.util.Scanner;


public class RockyCateringGUI extends JFrame implements ActionListener
{
	// constant for storing maximum no. of bookings
	int MaxBooking = 10;
	// instance variable for store current booking no.
			private int currentBooking = 0;
	// declaring an array of objects having two arguments Customer name and no. of guests
		private Booking bookingArray[] = new Booking[MaxBooking];
	
	private JLabel titleLabel = new JLabel("Rocky Catering Service Management System"); // program title
	private JLabel nameLabel = new JLabel("Customer name: ");// for prompt
	private JTextField nameField = new JTextField(26);      // for name entry

	private JLabel guestsLabel = new JLabel("Number of guests: ");// for prompt
	private JTextField guestsField = new JTextField(4);      // for number of guests entry
	private JTextArea displayTextArea = new JTextArea("", 16, 56); // declare text area
	private JScrollPane scrollPane; // scroll pane for the text area

	//  declare all of the buttons
	private JButton enterButton = new JButton("Enter"); // buttons
	private JButton displayButton = new JButton("Display All");
	private JButton searchButton = new JButton("Search");
	private JButton exitButton = new JButton("Exit");
  

	public RockyCateringGUI()
	{ // constructor create the Gui
		this.setLayout(new FlowLayout());			// set JFrame to FlowLayout

		titleLabel.setFont(new Font("Ariel", Font.BOLD, 22));
		add(titleLabel);
		add(nameLabel);
		add(nameField);
		add(guestsLabel);
		add(guestsField);

		// set text area to a monospaced font so the columns can be aligned using a format string
		displayTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		displayTextArea.setEditable(false); 			// make text area read only
		scrollPane = new JScrollPane(displayTextArea); 	// add text area to the scroll pane
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // just need vertical scrolling

		add(scrollPane);

		add(enterButton);
		add(displayButton);
		add(searchButton);
		add(exitButton);

		enterButton.addActionListener(this);		// add the action listener to the buttons
		displayButton.addActionListener(this);
		searchButton.addActionListener(this);
		exitButton.addActionListener(this);


		// when the user pushes the system close (X top right corner)
		addWindowListener( // override window closing method
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					exit();				// Attempt to exit application
				}
			}
		);
	}



	public void actionPerformed(ActionEvent e)
	{ // process the clicks on all of the buttons
		String command = e.getActionCommand();

		if (command.compareTo("Enter") == 0)
			enter();
		else if (command.compareTo("Display All") == 0)
			displayAll();
		else if (command.compareTo("Search") == 0)
			search();
		else if (command.compareTo("Exit") == 0)
			exit();
	}
	
	private void appendLine()
	{
		displayTextArea.append("-------------------------------------------------------\n");
	}

	
	private void enter()
	{
		// error message when maximum no of bookings have been reached
		if (currentBooking == MaxBooking) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Maximum number of bookings have been reached","Error" ,JOptionPane.ERROR_MESSAGE); 
		}	
		
	    // error message for not entering data in guests field and Customer name field
		    if ( guestsField.getText().compareTo("") == 0 ) {
			   JOptionPane.showMessageDialog(new JFrame(),
					"You must enter no. of guests","Error" ,JOptionPane.ERROR_MESSAGE);	
			}
	        if (nameField.getText().compareTo("") == 0) {
			   JOptionPane.showMessageDialog(new JFrame(),
			        "You must enter customer name","Error" ,JOptionPane.ERROR_MESSAGE);	
			}	
	
		//  Read in customer name and no. of guests information and add them to the booking array
	    /* if statement is used for preventing the program to store the charges if the name has 
	       not been entered */
           if (!guestsField.getText().equals("") && !nameField.getText().equals("")) {
        	String customerName = nameField.getText();
            int guests = Integer.parseInt(guestsField.getText());
            bookingArray[currentBooking] =  new Booking(customerName, guests);
            displayHeading();
           }
 
		//  Display customer name, number of guests and the booking charge to the text area   
            displayTextArea.append(String.format("%-30s%-17s$%-5.2f\n",
        		  bookingArray[currentBooking].getCustomerName(), 
        		  bookingArray[currentBooking].getGuests(),
        		  bookingArray[currentBooking].calculateCharge()));
         
         // clears the input of the input field
             nameField.setText("");
             guestsField.setText("");
             nameField.requestFocus();  // requests the focus shift to namefield
             currentBooking ++;
		}

	private void displayHeading()
	{
		displayTextArea.setText(String.format("%-30s%-17s%-6s\n",
				"Customer Name", "Guests", "Charge"));
		appendLine();
	}


	private void displayAll()
	{
		// error message if the booking are not entered
		   if (currentBooking == 0) {
			  JOptionPane.showMessageDialog(new JFrame(), "NO booking entered",
				   	"Error" ,JOptionPane.ERROR_MESSAGE);	
		      nameField.setText("");
	          guestsField.setText("");
		}
		
		//  display all of the entries 
            displayHeading();
            double TotalCharge = 0;
            int TotalGuests = 0 ;
            int x = 0 ; // integer used for looping
            while( x <  currentBooking ) {
            displayTextArea.append(String.format("%-30s%-17s$%-5.2f\n",
                    bookingArray[x].getCustomerName(), 
                    bookingArray[x].getGuests(),
            		bookingArray[x].calculateCharge()));
            TotalCharge += bookingArray[x].calculateCharge();
            TotalGuests += bookingArray[x].getGuests();
             x = x + 1;   
             }
            double averageGuests = (TotalGuests*1.0)/currentBooking;
        
            appendLine();
       
		//code for displaying average guests per booking and total charges collected
          displayTextArea.append(String.format("average Guests per Booking : %2.2f \n",averageGuests));
          displayTextArea.append(String.format("Total charges collected : $%2.2f \n",TotalCharge));
          nameField.requestFocus(); //shifts the focus to the namefield
	     }



	private void search()
	{
		// error message for no bookings 
		   if (currentBooking == 0) {
		       JOptionPane.showMessageDialog(new JFrame(), "NO booking entered",
				"Error" ,JOptionPane.ERROR_MESSAGE);	
			     nameField.setText("");
			     guestsField.setText("");
			         
				}
				
		// read  customer name and stores its value in name variable
		   String name ;
		   name = JOptionPane.showInputDialog(new JFrame(),"Enter the Customer name to be searched :"
			,"Rocky Catering Service Management System",JOptionPane.PLAIN_MESSAGE);
		   if (name.equals("")) {
			   JOptionPane.showMessageDialog(new JFrame(),"You must enter a search name"
						,"error",JOptionPane.ERROR_MESSAGE); // error for empty search field
		   }
			
		//  search for the customer name and view its entry
			for (int a = 0 ; a < currentBooking;a++) {
				if (name.compareTo( bookingArray[a].getCustomerName()) == 0) {
					 displayHeading();
					 displayTextArea.append(String.format("%-30s%-17s$%-5.2f\n",
			        		  bookingArray[a].getCustomerName(), 
			        		  bookingArray[a].getGuests(),
			        		  bookingArray[a].calculateCharge()));
				 break;
			}else if (a == (currentBooking - 1)) {
				JOptionPane.showMessageDialog(new JFrame(),"'"+name+"'"+" not found "
							,"error",JOptionPane.ERROR_MESSAGE);
			  }
			}
			 nameField.requestFocus(); // to shift the focus to the name field
		
	}


	private void exit()
	{ // display exit message and exit the app

		// display exit message
		JOptionPane.showMessageDialog(new JFrame(),"Thanks for using "
				+ "Rocky Catering Service Management System",
				"Rocky Catering Service Management System",JOptionPane.PLAIN_MESSAGE);
		
		System.exit(0);
	} // exit




	// Main method create instance of class
	public static void main(String[] args)
	{
		RockyCateringGUI f = new RockyCateringGUI();			// Create instance of class
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	// allow the code to close the program
		f.setBounds(200, 100, 470, 440);						// Define position and size of app
		f.setTitle("Rocky Catering Service Management System");		// Set the title of the app
		f.setVisible(true);										// Make the application visible
		f.setResizable(false);									// Make the window not resizable
	} // main

}
