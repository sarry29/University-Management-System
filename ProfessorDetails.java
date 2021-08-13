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
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProfessorDetails extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3;
    JTable t1;
    JButton b1,b2,b3,b4;
    JTextField t2;
    String x[]={"NAME","FATHER'S Name","AGE","DOB","ADDRESS","PHONE","EMAIL","CLASS X(%)","CLASS X11(%)","AADHAR NO","EMPLOY ID","COURSE","BRANCH","GENDER"};
    String y[][]=new String[100][14];
    int i=0,j=0;
    
    ProfessorDetails()
    {
        super("PROFESSORS DETAILS");
        setBounds(100,30,1050,650);
        setResizable(false);
        setLayout(null);
        
        ImageIcon cl=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/ten2.jpg"));
        Image i1=cl.getImage().getScaledInstance(1050,650,Image.SCALE_DEFAULT); //1000X700 size
        ImageIcon i2=new ImageIcon(i1);
        
        JLabel bg=new JLabel(i2);
        add(bg);
        setContentPane(bg);
        
        l1=new JLabel("Enter Employ ID to delete Professor record :");
        l1.setBounds(50,400, 390,30);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("serif",Font.BOLD,15));
        add(l1);
        
        t2=new JTextField();
        t2.setBounds(400,400,200,30);
        add(t2);
        
        b1=new JButton("DELETE");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBounds(600,400,100,30);
        add(b1);
        
        l2=new JLabel("Add New Professor Details :");
        l2.setBounds(50,450,250,30);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.BOLD,15));
        add(l2);
        
        b2=new JButton("Add Professor");
        b2.setBounds(300,450,150,30);
        b2.setBackground(Color.BLACK);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setForeground(Color.WHITE);
        add(b2);
        
        
        l3=new JLabel("Update Professor Details : ");
        l3.setBounds(50,500,250,30);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("serif",Font.BOLD,15));
        add(l3);
        
        b3=new JButton("Update Professor");
        b3.setBounds(300,500,150,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);
        
        
        b4=new JButton("CANCEL");
        b4.setBounds(50,550,100,30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("serif",Font.BOLD,15));
        add(b4);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        //table
        try{
            conn c=new conn();
            String s1="Select * from teacher";
            ResultSet rs=c.s.executeQuery(s1);
            while(rs.next())
            {
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("fathers_name");
                y[i][j++]=rs.getString("age");
                y[i][j++]=rs.getString("dob");
                y[i][j++]=rs.getString("address");
                y[i][j++]=rs.getString("phone");
                y[i][j++]=rs.getString("email");
                y[i][j++]=rs.getString("class_x");
                y[i][j++]=rs.getString("class_xii");
                y[i][j++]=rs.getString("aadhar");
                y[i][j++]=rs.getString("emp_id");
                y[i][j++]=rs.getString("course");
                y[i][j++]=rs.getString("dept");
                y[i][j]=rs.getString("gender");

                i++;
                j=0;
            }
            t1=new JTable(y,x);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Server not connected","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        JScrollPane jsp=new JScrollPane(t1);
        jsp.setBounds(20,50,980,340);
        add(jsp);
        
         t1.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    int row=t1.getSelectedRow();
                    t2.setText(t1.getModel().getValueAt(row, 10).toString());
                }               
         });
        
        
        JLabel head=new JLabel("PROFESSORS DETAILS");
        head.setBounds(400,0,500,40);
        head.setForeground(Color.WHITE);
        head.setFont(new Font("serif",Font.BOLD,20));
        add(head);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
    }
    public void actionPerformed(ActionEvent ae)
    {
        conn c1=new conn();
        if(ae.getSource()==b1)
        {
            String a=t2.getText();
            try{

             String q="delete from teacher where emp_id='"+a+"'";
             
             c1.s.executeUpdate(q);
             c1.s.executeUpdate("delete from attendance_teacher where emp_id='"+a+"'");
             c1.s.executeUpdate("delete from teacherlogin where username='"+a+"'");
             this.setVisible(false);
             new ProfessorDetails().setVisible(true);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                
                JOptionPane.showMessageDialog(null,"Server Error","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            
            if(ae.getSource()== b2)
            {
                new AddProfessor().f.setVisible(true);
                this.setVisible(false);
            }
            else
            {
                if(ae.getSource()==b3)
                {
                    new UpdateProfessor().f.setVisible(true);
                    this.setVisible(false);
                }
                
                else
                {
                    setVisible(false);
                }
                }
        }
        
    }
    public static void main(String ar[])
    {
        new ProfessorDetails().setVisible(true);
    }
}
