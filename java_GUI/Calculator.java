package java_GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

	JLabel l1,l2;
	JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bdiv, bmul, bsub, badd, bequal, bdot,bclear,bundo;
	JTextField t1 = new JTextField(12);
	 Font bigFont = t1.getFont().deriveFont(Font.PLAIN, 18f);
	 Font VbigFont = t1.getFont().deriveFont(Font.PLAIN, 17f);
	public Calculator() {

		// some of the components of JFrame
		l1 = new JLabel("Enter the data here :               ");
		l2 = new JLabel("                                    ");
		l2.setFont(VbigFont);
        t1.setFont(bigFont);
		// all the buttons of JFrame
		b7 = new JButton(" 7 ");
		b8 = new JButton(" 8 ");
		b9 = new JButton(" 9 ");
		bdiv = new JButton(" / ");
		b4 = new JButton(" 4 ");
		b5 = new JButton(" 5 ");
		b6 = new JButton(" 6 ");
		bmul = new JButton(" * ");
		b1 = new JButton(" 1 ");
		b2 = new JButton(" 2 ");
		b3 = new JButton(" 3 ");
		bsub = new JButton(" - ");
		bdot = new JButton(" . ");
		b0 = new JButton(" 0 ");
		bequal = new JButton(" = ");
		badd = new JButton(" + ");
        bclear = new JButton(" C ");
        bundo = new JButton(" CE ");
		// adding all the components to JFrame
		add(l1);
		add(t1);
        add(l2);
        
		// adding all the buttons to the JFrame
		add(b7);
		add(b8);
		add(b9);
		add(bdiv);
		add(b4);
		add(b5);
		add(b6);
		add(bmul);
		add(b1);
		add(b2);
		add(b3);
		add(bsub);
		add(bdot);
		add(b0);
		add(bequal);
		add(badd);
		add(bundo);
		add(bclear);

		// action listener for all the buttons
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bmul.addActionListener(this);
		bsub.addActionListener(this);
		bequal.addActionListener(this);
		badd.addActionListener(this);
		bdiv.addActionListener(this);
		bclear.addActionListener(this);
		bundo.addActionListener(this);

		// all the methods for the JFrame
		setLayout(new FlowLayout()); // setting the layout
		setTitle("CALCULATOR"); // setting the title of the program
		setResizable(false); // making the window non resizeable
		setBounds(500, 275, 230, 260); // setting the boundary of the window
		setVisible(true); // making JFrame visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // creating the default close operation on clicking cross

	}
     // programming the actions performed by all the buttons
	public void actionPerformed(ActionEvent a) {
		String action = a.getActionCommand();

		if (action.equals(" + ")) {
			t1.setText(t1.getText() + "+");
		} else if (action.equals(" - ")) {
			t1.setText(t1.getText() + "-");
		} else if (action.equals(" * ")) {
			t1.setText(t1.getText() + "*");
		} else if (action.equals(" / ")) {
			t1.setText(t1.getText() + "/");
		} else if (action.equals(" = ")) {
			opperation();
		} else if (action.equals(" 0 ")) {
			t1.setText(t1.getText() +"0" );
		} else if (action.equals(" 1 ")) {
			t1.setText(t1.getText() + "1");
		} else if (action.equals(" 2 ")) {
			t1.setText(t1.getText() + "2");
		} else if (action.equals(" 3 ")) {
			t1.setText(t1.getText() + "3");
		} else if (action.equals(" 4 ")) {
			t1.setText(t1.getText() + "4");
		} else if (action.equals(" 5 ")) {
			t1.setText(t1.getText()+"5");
		} else if (action.equals(" 6 ")) {
			t1.setText(t1.getText() + "6");
		} else if (action.equals(" 7 ")) {
			t1.setText(t1.getText() + "7");
		} else if (action.equals(" 8 ")) {
			t1.setText(t1.getText() + "8");
		} else if (action.equals(" 9 ")) {
			t1.setText(t1.getText() + "9");
		}else if (action.equals(" C ")) {
			t1.setText("");
		}else if (action.equals(" CE ")) {
			String last_char = t1.getText();
			t1.setText(last_char.substring(0, (last_char.length()-1)));
		}
	}

	// operation method contains the code for all the operations performed
	private void opperation() {
		String textInput = t1.getText();
		int x, y, z,l;
        l = 0;
        
        
		if (textInput.indexOf("*") != -1) {
			z = textInput.indexOf("*");
			x = Integer.parseInt(textInput.substring(0, z));
			y = Integer.parseInt(textInput.substring(z + 1, textInput.length()));
			l = x * y;
		} else if (textInput.indexOf("/") != -1) {
			z = textInput.indexOf("/");
			x = Integer.parseInt(textInput.substring(0, z));
			y = Integer.parseInt(textInput.substring(z + 1, textInput.length()));
			l = x / y ;
		} else if (textInput.indexOf("-") != -1) {
			z = textInput.indexOf("-");
			x = Integer.parseInt(textInput.substring(0, z));
			y = Integer.parseInt(textInput.substring(z + 1, textInput.length()));
			l = x - y ;
		} else if (textInput.indexOf("+") != -1) {
			z = textInput.indexOf("+");
			x = Integer.parseInt(textInput.substring(0, z));
			y = Integer.parseInt(textInput.substring(z + 1, textInput.length()));
            l = x + y ;
		}
		t1.setText("ans :"+l);
	}

}
