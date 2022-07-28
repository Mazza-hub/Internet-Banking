package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
   
    JTextField amount;
    JButton deposit,back;
    String cardNumber;
    String pinNumber;
    
   Deposit(String cardNumber,String pinNumber){
       
    this.cardNumber = cardNumber;
    this.pinNumber = pinNumber;
    
    this.setLayout(null);
       
    ImageIcon imgIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));   
    Image img1 = imgIcon1.getImage().getScaledInstance(900,730,Image.SCALE_DEFAULT);
    ImageIcon imgIcon2 = new ImageIcon(img1);
    JLabel image = new JLabel(imgIcon2);
    image.setBounds(0,0,900,720);
    this.add(image);
    
    JLabel text = new JLabel("Enter amount you want to deposit");
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD, 16));
    text.setBounds(200,250,400,20);
    image.add(text);
    
    amount = new JTextField();
    amount.setFont(new Font("Raleway",Font.BOLD,18));
    amount.setBounds(170,280,320,25);
    image.add(amount);
    
    deposit = new JButton("Deposit");
    deposit.setBounds(385,409,130,25);
    deposit.addActionListener(this);
    image.add(deposit);
    
    back = new JButton("Back");
    back.setBounds(385,437,130,25);
    back.addActionListener(this);
    image.add(back);
    
    this.setSize(900,730);
    this.setLocation(250,0);
    this.setUndecorated(true);
    this.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == deposit){
           String number = amount.getText();
           Date date = new Date();   //util package
           if(number.equals("")){
               JOptionPane.showMessageDialog(null, "Enter a valid amount");
           }else{
               try{
                 Conn conn = new Conn();
                 String query = "insert into bank values('"+cardNumber+"', '"+pinNumber+"', '"+date+"', 'Deposit', '"+number+"')";
                 conn.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Rs "+ number + " Deposited Successfully");
                 this.setVisible(false);
                 new Transactions(cardNumber,pinNumber).setVisible(true);
                 
               } catch(Exception e){
                   System.out.println(e);
               }
             }
           
       } else if(ae.getSource() == back){
           this.setVisible(false);
           new Transactions(cardNumber,pinNumber).setVisible(true);
       }
   } 
   
   public static void main(String[] args){
       new Deposit("","");
   }
}
