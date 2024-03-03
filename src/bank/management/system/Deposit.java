
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Deposit extends JFrame implements ActionListener {
    
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    
    Deposit(String pin){
        pinnumber=pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount you want to deposit:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Systen",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount=new JTextField();
//        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("Systen",Font.BOLD,16));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        deposit=new JButton("Deposit");        
        deposit.setFont(new Font("Systen",Font.BOLD,16));
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back=new JButton("Back");        
        back.setFont(new Font("Systen",Font.BOLD,16));
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        getContentPane().setBackground(Color.WHITE);        
        setSize(850,800);
        setLocation(350,0);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==deposit){
            String depo=amount.getText();
            Date date=new Date();
            if(depo.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit:");
            }else{
                Conn conn=new Conn();
                String query="insert into bank values ('"+pinnumber+"', '"+date+"', 'Deposit', '"+depo+"')";
                
                try {
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+depo+" Deposited successfully");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                
            }
            
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
