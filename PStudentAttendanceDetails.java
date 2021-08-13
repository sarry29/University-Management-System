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

public class PStudentAttendanceDetails extends JFrame implements ActionListener {
 
    String str;
    JTable j1;
    JButton b1;
    String h[]={"ENROLLMENT NO.","DATE & TIME","FIRST HALF","SECOND HALF"};
    String d[][]=new String[40][4];
    int i=0,j=0;
    
    PStudentAttendanceDetails(){}
    
    PStudentAttendanceDetails(String s)
    {
        super("STUDENT ATTENDANCE");
        setResizable(false);
        setBounds(350,100,600,550);
        
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/ten3.jpg"));
        Image img1=img.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT); //1000X700 size
        ImageIcon icc=new ImageIcon(img1);
        JLabel id15=new JLabel(icc);
        id15.setBounds(0,0,600,550);
        id15.setLayout(null);    
        setContentPane(id15);
        
        str=s;
        String n="";
         try
           {
                String qry="Select * from attendance_student where rollno='"+str+"'";   
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(qry);

                /*
                rs.next()
                if(rs.next()) only 1 row
                while(rs.next()) all rows
                 */
                
                
                while(rs.next())
                {
                    d[i][j++]=rs.getString("rollno");
                    d[i][j++]=rs.getString("Date");
                    d[i][j++]=rs.getString("first");
                    d[i][j]=rs.getString("second");
                    i++;
                    j=0;
                }
                j1=new JTable(d,h);
                //2 d array,1 array data/column data(metadata)
                
                String qry1="Select * from student where rollno='"+str+"'";
                ResultSet rs1=c.s.executeQuery(qry1);
                if(rs1.next())
                {
                    n=rs1.getString("name");
                }
                
           }
           catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, "Server not connected", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
         
           String ans=n.toUpperCase()+" Attendance Details"; 
           JLabel name=new JLabel(ans);
           name.setBounds(50,0,400,40);
           name.setFont(new Font("serif",Font.BOLD,18));
           id15.add(name);
           
           JScrollPane jsp=new JScrollPane(j1);
           jsp.setBounds(50,40,500,400);
           id15.add(jsp);
           
//            Cancel button
            b1=new JButton("CANCEL");
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.setBounds(200,450,150,40);
            b1.addActionListener(this);
            id15.add(b1);
            
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
    }
    
    public static void main(String args[])
    {
        new PStudentAttendanceDetails().setVisible(true);
    }
}
