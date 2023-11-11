
package electricity;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    
    JPanel p1;
    JTextField t1, t2, t3, t4;
    Choice c1;
    JButton b1, b2;
    Signup(){
        super("Signup");
        setBounds(600, 250, 700, 400);
        
        p1 = new JPanel();
        p1.setBounds(30, 30, 650, 300);
        p1.setLayout( null);
        p1.setBackground(new Color(102,102,255));
        p1.setForeground(new Color(34, 139, 34));
        p1.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 0), 5), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
        add(p1);
        
        JLabel l1 = new JLabel("Username");
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(100, 50, 100, 20);
        p1.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(260, 50, 150, 20);
        p1.add(t1);
        
        JLabel l2 = new JLabel("Name");
        l2.setForeground(Color.DARK_GRAY);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(100, 90, 100, 20);
        p1.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(260, 90, 150, 20);
        p1.add(t2);
        
        
        JLabel l3 = new JLabel("Password");
        l3.setForeground(Color.DARK_GRAY);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(100, 130, 100, 20);
        p1.add(l3);
        
        t3 = new JTextField();
        t3.setBounds(260, 130, 150, 20);
        p1.add(t3);
        
        
        JLabel l4 = new JLabel("Create Account As");
        l4.setForeground(Color.DARK_GRAY);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(100, 170, 140, 20);
        p1.add(l4);
        
        JLabel l5 = new JLabel("Meter Number");
        l5.setForeground(Color.DARK_GRAY);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(100, 210, 100, 20);
       
        p1.add(l5);
        
        t4 = new JTextField();
        t4.setBounds(260, 210, 150, 20);
    
        p1.add(t4);
        
        c1 = new Choice();
       
        c1.add("Customer");
        c1.setBounds(260, 170, 150, 20);
        p1.add(c1);
        

        b1 = new JButton("Create");
        b1.setBackground(Color.BLACK);
        b1.setForeground(new Color(0, 255, 0));
        b1.setBounds(140, 290, 120, 30);
        b1.addActionListener(this);
        p1.add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(new Color(0, 255, 0));
        b2.setBounds(300, 290, 120, 30);
        b2.addActionListener(this);
        p1.add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup3.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(425, 30, 250, 250);
        p1.add(l6);
    }
    
    
     String username;
    String name;
    String password;
    String meter_no;
    
    public Boolean validateSIGNUP(){
             String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String meter_no = t4.getText();
        
        if(username.equals("")) {
            
            JOptionPane.showMessageDialog(null, "Enter Username");
            return false;
        }     
        if(name.equals("")) {
            
            JOptionPane.showMessageDialog(null, "Enter Name");
            return false;
        }     
        if(password.equals("")) {
            
            JOptionPane.showMessageDialog(null, "Enter password");
            return false;
        }     
        if(meter_no.equals("")) {
            
            JOptionPane.showMessageDialog(null, "Enter meter_no");
            return false;
        }     
        
        return true;
    }
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            if (validateSIGNUP()==true){
                
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String user = c1.getSelectedItem();
            String meter = t4.getText();
            try{
                Conn c = new Conn();
                String str = null;
                if(user.equals("Admin")){
                    str = "insert into login values('"+meter+"', '"+username+"', '"+name+"', '"+password+"', '"+user+"')";
                }else{
                    str = "update login set username = '"+username+"', name = '"+name+"', password = '"+password+"', user = '"+user+"' where meter_no = '"+t4.getText()+"'";
                }
                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                this.setVisible(false);
                new Login().setVisible(true);
            }catch(Exception e){
            }   
            }
        } else if(ae.getSource()== b2){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Signup().setVisible(true);
    }
}
