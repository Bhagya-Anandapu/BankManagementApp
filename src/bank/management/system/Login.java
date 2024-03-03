
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author bhagya
 */
public class Login extends JFrame implements ActionListener {
    JButton login,signUp,clear;
    JTextField cardText;
    JPasswordField pinText;
    
    Login(){
        
        setTitle("AUTOMATED ATM MACHINE");
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);//image
        label.setBounds(70,10,100,100);
        add(label);//image
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);//title
        
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway",Font.BOLD,30));
        cardNo.setBounds(120,150,200,40);
        add(cardNo);//cardNo
        
        cardText=new JTextField();
        cardText.setBounds(300,150,250,30);
        cardText.setFont(new Font("Ariel",Font.BOLD,14));
        add(cardText);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,30));
        pin.setBounds(120,220,150,40);
        add(pin);//pin
        
        pinText=new JPasswordField();
        pinText.setBounds(300,220,250,30);
        pinText.setFont(new Font("Ariel",Font.BOLD,14));
        add(pinText);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(300,350,250,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,500);
        setVisible(true);
        setLocation(350,200);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == clear){
            cardText.setText("");
            pinText.setText("");
            
        }else if(e.getSource()==login){            
            Conn conn=new Conn();
            String cardnumber=cardText.getText();
            String pinnumber=pinText.getText();
            String query="select * from login where cardnumber = "+cardnumber+" and pin = "+pinnumber;
            
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect card number or Pin");
                }
            }catch(Exception m){
                System.out.println(m);
            }
            
        }else if(e.getSource()==signUp){
            setVisible(false);
            new SignUpOne().setVisible(true);            
        }
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static void main(String[] args){
        new Login().setVisible(true);
    }

    
    
}
