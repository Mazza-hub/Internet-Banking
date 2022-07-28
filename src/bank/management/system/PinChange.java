package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{
    
    JTextField pin, rePin;
    JButton change, back;
    String cardNumber, pinNumber;
    
    PinChange(String cardNumber, String pinNumber){
        
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        this.setLayout(null);
    
        ImageIcon imgIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img1 = imgIcon1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
        ImageIcon imgIcon2 = new ImageIcon(img1);
        JLabel image = new JLabel(imgIcon2);
        image.setBounds(0,0,900,730);
        this.add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN NUMBER");
        text.setBounds(230,250,400,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
    
        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setBounds(230,300,100,30);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 15));
        image.add(pintext);
        
        pin = new JTextField();
        pin.setFont(new Font("Raleway", Font.BOLD, 15));
        pin.setBounds(350,300,100,25);
        image.add(pin);
        
        JLabel repintext = new JLabel("RE-ENTER PIN:");
        repintext.setBounds(230,360,130,30);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 15));
        image.add(repintext);
        
        rePin = new JTextField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 15));
        rePin.setBounds(350,360,100,25);
        image.add(rePin);
        
        change = new JButton("CHANGE");
        change.setBounds(220,430,100,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(350,430,100,30);
        back.addActionListener(this);
        image.add(back);
        
        this.setSize(900,730);
        this.setLocation(300,0);
        this.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == change){
            try {
            String newPin = pin.getText();
            String reEnterPin = rePin.getText();
            
                if(!newPin.equals(reEnterPin)){
                    JOptionPane.showMessageDialog(null, "Entered pin doesnot match");
                    return;
                }
                if(newPin.equals("")){
                    JOptionPane.showMessageDialog(null, "please Enter new Pin");
                    return;
                }
                if(reEnterPin.equals("")){
                    JOptionPane.showMessageDialog(null, "please Re-Enter new Pin");
                    return;
                }
            
                System.out.println("reEnterPin "+ reEnterPin);
                System.out.println("pinNumber "+ pinNumber);
                Conn conn = new Conn();
                
                String query1 = "update bank set pinnumber = '"+reEnterPin+"' where pinnumber = '"+pinNumber+"'";
                String query2 = "update login set pinnumber = '"+reEnterPin+"' where pinnumber = '"+pinNumber+"'";
                String query3 = "update signupthree set pinnumber = '"+reEnterPin+"' where pinnumber = '"+pinNumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
                this.setVisible(false);
                new Transactions(cardNumber,reEnterPin).setVisible(true);
                
            } catch(Exception e){
                System.out.println(e);
            }
        } else {
            this.setVisible(false);
            new Transactions(cardNumber,pinNumber).setVisible(true);
        }
        
    }
    
    public static void main(String[] args){
        new PinChange("","");
    }

}
