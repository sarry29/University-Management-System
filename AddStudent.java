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
import java.util.*;
import java.sql.*;

public class AddStudent implements ActionListener {
        
        JFrame f;
        JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id13,id14,id15,gen;
        JButton b1,b2;
        JComboBox c1,c2,gen1;
        JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
        static Set<Long> allRoll=new HashSet<>();
        
        static long findRoll()
        {
            Random ran=new Random();//java util
            //how many digit for random no which will be mode with 9000()i.e for 4 digit
            long first4=(ran.nextLong()%9000L) + 1000L;
            long first=Math.abs(first4);
            while(allRoll.contains(first))
            {
                first4=(ran.nextLong()%9000L) + 1000L;
                first=Math.abs(first4);
            }
            allRoll.add(first);
            return first;
        }
        
        //or by defining range
//        int max=9999,min=0000;
//        int range=max-min;
//        int rand = (int)(Math.random() * range) + min;
//        rand=(int)Math.abs(()rand);  
        
        AddStudent()
        {
            f=new JFrame("ADD STUDENT");
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
            
            id=new JLabel("New Student Details");
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
            id15.add(t1);    
            

//           Father NAme
            id2=new JLabel("Father's Name :");
            id2.setBounds(400,150,200,30);
            id2.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id2);
         
            t2=new JTextField();
            t2.setBounds(600,150,150,30);
            id15.add(t2);
            
//           Age
            id3=new JLabel("Age :");
            id3.setBounds(50,200,100,30);
            id3.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id3);
         
            t3=new JTextField();
            t3.setBounds(200,200,150,30);
            id15.add(t3);
            
            
//          Date of birth
            id4=new JLabel("DOB (dd/mm/yyyy) :");
            id4.setBounds(400,200,200,30);
            id4.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id4);
         
            t4=new JTextField();
            t4.setBounds(600,200,150,30);
            id15.add(t4);

            
            
//            Address
            id5=new JLabel("Address :");
            id5.setBounds(50,250,100,30);
            id5.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id5);
         
            t5=new JTextField();
            t5.setBounds(200,250,150,30);
            id15.add(t5);
            
//          Gender 
            gen=new JLabel("Gender  :");
            gen.setBounds(400,250,200,30);
            gen.setFont(new Font("serif",Font.BOLD,20));
            id15.add(gen);
         
            String gender[]={"MALE","FEMALE","OTHER"};
            gen1=new JComboBox(gender);
            gen1.setBounds(600,250,150,30);
            id15.add(gen1);

//          Phone
            id6=new JLabel("Phone :");
            id6.setBounds(400,300,200,30);
            id6.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id6);
         
            t6=new JTextField();
            t6.setBounds(600,300 ,150,30);
            id15.add(t6);
            
            
//           Email Id
            id7=new JLabel("Email ID :");
            id7.setBounds(50,300,100,30);
            id7.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id7);
         
            t7=new JTextField();
            t7.setBounds(200,300,150,30);
            id15.add(t7);
            

//          Class X
            id8=new JLabel("Class X(%) :");
            id8.setBounds(400,350,200,30);
            id8.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id8);
         
            t8=new JTextField();
            t8.setBounds(600,350 ,150,30);
            id15.add(t8);
            
            
//           Class XII(%)
            id9=new JLabel("Class XII(%) :");
            id9.setBounds(50,350,130,30);
            id9.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id9);
         
            t9=new JTextField();
            t9.setBounds(200,350,150,30);
            id15.add(t9);
            

//          Aadhar no
            id10=new JLabel("Aadhar Number :");
            id10.setBounds(400,400,200,30);
            id10.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id10);
         
            t10=new JTextField();
            t10.setBounds(600,400 ,150,30);
            t10.setText("AADHR");
            id15.add(t10);
            
//            ALL ROll no in set
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from student");
            while(rs.next())
            {
                String s=rs.getString("rollno");
                s=s.substring(7,11);
                Long val=Long.parseLong(s);
                allRoll.add(val);
            }
        }
        catch(Exception e){}
        
