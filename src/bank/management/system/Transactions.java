package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdraw,fastCash,miniStatement,pinChange,balanceEnq,exit;
    String cardNumber, pinNumber;
    
     Transactions(String cardNumber, String pinNumber) {
         
         this.cardNumber = cardNumber;  // stores local var in golbal var
         this.pinNumber = pinNumber;
         
         System.out.println("cardNumber "+ cardNumber);
         System.out.println("pinNumber "+ pinNumber);
         setLayout(null);
         
         ImageIcon imgIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image img1 = imgIcon1.getImage().getScaledInstance(900,730,Image.SCALE_DEFAULT);
         ImageIcon imgIcon2 = new ImageIcon(img1);
         JLabel image = new JLabel(imgIcon2);
         image.setBounds(0,0,900,720);
         this.add(image);
         
         JLabel text = new JLabel("Please select your Transaction");
         text.setBounds(230,250,700,35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System", Font.BOLD, 16));
         image.add(text);
         
         deposit = new JButton("Deposit");
         deposit.setBounds(160,352,130,25);
         deposit.addActionListener(this);
         image.add(deposit);
         
         withdraw = new JButton("Cash Withdraw");
         withdraw.setBounds(385,352,130,25);
         withdraw.addActionListener(this);
         image.add(withdraw);
         
         fastCash = new JButton("Fast Cash");
         fastCash.setBounds(160,381,130,25);
         fastCash.addActionListener(this);
         image.add(fastCash);
         
         miniStatement = new JButton("Mini Statement");
         miniStatement.setBounds(385,381,130,25);
         miniStatement.addActionListener(this);
         image.add(miniStatement);
         
         pinChange = new JButton("Pin Change");
         pinChange.setBounds(160,409,130,25);
         pinChange.addActionListener(this);
         image.add(pinChange);
         
         balanceEnq = new JButton("Balance Enquiry");
         balanceEnq.setBounds(385,409,130,25);
         balanceEnq.addActionListener(this);
         image.add(balanceEnq);
         
         exit = new JButton("Exit");
         exit.setBounds(385,437,130,25);
         exit.addActionListener(this);
         image.add(exit);
         
         this.setSize(900,730);
         this.setLocation(250,0);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setUndecorated(true);  // to hide window border
         this.setVisible(true);  // always place it at last
     }
     
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == exit){
             System.exit(0);
         } else if(ae.getSource() == deposit){
             this.setVisible(false);
             new Deposit(cardNumber,pinNumber).setVisible(true);
         }else if(ae.getSource() == withdraw){
             this.setVisible(false);
             new Withdrawl(cardNumber,pinNumber).setVisible(true);
         }else if(ae.getSource() == fastCash){
             this.setVisible(false);
             new FastCash(cardNumber,pinNumber).setVisible(true);
         }else if(ae.getSource() == pinChange){
             this.setVisible(false);
             new PinChange(cardNumber,pinNumber).setVisible(true);
         }else if(ae.getSource() == balanceEnq){
             this.setVisible(false);
             new BalanceEnquiry(cardNumber,pinNumber).setVisible(true);
         }else if(ae.getSource() == miniStatement){
             new MiniStatement(cardNumber,pinNumber).setVisible(true);
         }
     }
     
     public static void main(String[] args){
         new Transactions("","");
     }
}
