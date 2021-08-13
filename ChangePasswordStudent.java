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
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ChangePasswordStudent extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    String name,id;
    
    ChangePasswordStudent(){}
    ChangePasswordStudent(String s)
    {
        super("CHANGE PASSWORD");
        setBounds(400,150,450,400);
        setLayout(null);
        setResizable(false);
        
        id=s;//for scope of rollno outside constructor too

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/six1.jpg"));
        Image img1=img.getImage().getScaledInstance(450,400,Image.SCALE_DEFAULT); //1000X700 size
        ImageIcon icc=new ImageIcon(img1);
        JLabel bgimg=new JLabel(icc);
        setContentPane(bgimg);
        
        l1=new JLabel("Change Password");
        l1.setFont(new Font("serif",Font.BOLD,25));
        l1.setBounds(100,10,300,60);
        bgimg.add(l1);
        
//        enroll no
        l2=new JLabel("Enrollment No :",JLabel.TRAILING);
        l2.setFont(new Font("serif",Font.BOLD,15));
        l2.setBounds(20,80,150,30);
        
        t1=new JTextField();
        t1.setEditable(false);
        t1.setText(s);
        t1.setBounds(180,80,150,30);
        t1.setFont(new Font("serif",Font.BOLD,15));
        bgimg.add(l2);
        bgimg.add(t1);
        
//        name
        l3=new JLabel("Name :",JLabel.TRAILING);
        l3.setFont(new Font("serif",Font.BOLD,15));
        l3.setBounds(20,120,150,30);
        
        t2=new JTextField();
        t2.setEditable(false);
        t2.setBounds(180,120,150,30);
        t2.setFont(new Font("serif",Font.BOLD,15));
        bgimg.add(l3);
        bgimg.add(t2);
        
        try{
            conn c=new conn();
            String q="Select name from student where rollno='"+s+"'";
            ResultSet rs=c.s.executeQuery(q);
            if(rs.next())
            {
                name=rs.getString("name");
                t2.setText(name);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Server not connected","ERROR",JOptionPane.WARNING_MESSAGE);
        }
        
//      default pswd
        l4=new JLabel("Previous Password :",JLabel.TRAILING);
        l4.setFont(new Font("serif",Font.BOLD,15));
        l4.setBounds(20,160,150,30);
        
        t3=new JTextField();
        t3.setBounds(180,160,150,30);
        t3.setFont(new Font("serif",Font.BOLD,15));
        bgimg.add(l4);
        bgimg.add(t3);

//      new pswd
        l5=new JLabel("New Password :",JLabel.TRAILING);
        l5.setFont(new Font("serif",Font.BOLD,15));
        l5.setBounds(20,200,150,30);
        
        t4=new JTextField();
        t4.setFont(new Font("serif",Font.BOLD,15));
        t4.setBounds(180,200,150,30);
        bgimg.add(l5);
        bgimg.add(t4);
        
//      confirm pswd
        l6=new JLabel("Confirm New Password :",JLabel.TRAILING);
        l6.setFont(new Font("serif",Font.BOLD,13));
        l6.setBounds(20,240,150,30);
        
        t5=new JTextField();
        t5.setFont(new Font("serif",Font.BOLD,15));
        t5.setBounds(180,240,150,30);
        bgimg.add(l6);
        bgimg.add(t5);
        
//        Submit button
        b1=new JButton("SUBMIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(90,290,100,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        bgimg.add(b1);
        
//        cancel button
        b2=new JButton("CANCEL");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(200,290,100,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        bgimg.add(b2);
        
        
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String a=t3.getText();//previous password
            String b=t4.getText();//new password
            String c=t5.getText();//confirm new password
            
            if(a.equals(b))
            {
                setVisible(false);
                JOptionPane.showMessageDialog(null,"Previous and new Password can't be same","WARNING",JOptionPane.WARNING_MESSAGE);
                this.setVisible(true);
            }
            else
            {
                if(!b.equals(c))
                {
                    setVisible(false);
                    JOptionPane.showMessageDialog(null,"new and confirm Password must be same","WARNING",JOptionPane.WARNING_MESSAGE);
                    this.setVisible(true);
                }
                else
                {
                    String checkPsrd="";
                    try{
                        conn c2=new conn();
                        String qry2="Select * from studentlogin where username='"+id+"'";
                        ResultSet rs=c2.s.executeQuery(qry2);
                        if(rs.next())
                        {
                            checkPsrd=rs.getString("password");
                        }
                    }catch(Exception e){System.out.println("ERRor"+checkPsrd);}
                    if(checkPsrd.equals(a))
                    {
                    
                        try
                        {
                               String qry="UPDATE studentlogin SET password='"+b+"' where username='"+id+"'";
                            conn c1=new conn();
                            c1.s.executeUpdate(qry);
                            JOptionPane.showMessageDialog(null,"Password Changed","ALERT",JOptionPane.INFORMATION_MESSAGE);
                            setVisible(false);

                        }
                        catch(Exception e)
                        {
                            JOptionPane.showMessageDialog(null,"Server not connected","ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Previous password does'nt match","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            
        }
        if(ae.getSource()==b2)
        {
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new ChangePasswordStudent().setVisible(true);
    }
}
