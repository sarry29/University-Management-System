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
import java.awt.event.*;
import java.sql.*;

public class PStudentDetails implements ActionListener {
        
        JFrame f;
        JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id13,id14,id15,gen;
        JButton b1,b2;
        JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,gen1;
        
        PStudentDetails()
        {
        }
        PStudentDetails(String roll)
        {
            f=new JFrame("STUDENT DETAILS");
            f.setBackground(Color.WHITE);
            f.setLayout(null);
            f.setResizable(false);//disable maximize button
            
            id15=new JLabel();
            id15.setBounds(0,0,900,700);
            id15.setLayout(null);
            ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/fourth.jpg"));
            Image img1=img.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT); //1000X700 size
            ImageIcon icc=new ImageIcon(img1);
            id15.setIcon(icc);
            f.add(id15);
            
            id=new JLabel("Student Details");
            id.setBounds(320,30,500,50);
            id.setFont(new Font("serif",Font.BOLD,25));
            id.setForeground(Color.BLACK);
            id15.add(id);
            
            
//            Name
            id1=new JLabel("Name :");
            id1.setBounds(50,150,100,30);
            id1.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id1);
            
            t1=new JTextField();
            t1.setBounds(200,150,150,30);
            t1.setEditable(false);
            id15.add(t1);    
            
            
//           Father NAme
            id2=new JLabel("Father's Name :");
            id2.setBounds(400,150,200,30);
            id2.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id2);
         
            t2=new JTextField();
            t2.setEditable(false);
            t2.setBounds(600,150,150,30);
            id15.add(t2);    
            
//           Age
            id3=new JLabel("Age :");
            id3.setBounds(50,200,100,30);
            id3.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id3);
         
            t3=new JTextField();
            t3.setEditable(false);
            t3.setBounds(200,200,150,30);
            id15.add(t3);
            
//          Date of birth
            id4=new JLabel("DOB (dd/mm/yyyy) :");
            id4.setBounds(400,200,200,30);
            id4.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id4);
         
            t4=new JTextField();
            t4.setEditable(false);
            t4.setBounds(600,200,150,30);
            id15.add(t4);

//            Address
            id5=new JLabel("Address :");
            id5.setBounds(50,250,100,30);
            id5.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id5);
         
            t5=new JTextField();
            t5.setEditable(false);
            t5.setBounds(200,250,150,30);
            id15.add(t5);
            
//          Phone
            id6=new JLabel("Phone :");
            id6.setBounds(400,250,200,30);
            id6.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id6);
         
            t6=new JTextField();
            t6.setEditable(false);
            t6.setBounds(600,250 ,150,30);
            id15.add(t6);
            
            
//           Email Id
            id7=new JLabel("Email ID :");
            id7.setBounds(50,300,100,30);
            id7.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id7);
         
            t7=new JTextField();
            t7.setEditable(false);
            t7.setBounds(200,300,150,30);
            id15.add(t7);
            
//          gender
            gen=new JLabel("Gender :");
            gen.setBounds(400,300,200,30);
            gen.setFont(new Font("serif",Font.BOLD,20));
            id15.add(gen);
         
            gen1=new JTextField();
            gen1.setEditable(false);
            gen1.setBounds(600,300,150,30);
            id15.add(gen1);
            
//          Class X
            id8=new JLabel("Class X(%) :");
            id8.setBounds(400,350,200,30);
            id8.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id8);
         
            t8=new JTextField();
            t8.setEditable(false);
            t8.setBounds(600,350 ,150,30);
            id15.add(t8);
            
            
//           Class XII(%)
            id9=new JLabel("Class XII(%) :");
            id9.setBounds(50,350,130,30);
            id9.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id9);
         
            t9=new JTextField();
            t9.setEditable(false);
            t9.setBounds(200,350,150,30);
            id15.add(t9);
            
//          Aadhar no
            id10=new JLabel("Aadhar Number :");
            id10.setBounds(400,400,200,30);
            id10.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id10);
         
            t10=new JTextField();
            t10.setEditable(false);
            t10.setBounds(600,400 ,150,30);
            t10.setText("AADHR");
            id15.add(t10);
        
//           Enrollment NO
            id11=new JLabel("Enroll No :");
            id11.setBounds(50,400,100,30);
            id11.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id11);
         
            t11=new JTextField();
            t11.setBounds(200,400,150,30);
            t11.setEditable(false);
            id15.add(t11);
            
//          Course        
            id12=new JLabel("Course :");
            id12.setBounds(400,450,200,30);
            id12.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id12);

            
            t12=new JTextField();
            t12.setEditable(false);
            t12.setBounds(600,450,150,30);
            id15.add(t12);
        
//           Branch
            id13=new JLabel("Branch :");
            id13.setBounds(50,450,100,30);
            id13.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id13);
            
            t13=new JTextField();
            t13.setBounds(200,450,150,30);
            t13.setEditable(false);
            id15.add(t13);
            
            
//          Cacnel button
            b1=new JButton("CANCEL");
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.setBounds(350,500,150,40);
            id15.add(b1);
            

            b1.addActionListener(this);
            
            f.setVisible(true);
            f.setSize(900,600);
            f.setLocation(150,50);
                    
            
            try{
                        conn conn2=new conn();
                        String qry="Select * from student where rollno='"+roll+"'";
                        ResultSet rs=conn2.s.executeQuery(qry);
                        if(rs.next())
                        {
                            f.setVisible(true);
                            t1.setText(rs.getString(1));//fetch 1 column
                            t2.setText(rs.getString(2));
                            t3.setText(rs.getString(3));
                            t4.setText(rs.getString(4));
                            t5.setText(rs.getString(5));
                            t6.setText(rs.getString(6));
                            t7.setText(rs.getString(7));
                            t8.setText(rs.getString(8));
                            t9.setText(rs.getString(9));
                            t10.setText(rs.getString(10));
                            t11.setText(rs.getString(11));
                            t12.setText(rs.getString(12));
                            t13.setText(rs.getString(13));
                            gen1.setText(rs.getString(14));
                        }
                    }
                    catch(Exception exp)
                    {
                        JOptionPane.showMessageDialog(null,"Server Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
            
            
        }//constructor
        
        public void actionPerformed(ActionEvent ae)
        {
                    
                f.setVisible(false);
        }//func
        
        
        public static void main(String args[])
        {
            new PStudentDetails().f.setVisible(true);
        }
}//class