//           Enrollment NO
            id11=new JLabel("Enroll No :");
            id11.setBounds(50,400,100,30);
            id11.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id11);
         
            t11=new JTextField();
            t11.setBounds(200,400,150,30);
            
            long first=findRoll();
            t11.setText("1810DMB"+first);
            t11.setEditable(false);
            id15.add(t11);
            
//          Course        
            id12=new JLabel("Course :");
            id12.setBounds(400,450,200,30);
            id12.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id12);

            String course[]={"BTech","BSC","BBA","BCA","MCA","MBA","MTech"};
            c1=new JComboBox(course);
            c1.setBounds(600,450,150,30);
//          c1.setBackground(Color.BLACK);    
//          c1.setForeground(Color.WHITE);
            id15.add(c1);
        
//           Branch
            id13=new JLabel("Branch :");
            id13.setBounds(50,450,100,30);
            id13.setFont(new Font("serif",Font.BOLD,20));
            id15.add(id13);
            
            String course1[]={"IT","CS","Electrical","Mechanical","Civil","Electronics"};
            c2=new JComboBox(course1);
            c2.setBounds(200,450,150,30);
//            c2.setBackground(Color.BLACK);
//            c2.setForeground(Color.WHITE);
            id15.add(c2);
            
            
//          Submit button
            b1=new JButton("Submit");
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.setBounds(250,500,150,40);
            id15.add(b1);
            
//            Cancel button
            b2=new JButton("Cancel");
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);
            b2.setBounds(450,500,150,40);
            id15.add(b2);

            b1.addActionListener(this);
            b2.addActionListener(this);
            
            f.setVisible(true);
            f.setSize(900,600);
            f.setLocation(180,30);
        }//constructor
        
        public void actionPerformed(ActionEvent ae)
        {
            String a=t1.getText();//Name
            String b=t2.getText();//Father NAme
            String c=t3.getText();//Age
            String d=t4.getText();//Date of birth
            String e=t5.getText();//address
            String ff=t6.getText();//Phone
            String g=t7.getText();//Email Id
            String h=t8.getText();//Class X
            String i=t9.getText();//Class XII
            String j=t10.getText();//Aadhar no
            String k=t11.getText();//Enrollment NO
            //return obj of an object thats why typecast to String
            String l=(String)c1.getSelectedItem();
            String m=(String)c2.getSelectedItem();
            String selGen=(String)gen1.getSelectedItem();
                    
            if(ae.getSource()==b1)
            {
                if(a.length()<=3||b.length()<=3||(c.length()==0&&c.length()>=3)||d.length()!=10||e.length()==0||ff.length()!=10||g.length()==0||(h.length()==0&&h.length()>=4)||(i.length()==0&&i.length()>=4)||j.length()!=10)
                {
                    JOptionPane.showMessageDialog(null,"Invalid Input","WARNING",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    try{
                        conn cc=new conn();
                        String q="insert into student values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+ff+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"','"+l+"','"+m+"','"+selGen+"')";
                        String q1="insert into studentlogin values('"+k+"','0000','"+a+"')";
                        cc.s.executeUpdate(q);
                        cc.s.executeUpdate(q1);
                        
                        JOptionPane.showMessageDialog(null,"Student Detail inserted Successfully","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch(Exception exp)
                        {
                            JOptionPane.showMessageDialog(null,"Invalid Input or Already Register User","ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                }
            }
            else
            {
                f.setVisible(false);
            }
        }//func
        public static void main(String args[])
        {
            new AddStudent().f.setVisible(true);
        }
}//class

//com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: 
//You have an error in your SQL syntax; 
//check the manual that corresponds to your MySQL server version for the right syntax to use near '21','01/01/2000','102 ,a street','9887654890','deepak@gmail.com','90','90','AADH' at line 1
