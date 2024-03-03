
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MiniStatement extends JFrame implements ActionListener   {
    String pinnumber;
    JButton back;
    JLabel mini;
    MiniStatement(String pin){   
        pinnumber=pin;
        
        
        setTitle("MINI STATEMENT");
        setLayout(null);
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        bank.setFont(new Font("System",Font.BOLD,16));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,600,20);
        card.setFont(new Font("System",Font.BOLD,16));
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        balance.setFont(new Font("System",Font.BOLD,16));
        add(balance);
        
        mini = new JLabel();
        add(mini);
        
        try{
            Conn conn=new Conn();
            
            ResultSet rs=conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,12)+"XXXX");
                
            }
            
           
        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
            int bal=0;
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                        System.out.println(rs.getString("amount"));
                        bal+=Integer.parseInt(rs.getString("amount"));
                }else{
                        System.out.println(rs.getString("amount"));
                        bal-=Integer.parseInt(rs.getString("amount"));
                }
                balance.setText("Your current account balance:"+bal);
            }
        }catch(Exception e){
        System.out.println(e);
    }
        mini.setBounds(20,140,400,200);
        getContentPane().setBackground(Color.WHITE);        
        setSize(400,600);
        setVisible(true);
        setLocation(350,200);
    }
    @Override
    public void actionPerformed(ActionEvent e) {        
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
}
