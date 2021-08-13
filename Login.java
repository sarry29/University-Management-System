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
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public  class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6;//user,password
    JButton b1,b2,b3,b4,b5,b6;//Login,cancel
    JTextField t1,t3,t5;
    JPasswordField t2,t4,t6;
    JTabbedPane tp;
    JPanel p1,p2,p3;
    
    Login()
    {
        super("LOGIN");
        setLayout(null);
        setResizable(false);
        setBounds(380,150,700,400);
        
        ImageIcon cl=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/ten4.jpg"));
        Image cs1=cl.getImage().getScaledInstance(700,400,Image.SCALE_DEFAULT); //1000X700 size
        ImageIcon cs2=new ImageIcon(cs1);
        
        JLabel bgimg=new JLabel(cs2);
        setContentPane(bgimg);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/second.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT); //1000X700 size
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(450,90,150,180);
        bgimg.add(l3);
        
        
        //panel 1
        p1=new JPanel();
        p1.setLayout(null);
        
        JLabel stud=new JLabel("Student Login");
        stud.setFont(new Font("serif",Font.BOLD,17));
        stud.setBounds(40,10,200,25);
        p1.add(stud);
        
        l1=new JLabel("UserName :");
        l1.setBounds(40,37,150,25);
        l1.setFont(new Font("serif",Font.BOLD,17));
        p1.add(l1);
        
        l2=new JLabel("Password :");
        l2.setBounds(40,90,100,30);
        l2.setFont(new Font("serif",Font.BOLD,17));
        p1.add(l2);
        
        t1=new JTextField();
        t1.setBounds(170,40,150,30);
        t1.setFont(new Font("serif",Font.PLAIN,15));
        p1.add(t1);
        
        t2=new JPasswordField();
        t2.setBounds(170,90,150,30);
        t2.setFont(new Font("serif",Font.PLAIN,15));
        p1.add(t2);
        
        b1=new JButton("Login");
        b1.setBounds(40,160,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        p1.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,160,120,  30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        p1.add(b2);

        
        //panel 2
        p2=new JPanel();
        p2.setLayout(null);
        JLabel prof=new JLabel("Professor Login");
        prof.setFont(new Font("serif",Font.BOLD,17));
        prof.setBounds(40,10,200,25);
        p2.add(prof);
        
        l3=new JLabel("UserName :");
        l3.setBounds(40,37,150,25);
        l3.setFont(new Font("serif",Font.BOLD,17));
        p2.add(l3);
        
        l4=new JLabel("Password :");
        l4.setBounds(40,90,100,30);
        l4.setFont(new Font("serif",Font.BOLD,17));
        p2.add(l4);
        
        p2.add(l3);
        p2.add(l4);
        
        t3=new JTextField();
        t3.setBounds(170,40,150,30);
        t3.setFont(new Font("serif",Font.PLAIN,15));
        p2.add(t3);
        
        t4=new JPasswordField();
        t4.setBounds(170,90,150,30);
        t4.setFont(new Font("serif",Font.PLAIN,15));
        p2.add(t4);
        
        b3=new JButton("Login");
        b3.setBounds(40,160,120,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        p2.add(b3);
        
        b4=new JButton("Cancel");
        b4.setBounds(180,160,120,  30);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        p2.add(b4);

        
        
        //panel 3
        p3=new JPanel();
        p3.setLayout(null);
        JLabel admin=new JLabel("Admin Login");
        admin.setFont(new Font("serif",Font.BOLD,17));
        admin.setBounds(40,10,200,25);
        p3.add(admin);
        
        l5=new JLabel("UserName :");
        l5.setBounds(40,37,150,25);
        l5.setFont(new Font("serif",Font.BOLD,17));
        p3.add(l5);
        
        l6=new JLabel("Password :");
        l6.setBounds(40,90,100,30);
        l6.setFont(new Font("serif",Font.BOLD,17));
        p3.add(l6);
        
        p3.add(l5);
        p3.add(l6);
        
        t5=new JTextField();
        t5.setBounds(170,40,150,30);
        t5.setFont(new Font("serif",Font.PLAIN,15));
        p3.add(t5);
        
        t6=new JPasswordField();
        t6.setBounds(170,90,150,30);
        t6.setFont(new Font("serif",Font.PLAIN,15));
        p3.add(t6);
        
        b5=new JButton("Login");
        b5.setBounds(40,160,120,30);
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.addActionListener(this);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        p3.add(b5);
        
        b6=new JButton("Cancel");
        b6.setBounds(180,160,120,  30);
        b6.setFont(new Font("serif",Font.BOLD,15));
        b6.addActionListener(this);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        p3.add(b6);

        p3.add(b6);
        
        
        tp=new JTabbedPane();
        tp.add("Student",p1);
        tp.add("Professor",p2);
        tp.add("Admin",p3);
        tp.setBounds(20,20,400,250);

        String notemsg="<html>NOTE:- For new user password would be 0000,kindly change password by log-in.<br/>Thank You!</html>";
        JLabel note=new JLabel(notemsg);
        note.setForeground(Color.BLACK);
        note.setBounds(20,260,600,100);
        note.setFont(new Font("serif",Font.BOLD,15));
        
        bgimg.add(note);
        bgimg.add(tp);
        
//        getContentPane().setBackground(Color.WHITE);// to set color of whole frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//login constuctor

    public void actionPerformed(ActionEvent ae)
    {
        //check which button is pressed
        if(ae.getSource()==b5)
        {
            //if b1 (login) button is pressed then connection established with database
            try
            {
                conn c1=new conn();//connection class object
                String u=t5.getText();
                String v=t6.getText();

                String q="Select * from login where username='"+u+"' and password='"+v+"';";

                //ResultSet interface  == (c1.s.executeQuery(q)) returning object of returnset
                //it store data which is fetch from database
                ResultSet rs=c1.s.executeQuery(q);
                
                //jump row to row = rs.next()
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(this,"HELLO ADMIN","Alert",JOptionPane.INFORMATION_MESSAGE);
                    new Project().setVisible(true);
                    setVisible(false);
                
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"INVALID INPUT","ALERT",JOptionPane.WARNING_MESSAGE);
                   
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Server not connected","ALERT",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
       
        if(ae.getSource()==b1)//student login
        {
            try
            {
                conn c1=new conn();//connection class object
                String u=t1.getText();
                String v=t2.getText();

                String q="Select * from studentlogin where username='"+u+"' and password='"+v+"';";

                ResultSet rs=c1.s.executeQuery(q);
                
                if(rs.next())
                {
                    String name=rs.getString(3);
                    String inp="Hello "+name.toUpperCase();
                    JOptionPane.showMessageDialog(this,inp,"Alert",JOptionPane.INFORMATION_MESSAGE);
                    new StudentProject(u).setVisible(true);
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"INVALID INPUT","ALERT",JOptionPane.WARNING_MESSAGE);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Server not connected","ALERT",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        
        if(ae.getSource()==b3)//teacher login
        {
            try
            {
                conn c1=new conn();//connection class object
                String u=t3.getText();
                String v=t4.getText();
                
                String q="Select * from teacherlogin where username='"+u+"' and password='"+v+"';";
                System.out.println(u+" "+v+" "+q);
                
                ResultSet rs=c1.s.executeQuery(q);
                
                if(rs.next())
                {
                    String name=rs.getString(3);
                    String inp="Hello, "+name.toUpperCase()+" PROFESSOR";
                    JOptionPane.showMessageDialog(this,inp,"Alert",JOptionPane.INFORMATION_MESSAGE);
                    new ProfessorProject(u).setVisible(true);
                    setVisible(false);
                
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"INVALID INPUT","ALERT",JOptionPane.WARNING_MESSAGE);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Server not connected","ALERT",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        
        //cancel button
        if(ae.getSource()==b6||ae.getSource()==b4||ae.getSource()==b2)
            {
                System.exit(0);
                //if cancel is clicked then frame will be closed
            }            

        
        
    }

    public static void main(String args[])
    {
        new Login().setVisible(true);
    }
}//class

