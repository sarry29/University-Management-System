/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.management.system;


/**
 *
 * @author sarry
 */

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;

public class EnterMarks extends JFrame implements ActionListener{
    JLabel l,l1,l2,l3,l4;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b1,b2;
    
    EnterMarks()
    {
            setSize(800,600);
            setLocation(200,50);
            setLayout(null);
        
            ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/six1.jpg"));
            Image img1=img.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT); //1000X700 size
            ImageIcon icc=new ImageIcon(img1);
            
            l=new JLabel(icc);
            l.setBounds(0,0,900,800);
            add(l);
            
            l1=new JLabel("Enters marks of students");
            l1.setFont(new Font("serif",Font.BOLD,30));
            l1.setBounds(50,0,500,40);
            l.add(l1);
            
            l2=new JLabel("Enter Roll Number");
            l2.setFont(new Font("serif",Font.BOLD,15));
            l2.setBounds(50,70,200,40);
            l.add(l2);
            
            t1=new JTextField();
            t1.setBounds(50,100,250,20);
            l.add(t1);
            
            l3=new JLabel("Enter Subject");
            l3.setFont(new Font("serif",Font.BOLD,15));
            l3.setBounds(50,150,200,40);
            l.add(l3);
            
            l4=new JLabel("Enter Marks");
            l4.setFont(new Font("serif",Font.BOLD,15));
            l4.setBounds(300,150,200,40);
            l.add(l4);
                
            JPanel p=new JPanel();
            p.setLayout(new GridLayout(5,2,0,3));
            p.setBounds(50,200,500,200);
            
            t2=new JTextField();
            p.add(t2);
            
            t3=new JTextField();
            p.add(t3);
            
            t4=new JTextField();
            p.add(t4);
            
            t5=new JTextField();
            p.add(t5);
            
            t6=new JTextField();
            p.add(t6);
            
            t7=new JTextField();
            p.add(t7);
            
            t8=new JTextField();
            p.add(t8);
            
            t9=new JTextField();
            p.add(t9);
            
            t10=new JTextField();
            p.add(t10);
                        
            t11=new JTextField();
            p.add(t11);
            
            
            l.add(p);
            
            b1=new JButton("SUBMIT");
            b1.setForeground(Color.WHITE);
            b1.setBackground(Color.BLACK);
            b1.setBounds(50,420,100,30);
            l.add(b1);
            
            b2=new JButton("CANCEL");
            b2.setForeground(Color.WHITE);
            b2.setBackground(Color.BLACK);
            b2.setBounds(300,420,100,30);
            l.add(b2);
            
            b1.addActionListener(this);
            b2.addActionListener(this);

    }
    
    public void actionPerformed(ActionEvent ae)
    {
            if(ae.getSource()==b1)
            {
                
                try
                {
                    conn c1=new conn();
                    String s1="insert into subject value('"+t1.getText()+"','"+t2.getText()+"','"+t4.getText()+"','"+t6.getText()+"','"+t8.getText()+"','"+t10.getText()+"')";
                    String s2="insert into marks value('"+t1.getText()+"','"+t3.getText()+"','"+t5.getText()+"','"+t7.getText()+"','"+t9.getText()+"','"+t11.getText()+"')";

                    c1.s.executeUpdate(s1);
                    c1.s.executeUpdate(s2);

                    JOptionPane.showMessageDialog(null,"Marks Inserted Successfully","Alert",JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
//                    new Project().setVisible(true);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"Marks not Inserted successfully","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                if(ae.getSource()==b2)
                {
                    this.setVisible(false);
//                    new Project().setVisible(true);
                }
            }
                
    }
    
    public static void main(String args[])
    {
        new EnterMarks().setVisible(true);
    }
}
