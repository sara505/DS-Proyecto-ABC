/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Sara Eraso
 */
public class sqlConnection {
    
    Connection conn = null;
    String url ="jdbc:postgresql://ec2-34-231-177-125.compute-1.amazonaws.com/d5g5o5nng6dbia";
    String user = "pgtmwskyyffgmz";
    String password = "a41f41a5859d69da7233e41084dc023cfb4852f596b03499a0f127f833b46e09";
    
    public Connection connect(){
    
        try {
            Class.forName("org.postgresql.Driver"); //inicializar el driver sql
            conn=DriverManager.getConnection(url,user,password);
            if(conn != null){
                System.out.println("conexión realizada correctamente");
            }
            
        } catch (Exception e) {     
            JOptionPane.showMessageDialog(null, "Connection error "+e, "Error", JOptionPane.ERROR_MESSAGE);  
        }
        return conn;
    }  
}
