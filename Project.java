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

public class Project extends JFrame implements ActionListener {
    Project()
    {
        super("STUDENT MANAGEMENT SYSTEM");
        setSize(1250,800);
        ImageIcon cl=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/first.jpg"));
        Image i1=cl.getImage().getScaledInstance(1250,800,Image.SCALE_DEFAULT); //1000X700 size
        ImageIcon i2=new ImageIcon(i1);
        
        JLabel l1=new JLabel(i2);
        add(l1);
        setContentPane(l1);
        
        JMenuBar mb=new JMenuBar();
        mb.setBackground(Color.BLACK);
        mb.setSize(1080,60);
     
        
        //master menu
        JMenu master =new JMenu("MASTER");
        master.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem m1=new JMenuItem("New Professor");
        JMenuItem m2=new JMenuItem("New Student Admission");
        master.setForeground(Color.YELLOW);
        
        m1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon1.png"));
        Image image1=icon1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic('B');
        
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        m1.setBackground(Color.WHITE);
        
        m2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon2.png"));
        Image image2=icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT); //1000X700 size
        m2.setIcon(new ImageIcon(image2));
        m2.setMnemonic('A');
        m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        m2.setBackground(Color.WHITE);
        master.add(m2);
        master.add(m1);
        
        m1.addActionListener(this);
        m2.addActionListener(this);  
        
        
       //user menu 
        JMenu user=new JMenu("Details");
        user.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem u1=new JMenuItem("Student Details");
        JMenuItem u2=new JMenuItem("Professor Details");
        user.setForeground(Color.ORANGE);
        
        u1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon3.png"));
        Image image3=icon3.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        u1.setIcon(new ImageIcon(image3));
        u1.setMnemonic('C');
        
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);
        user.add(u1);
        
        u2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon4.jpg"));
        Image image4=icon4.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        u2.setIcon(new ImageIcon(image4));
        u2.setMnemonic('D');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        u2.setBackground(Color.WHITE);
        user.add(u2);

        
        u1.addActionListener(this);
        u2.addActionListener(this);  

        
        //attendance details
        JMenu attendance=new JMenu("Attendance");
        attendance.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem a1=new JMenuItem("Student Attendance");
        JMenuItem a2=new JMenuItem("Professor Attendance");
        attendance.setForeground(Color.YELLOW);
        
        a1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon14.jpg"));
        Image image5=icon5.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        a1.setIcon(new ImageIcon(image5));
        a1.setMnemonic('E');
        
        a1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        a1.setBackground(Color.WHITE);
        attendance.add(a1);
        
        a2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon15.png"));
        Image image6=icon6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT); //1000X700 size
        a2.setIcon(new ImageIcon(image6));
        a2.setMnemonic('F');
        a2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
        a2.setBackground(Color.WHITE);
        attendance.add(a2);
                
        a1.addActionListener(this);
        a2.addActionListener(this);  

//        Attendance detail Menu
        JMenu attendance_detail=new JMenu("Attendance Details");
        attendance_detail.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem b1=new JMenuItem("Student Attendance Detail");
        JMenuItem b2=new JMenuItem("Professor Attendance Detail");
        attendance_detail.setForeground(Color.ORANGE);
        
        b1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon15.png"));
        Image image7=icon7.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        b1.setIcon(new ImageIcon(image7));
        b1.setMnemonic('G');
        
        b1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        b1.setBackground(Color.WHITE);
        attendance_detail.add(b1);
        
        b2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon14.jpg"));
        Image image8=icon8.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        b2.setIcon(new ImageIcon(image8));
        b2.setMnemonic('H');
        b2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
        b2.setBackground(Color.WHITE);
        attendance_detail.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        //Examination Details MEnu
        JMenu exam=new JMenu("Examination");
        exam.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem c1=new JMenuItem("Examination Detail");
        JMenuItem c2=new JMenuItem("Enter Marks");
        exam.setForeground(Color.YELLOW);
        
        c1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon16.png"));
        Image image9=icon9.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        c1.setIcon(new ImageIcon(image9));
        c1.setMnemonic('I');
        
        c1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
        c1.setBackground(Color.WHITE);
        exam.add(c1);
        
        c2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon17.png"));
        Image image10=icon10.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        c2.setIcon(new ImageIcon(image10));
        c2.setMnemonic('J');
        c2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,ActionEvent.CTRL_MASK));
        c2.setBackground(Color.WHITE);
        exam.add(c2);
        
        c1.addActionListener(this);
        c2.addActionListener(this);
        
        
        //report menu
        JMenu report=new JMenu("Update Details");
        report.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem r1=new JMenuItem("Update Student");
        JMenuItem r2=new JMenuItem("Update Professor");
        report.setForeground(Color.ORANGE);
        
        r1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon5.png"));
        Image image11=icon11.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        r1.setIcon(new ImageIcon(image11));
        r1.setMnemonic('K');
        
        r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
        r1.setBackground(Color.WHITE);
        report.add(r1);
        
        r2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon6.png"));
        Image image12=icon12.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        r2.setIcon(new ImageIcon(image10));
        r2.setMnemonic('L');
        r2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        r2.setBackground(Color.WHITE);
        report.add(r2);
        
        r1.addActionListener(this);
        r2.addActionListener(this);

        
//        Fee menu
        JMenu fee=new JMenu("Fee Details");
        fee.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem s1=new JMenuItem("Fee Structure");
        JMenuItem s2=new JMenuItem("Student Fee Form");
        fee.setForeground(Color.YELLOW);
        
        s1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon13=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon7.png"));
        Image image13=icon13.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        s1.setIcon(new ImageIcon(image13));
        s1.setMnemonic('M');
        
        s1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        s1.setBackground(Color.WHITE);
        fee.add(s1);
        
        s2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon14=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon8.png"));
        Image image14=icon14.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        s2.setIcon(new ImageIcon(image14));
        s2.setMnemonic('N');
        s2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        s2.setBackground(Color.WHITE);
        fee.add(s2);
        
        s1.addActionListener(this);
        s2.addActionListener(this);

        
