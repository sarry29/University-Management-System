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
import java.sql.*;
public class ProfessorAttendance  extends JFrame implements ActionListener {
    
        JTable j1;
        JButton b1,b2;
        String h[]={"EMPLOY ID","DATE & TIME","FIRST HALF","SECOND HALF"};
        String d[][]=new String[100][4];
        int i=0,j=0;
        
       ProfessorAttendance()
       {
           super("VIEW PROFESSORS ATTENDANCE");
           setResizable(false);
           setBounds(300,100,515,485);
           setLayout(null);
           try
           {
               
                String qry="Select * from attendance_teacher";   
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(qry);

                /*
                rs.next()
                if(rs.next()) only 1 row
                while(rs.next()) all rows
                 */

                while(rs.next())
                {
                    d[i][j++]=rs.getString("emp_id");
                    d[i][j++]=rs.getString("Date");
                    d[i][j++]=rs.getString("first");
                    d[i][j]=rs.getString("second");
                    i++;
                    j=0;
                }
                j1=new JTable(d,h);
                //2 d array,1 array data/column data(metadata)
           
           }
           catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, "Server not connected", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
           
           JScrollPane jsp=new JScrollPane(j1);
           jsp.setBounds(0,0,500,400);
           add(jsp);
       
                          
           b1=new JButton("PRINT");
           b1.setBounds(0,400,250,50);
           add(b1);
           
           b2=new JButton("CLOSE");
           b2.setBounds(250,400,250,50);
           add(b2);
           
           b1.addActionListener(this);
           b2.addActionListener(this);
         
       }
       
       
       public void actionPerformed(ActionEvent ae)
       {
           if(ae.getSource()==b1)
           {
               try{
                   j1.print();
               }
               catch(Exception e){}
           }
           else
           {
               setVisible(false);
           }
       }
       public static void main(String args[])
       {
           new ProfessorAttendance().setVisible(true);
       }
}

