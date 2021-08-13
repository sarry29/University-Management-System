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

public class StudentProject extends JFrame implements ActionListener {
    
    String str;
    StudentProject(){}
    StudentProject(String s)
    {
        super("STUDENT DETAILS");
        str=s;
        setBounds(10,10,1250,800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        ImageIcon cl=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/first.jpg"));
        Image i1=cl.getImage().getScaledInstance(1250,800,Image.SCALE_DEFAULT); //1000X700 size
        ImageIcon i2=new ImageIcon(i1);
        
        JLabel l1=new JLabel(i2);
        add(l1);
        setContentPane(l1);
        
        JMenuBar mb=new JMenuBar();
        mb.setBackground(Color.BLACK);
        mb.setSize(1250,30);
        
        //Details menu
        JMenu detail =new JMenu("Details");
        detail.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem sdetail=new JMenuItem("Student Details and Information");
        detail.setForeground(Color.YELLOW);
        
        
        sdetail.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon2.png"));
        Image image2=icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT); //1000X700 size
        sdetail.setIcon(new ImageIcon(image2));
        sdetail.setMnemonic('A');
        sdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        sdetail.setBackground(Color.WHITE);
        detail.add(sdetail);
        
        sdetail.addActionListener(this);
    
        //attendance details
        JMenu attendance=new JMenu("Attendance");
        attendance.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem a1=new JMenuItem("Student Attendance details");
        attendance.setForeground(Color.ORANGE);
        
        a1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon14.jpg"));
        Image image5=icon5.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        a1.setIcon(new ImageIcon(image5));
        a1.setMnemonic('B');
        
        a1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        a1.setBackground(Color.WHITE);
        attendance.add(a1);
        
                
        a1.addActionListener(this);
        
        
        //Examination Details MEnu
        JMenu exam=new JMenu("Examination Report");
        exam.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem c1=new JMenuItem("Student Examination Detail");
        exam.setForeground(Color.YELLOW);
        
        c1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon16.png"));
        Image image9=icon9.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        c1.setIcon(new ImageIcon(image9));
        c1.setMnemonic('C');
        
        c1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        c1.setBackground(Color.WHITE);
        exam.add(c1);
        
        c1.addActionListener(this);
        
//      Fee 
        JMenu fee=new JMenu("Fee Details");
        fee.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem s1=new JMenuItem("Student Fee Details");
        fee.setForeground(Color.ORANGE);
        
        s1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon13=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon7.png"));
        Image image13=icon13.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        s1.setIcon(new ImageIcon(image13));
        s1.setMnemonic('D');
        
        s1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        s1.setBackground(Color.WHITE);
        fee.add(s1);
        
        s1.addActionListener(this);

        
//        Utility Mwnu
        JMenu utility=new JMenu("Utility");
        utility.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem ut1=new JMenuItem("Notepad");
        JMenuItem ut3=new JMenuItem("Browser");
        utility.setForeground(Color.YELLOW);
        
        ut1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon15=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon9.png"));
        Image image15=icon15.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        ut1.setIcon(new ImageIcon(image15));
        ut1.setMnemonic('E');
        
        ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        ut1.setBackground(Color.WHITE);
        utility.add(ut1);
        
        ut3.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon17=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon11.png"));
        Image image17=icon17.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        ut3.setIcon(new ImageIcon(image17));
        ut3.setMnemonic('F');
        ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
        ut3.setBackground(Color.WHITE);
        utility.add(ut3);
        
        ut1.addActionListener(this);
        ut3.addActionListener(this);
        
//      Change password
        JMenu psrd=new JMenu("Change password");
        psrd.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem psrd1=new JMenuItem("Change password");
        psrd.setForeground(Color.ORANGE);
        
        psrd1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon14=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon5.png"));
        Image image14=icon14.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        psrd1.setIcon(new ImageIcon(image14));
        psrd1.setMnemonic('G');
        
        psrd1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        psrd1.setBackground(Color.WHITE);
        psrd.add(psrd1);
        
        psrd1.addActionListener(this);
        
        
        
//      About Menu
        JMenu about=new JMenu("About");
        about.setFont(new Font("serif",Font.BOLD,10));
        JMenuItem ab1=new JMenuItem("About");
        about.setForeground(Color.YELLOW);
        
        ab1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon18=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon13.jpg"));
        Image image18=icon18.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT); //1000X700 size
        ab1.setIcon(new ImageIcon(image17));
        ab1.setMnemonic('H');
        ab1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
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
        
        mb.add(detail);        
        mb.add(attendance);
        mb.add(exam);
        mb.add(fee);
        mb.add(utility);
        mb.add(psrd);
        mb.add(about);
        mb.add(exit);
        add(mb);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String a=ae.getActionCommand();
        if(a.equals("Student Details and Information"))
        {
            new PStudentDetails(str).f.setVisible(true);
        }
        if(a.equals("Student Examination Detail"))
        {
            new PExamDetails(str).setVisible(true);
        }
        if(a.equals("Student Attendance details"))
        {
            new PStudentAttendanceDetails(str).setVisible(true);
        }
        if(a.equals("Student Fee Details"))
        {
            new PFeeDetails(str).setVisible(true);
        }
        if(a.equals("Notepad"))
        {
             try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){}
        }
        if(a.equals("Browser"))
        {
            try{
                Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            }catch(Exception e){}
        }
        if(a.equals("About"))
        {
            new AboutUs().setVisible(true);
        }
        if(a.equals("Exit"))
        {
            setVisible(false);
            new Login().setVisible(true);
        }
        if(a.equals("Change password"))
        {
//            setVisible(false);
            new ChangePasswordStudent(str).setVisible(true);
        }
        
        
    }//method
    public static void main(String args[])
    {
        new StudentProject().setVisible(true);
    }
    
}
