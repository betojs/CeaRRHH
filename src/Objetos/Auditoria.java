/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ELI
 */
public class Auditoria {
    Conectar cc=new Conectar();
Connection cn = cc.conexion();
    
     public void auditoria(String usu , String accion, String campo){
    
    String idus="";
    
    String usuario="";
    
    try{
  
        Statement s = cn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM usuario WHERE usu_us='"+usu+"'");
    
         while (rs.next()){
        idus=rs.getString("id_us");
        usuario=rs.getString("usu_us");
            System.out.println(idus);
         }
        PreparedStatement pst= cn.prepareStatement("INSERT INTO auditoria (id_us,usu_us,acc_aud,camp_aud,fecc_aud,hora_aud)VALUE(?,?,?,?,?,?)");
        pst.setString(1, idus);
        pst.setString(2, usuario);
        pst.setString(3, accion);
        
        pst.setString(4, campo);
        
        
      
         Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
     
        pst.setString(5, date.format(now) );
        pst.setString(6, hour.format(now));
    
        
         pst.executeUpdate();
    
    }catch(SQLException | HeadlessException e){
        System.out.println("Error Sql   "+e);
    
    
    }
    
    
    /* Codigo para el boton!!!
    
    try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM variable WHERE id='1'");
            
            String usu="";
            
            while(rs.next()){
             usu=rs.getString(2);
            }
            
          
            String accion="Registro Nuevo Usuario";
            System.out.println(usu);
            auditar.auditoria(usu, accion, JTUs.getText() );
            
            
        }catch(Exception e){
        
        System.out.println("auditoria"+e);
        }
    
    */
    
    
    
    
    }
    
    
    
    
}
