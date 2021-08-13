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

public class StudentAttendanceDetail extends JFrame implements ActionListener {
 
    JButton b1,b2;
    Choice c1,c2,c3;
    JLabel l1,l2,l3;
    
    StudentAttendanceDetail()
    {
        super("ADD STUDENT ATTENDANCE");
        setResizable(false);
        setLayout(new GridLayout(4,2,10,50));
        setBounds(400,100,400,400);
        setBackground(Color.LIGHT_GRAY);
        
        c1=new Choice();
        try
        {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from student");
            while(rs.next())
            {
                c1.add(rs.getString("rollno"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error in fetching enrollment number \nERROR:Server not connected","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
        l1=new JLabel("SELECT ENROLLMENT NO. : ",JLabel.CENTER);
        l1.setFont(new Font("serif",Font.BOLD,10));
        add(l1);
        add(c1);
        
        l2=new JLabel("FIRST HALF : ",JLabel.CENTER);
        l2.setFont(new Font("serif",Font.BOLD,10));
        c2=new Choice();
        c2.add("Present");
        c2.add("Absent");
        c2.add("Leaves");        
        add(l2);
        add(c2);
        
        l3=new JLabel("SECOND HALF : ",JLabel.CENTER);
        l3.setFont(new Font("serif",Font.BOLD,10));
        c3=new Choice();
        c3.add("Present");
        c3.add("Absent");
        c3.add("Leaves");
        
        add(l3);
        add(c3);
        
        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
       
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String a=c2.getSelectedItem();//first
        String b=c3.getSelectedItem();//second
        String dt= new java.util.Date().toString();//date
        String id=c1.getSelectedItem();//enroll no
        
//        HERE CHECK
        String qry="insert into attendance_student values('"+id+"','"+dt+"','"+a+"','"+b+"')";
                if(ae.getSource()==b1)
        {
            try{
                conn c=new conn();
                c.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Attendance Confirmed","ALERT",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Server not connected","ERROR",JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        }
        else
        {
            if(ae.getSource()==b2)
            {
                setVisible(false);
            }
        }
    }
    public static void main(String args[])
    {
        new StudentAttendanceDetail().setVisible(true);
    }
}
