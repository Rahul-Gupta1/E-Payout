/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.*;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class About extends JFrame implements ActionListener{
    



    JButton b1;
    JLabel l1;
    Font f, f1, f2;
    TextArea t1;
    String s;

    public About() {

        setLayout(null);
        getContentPane().setBackground((new Color(102,102,255)));
        JButton b1 = new JButton("Exit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(new Color(0, 255, 0));
        add(b1);
        b1.setBounds(180, 430, 120, 20);
        b1.addActionListener(this);

        Font f = new Font("RALEWAY", Font.BOLD, 180);
        setFont(f);

        s = "                                    E-payout         \n  "
                + "\nE-payout is a software-based application "
                + "developed in Java programming language. The project aims at serving"
                + "the department of electricity by computerizing the billing system. "
                + "It mainly focuses on the calculation of Units consumed during the "
                + "specified time and the money to be paid to electricity offices. "
                + "This computerized system will make the overall billing system easy, "
                + "accessible, comfortable and effective for consumers.\n\n"
                ;
      
        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
         
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 300);
       
        t1.setBackground(new Color(127,255,212));
       

        add(t1);

        Font f1 = new Font("RALEWAY", Font.BOLD, 16);
        t1.setFont(f1);

        Container contentPane = this.getContentPane();
        t1 = new TextArea();

        JLabel l1 = new JLabel("About E-payout");
        add(l1);
        l1.setBounds(170, 10, 180, 80);
        l1.setForeground(Color.red);

        Font f2 = new Font("RALEWAY", Font.BOLD, 20);
        l1.setFont(f2);
     
        setBounds(700, 220, 500, 550);
        
        
        setLayout(null);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String args[]) {
        new About().setVisible(true);
    }

    private void setBorder(TitledBorder titledBorder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