//        Utility Mwnu
        JMenu utility=new JMenu("Utility");
        utility.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem ut1=new JMenuItem("Notepad");
        JMenuItem ut2=new JMenuItem("Calculator");
        
        JMenu ut3=new JMenu("Browser");
        JMenuItem ut3a=new JMenuItem("Chrome");
        JMenuItem ut3b=new JMenuItem("Internet Explorer");
        JMenuItem ut3c=new JMenuItem("Mozilla Firefox");

        utility.setForeground(Color.ORANGE);
        
        ut1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon15=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon9.png"));
        Image image15=icon15.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        ut1.setIcon(new ImageIcon(image15));
        ut1.setMnemonic('O');
        
        ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        ut1.setBackground(Color.WHITE);
        utility.add(ut1);
        
        ut2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon16=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon10.png"));
        Image image16=icon16.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        ut2.setIcon(new ImageIcon(image16));
        ut2.setMnemonic('P');
        ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        ut2.setBackground(Color.WHITE);
        utility.add(ut2);
        
        
        ut3.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon17=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon11.png"));
        Image image17=icon17.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        ut3.setIcon(new ImageIcon(image17));
//        ut3.setMnemonic('Q');
//        ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
        ut3.setBackground(Color.WHITE);
        
        //image for browser
        ut3a.setIcon(new ImageIcon(image17));
        ut3b.setIcon(new ImageIcon(image17));
        ut3c.setIcon(new ImageIcon(image17));
        ut3.add(ut3a);
        ut3.add(ut3b);
        ut3.add(ut3c);
        
        utility.add(ut3);
        
        ut1.addActionListener(this);
        ut2.addActionListener(this);
        
        //inner browser
        ut3a.addActionListener(this);
        ut3b.addActionListener(this);
        ut3c.addActionListener(this);
        
        
//      About Menu
        JMenu about=new JMenu("About");
        about.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem ab1=new JMenuItem("About");
        about.setForeground(Color.YELLOW);
        
        ab1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon18=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon13.jpg"));
        Image image18=icon18.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        ab1.setIcon(new ImageIcon(image17));
        ab1.setMnemonic('R');
        ab1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        ab1.setBackground(Color.WHITE);
        about.add(ab1);
        
        ab1.addActionListener(this);
        
        
//     Exit Menu
        JMenu exit=new JMenu("EXIT");
        exit.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem e1=new JMenuItem("Exit");
        exit.setForeground(Color.ORANGE);
        
        e1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon19=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon12.png"));
        Image image19=icon19.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        e1.setIcon(new ImageIcon(image17));
        e1.setMnemonic('Z');
        e1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
        e1.setBackground(Color.WHITE);
        exit.add(e1);
        
        e1.addActionListener(this);
    
//        Add Menus to MenuBar
        mb.add(master); 
        mb.add(user);
        mb.add(attendance_detail);
        mb.add(attendance);
        mb.add(exam);
        mb.add(report);
        mb.add(fee);
        mb.add(utility);
        mb.add(about);
        mb.add(exit);
        
        setJMenuBar(mb); 
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//constructor

    public void actionPerformed(ActionEvent ae)
    {
        //which menuitem is pressed return string name oof menuitem
        String msg = ae.getActionCommand();
        
        if(msg.equals("New Student Admission")){
//            f is written bcause JFrame explicitlyd ddfine in addStudent
            new AddStudent().f.setVisible(true);
            
        }else if(msg.equals("New Professor")){
            new AddProfessor().f.setVisible(true);

        }else if(msg.equals("Student Details")){
            new StudentDetails().setVisible(true);
            
        }else if(msg.equals("Professor Details")){
            new ProfessorDetails().setVisible(true);

        }else if(msg.equals("Student Attendance")){
            new StudentAttendance().setVisible(true);
            
        }else if(msg.equals("Professor Attendance")){
            new ProfessorAttendance().setVisible(true);
            
        }else if(msg.equals("Student Attendance Detail")){
            new StudentAttendanceDetail().setVisible(true);
            
        }else if(msg.equals("Professor Attendance Detail")){
            new ProfessorAttendanceDetail().setVisible(true);
            
        } else if(msg.equals("Examination Detail")){
            new ExaminationDetail().setVisible(true);
            
        }else if(msg.equals("Enter Marks")){
            new EnterMarks().setVisible(true);
            
        }else if(msg.equals("Update Student")){
            new UpdateStudent().f.setVisible(true);
            
        }else if(msg.equals("Update Professor")){
            new UpdateProfessor().f.setVisible(true);
            
        }else if(msg.equals("Fee Structure")){
            new FeeStructure().setVisible(true);
            
        }else if(msg.equals("Student Fee Form")){
            new StudentFeeForm().setVisible(true);
            
        }else if(msg.equals("Notepad")){
            
            
//            Runtime class k andr runtime static method which open apppln
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){}
            
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){}
            
        }else if(msg.equals("Mozilla Firefox")){
            try{
                Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            }catch(Exception e){}
            
        }else if(msg.equals("Internet Explorer"))
        {
            try
            {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe");
            }
            catch(Exception e){}
            
        }else if(msg.equals("Chrome"))
        {
            try{
                Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            }
            catch(Exception e){}
            
        }else if(msg.equals("About")){
            new AboutUs().setVisible(true);
            
        }else if(msg.equals("Exit")){
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }//action listener
    public static void main(String args[])
    {
        new Project().setVisible(true);
        
    }
}//class

