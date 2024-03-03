
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame  implements ActionListener {
    
    String pinnumber;
    JPasswordField npin,rpin;
    JButton change,back;
    
    PinChange(String pin){
        setLayout(null);
        
        pinnumber=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Change your pin");
        text.setBounds(260,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,20));
        image.add(text);
        
        JLabel text1 = new JLabel("Enter new pin:");
        text1.setBounds(160,350,700,35);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("System",Font.BOLD,16));
        image.add(text1);
        
        npin=new JPasswordField();
        npin.setBounds(330,350,150,30);
        npin.setFont(new Font("Ariel",Font.BOLD,14));
        add(npin);
        
        JLabel text2 = new JLabel("Re-Enter new pin:");
        text2.setBounds(160,400,700,35);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System",Font.BOLD,16));
        image.add(text2);
        
        rpin=new JPasswordField();
        rpin.setBounds(330,400,150,30);
        rpin.setFont(new Font("Ariel",Font.BOLD,14));
        image.add(rpin);
        
        change=new JButton("Change");
        change.setBounds(368,485,150,30);
        change.setFont(new Font("Ariel",Font.BOLD,14));
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("Back");
        back.setBounds(368,522,150,30);
        back.setFont(new Font("Ariel",Font.BOLD,14));
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);}
        else if(e.getSource() == change){
            try{
            String nepin=npin.getText();
            String repin=rpin.getText();
            System.out.println(nepin);
            System.out.println(repin);
            if(nepin.equals(repin)){
                Conn conn=new Conn();
            String query1="update bank set pin = '"+repin+"' where pin ='"+pinnumber+"'";
            String query2="update login set pin = '"+repin+"' where pin ='"+pinnumber+"'";
            String query3="update signupthree set pin = '"+repin+"' where pin ='"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            
            setVisible(false);
            new Transactions(repin).setVisible(true);
            }else if(!nepin.equals(repin)){
                JOptionPane.showMessageDialog(null, "PIN donot match");
                return;
            }else if(!nepin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter PIN");
                return;
            }else if(!repin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter PIN");
                return;
            }
            
        
        }catch(Exception ex){
            System.out.println(ex);
        }
        }
        
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
