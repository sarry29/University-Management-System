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

public class PFeeDetails extends JFrame implements ActionListener {
    
    String field[]={"ENROLLMENT NO.","NAME","FATHER'S NAME","COURSE","BRANCH","SEMESTER","FEES DEPOSIT","PAID/UNPAID"};
    String fieldValues[][]=new String[8][8];
    JTable jt;
    JLabel l1;
    JButton b1;
    int i=0,j=0;
    PFeeDetails(){}
   PFeeDetails(String s)
   {
       super("FEE DETAILS");
       setBounds(300,100,700,500);
       setResizable(false); 
       
       ImageIcon cl=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/nine1.jpg"));
       Image i1=cl.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT); //1000X700 size
       ImageIcon i2=new ImageIcon(i1);
       JLabel bg=new JLabel(i2);
       setContentPane(bg);
       
       String name="";
       try{
           
           conn c=new conn();
           String qry="Select name from fee where rollno='"+s+"'";
           ResultSet rs=c.s.executeQuery(qry);
           if(rs.next())
           {
               name=rs.getString("name");
           }
           
           qry="Select * from fee where rollno='"+s+"'";
           rs=c.s.executeQuery(qry);
           System.out.println(" 1here");
           while(rs.next())   
           {
               fieldValues[i][j++]=rs.getString("rollno");
               fieldValues[i][j++]=rs.getString("name");
               fieldValues[i][j++]=rs.getString("fathers_name");
               fieldValues[i][j++]=rs.getString("course");
               fieldValues[i][j++]=rs.getString("branch");
               fieldValues[i][j++]=rs.getString("semester");
               fieldValues[i][j]=rs.getString("fee_paid");
               System.out.println(fieldValues[i][j-1]+" here");
               
               if(fieldValues[i][j].length()>0)
               {
                   fieldValues[i][++j]="PAID";
               }
               else
               {
                   fieldValues[i][++j]="UNPAID";
               }
               i++;
               j=0;
           }
           jt=new JTable(fieldValues,field);
           jt.setBackground(Color.LIGHT_GRAY);
           
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,"Server not Connected","ERROR",JOptionPane.ERROR_MESSAGE);
       }

       name=name.toUpperCase()+" FEES DETAILS";
       l1=new JLabel(name);
       l1.setBounds(150,80,500,40);
       l1.setForeground(Color.WHITE);
       l1.setFont(new Font("serif",Font.BOLD,25));
       bg.add(l1);
       
              
       JScrollPane jsp=new JScrollPane(jt);
       jsp.setBounds(50,130,600,150);
       bg.add(jsp);
       
       b1=new JButton("CANCEL");
       b1.setBounds(290,300,100,30);
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.BLACK);
       b1.addActionListener(this);
       bg.add(b1);
       
//       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
       setVisible(false);
   }
   public static void main(String args[])
   {
       new PFeeDetails().setVisible(true);
   }

    
}
