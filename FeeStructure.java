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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FeeStructure extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JLabel head,image;
    JLabel m1,m2,m3,m4,m5,m6,m7,m8;
    JButton b1;




    FeeStructure()
    {
        setBounds(100,50,900,600);
        setLayout(null);
        setResizable(false);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/nine.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT); //1000X700 size
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        setContentPane(image);
//        l3.setBounds(350,20,150,150);
        
//        add(l3);
        
        
        head=new JLabel("Fee Structure");
        head.setBounds(350,10,300,40); 
        head.setFont(new Font("serif",Font.ITALIC,30));
        head.setForeground(Color.WHITE);
        image.add(head);
        
//        JPanel p2=new JPanel();
//        p2.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY,3,true),"FEE STRUCTURE",TitledBorder.LEADING,TitledBorder.TOP,null,Color.DARK_GRAY));
//        p2.setBounds(80,50,750,450);
//        
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(9,8));
        p.setBounds(100,70,700,400);
        p.setBackground(Color.LIGHT_GRAY);
        
        l1=new JLabel("Course");
        l1.setFont(new Font("serif",Font.BOLD,15));
        l2=new JLabel("BTech");
        l2.setFont(new Font("serif",Font.BOLD,15));
        l3=new JLabel("BCA");
        l3.setFont(new Font("serif",Font.BOLD,15));
        l4=new JLabel("BBA");
        l4.setFont(new Font("serif",Font.BOLD,15));
        l5=new JLabel("BSc");
        l5.setFont(new Font("serif",Font.BOLD,15));
        l6=new JLabel("MBA");
        l6.setFont(new Font("serif",Font.BOLD,15));
        l7=new JLabel("MCA");
        l7.setFont(new Font("serif",Font.BOLD,15));
        l8=new JLabel("MTech");
        l8.setFont(new Font("serif",Font.BOLD,15));
        
        
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l5);
        p.add(l6);
        p.add(l7);
        p.add(l8);

        
        m1=new JLabel("Semester 1");
        m1.setFont(new Font("serif",Font.BOLD,15));
        m2=new JLabel("Semester 2");
        m2.setFont(new Font("serif",Font.BOLD,15));
        m3=new JLabel("Semester 3");
        m3.setFont(new Font("serif",Font.BOLD,15));
        m4=new JLabel("Semester 4");
        m4.setFont(new Font("serif",Font.BOLD,15));
        m5=new JLabel("Semester 5");
        m5.setFont(new Font("serif",Font.BOLD,15));
        m6=new JLabel("Semester 6");
        m6.setFont(new Font("serif",Font.BOLD,15));
        m7=new JLabel("Semester 7");
        m7.setFont(new Font("serif",Font.BOLD,15));
        m8=new JLabel("Semester 8");
        m8.setFont(new Font("serif",Font.BOLD,15));
        
        
        


        //row 1
        p.add(m1);
        p.add(new JLabel("RS 37500"));
        p.add(new JLabel("RS 30000"));
        p.add(new JLabel("RS 22000"));
        p.add(new JLabel("RS 15000"));
        p.add(new JLabel("RS 60000"));
        p.add(new JLabel("RS 50000"));
        p.add(new JLabel("RS 80000"));

        
        //r2
        p.add(m2);
        p.add(new JLabel("RS 37500"));
        p.add(new JLabel("RS 30000"));
        p.add(new JLabel("RS 22000"));
        p.add(new JLabel("RS 15000"));
        p.add(new JLabel("RS 60000"));
        p.add(new JLabel("RS 50000"));
        p.add(new JLabel("RS 80000"));


        //r3
        p.add(m3);
        p.add(new JLabel("RS 37500"));
        p.add(new JLabel("RS 30000"));
        p.add(new JLabel("RS 22000"));
        p.add(new JLabel("RS 15000"));
        p.add(new JLabel("RS 60000"));
        p.add(new JLabel("RS 50000"));
        p.add(new JLabel("RS 80000"));
        
        //r4
        p.add(m4);
        p.add(new JLabel("RS 37500"));
        p.add(new JLabel("RS 30000"));
        p.add(new JLabel("RS 22000"));
        p.add(new JLabel("RS 15000"));
        p.add(new JLabel("RS 60000"));
        p.add(new JLabel("RS 50000"));
        p.add(new JLabel("RS 80000"));

        //r5
        p.add(m5);
        p.add(new JLabel("RS 37500"));
        p.add(new JLabel("RS 30000"));
        p.add(new JLabel("RS 22000"));
        p.add(new JLabel("RS 15000"));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));

        
        p.add(m6);
        p.add(new JLabel("RS 37500"));
        p.add(new JLabel("RS 30000"));
        p.add(new JLabel("RS 22000"));
        p.add(new JLabel("RS 15000"));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));

        
        p.add(m7);
        p.add(new JLabel("RS 37500"));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));
        
        p.add(m8);
        p.add(new JLabel("RS 37500"));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));
        p.add(new JLabel(" "));
        
        image.add(p);

//        image.add(p2);
//        p2.add(p);

        
        b1=new JButton("CLOSE");
        b1.setBounds(400,500,100,40);
        image.add(b1);
        b1.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            this.setVisible(false);
        }
        
    }
    public static void main(String a[])
    {
        new FeeStructure().setVisible(true);
    }
}
