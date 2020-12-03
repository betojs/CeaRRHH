/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

        
        public class limpiar {
            
            public void limpiarCampos(JPanel jPanel1){
         
     
                
        for (int i=0; jPanel1.getComponents().length > i ; i++){
            
           //LIMPIA TODOS LOS JTEXTFIELD DE UN PANEL
            if(jPanel1.getComponents()[i]instanceof JTextField){
            
            ((JTextField)jPanel1.getComponents()[i]).setText("");
            }
            
            
             if(jPanel1.getComponents()[i] instanceof JPasswordField){
            
            ((JPasswordField)jPanel1.getComponents()[i]).setText("");
            }
            
            
             if(jPanel1.getComponents()[i] instanceof JComboBox){
            
            ((JComboBox)jPanel1.getComponents()[i]).setSelectedItem("");
            }
            
            
            
             if(jPanel1.getComponents()[i] instanceof JTextArea){
            
            ((JTextArea)jPanel1.getComponents()[i]).setText("");
            }
        }
            
    }

}
