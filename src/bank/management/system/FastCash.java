package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;   //ResultSet  //date class is in both pkg so we have to
import java.util.Date;            // mention it explicity here .Date
 
public class FastCash extends JFrame implements ActionListener {

    JButton deposit,withdraw,fastCash,miniStatement,pinChange,balanceEnq,back;
    String cardNumber;
    String pinNumber;
    
     FastCash(String cardNumber, String pinNumber){
         
         this.cardNumber = cardNumber;  // stores local var in golbal var
         this.pinNumber = pinNumber;
         setLayout(null);
         
         ImageIcon imgIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image img1 = imgIcon1.getImage().getScaledInstance(900,730,Image.SCALE_DEFAULT);
         ImageIcon imgIcon2 = new ImageIcon(img1);
         JLabel image = new JLabel(imgIcon2);
         image.setBounds(0,0,900,720);
         this.add(image);
         
         JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
         text.setBounds(230,250,700,35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System", Font.BOLD, 16));
         image.add(text);
         
         deposit = new JButton("Rs 100");
         deposit.setBounds(160,352,130,25);
         deposit.addActionListener(this);
         image.add(deposit);
         
         withdraw = new JButton("Rs 500");
         withdraw.setBounds(385,352,130,25);
         withdraw.addActionListener(this);
         image.add(withdraw);
         
         fastCash = new JButton("Rs 1000");
         fastCash.setBounds(160,381,130,25);
         fastCash.addActionListener(this);
         image.add(fastCash);
         
         miniStatement = new JButton("Rs 2000");
         miniStatement.setBounds(385,381,130,25);
         miniStatement.addActionListener(this);
         image.add(miniStatement);
         
         pinChange = new JButton("Rs 5000");
         pinChange.setBounds(160,409,130,25);
         pinChange.addActionListener(this);
         image.add(pinChange);
         
         balanceEnq = new JButton("Rs 10000");
         balanceEnq.setBounds(385,409,130,25);
         balanceEnq.addActionListener(this);
         image.add(balanceEnq);
         
         back = new JButton("Back");
         back.setBounds(385,437,130,25);
         back.addActionListener(this);
         image.add(back);
         
         this.setSize(900,730);
         this.setLocation(250,0);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setUndecorated(true);  // to hide window border
         this.setVisible(true);  // always place it at last
     }
     
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == back){
             this.setVisible(false);
             new Transactions(cardNumber, pinNumber).setVisible(true);
         } else {
             String amount = ((JButton)ae.getSource()).getText().substring(3);        //ae.getSource() returns an object so typecast it to JButton
                                                              // substring(3) to remove first 3 char (Rs 100 -> 100)
             System.out.println(amount);
                                                              
             Conn c = new Conn();
             
             try{
                 ResultSet rs = c.s.executeQuery("select * from bank where cardNumber = '"+cardNumber+"'");
                 int balance = 0;
                 while(rs.next()){
                     if(rs.getString("Type").equals("Deposit")){
                         balance += Integer.parseInt(rs.getString("amount"));
                     } else if(rs.getString("Type").equals("Withdrawl")) {
                         balance -= Integer.parseInt(rs.getString("amount"));
                     }
                 }
                 System.out.println("balance Fast Cash:"+ balance);
                 System.out.println("amount Fast Cash:"+ Integer.parseInt(amount));
                 
                 if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                     return;
                 }
                 Date date = new Date();
                 String query = "insert into bank values('"+cardNumber+"', '"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, " Rs " + amount + " Debited Successfully");
                 
                 this.setVisible(false);
                 new Transactions(cardNumber, pinNumber).setVisible(true);
                 
             } catch (Exception e){
                 System.out.println(e);
             }
                                                               
     }
     }
     
     public static void main(String[] args){
         new FastCash("","");
     }
}
