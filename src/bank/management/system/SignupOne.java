package bank.management.system;

import com.toedter.calendar.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener {  //AL is an interface used here for next button action
    
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,cityTextField,stateTextField,pinTextField;
    JRadioButton male,female,others,married,unmarried,other;
    JDateChooser dateChooser;
    JButton next;

    SignupOne() {

        this.setLayout(null);
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 10000L) + 1000L;
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setBounds(120,35,600,40);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        this.add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details ");
        personalDetails.setBounds(300,88,300,40);
        personalDetails.setFont(new Font("Raleway", Font.BOLD,20));
        this.add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setBounds(120,150,150,30);
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300,150,300,30);
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(120,200,150,30);
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300,200,300,30);
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(fnameTextField);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setBounds(120,250,150,30);
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,250,150,30);
        dateChooser.setForeground(new Color(105,05,105));
        this.add(dateChooser);
       
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(120,300,150,30);
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 300,80,30);
        male.setBackground(Color.WHITE);
        this.add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(400, 300,70,30);
        female.setBackground(Color.WHITE);
        this.add(female);

        others = new JRadioButton("Others");
        others.setBounds(500, 300,80,30);
        others.setBackground(Color.WHITE);
        this.add(others);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(others);


        JLabel email = new JLabel("Email Address:");
        email.setBounds(120,350,150,30);
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(email);
       
        emailTextField = new JTextField();
        emailTextField.setBounds(300,350,300,30);
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(emailTextField);

        JLabel martial = new JLabel("Marital Status:");
        martial.setBounds(120,400,150,30);
        martial.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(martial);
        
        married = new JRadioButton("Married");
        married.setBounds(300,400,70,30);
        married.setBackground(Color.WHITE);
        this.add(married);
       
        unmarried = new JRadioButton("UnMarried");
        unmarried.setBounds(390,400,90,30);
        unmarried.setBackground(Color.WHITE);
        this.add(unmarried);
       
        other = new JRadioButton("Other");
        other.setBounds(500,400,70,30);
        other.setBackground(Color.WHITE);
        this.add(other);

        ButtonGroup martialGroup = new ButtonGroup();
        martialGroup.add(married);
        martialGroup.add(unmarried);
        martialGroup.add(other);

        JLabel city = new JLabel("City:");
        city.setBounds(120,450,150,30);
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(city);
        
        cityTextField = new JTextField();
        cityTextField.setBounds(300,450,300,30);
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setBounds(120,500,150,30);
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(state);
       
        stateTextField = new JTextField();
        stateTextField.setBounds(300,500,300,30);
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(stateTextField);

        JLabel pincode = new JLabel("PinCode:");
        pincode.setBounds(120,550,150,30);
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(pincode); 

        pinTextField = new JTextField();
        pinTextField.setBounds(300,550,300,30);
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(520,600,80,30);
        next.addActionListener(this);
        this.add(next);

        this.setSize(850,700);
        this.setLocation(300,30);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random; // random is Long; convert it to string using "" +
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if( male.isSelected() ){
            gender = "Male";
        } else if( female.isSelected() ) {
            gender = "Female";
        } else if ( others.isSelected() ){
            gender = "Others";
        }
        String email = emailTextField.getText();

        String marital = null;
        if( male.isSelected() ){
            marital = "Married";
        } else if( female.isSelected() ) {
            marital = "Unmarried";
        } else if ( others.isSelected() ){
            marital = "Other";
        }
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try{
            if(name.equals("")){     //task - do validation for rest fields
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);  // executeUpdate() for DML commands
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
        } catch (Exception e) { 
            System.out.println(e);
        }

    }

    public static void main(String[] args){
        new SignupOne();
    }
}

