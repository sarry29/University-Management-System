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
 
public class Splash {
    
    public static void main(String args[])
    {
//        1920x1080 
        Frame f=new Frame();//making obj of frame ckass
        f.setVisible(true);
        int i;
        int x=1;
        for(i= 2;i<=600;i+=4,x+=1)
        {
            f.setLocation((500-((i+x)/2)),300-(i)/2);
            f.setSize(i+3*x,i+x/2);
            
            //multithreading use fot delay in frame
            try
            {
                Thread.sleep(10);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }//loop
    }//main
}//class

//frame which  inherit swing frame and for threading using runnable
class Frame extends JFrame  implements Runnable{
     Thread t1;//reference
    
    Frame()
    {
        super("UNIVERSITY MANAGEMENT SYSTEM");//heading of frame
        setLayout(new FlowLayout());
        ImageIcon c1=new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/first.jpg"));
        Image i1=c1.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT); //1000X700 size
        ImageIcon i2=new ImageIcon(i1);

//        ImageIcon imageIcon = new ImageIcon("icons/first.jpg"); // load the image to a imageIcon
//        Image image = imageIcon.getImage(); // transform it 
//        Image newimg = image.getScaledInstance(1000, 550,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//        ImageIcon i2= new ImageIcon(newimg);  // transform it back  

        JLabel m1=new JLabel(i2);
        add(m1);
        setContentPane(m1);
        
        JLabel s1=new JLabel("U N I V E R S I T Y");
        s1.setBounds(10,20,300,40);
        s1.setFont(new Font("serif",Font.BOLD,35));
        s1.setForeground(Color.WHITE);
        add(s1);
                
        JLabel m=new JLabel("M A N A G E M E N T");
        m.setFont(new Font("serif",Font.BOLD,35));        
        m.setBounds(10,70,500,40);
        m.setForeground(Color.WHITE);
        add(m); 
        
        JLabel s2=new JLabel("S Y S T E M");
        s2.setFont(new Font("serif",Font.BOLD,35));
        s2.setBounds(10,120,300,40);
        s2.setForeground(Color.WHITE);
        add(s2);
        
        t1=new Thread(this);//obj thread create
        t1.start();
    }
    public void run()
    {
       try
       {   
           Thread.sleep(7000);
           this.setVisible(false);
           new Login().setVisible(true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }//catch
       
    }//run
}//class frame
