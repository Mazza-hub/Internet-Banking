package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*; 
import java.sql.*;

//Login class
public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField; 
    JPasswordField pinTextField;

    Login(){
        this.setTitle("ATM");
        this.setLayout(null); //bydefault center so use null for costome
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); //get from disk
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // convert to img for edit porpose
        ImageIcon i3 = new ImageIcon(i2);          // convert to imageicon 
        JLabel label = new JLabel(i3);            // converted to label to put on frame
        label.setBounds(70, 10, 100, 100);         // to place on top right corner
        this.add(label); // added on frame 

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));     // ..new keyword?
        text.setBounds(200,40,400,40);                       // used because setLayout is null
        this.add(text);
        
        JLabel cardno = new JLabel("Card NO.:- ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));     // ..new keyword?
        cardno.setBounds(120,150,150,40); // used because setLayout is null
        this.add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,155,250,28);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(cardTextField);
        
        JLabel pin = new JLabel("PIN:- ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));     // ..new keyword?
        pin.setBounds(120,220,150,40);                     // used because setLayout is null
        this.add(pin);
       
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,225,250,28);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        this.add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        this.add(clear);
        
        signup = new JButton("SIGNUP");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        this.add(signup);

        getContentPane().setBackground(Color.WHITE);
        this.setSize(800,480);
        this.setVisible(true);
        this.setLocation(300,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // defines the button function
    public void actionPerformed(ActionEvent ae){           // override because of interface ActionListener
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText(""); 
        }
        else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();        // -- due to password field
            
            String query = "select * from login where cardnumber = '"+cardNumber+"' and pinnumber = '"+pinNumber+"'";
            
            try{
               ResultSet rs =  conn.s.executeQuery(query);  //ResultSet to store the return data;  executeQuery() for DDL
               if(rs.next()){                               //gives true or false
                   this.setVisible(false);
                   new Transactions(cardNumber,pinNumber).setVisible(true);
               } else {
                   JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin Number");
               }
            } catch (Exception e) {
               System.out.println(e); 
            }
        }
        else if(ae.getSource() == signup){   // open signup form after clicking on signup button    
            setVisible(false);
            new SignupOne().setVisible(true);   //new SignupOne() is object
        }                               
    }

    public static void main(String[] args) {
        new Login();
    }
}
