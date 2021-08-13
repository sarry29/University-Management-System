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

import java.awt.*;
import javax.swing.*;

public class AboutUs extends JFrame implements ActionListener{
    
    AboutUs()
    {
        super("ABOUT");
        setBounds(250,100,500,400);
        setBackground(Color.WHITE);
        setResizable(false);
        setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/six.jpg"));
        Image img1=img.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT); //1000X700 size
        ImageIcon icc=new ImageIcon(img1);
        JLabel l1=new JLabel(icc);
        l1.setBounds(330,50,150,150);
        add(l1);
        
        JLabel head1=new JLabel("STUDENT");
        head1.setForeground(Color.CYAN);
        head1.setBounds(10,10,150,50);
        head1.setFont(new Font("serif",Font.BOLD,25));
        
        JLabel head2=new JLabel("MANAGEMENT SYSTEM");
        head2.setForeground(Color.BLUE);
        head2.setBounds(10,60,250,50);
        head2.setFont(new Font("serif",Font.BOLD,20));
        
        add(head1);
        add(head2);

        
        JLabel dev=new JLabel("Developed By:-Rabdeep Singh");
        dev.setForeground(Color.BLACK);
        dev.setBounds(10,150,250,30);                
        dev.setFont(new Font("serif",Font.ITALIC,20));
        add(dev);
        
        JLabel em=new JLabel("E-Mail: sarrysingh1290@gmail.com");
        em.setForeground(Color.BLACK);
        em.setBounds(10,190,500,60);
        em.setFont(new Font("serif",Font.ITALIC,20));
        add(em);
        
        JButton b1=new JButton("CLOSE");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(10,300,100,30);
        b1.setFont(new Font("serif",Font.BOLD,15));   
        add(b1);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        JOptionPane.showMessageDialog(null,"THANK YOU FOR VISITING!","THANK YOU",JOptionPane.INFORMATION_MESSAGE);
        setVisible(false);
    }
    public static void main(String args[])
    {
        new AboutUs().setVisible(true);
    }
}
