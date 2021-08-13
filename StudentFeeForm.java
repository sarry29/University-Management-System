    /*
 * To change is license header, choose License Headers in Project Properties.
 * To change is template file, choose Tools | Templates
 * and open e template in e editor.
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
import javax.swing.border.*;
import java.util.*;

public class StudentFeeForm extends JFrame implements ActionListener,ItemListener{
    
    JPanel p;
    JTextField c1,c3;  
    JComboBox c2;
    JButton b1,b2;
    Choice ch1;
    JTextField t1,t2,t3;
    
    StudentFeeForm()
    {
        super("STUDENT FEE FORM");
        setBounds(300,50,800,600);
        setResizable(false);
        
        ImageIcon te=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/ten1.jpg"));
        Image i1=te.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT); //1000X700 size
        ImageIcon i2=new ImageIcon(i1);
        
        JLabel img=new JLabel(i2);
        setContentPane(img);
        
        JLabel head=new JLabel("Student Fee Form ");
        head.setFont(new Font("serif",Font.ITALIC,35));
        head.setBounds(250,30,400,40);
        img.add(head);
        
        p=new JPanel();
        p.setBorder(new EmptyBorder(5,5,5,5));
        p.setLayout(new GridLayout(7,2,20,20));
        p.setBackground(Color.LIGHT_GRAY);
//        setContentPane(p);
        p.setBounds(130,100,500,350);
        
//        img.add(p);
        
//  for automatic all student enrollment fetch
        ch1=new Choice();
        ch1.setFont(new Font("serif",Font.BOLD,15));
        
        try{
            conn connection=new conn();
            ResultSet rs=connection.s.executeQuery("Select * from student");
            while(rs.next())
            {
                ch1.add(rs.getString("rollno"));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Server data fetch Error","ERROR",JOptionPane.ERROR_MESSAGE);
        } 
        
        ch1.addItemListener(this);
        
        JLabel l1=new JLabel("Select Enrollment No :",JLabel.CENTER);
        l1.setFont(new Font("serif",Font.BOLD,20));
        p.add(l1);
        p.add(ch1);
        
        JLabel l2=new JLabel("Name :",JLabel.CENTER);
        l2.setFont(new Font("serif",Font.BOLD,20));
        p.add(l2);
        t1 = new JTextField();
        t1.setBackground(Color.WHITE);
        t1.setFont(new Font("serif",Font.BOLD,15));
        t1.setEditable(false);
        p.add(t1);
        
        
        JLabel l3=new JLabel("Father's Name :",JLabel.CENTER);
        l3.setFont(new Font("serif",Font.BOLD,20));
        p.add(l3);
        t2 = new JTextField();
        t2.setBackground(Color.WHITE);
        t2.setFont(new Font("serif",Font.BOLD,15));
        t2.setEditable(false);
        p.add(t2);
        
//        try
//        {
//            conn c=new conn();
//            ResultSet rs=c.s.executeQuery("Select * from student where rollno='"+ch1.getSelectedItem()+"'");
//            while(rs.next())
//            {
//                t1.setText(rs.getString("name"));
//                t2.setText(rs.getString("faers_name"));
//                
//            }
//             String s12=ch1.getSelectedItem();
//             ch1.insert(s12,1);
//             System.out.println(t1.getText()+" "+t2.getText());
//             setVisible(false);
//             if(!ch1.getSelectedItem().equals(s12))
//             {
//                 
//             }
//        }
//        catch(Exception e){
//        System.out.println("asdfgfdsa");
//        }
            
        JLabel l7 = new JLabel("Course :",JLabel.CENTER);
        l7.setFont(new Font("serif", Font.BOLD, 20));
        p.add(l7);
        
        c3=new JTextField();
        c3.setEditable(false);
        c3.setFont(new Font("serif",Font.BOLD,15));
        c3.setBackground(Color.WHITE);
        p.add(c3);
        
        

        
        JLabel l4=new JLabel("Branch :",JLabel.CENTER);
        l4.setFont(new Font("serif",Font.BOLD,20));
        p.add(l4);
        c1=new JTextField();
        c1.setEditable(false);
        c1.setFont(new Font("serif",Font.BOLD,15));
        c1.setBackground(Color.WHITE);
        p.add(c1);
        
        
        
        
        JLabel l5=new JLabel("Semester :",JLabel.CENTER);
        l5.setFont(new Font("serif",Font.BOLD,20));
        p.add(l5);
        c2=new JComboBox();
        c2.setModel(new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8"}));
        c2.setFont(new Font("serif",Font.BOLD,15));
        c2.setBackground(Color.WHITE);
        p.add(c2);
        c2.addItemListener(this);
        
        
        JLabel l6=new JLabel("Total Payable :",JLabel.CENTER);
        l6.setFont(new Font("serif",Font.BOLD,20));
        p.add(l6);
        t3=new JTextField();
        t3.setFont(new Font("serif",Font.BOLD,20));
        t3.setEditable(false);
        t3.setFont(new Font("serif",Font.BOLD,15));
        p.add(t3);
        
        JButton b1=new JButton("PAY");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setSize(80,40);
        b1.setBounds(130,450,500,30);
        b1.addActionListener(this);

        
        img.add(b1);    
        img.add(p);
        
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
    

    public void actionPerformed(ActionEvent ae)
    {
                try{
                    conn co=new conn();
                    String qry="insert into fee(rollno,name,fathers_name,course,branch,semester,fee_paid)  values(?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = co.c.prepareStatement(qry);
                    st.setString(1, ch1.getSelectedItem());
                    st.setString(2, t1.getText());
                    st.setString(3, t2.getText());
                    st.setString(4, c3.getText()); //course
                    st.setString(5, c1.getText());//branch
                    st.setString(6, (String)c2.getSelectedItem());//semester
                    st.setString(7, t3.getText());//amount  payable
                    int i = st.executeUpdate();
                    if (i > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Successfully Paid");
                        setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "NOT PAID","ERROR",JOptionPane.WARNING_MESSAGE);
                    }
                }
                catch(Exception e)
                {
                    String msg="Already paid for "+(String)c2.getSelectedItem()+" semester";
                    JOptionPane.showMessageDialog(null,msg,"ERROR",JOptionPane.ERROR_MESSAGE);
                }
            
    }
    
//                String a=t3.getText();
//                try{
//                      conn co=new conn();
//                      String qry="insert into fee(rollno,name,fathers_name,course,branch,semester,fee_paid)  values('"+(String)ch1.getSelectedItem()+"','"+t1.getText()+"','"+t2.getText()+"','"+(String)c3.getSelectedItem()+"','"+(String)c1.getSelectedItem()+"','"+(String)c2.getSelectedItem()+"','"+t3.getText()+"')";
//                      co.s.executeQuery(qry);
//                      JOptionPane.showMessageDialog(null,"Successfully Paid","ALERT",JOptionPane.INFORMATION_MESSAGE);
//                      setVisible(false);
//                }
//                catch(Exception e)
//                {
//                    JOptionPane.showMessageDialog(null,"Server not connected","ERROR",JOptionPane.ERROR_MESSAGE);
//                }

    
    
//    for combobox and choice events
     public void itemStateChanged(ItemEvent ie)
    {
        if(ie.getSource()==ch1)
        {
            String id=ch1.getSelectedItem();
            try
            {
                conn c=new conn();
                String qry="Select name,fathers_name,branch,course  from student where rollno='"+id+"'";
                ResultSet rs=c.s.executeQuery(qry);
                if(rs.next())
                {
                    t1.setText(rs.getString("name"));
                    t2.setText(rs.getString("fathers_name"));
                    c1.setText(rs.getString("branch"));
                    c3.setText(rs.getString("course"));
                    
                }
            }
            catch(Exception e){}
        }
        if(ie.getSource() == c3||ie.getSource() == c2)
        {

            String amount="";
            
            String br=c3.getText();
            String sem=(String)c2.getSelectedItem();
            
            //btech
            if(br.equals("BTech")&&sem.equals("1"))
            {
                amount="42500";
            }
            else
            {
            if(br.equals("BTech")&&!sem.equals("1"))
            {
                amount="37500";
            }
            }
            
//          BSC
            if(br.equals("BSC")&&sem.equals("1"))
            {
                amount="20000";
            }
            if(br.equals("BSC")&&!sem.equals("1"))
            {
                amount="15000";
            }
            
//            BBA
            if(br.equals("BBA")&&sem.equals("1"))
            {
                amount="27000";
            }
            if(br.equals("BBA")&&!sem.equals("1"))
            {
                amount="22000";
            }
            
//            BCA
            if(br.equals("BCA")&&sem.equals("1"))
            {
                amount="35000";
            }
            if(br.equals("BCA")&&!sem.equals("1"))
            {
                amount="30000";
            }
            
//            MCA
            if(br.equals("MCA")&&sem.equals("1"))
            {
                amount="55000";
            }
            if(br.equals("MCA")&&!sem.equals("1"))
            {
                amount="50000";
            }
            
//            MBA
            if(br.equals("MBA")&&sem.equals("1"))
            {
                amount="65000";
            }
            if(br.equals("MBA")&&!sem.equals("1"))
            {
                amount="60000";
            }
            
//            MTech
            if(br.equals("MTech")&&sem.equals("1"))
            {
                amount="85000";
            }
            if(br.equals("MTech")&&!sem.equals("1"))
            {
                amount="80000";
            }
            
            t3.setText(amount);
        }   
    }
    
    public static void main(String args[])
    {
        new StudentFeeForm().setVisible(true);
    }
}
