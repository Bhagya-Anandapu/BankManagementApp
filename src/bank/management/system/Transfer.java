
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transfer extends JFrame implements ActionListener {
    
    JButton Transfer,back;
    JTextField amount,account;
    String pinnumber;
    JLabel text1;
    
    Transfer(String pin){
        pinnumber=pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Account Number:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        account=new JTextField();
//        amount.setForeground(Color.WHITE);
        account.setFont(new Font("System",Font.BOLD,16));
        account.setBounds(170,350,320,25);
        image.add(account);
        
        text1=new JLabel("Enter Amount:");
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("System",Font.BOLD,16));
        text1.setBounds(170,400,400,20);
        image.add(text1);
        
        amount=new JTextField();
//        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("System",Font.BOLD,16));
        amount.setBounds(170,450,320,25);
        image.add(amount);
        
        
        
        Transfer=new JButton("Transfer");        
        Transfer.setFont(new Font("System",Font.BOLD,16));
        Transfer.setBounds(355,485,150,30);
        Transfer.addActionListener(this);
        image.add(Transfer);
        
        back=new JButton("Back");        
        back.setFont(new Font("System",Font.BOLD,16));
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        getContentPane().setBackground(Color.WHITE);        
        setSize(850,800);
        setLocation(350,0);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Transfer("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String acc=account.getText();
        String amm=amount.getText();
        Date date=new Date();
        if(ae.getSource()==Transfer){
            int balance=0;
            String formno="";
            Conn c1=new Conn();
            try{
                ResultSet rs=c1.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                System.out.println(rs);                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
//                        System.out.println(rs.getString("amount"));
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
//                        System.out.println(rs.getString("amount"));
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }   
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
            if(balance<Integer.parseInt(amm)){
                 JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 return;
                             
            }
           try{
               ResultSet rs=c1.s.executeQuery("select * from login where cardnumber = '"+acc+"'");
               while(rs.next()){
                   formno=rs.getString("pin");
                }
               String query="insert into bank values ('"+pinnumber+"', '"+date+"', 'Transfer', '"+amm+"')";
               String query1="insert into bank values ('"+formno+"', '"+date+"', 'Deposit', '"+amm+"')";
               c1.s.executeUpdate(query);
               c1.s.executeUpdate(query1);
               JOptionPane.showMessageDialog(null,"Rs "+amm+" Transfered successfully");
              
               
           }catch(Exception ex){
               ex.printStackTrace();
           }
           
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
