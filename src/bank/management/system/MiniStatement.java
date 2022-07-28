package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
    String cardNumber, pinNumber;
    
    MiniStatement(String cardNumber, String pinNumber){
        
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        this.setLayout(null);
        
        JLabel name = new JLabel("Indian Bank");
        name.setBounds(150,20,100,20);
        this.add(name);
        
        JLabel card = new JLabel();
        card.setBounds(100,50,300,20);
        this.add(card);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,100,400,200);
        this.add(mini);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,200,20);
        this.add(balance);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '"+pinNumber+"'");
            
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardNumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12) );
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where cardnumber = '"+cardNumber+"'");
            
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>"); 
                
                if(rs.getString("Type").equals("Deposit")){
                         bal += Integer.parseInt(rs.getString("amount"));
                     } else if(rs.getString("Type").equals("Withdrawl")) {
                         bal -= Integer.parseInt(rs.getString("amount"));
                     }
            }
            balance.setText("Your Current Balance is Rs " + bal);
        } catch (Exception e){
            System.out.println(e);
        }
        
        
       
        this.setSize(400,600);
        this.setLocation(400,100);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }
    
    public static void main(String[] args){
        new MiniStatement("","");
    }
    
}
