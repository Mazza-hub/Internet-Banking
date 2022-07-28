package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  //  for ActionListener interface
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
   
    JRadioButton r1,r2,r3,r4;
    JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
    JButton submit, cancel;        
    String formno;
    
    SignupThree(String formno){
        
           this.formno = formno;
           this.setLayout(null);
        
           JLabel accountDetails = new JLabel("Page: 3 Account Details");
           accountDetails.setFont(new Font("Raleway",Font.BOLD,20));
           accountDetails.setBounds(300,30,300,40);
           this.add(accountDetails);
        
           JLabel type = new JLabel("Account Type:");
           type.setFont(new Font("Raleway",Font.BOLD,20));
           type.setBounds(100,100,200,30);
           this.add(type);
        
        
           r1 = new JRadioButton("Saving Account");
           r1.setBounds(100,140,200,30);
           r1.setBackground(Color.WHITE);
           this.add(r1);
      
           r2 = new JRadioButton("Current Account");
           r2.setBounds(500,140,200,30);
           r2.setBackground(Color.WHITE);
           this.add(r2);
        
           r3 = new JRadioButton("Fixed Deposit Account");
           r3.setBounds(100,180,200,30);
           r3.setBackground(Color.WHITE);
           this.add(r3);
        
           r4 = new JRadioButton("Reccuring Deposit Account");
           r4.setBounds(500,180,200,30);
           r4.setBackground(Color.WHITE);
           this.add(r4);
        
           ButtonGroup account = new ButtonGroup();
           account.add(r1);
           account.add(r2);
           account.add(r3);
           account.add(r4);
        
           JLabel card = new JLabel("Card Number:");
           card.setFont(new Font("Raleway",Font.BOLD,20));
           card.setBounds(100,220,150,40);
           this.add(card);
              
           JLabel number = new JLabel("XXXX-XXXX-XXXX-8798");
           number.setFont(new Font("Raleway",Font.BOLD,20));
           number.setBounds(300,220,300,40);
           this.add(number);
           
           JLabel cardmsg = new JLabel("Your 16 digit card number");
           cardmsg.setFont(new Font("Raleway",Font.PLAIN,13));
           cardmsg.setBounds(100,262,200,20);
           this.add(cardmsg);
           
           JLabel pin = new JLabel("PIN:");
           pin.setFont(new Font("Raleway",Font.BOLD,20));
           pin.setBounds(100,310,80,30);
           this.add(pin);
           
           JLabel pnumber = new JLabel("XXXX");
           pnumber.setFont(new Font("Raleway",Font.BOLD,20));
           pnumber.setBounds(300,310,120,30);
           this.add(pnumber);
        
           JLabel pinmsg = new JLabel("Your 4 digit card number");
           pinmsg.setFont(new Font("Raleway",Font.PLAIN,13));
           pinmsg.setBounds(100,350,200,20);
           this.add(pinmsg);
           
           JLabel accRequired = new JLabel("Account Required:");
           accRequired.setFont(new Font("Raleway",Font.BOLD,20));
           accRequired.setBounds(100,400,200,30);
           this.add(accRequired);
           
           cb1 = new JCheckBox("ATM Card");
           cb1.setBounds(100,450,140,30);
           cb1.setBackground(Color.WHITE);
           this.add(cb1);
           
           cb2 = new JCheckBox("Internet Banking");
           cb2.setBounds(500,450,140,40);
           cb2.setBackground(Color.WHITE);
           this.add(cb2);
           
           cb3 = new JCheckBox("Mobile Banking");
           cb3.setBounds(100,490,140,30);
           cb3.setBackground(Color.WHITE);
           this.add(cb3);
           
           cb4 = new JCheckBox("Email & SMS Alert");
           cb4.setBounds(500,490,140,30);
           cb4.setBackground(Color.WHITE);
           this.add(cb4);
           
           cb5 = new JCheckBox("Cheque Book");
           cb5.setBounds(100,530,140,30);
           cb5.setBackground(Color.WHITE);
           this.add(cb5);
           
           cb6 = new JCheckBox("E-Statement");
           cb6.setBounds(500,530,140,30);
           cb6.setBackground(Color.WHITE);
           this.add(cb6);
           
           cb7 = new JCheckBox("I hereby declare that all the information given are correct to the best of my knowledge.");
           cb7.setBounds(100,570,600,30); 
           cb7.setBackground(Color.WHITE);
           this.add(cb7);
           
           submit = new JButton("Submit");
           submit.setBounds(160,630,150,30);
           submit.setBackground(Color.BLACK);
           submit.setForeground(Color.WHITE);
           submit.setFont(new Font("Raleway",Font.BOLD,15));
           submit.addActionListener(this);
           this.add(submit);
           
           cancel = new JButton("Cancel");
           cancel.setBounds(460,630,150,30);
           cancel.setBackground(Color.BLACK);
           cancel.setForeground(Color.WHITE);
           cancel.setFont(new Font("Raleway",Font.BOLD,15));
           cancel.addActionListener(this);
           this.add(cancel);
           
        this.setSize(850,700);
        this.setLocation(300,30);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){ // overriding actionPerformed() of interface
        
        String accountType = null;
        
        if(ae.getSource() == submit){
            if(r1.isSelected()) {
                accountType = "Saving Account";
            } else if(r2.isSelected()) {
                accountType = "Current Account";
            } else if(r3.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if(r4.isSelected()) {
                accountType = "Reccuring Deposit Account";
            }
            
            Random random = new Random();  // java.util.* package
            String cardNumber = "" + Math.abs((random.nextLong() % 1000000L)); // to fixe first 10 no add it like this 
            cardNumber = "0502000100" + cardNumber;
            
            String pinNumber = "" + Math.abs(random.nextLong() % 10000); // to fix first no is always non-zero
           
            String facility = "";
            if(cb1.isSelected()){
                facility = facility + " ATM Card ";
            }
            if(cb2.isSelected()){
                facility = facility +  " Internet Banking ";
            }
            if(cb3.isSelected()){
                facility = facility + " Mobile Banking ";
            }
            if(cb4.isSelected()){
                facility = facility + " Email & SMS Alert ";
            }
            if(cb5.isSelected()){
                facility = facility + " Cheque Book ";
            }
            if(cb6.isSelected()){
                facility = facility + " E-Statement ";
            }
            
            String declaration = "";
            if(cb7.isSelected()){
                declaration += "Checked";
            }
            
            try {
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type Required.");  // do the remainings validation for
                } else if(declaration.equals("")){
                    JOptionPane.showMessageDialog(null, "Verify the declaration");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')"; 
                    conn.s.executeUpdate(query1);
                    String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber +"\n" + "Pin number: "+pinNumber);
                    
                    this.setVisible(false);
                    new Deposit(cardNumber,pinNumber).setVisible(true);
                    
                }
                
            } catch (Exception e){
                System.out.print(e);
            }
            
        } else if(ae.getSource() == cancel){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new SignupThree("");
    }
    
}
