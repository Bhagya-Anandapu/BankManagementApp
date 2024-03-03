
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    SignUpThree(String form){
        formno=form;
        setLayout(null);
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,120,200,40);
        add(type);
        
        r1=new JRadioButton("Fixed Deposit Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,170,250,20);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,170,250,20);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3=new JRadioButton("Reccuring Deposit Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,210,250,20);
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4=new JRadioButton("Saving Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,210,250,20);
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,280,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(300,280,300,30);
        add(number);
        
        JLabel cardDetails=new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetails.setBounds(100,310,300,20);
        add(cardDetails);
        
        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,350,200,30);
        add(pin);
        
        JLabel pinnum=new JLabel("XXXX");
        pinnum.setFont(new Font("Raleway",Font.BOLD,22));
        pinnum.setBounds(300,350,100,30);
        add(pinnum);
        
        JLabel pinDetails=new JLabel("Your 4 Digit Pin Number");
        pinDetails.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetails.setBounds(100,380,300,20);
        add(pinDetails);
        
        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,430,300,30);
        add(services);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,470,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,470,200,30);
        add(c2);
        
        c3=new JCheckBox("Email and SMS Alerting");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,510,250,30);
        add(c3);
        
        c4=new JCheckBox("Cheque Book");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,510,200,30);
        add(c4);
        
        c5=new JCheckBox("E-Statement");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,550,200,30);
        add(c5);
        
        c6=new JCheckBox("Mobile Banking");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,550,200,30);
        add(c6);
        
        c7=new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,14));
        c7.setBounds(100,600,600,30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,670,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(450,670,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);        
        setSize(850,800);
        setLocation(350,0);
        setVisible(true);
    }  


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r4.isSelected()){
                accountType="Saving Account";
            }else if(r2.isSelected()){
                accountType="Current Account";
            }else if(r3.isSelected()){
                accountType="Reccuring Deposit Account";
            }
            long min = 1000000000000000L;  // 16 digits starting with 1
            long max = 9999999999999999L;
            Random random=new Random();
            String cardnumber=""+random.nextLong(max - min + 1) + min;;
            cardnumber = cardnumber.substring(0, 16);
            String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
            
            String facility="";
            if(c1.isSelected()){
                facility+=" ATM Card";
            }else if(c2.isSelected()){
                facility+=" Internet Banking";
            }else if(c3.isSelected()){
                facility+=" Email and SMS Alerting";
            }else if(c4.isSelected()){
                facility+=" Cheque Book";
            }else if(c5.isSelected()){
                facility+=" E-Statement";
            }else if(c6.isSelected()){
                facility+=" Mobile Banking";
            }
            String form =formno;
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else{
                    Conn conn = new Conn();
                    String query="insert into signupthree values('"+form+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    conn.s.executeUpdate(query);
                    String query1="insert into login values('"+form+"', '"+cardnumber+"', '"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\nPin: "+pinnumber);
                    
                }
                setVisible(false);
                new Login().setVisible(true);
            }catch (Exception m){
                System.out.println(m);
            }
            
        }else if(e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static void main(String[] args){
        new SignUpThree("").setVisible(true);
    }
}
