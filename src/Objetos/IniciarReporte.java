/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer.*;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;


/**
 *
 * @author ELI
 */

public class IniciarReporte {
    
    Connection conn;
    
Conectar cc=new Conectar();
Connection cn = cc.conexion();
 
    public void MiConsultaN(){
        try{
            String archivo = System.getProperty ("user.dir")+"\\src\\Reportes\\reportGuardia.jasper";
            System.out.println("Cargando desde: " + archivo);
            if(archivo == null){
                JOptionPane.showMessageDialog(null,"Error al generar reporte, verifique impresora\n", "Generar Reporte",JOptionPane.ERROR_MESSAGE);
            } JasperReport masterReport= null;
            try {
                masterReport= (JasperReport) JRLoader.loadObject(archivo);
            } catch (JRException e) {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                JOptionPane.showMessageDialog(null,"Error al generar reporte, verifique impresora\n","Generar Reporte",JOptionPane.ERROR_MESSAGE);
            }
            JasperPrint jasperPrint= JasperFillManager.fillReport(masterReport,null,conn);
            JasperViewer jviewer= new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Titulo de mi Reporte");
            jviewer.setVisible(true);
        }catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
    }

    public void MiConsultaN(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
