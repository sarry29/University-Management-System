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
import java.util.Arrays;
import javax.swing.border.Border;

public class PExamDetails extends JFrame implements ActionListener {
 
    String str;
    JTable j1;
    JButton b1;
    String h[];
    String d[][]=new String[14][5];
    int i=0,j=0;
    
    PExamDetails(){}
    
    PExamDetails(String s)
    {
        super("EXAMINATION DETAILS");
        setResizable(false);
        setBounds(350,100,600,550);
        
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/ten4.jpg"));
        Image img1=img.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT); //1000X700 size
        ImageIcon icc=new ImageIcon(img1);
        JLabel id15=new JLabel(icc);
        id15.setBounds(0,0,600,550);
        id15.setLayout(null);    
        setContentPane(id15);
        
        str=s;
        String n="";
        h=new String[5];
        i=0;
        try
           {
                String qry="Select * from subject where rollno='"+str+"'";   
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(qry);
                
                if(rs.next())
                {
                    h[i++]=rs.getString("subject1");
                    h[i++]=rs.getString("subject2");
                    h[i++]=rs.getString("subject3");
                    h[i++]=rs.getString("subject4");
                    h[i]=rs.getString("subject5");
                }
                /*
                rs.next()
                if(rs.next()) only 1 row
                while(rs.next()) all rows
                 */
                System.out.println(Arrays.toString(h));
           
                String qry2="Select * from student where rollno='"+s+"'";
                ResultSet rs2=c.s.executeQuery(qry2);
                if(rs2.next())
                {
                    n=rs2.getString("name");
                }
                
           }
        catch(Exception e){}
        String a[]=new String[5];
        try{
                conn c12=new conn();
                String qry1="Select * from marks where rollno='"+"1810DMB9999"+"'";
                ResultSet rs1=c12.s.executeQuery(qry1);
                
                
                i=0;
                if(rs1.next())
                {
                    a[i++]=rs1.getString("marks1");
                    a[i++]=rs1.getString("marks2");
                    a[i++]=rs1.getString("marks3");
                    a[i++]=rs1.getString("marks4");
                    a[i]=rs1.getString("marks5");
                }
                System.out.println(Arrays.toString(a));

        }
           catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, "Server not connected", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
         
           JLabel name=new JLabel("Marks in Individual Subjects");
           name.setForeground(Color.WHITE);
           name.setBounds(50,10,600,40);
           name.setFont(new Font("serif",Font.BOLD,25));
           id15.add(name);
           
           String ans="Student - "+n.toUpperCase(); 
           JLabel name1=new JLabel(ans);
           name1.setForeground(Color.WHITE);
           name1.setBounds(50,55,600,40);
           name1.setFont(new Font("serif",Font.BOLD,18));
           id15.add(name1);
           
           JPanel jsp=new JPanel();
           jsp.setLayout(new GridLayout(2,5));
           jsp.setBackground(Color.LIGHT_GRAY);
           jsp.setBounds(50,90,500,100);
           
          
           Border blackline = BorderFactory.createLineBorder(Color.black);
           
           JLabel s1=new JLabel(h[0],JLabel.CENTER);
           s1.setBorder(blackline);
           jsp.add(s1);
           JLabel s2=new JLabel(h[1],JLabel.CENTER);
           s2.setBorder(blackline);
           jsp.add(s2);
           JLabel s3=new JLabel(h[2],JLabel.CENTER);
           s3.setBorder(blackline);
           jsp.add(s3);
           JLabel s4=new JLabel(h[3],JLabel.CENTER);
           s4.setBorder(blackline);
           jsp.add(s4);
           JLabel s5=new JLabel(h[4],JLabel.CENTER);
           s5.setBorder(blackline);
           jsp.add(s5);
           
           
           JLabel m1=new JLabel(a[0],JLabel.CENTER);
           m1.setBorder(blackline);
           jsp.add(m1);
           JLabel m2=new JLabel(a[1],JLabel.CENTER);
           m2.setBorder(blackline);
           jsp.add(m2);
           JLabel m3=new JLabel(a[2],JLabel.CENTER);
           m3.setBorder(blackline);
           jsp.add(m3);
           JLabel m4=new JLabel(a[3],JLabel.CENTER);
           m4.setBorder(blackline);
           jsp.add(m4);
           JLabel m5=new JLabel(a[4],JLabel.CENTER);
           m5.setBorder(blackline);
           jsp.add(m5);
           
           id15.add(jsp);
           
           //Marks of stduent
           String str2="Marks obtain :";
           JLabel mark=new JLabel(str2);
           mark.setBounds(50,210,200,40);
           mark.setForeground(Color.WHITE);
           mark.setFont(new Font("serif",Font.BOLD,20));
           
           id15.add(mark);
           
           int no=Integer.parseInt(a[0])+Integer.parseInt(a[1])+Integer.parseInt(a[2])+Integer.parseInt(a[3])+Integer.parseInt(a[4]);
           JTextField markT=new JTextField();
           markT.setBounds(200,220,150,30);
           markT.setText(Integer.toString(no));
           markT.setFont(new Font("serif",Font.ITALIC,15));
           markT.setEditable(false);           
           id15.add(markT);
                      
           //total marks
           JLabel mark1=new JLabel("Total marks :");
           mark1.setBounds(50,260,200,40);
           mark1.setFont(new Font("serif",Font.BOLD,20));
           mark1.setForeground(Color.WHITE);
           id15.add(mark1);
            
           JTextField markT1=new JTextField("500");
           markT1.setBounds(200,270,150,30);
           markT1.setFont(new Font("serif",Font.ITALIC,15));
           markT1.setEditable(false);           
           id15.add(markT1);
           
           //Percentage
           JLabel mark2=new JLabel("Percentage :");
           mark2.setBounds(50,310,200,40);
           mark2.setFont(new Font("serif",Font.BOLD,20));
           mark2.setForeground(Color.WHITE);
           id15.add(mark2);
            
           float per=(float)(((float)no/500)*100);
           JTextField markT2=new JTextField();
           markT2.setBounds(200,320,150,30);
           markT2.setFont(new Font("serif",Font.ITALIC,15));
           markT2.setEditable(false);
           markT2.setText(Float.toString(per));
           id15.add(markT2);
           
           
//                jsp.setBounds(50,40,500,100);

           
//            Cancel button
            b1=new JButton("CANCEL");
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.setBounds(50,370,150,40);
            b1.addActionListener(this);
            id15.add(b1);
            
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
    }
    
    public static void main(String args[])
    {
        new PExamDetails("1810DMB9999").setVisible(true);
    }
}
