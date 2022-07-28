package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    String cardNumber, pinNumber;
    JButton back;
    
    BalanceEnquiry(String cardNumber, String pinNumber){
        this.setLayout(null);
        
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        
        ImageIcon imgIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img1 = imgIcon1.getImage().getScaledInstance(900,730,Image.SCALE_DEFAULT);
        ImageIcon imgIcon2 = new ImageIcon(img1);
        JLabel image = new JLabel(imgIcon2);
        image.setBounds(0,0,900,730);
        this.add(image);
        
        JButton back = new JButton("Back");
        back.setBounds(385,437,130,25);
        back.addActionListener(this);
        image.add(back);
        
         Conn c = new Conn();
         int balance = 0;   
             try{
                 ResultSet rs = c.s.executeQuery("select * from bank where cardNumber = '"+cardNumber+"'");
                 
                 while(rs.next()){
                     if(rs.getString("Type").equals("Deposit")){
                         balance += Integer.parseInt(rs.getString("amount"));
                     } else if(rs.getString("Type").equals("Withdrawl")) {
                         balance -= Integer.parseInt(rs.getString("amount"));
                     }
                 }
             } catch (Exception e){
                 System.out.println(e);
             }
             
             JLabel text = new JLabel("Your Current balance: "+ balance);
             text.setForeground(Color.WHITE);
             text.setBounds(250,300,400,30);
             text.setFont(new Font("Raleway", Font.BOLD, 18));
             image.add(text);
        
        this.setSize(900,730);
        this.setLocation(300,0);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        this.setVisible(false);
        new Transactions(cardNumber, pinNumber).setVisible(true);
    }
    
    public static void main(String[] args){
        new BalanceEnquiry("","");
    }
}
