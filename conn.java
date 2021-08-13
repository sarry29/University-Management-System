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
public class conn {
    Connection c;
    Statement s;
    public conn()
    {
     
        try{
            Class.forName("com.mysql.jdbc.Driver");
//            c=DriverManager.getConnection("jdbc:mysql:///sms","root","");   
            c=DriverManager.getConnection("jdbc:mysql:///sms?autoReconnect=true&useSSL=false","root","");//databse user password
           s=c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Exception occur is "+e);
        }
    }
}
