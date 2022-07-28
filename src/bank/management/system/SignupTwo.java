package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {  //AL is an interface used here for next button action
    
    long random;
    JTextField pan,aadhar;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,occupation,education;
    JButton next;
    String formno;

    SignupTwo(String formno) {

        this.formno = formno;
        this.setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - Page 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details ");
        additionalDetails.setBounds(300,30,300,40);
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,20));
        this.add(additionalDetails);
        
        JLabel check = new JLabel("Religion:");
        check.setBounds(120,100,150,30);
        check.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(check);
        
        String[] valReligion = {"Hindu","Muslim","Sikh","Christion","Others"}; 
        religion = new JComboBox(valReligion);
        religion.setBounds(300,100,300,30);
        religion.setBackground(Color.WHITE);
        this.add(religion);

        JLabel name = new JLabel("Category:");
        name.setBounds(120,150,150,30);
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(name);

        String[] valCategory = {"General","OBC","SC","ST"};
        category = new JComboBox(valCategory);
        category.setBounds(300,150,300,30);
        category.setBackground(Color.WHITE);
        this.add(category);
        
        JLabel fname = new JLabel("Income:");
        fname.setBounds(120,200,150,30);
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(fname);

        String[] incomeCategory = {"null",">1,50,000",">2,50,000",">5,00,000","<10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,200,300,30);
        income.setBackground(Color.WHITE);
        this.add(income);

        JLabel dob = new JLabel("Educational:");
        dob.setBounds(120,260,150,30);
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(dob);
       
        JLabel gender = new JLabel("Qualification:");
        gender.setBounds(120,290,150,30);
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(gender);
        
        String[] educationValues = {"Non-Graduate","Graduate","Post_Graduate","Doctrate","Others"};
        education = new JComboBox(educationValues);
        education.setBackground(Color.WHITE);
        education.setBounds(300,280,300,30);
        this.add(education);
       
        JLabel email = new JLabel("Occupation:");
        email.setBounds(120,350,150,30);
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(email);
       
        String[] occupationValues = {"Salaried","Self-Employed","Buisness","Student","Retired","Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300,350,300,30);
        this.add(occupation);
        

        JLabel martial = new JLabel("PAN Number:");
        martial.setBounds(120,400,150,30);
        martial.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(martial);
        
        pan = new JTextField();
        pan.setBounds(300,400,300,30);
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(pan);

        JLabel city = new JLabel("Aadhar Number:");
        city.setBounds(120,450,150,30);
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(city);
        
        aadhar = new JTextField();
        aadhar.setBounds(300,450,300,30);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(aadhar);

        JLabel state = new JLabel("Seniour Citizen:");
        state.setBounds(120,500,150,30);
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(state);
       
        syes = new JRadioButton("Yes");
        syes.setBounds(340,500,100,30);
        syes.setBackground(Color.WHITE);
        this.add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(460,500,100,30);
        sno.setBackground(Color.WHITE);
        this.add(sno);
               
        ButtonGroup scitizen = new ButtonGroup();
        scitizen.add(syes);
        scitizen.add(sno);
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setBounds(120,550,200,30);
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        this.add(pincode); 

        eyes = new JRadioButton("Yes");
        eyes.setBounds(340,550,100,30);
        eyes.setBackground(Color.WHITE);
        this.add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(460,550,100,30);
        eno.setBackground(Color.WHITE);
        this.add(eno);
               
        ButtonGroup existing = new ButtonGroup();
        existing.add(eyes);
        existing.add(eno);

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
       
        String sreligion = (String)religion.getSelectedItem(); //returns obj so converted to str
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        String seniorcitizen = null;
        if( syes.isSelected() ){
            seniorcitizen = "Yes";
        } else if( sno.isSelected() ) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if( eyes.isSelected() ){
            existingaccount = "Yes";
        } else if( eno.isSelected() ) {
            existingaccount = "No";
        }
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
       

        try{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
                c.s.executeUpdate(query);  
                this.setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        } catch (Exception e) { 
            System.out.println(e);
        }

    }

    public static void main(String[] args){
        new SignupTwo("");
    }
}