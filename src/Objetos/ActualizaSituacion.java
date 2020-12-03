/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ELI
 */
public class ActualizaSituacion {
    
    
    
Conectar cc=new Conectar();
Connection cn = cc.conexion();
    public void Actualiza(){
    String diaActual="";
Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
       diaActual=(date.format(now));    
    
    
       try{for(int i=0;i<10000;i++){
                    Statement st = cn.createStatement();
                    
                    ResultSet rs = st.executeQuery("SELECT * FROM situacion WHERE id_sit='"+i+"'");

                    String fechafin="";

                    while(rs.next()){
                        fechafin=rs.getString(7);
                    }
                    if(fechafin.equals(diaActual)){
                    String estatus="Activo";
                    try {

            PreparedStatement pst = cn.prepareStatement("UPDATE situacion SET status='"+estatus
                

                //en elregistro enque se va a guardar!
                +"' WHERE id_sit='"+i+"'");
            pst.executeUpdate();
            //Mostrar los datos actualizados!!
           

            if( cn==null){
                }
            else{
           }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e.getMessage());
            // Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
                    }
                    
                    
                    System.out.println(fechafin);
                    

       }}catch(Exception e){

                    System.out.println("auditoria"+e);
                }
       
       
       
    
    }
    
}
