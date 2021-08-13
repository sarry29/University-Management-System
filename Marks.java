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
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Marks extends JFrame  
{
    JTextArea t1;
    JPanel p1;
   

    Marks(){}
    Marks(String s)       
    {
        super("MARKS DETAILS");
        setResizable(false);
        setSize(500,500);
        setLocation(250,100);
        setLayout(new BorderLayout());
        
        p1=new JPanel();
        
        t1=new JTextArea(50,15);//row col 50,15
        JScrollPane jsp=new JScrollPane(t1);
        t1.setFont(new Font("serif",Font.BOLD,20));
        
        add(p1,"North");
        add(jsp,"Center");
        mark(s);
    }
    
    public void mark(String str)
    {
        try{
            conn c=new conn();
            t1.setText("\tResult of Examination\n\n Subject\n");
            ResultSet rs1=c.s.executeQuery("Select * from subject where rollno='"+str+"'");
            
            if(rs1.next())
            {
                t1.append("\n\t"+rs1.getString("subject1"));
                t1.append("\n\t"+rs1.getString("subject2"));
                t1.append("\n\t"+rs1.getString("subject3"));
                t1.append("\n\t"+rs1.getString("subject4"));
                t1.append("\n\t"+rs1.getString("subject5"));
                t1.append("\n----------------------------------\n");
            }
            
            ResultSet rs2=c.s.executeQuery("Select * from marks where rollno='"+str+"'");
            t1.append("\n Marks\n");

            if(rs2.next())
            {
                int m1=Integer.parseInt(rs2.getString("marks1"));
                int m2=Integer.parseInt(rs2.getString("marks2"));
                int m3=Integer.parseInt(rs2.getString("marks3"));
                int m4=Integer.parseInt(rs2.getString("marks4"));
                int m5=Integer.parseInt(rs2.getString("marks5"));
                
                t1.append("\n\t"+rs2.getString("marks1"));
                t1.append("\n\t"+rs2.getString("marks2"));
                t1.append("\n\t"+rs2.getString("marks3"));
                t1.append("\n\t"+rs2.getString("marks4"));
                t1.append("\n\t"+rs2.getString("marks5"));
                t1.append("\n----------------------------------\n");
                t1.append("\n");
                
                double t=(double)(m1+m2+m3+m4+m5);
                t1.append("Total Marks : "+Integer.toString((int)t)+"/500");
                
                double per=t/500*100;
                t1.append("\nPercentage = "+Double.toString(per)+"%");
            }    
        }
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Server not connected","ERROR",JOptionPane.ERROR_MESSAGE);
            setVisible(false);
        }
        
    }//marks method
    public static void main(String args[])
    {
        new Marks().setVisible(true);
    }
}
