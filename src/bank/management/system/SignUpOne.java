
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameText,FnameText,addressText,emailText,cityText,stateText,pinCodeText;
    JButton next;
    JRadioButton male ,female,other,married,unmarried;
    JDateChooser dateChooser;
    
    
    SignUpOne(){
        setLayout(null);
        
        Random ran=new Random();
        random =Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("APPLICATION FORM NO: "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails=new JLabel("Page 1: Personal Details " );
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name=new JLabel("Name: " );
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameText=new JTextField();
        nameText.setFont(new Font("Raleway",Font.BOLD,14));
        nameText.setBounds(300,140,400,30);
        add(nameText);
        
        JLabel Fname=new JLabel("Father's Name: " );
        Fname.setFont(new Font("Raleway",Font.BOLD,20));
        Fname.setBounds(100,190,200,30);
        add(Fname);
        
        FnameText=new JTextField();
        FnameText.setFont(new Font("Raleway",Font.BOLD,14));
        FnameText.setBounds(300,190,400,30);
        add(FnameText);
        
        JLabel dob=new JLabel("Date of Birth: " );
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
         dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.red);
        add(dateChooser);
        
        JLabel gender=new JLabel("Gender: " );
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,100,30);
        add(gender);
        
         male= new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
         female=new JRadioButton("Female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("Email Address: " );
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailText=new JTextField();
        emailText.setFont(new Font("Raleway",Font.BOLD,14));
        emailText.setBounds(300,340,400,30);
        add(emailText);
        
        JLabel Mstatus=new JLabel("Marital Status: " );
        Mstatus.setFont(new Font("Raleway",Font.BOLD,20));
        Mstatus.setBounds(100,390,200,30);
        add(Mstatus);
        
         married= new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
         unmarried=new JRadioButton("UnMarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
         other=new JRadioButton("Other");
        other.setBounds(640,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup Mgroup = new ButtonGroup();
        gendergroup.add(married);
        gendergroup.add(unmarried);
        gendergroup.add(other);
        
        JLabel address=new JLabel("Address: " );
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,100,30);
        add(address);
        
        addressText=new JTextField();
        addressText.setFont(new Font("Raleway",Font.BOLD,14));
        addressText.setBounds(300,440,400,30);
        add(addressText);
        
        JLabel city=new JLabel("City: " );
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,100,30);
        add(city);
        
        cityText=new JTextField();
        cityText.setFont(new Font("Raleway",Font.BOLD,14));
        cityText.setBounds(300,490,400,30);
        add(cityText);
        
        JLabel state=new JLabel("State: " );
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,100,30);
        add(state);
        
        stateText=new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD,14));
        stateText.setBounds(300,540,400,30);
        add(stateText);
        
        JLabel pinCode=new JLabel("Pin Code: " );
        pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        pinCode.setBounds(100,590,100,30);
        add(pinCode);
        
        pinCodeText=new JTextField();
        pinCodeText.setFont(new Font("Raleway",Font.BOLD,14));
        pinCodeText.setBounds(300,590,400,30);
        add(pinCodeText);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,0);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno=""+random;
        String name=nameText.getText();
        String fname=FnameText.getText();
        String dob=""+((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        String email=emailText.getText();
        String marital="";
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(other.isSelected()){
            marital="Other";
        }
        
        String address=addressText.getText();
        String city=cityText.getText();
        String state=stateText.getText();
        String pin=pinCodeText.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        } catch (Exception m){
            System.out.println(m);
        }
    }
    public static void main(String[] args){
        new SignUpOne().setVisible(true);
    }
    
}
