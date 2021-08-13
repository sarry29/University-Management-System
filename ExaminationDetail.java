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
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class ExaminationDetail extends JFrame implements ActionListener {
    
    JPanel p;
    JTable  table;
    JButton b1,b2,b3;
    JLabel la1,l2,image;
    JTextField search;
    int i=0,j=0;
    String h[]={"NAME","FATHER'S NAME","AGE","DOB","ADDRESS","PHONE","E-MAIL","CLASS X","CLASS XII","AADHAR NO","ROLLNO","COURSE","BRANCH"};
    String d[][]=new String[40][13];
            
//    public void Book()
//    {
//        try{
//            conn con=new conn();
//            String sql="Select * from student";
//            PreparedStatement st=con.c.prepareStatement(sql);
//            ResultSet rs=st.executeQuery();
//            
//            table.setModel(DbUtils.resultSetToTableModel(rs));
//           rs.close();
//           st.close();
//           con.c.close();
//        }
//        catch(SQLException e){}
//    }
    
    ExaminationDetail()
    {
        super("EXAMINATION DETAILS");
        setResizable(false);
        setBounds(50,50,1100,600);
        setLayout(null);
        
               
        p=new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        setContentPane(p); 
        p.setLayout(null);
        
        //for creating table JScrollPane is compulsory to made
        JScrollPane sp=new JScrollPane();
        sp.setBounds(75,150,950,340);
        p.add(sp);
         int i=0,j=0;
         
        try
           {
                String qry="Select * from student";   
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(qry);

                /*
                rs.next()
                if(rs.next()) only 1 row
                while(rs.next()) all rows
                 */
                
                
                while(rs.next())
                {
                    d[i][j++]=rs.getString(1);
                    d[i][j++]=rs.getString(2);
                    d[i][j++]=rs.getString(3);
                    d[i][j++]=rs.getString(4);
                    d[i][j++]=rs.getString(5);
                    d[i][j++]=rs.getString(6);
                    d[i][j++]=rs.getString(7);
                    d[i][j++]=rs.getString(8);
                    d[i][j++]=rs.getString(9);
                    d[i][j++]=rs.getString(10);
                    d[i][j++]=rs.getString(11);
                    d[i][j++]=rs.getString(12);
                    d[i][j++]=rs.getString(13);

                    i++;
                    j=0;
                }
                table=new JTable(d,h);
                //2 d array,1 array data/column data(metadata)

           }
           catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, "Server not connected", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
         
        
        table.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent me)
                {
//                    check here 2:9:44
                    int row=table.getSelectedRow();
                    search.setText(table.getModel().getValueAt(row, 10).toString());
                }               
         });
        
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.BLACK);
        table.setFont(new Font("serif",Font.BOLD,16));
        
        sp.setViewportView(table);//table add in scrollpane

        JLabel ll=new JLabel("Check Result");
        ll.setForeground(Color.BLACK);
        ll.setFont(new Font("serif",Font.BOLD,30));
        ll.setBounds(50,0,400,50);
        p.add(ll);
       
        b1=new JButton("Result");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(Color.DARK_GRAY,2,true));
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("serif",Font.BOLD,18));
        b1.setBounds(400,90,100,30);
        p.add(b1);
            
       
       JLabel label=new JLabel("Enter Enrollment Number");
       label.setBounds(200, 55, 300, 30);
       label.setFont(new Font("serif",Font.BOLD,18));
       p.add(label);
       
       search=new JTextField();
       search.setBackground(Color.LIGHT_GRAY);
       search.setForeground(Color.BLACK);
       search.setFont(new Font("serif",Font.BOLD,15));
       search.setBorder(new LineBorder(Color.DARK_GRAY,3,true));
       search.setBounds(200,90,200,30);
       p.add(search);
       search.setColumns(10);
    
       JLabel l3=new JLabel("Back");
       l3.addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(MouseEvent ae)
           {
               setVisible(false);
           }
       });
       l3.setForeground(Color.GRAY);
       l3.setFont(new Font("serif",Font.BOLD,18));
       l3.setBounds(100,90,70,30);
       p.add(l3);
       
       
       JPanel p2=new JPanel();
       p2.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY,3,true),"EXAM DETAILS",TitledBorder.LEADING,TitledBorder.TOP,null,Color.DARK_GRAY));
       p2.setBounds(50,50,1000,450);
       p.add(p2);
//       Book();
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try{
            conn c1=new conn();
            if(ae.getSource()==b1)
            {
             new Marks(search.getText()).setVisible(true);
             this.setVisible(false);
            }
        }
        catch(Exception e){}
    }
    public static void main(String args[])
    {
        
        new ExaminationDetail().setVisible(true);
      
    }
}
