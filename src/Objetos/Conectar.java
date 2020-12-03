/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Familia
 */
public class Conectar {
    Connection Conectar=null;
    
    public Connection conexion(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Conectar=DriverManager.getConnection("jdbc:mysql://localhost/cea", "root", "");
    
    }catch(Exception e){
    JOptionPane.showMessageDialog(null,"error en coneccion con Base de Datos");
        System.out.println(e.getMessage());
    
    }
    return Conectar;
    }
    

    
    
      /*  try{
    Class.forName("org.gjt.mm.mysql.Driver");
    Conectar=DriverManager.getConnection("jdbc:mysql://localhost/usuarios", "root", null);
    
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"error"+ e);
        System.out.println(e.getMessage());
    
    }*/
    
    
}
