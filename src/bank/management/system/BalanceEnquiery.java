
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BalanceEnquiery extends JFrame implements ActionListener  {
    
    String pinnumber;
    JButton back;
    
    BalanceEnquiery(String pin){
        setLayout(null);
        pinnumber=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
                
        back=new JButton("Back");
        back.setBounds(368,522,150,30);
        back.setFont(new Font("Ariel",Font.BOLD,14));
        back.addActionListener(this);
        image.add(back);
        int balance=0;
        Conn conn=new Conn();
            try{
                ResultSet rs=conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
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
        JLabel text=new JLabel("Your Current Account balance is Rs "+balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(160,160,400,300);
        image.add(text);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String[] args){
        new BalanceEnquiery("").setVisible(true);
    }
}
