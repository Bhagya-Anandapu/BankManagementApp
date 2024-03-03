
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {
    String formno;
    JTextField aadharText,pinText,panText;
    JButton next;
    JRadioButton SYes,SNo,AYes,ANo;
    JComboBox education,religion,income,category,occupation;
    
    
    SignUpTwo(String form){
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        formno=form;
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Details " );
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name=new JLabel("Religion: " );
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[]={"Hindu","Muslim","Christian","Sikh","Other"};
        religion = new JComboBox(valReligion);
        religion.setFont(new Font("Raleway",Font.BOLD,14));
        religion.setBackground(Color.WHITE);
        religion.setBounds(300,140,400,30);
        add(religion);
        
        
        String valCat[]={"General","OBC","SC","ST","Other"};
        JLabel Fname=new JLabel("Category: " );
        Fname.setFont(new Font("Raleway",Font.BOLD,20));
        Fname.setBounds(100,190,200,30);
        add(Fname);
        
        category = new JComboBox(valCat);
        category.setFont(new Font("Raleway",Font.BOLD,14));
        category.setBackground(Color.WHITE);
        category.setBounds(300,190,400,30);
        add(category);
        
        JLabel dob=new JLabel("Income: " );
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incat[]={"Null","< 1,50,000","< 2,50,000","< 5,50,000","Upto 10,00,000"};
        income = new JComboBox(incat);
        income.setFont(new Font("Raleway",Font.BOLD,14));
        income.setBackground(Color.WHITE);
        income.setBounds(300,240,400,30);        
        add(income);
        
        JLabel gender=new JLabel("Educational " );
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,150,30);
        add(gender);
        
        JLabel email=new JLabel("Qualification: " );
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String eduval[]={"Non-Graduation","Graduate","Post-Graduate","Doctrate","Others"};
        education = new JComboBox(eduval);
        education.setFont(new Font("Raleway",Font.BOLD,14));
        education.setBackground(Color.WHITE);
        education.setBounds(300,340,400,30);
        add(education);
        
        JLabel Mstatus=new JLabel("Occupation: " );
        Mstatus.setFont(new Font("Raleway",Font.BOLD,20));
        Mstatus.setBounds(100,390,200,30);
        add(Mstatus);
        
        String occuval[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox(occuval);
        occupation.setFont(new Font("Raleway",Font.BOLD,14));
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300,390,100,30);        
        add(occupation);
        
        
        JLabel address=new JLabel("Pan Number: " );
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,150,30);
        add(address);
        
        panText=new JTextField();
        panText.setFont(new Font("Raleway",Font.BOLD,14));
        panText.setBounds(300,440,400,30);
        add(panText);
        
        JLabel city=new JLabel("Aadhar Number: " );
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadharText=new JTextField();
        aadharText.setFont(new Font("Raleway",Font.BOLD,14));
        aadharText.setBounds(300,490,400,30);
        add(aadharText);
        
        JLabel state=new JLabel("Senior Cititzen: " );
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,250,30);
        add(state);
        
        SYes= new JRadioButton("Yes");
        SYes.setBounds(300,540,100,30);
        SYes.setBackground(Color.WHITE);
        add(SYes);
        
        SNo=new JRadioButton("No");
        SNo.setBounds(400,540,100,30);
        SNo.setBackground(Color.WHITE);
        add(SNo);
        
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(SYes);
        seniorgroup.add(SNo);
        
        
        JLabel pinCode=new JLabel("Existing account: " );
        pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        pinCode.setBounds(100,590,200,30);
        add(pinCode);
        
        AYes= new JRadioButton("Yes");
        AYes.setBounds(300,590,100,30);
        AYes.setBackground(Color.WHITE);
        add(AYes);
        
        ANo=new JRadioButton("No");
        ANo.setBounds(400,590,200,30);
        ANo.setBackground(Color.WHITE);
        add(ANo);
        
        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(AYes);
        accountgroup.add(ANo);
        
        
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
        String sformno=formno;
        String sreligion=(String)religion.getSelectedItem();
        String cat=(String)category.getSelectedItem();
        String inc=(String)income.getSelectedItem();
        String edu=(String)education.getSelectedItem();
        String occu=(String)occupation.getSelectedItem();
        String pan=panText.getText();
        String aadhar=aadharText.getText();
        String senior=null;
        if(SYes.isSelected()){
            senior="Yes";
        }else if(SNo.isSelected()){
            senior="No";
        }
        
        String existing="";
        if(AYes.isSelected()){
            existing="Yes";
        }else if(ANo.isSelected()){
            existing="No";
        }
        
        try{
            if(aadharText.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar Number is Required");
            }else{
                Conn c=new Conn();
                String query="insert into signuptwo values('"+sformno+"', '"+sreligion+"', '"+cat+"', '"+inc+"', '"+edu+"', '"+occu+"', '"+pan+"', '"+aadhar+"', '"+senior+"', '"+existing+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpThree(sformno).setVisible(true);
                
            }
        } catch (Exception m){
            System.out.println(m);
        }
    }
    public static void main(String[] args){
        new SignUpTwo("").setVisible(true);
    }
}
