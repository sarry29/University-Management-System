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

public class ProfessorProject extends JFrame implements ActionListener {
    
    String str;
    ProfessorProject(){}
    ProfessorProject(String s)
    {
        super("PROFESSOR DETAILS");
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
        JMenuItem sdetail=new JMenuItem("Professor Details and Information");
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
        JMenuItem a1=new JMenuItem("Professor Attendance details");
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
        
        
        //Utility Mwnu
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
        mb.add(utility);
        mb.add(psrd);
        mb.add(about);
        mb.add(exit);
        add(mb);
    
    }

    
    public void actionPerformed(ActionEvent ae)
    {
        String a=ae.getActionCommand();
        if(a.equals("Professor Details and Information"))
        {
            new PProfessorDetails(str).f.setVisible(true);
        }
        if(a.equals("Professor Attendance details"))
        {
            new PProfessorAttendanceDetails(str).setVisible(true);
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
            new ChangePasswordProfessor(str).setVisible(true);
        }
        
    }//method
 
    public static void main(String args[])
    {
        new ProfessorProject().setVisible(true);
    }
}
