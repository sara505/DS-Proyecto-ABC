 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import getset.SubsidiaryVariables;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Sara Eraso
 */
public class SubsidiaryCrud extends sqlConnection{
    
    java.sql.Statement st;
    ResultSet rs;
    SubsidiaryVariables var = new SubsidiaryVariables();
   
    
    public void create(int id,String name,String direction, LocalDate foundation ){
        
        Date date = Date.from(foundation.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Timestamp ts = new Timestamp(date.getTime());
    
        try{
            Connection connect = connect(); //Conexión directa a la base de datos
            st = connect.createStatement(); // crea un objeto para poder ejecutar sentencias SQL
            String sql = "INSERT INTO prueba_sedes(id_subsidiary,name,address,founded_date) VALUES('"+id+"','"+name+"','"+direction+"','"+ts+"')";
            st.execute(sql); //ejecutar el sql
            st.close(); //Cerrar ejecución
            connect.close(); //Cierra la conexión
            JOptionPane.showMessageDialog(null, "nice!", "Message",JOptionPane.INFORMATION_MESSAGE);
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR PARC", "Message"+e,JOptionPane.ERROR_MESSAGE);
        }
    }
    public SubsidiaryVariables read(int id) {
   
        try{
                Connection connect= connect();
                st= connect.createStatement();
                String sql = "SELECT * FROM prueba_sedes WHERE id_subsidiary='"+id+"'";
                rs=st.executeQuery(sql);

                if(rs.next()){
                   
                   System.out.println("dato encontrado"); 
                   var.setId_sede(Integer.parseInt(rs.getString("id_subsidiary")));
                   var.setNombre_sede(rs.getString("name"));                   
                   var.setDireccion_sede(rs.getString("address"));
                   var.setFechaFundacion_sede(rs.getTimestamp("founded_date").toLocalDateTime().toLocalDate());
                }else{
                    //en caso de no encontrar información en la BD
                   var.setId_sede(rs.getInt(""));
                   var.setNombre_sede("");
                   var.setDireccion_sede(rs.getString(""));
                   var.setFechaFundacion_sede(rs.getTimestamp("").toLocalDateTime().toLocalDate());
                   
                   
                   JOptionPane.showMessageDialog(null, "No existe el registro","sin registro",JOptionPane.INFORMATION_MESSAGE);
                   st.close();
                   connect.close();
                }
                st.close();
                connect.close();
            }catch(Exception e){
                var.setId_sede(-1);
                JOptionPane.showMessageDialog(null, "ERROR AL LEER", "Message"+e,JOptionPane.ERROR_MESSAGE);
                
            }
        return var;
       }
   public void update(int id,String name,String direction, LocalDate foundation){
   
    Date date = Date.from(foundation.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    Timestamp ts = new Timestamp(date.getTime());
    try{
        Connection connect=connect();
        st = connect.createStatement();
        String sql = "UPDATE prueba_sedes SET id_subsidiary = '"+id+"', name = '"+name+"', address = '"+direction+"', founded_date = '"+ts+"' WHERE id_subsidiary = '"+id+"'";
        st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Se ha actualizado el registro con éxito", "sin registro", JOptionPane.INFORMATION_MESSAGE);
        
        st.close();
        connect.close();


    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR", "Message"+e,JOptionPane.ERROR_MESSAGE);
    }
   }
     
}
