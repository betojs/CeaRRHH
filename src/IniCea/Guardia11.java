/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IniCea;

import G14.IniG14;
import G18.IniG18;
import G19.IniG19;
import G7.IniG7;
import Objetos.Conectar;
import Objetos.IniciarReporte;
import Objetos.fondo;
import ceaa.ingres;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.collections.map.HashedMap;




/**
 *
 * @author Familia
 */
public class Guardia11 extends javax.swing.JFrame {
    
    Conectar cc=new Conectar();
Connection cn = cc.conexion();

    /**
     * Creates new form IniCea
     */


    JDialog viewer = new JDialog(new JFrame(),"reporte",true);
    
    
    public Guardia11() {
        initComponents();
        
         this.setResizable(false);
       fondo imagen =new fondo();
       String imagenes=imagen.fond();
        
        ((JPanel)getContentPane()).setOpaque(false);
            ImageIcon uno=new ImageIcon(this.getClass().getResource(imagenes));
          JLabel fondo= new JLabel(); 
          fondo.setIcon(uno);
          getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
          fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());

         this.setSize(900,700);
        
         Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
       this.jLabel9.setText(date.format(now));
        this.jLabel10.setText(hour.format(now));
         
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM variable WHERE id='1'");
            
            String usu="";
            
            while(rs.next()){
             usu=rs.getString(2);
            }
            JLnombreUSU.setText(usu);
          
            
            
            
        }catch(Exception e){
        
        System.out.println("auditoria"+e);
        }
        
         DatosOfi_Sup_Op();
         DatosOfi_Sup_vu_sucr();
         DatosOfi_Sup_vu_libr();
         DatosOfiDia();
         DatosInsG7();
         DatosInsG14();
         DatosInsG18();
         DatosInsG19();
         DatosHang3();
         
         DatosHang4();
         DatosHang5();
         //Nocturno...............!!!!!!
         
         DatosNoc_Hang1_1();
         DatosNoc_Hang1_2();
         DatosNoc_Hang1_3();
         DatosNoc_Hang4_1();
         DatosNoc_Hang4_2();
         DatosNoc_Hang4_3();
         DatosNoc_Hang5_1();
         DatosNoc_Hang5_2();
         DatosNoc_Hang5_3();
         DatosNoc_CentO_1();
         DatosNoc_CentO_2();
         DatosNoc_CentO_3();
         DatosNoc_CentE_1();
         DatosNoc_CentE_2();
         DatosNoc_CentE_3();
         
         
         
         
         
         
    }

    
    
    
    
    void DatosOfi_Sup_Op(){
    
    String sql="Select * from personal";
    CMB_OFI_SUP_OP.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    
    
    if(rango.equals("CAP")){
    CMB_OFI_SUP_OP.addItem(rango+". "+ape+" "+nombre);
    }
    }
    
    }catch(Exception e){}
    
    
    
    }
    
    void DatosOfi_Sup_vu_sucr(){
    
    String sql="Select * from personal";
    CMB_OFI_SUP_VU_SUCR.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    
    CMB_OFI_SUP_VU_SUCR.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
    void DatosOfi_Sup_vu_libr(){
    
    String sql="Select * from personal";
    CMB_OFI_SUP_VU_LIBER.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_OFI_SUP_VU_LIBER.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
   
    void DatosOfiDia(){
    
    String sql="Select * from personal";
    CMB_OFIDIA.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_OFIDIA.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
   
    void DatosInsG7(){
    
    String sql="Select * from personal";
    CMB_INSG7.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_INSG7.addItem(rango+". "+ape+" "+nombre);
    
    }
   
    
    }catch(Exception e){}
    
    
    
    }
    
    void DatosInsG14(){
    
    String sql="Select * from personal";
    CMB_INSPG14.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_INSPG14.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
    void DatosInsG18(){
    
    String sql="Select * from personal";
    CMB_INSPG18.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_INSPG18.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
    void DatosInsG19(){
    
    String sql="Select * from personal";
    CMB_INSPG19.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_INSPG19.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
    void DatosHang3(){
    
    String sql="Select * from personal";
    CMB_HANG3.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_HANG3.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
    void DatosHang4(){
    
    String sql="Select * from personal";
    CMB_HANG4.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_HANG4.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
    void DatosHang5(){
    
    String sql="Select * from personal";
    CMB_HANG5.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_HANG5.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
    
   // Nocturnos
    
    void DatosNoc_Hang1_1(){
    
    String sql="Select * from personal";
    CMB_NOC_HANG3_1.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_NOC_HANG3_1.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
     void DatosNoc_Hang1_2(){
    
    String sql="Select * from personal";
    CMB_NOC_HANG3_2.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_NOC_HANG3_2.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
     void DatosNoc_Hang1_3(){
    
    String sql="Select * from personal";
    CMB_NOC_HANG3_3.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_NOC_HANG3_3.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
     void DatosNoc_Hang4_1(){
    
    String sql="Select * from personal";
    CMB_NOC_HANG4_1.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_NOC_HANG4_1.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
    void DatosNoc_Hang4_2(){
    
    String sql="Select * from personal";
    CMB_NOC_HANG4_2.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_NOC_HANG4_2.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
    void DatosNoc_Hang4_3(){
    
    String sql="Select * from personal";
    CMB_NOC_HANG4_3.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_NOC_HANG4_3.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
    
   void DatosNoc_Hang5_1(){
    
    String sql="Select * from personal";
    CMB_NOC_HANG5_1.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_NOC_HANG5_1.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
     
   void DatosNoc_Hang5_2(){
    
    String sql="Select * from personal";
    CMB_NOC_HANG5_2.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_NOC_HANG5_2.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
   
   void DatosNoc_Hang5_3(){
    
    String sql="Select * from personal";
    CMB_NOC_HANG5_3.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_NOC_HANG5_3.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
   
   void DatosNoc_CentO_1(){
    
    String sql="Select * from personal";
    CMB_CENTIO_1.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_CENTIO_1.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
  
   void DatosNoc_CentO_2(){
    
    String sql="Select * from personal";
    CMB_CENTIO_2.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_CENTIO_2.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
   
   void DatosNoc_CentO_3(){
    
    String sql="Select * from personal";
    CMB_CENTIO_3.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_CENTIO_3.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
   
   void DatosNoc_CentE_1(){
    
    String sql="Select * from personal";
    CMB_CENTIE_1.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_CENTIE_1.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
   
    void DatosNoc_CentE_2(){
    
    String sql="Select * from personal";
    CMB_CENTIE_2.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_CENTIE_2.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
   
    void DatosNoc_CentE_3(){
    
    String sql="Select * from personal";
    CMB_CENTIE_3.addItem("");
    try{
    
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    String rango, nombre, ape;
    while (rs.next()){
    
    rango=rs.getString("grado");
    nombre=rs.getString("nom_per");
    ape=rs.getString("ape_per");
    CMB_CENTIE_3.addItem(rango+". "+ape+" "+nombre);
    
    }
    
    }catch(Exception e){}
    
    
    
    }
   
   
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Centr = new javax.swing.JLabel();
        CEA = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        JLnombreUSU = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        CMB_OFI_SUP_OP = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        CMB_OFI_SUP_VU_SUCR = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        CMB_OFI_SUP_VU_LIBER = new javax.swing.JComboBox();
        CMB_INSG7 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CMB_HANG4 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        CMB_HANG3 = new javax.swing.JComboBox();
        CMB_INSPG19 = new javax.swing.JComboBox();
        CMB_INSPG18 = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        CMB_INSPG14 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        CMB_HANG5 = new javax.swing.JComboBox();
        CMB_OFIDIA = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        CMB_NOC_HANG3_3 = new javax.swing.JComboBox();
        CMB_NOC_HANG3_2 = new javax.swing.JComboBox();
        CMB_NOC_HANG3_1 = new javax.swing.JComboBox();
        CMB_NOC_HANG4_2 = new javax.swing.JComboBox();
        CMB_NOC_HANG4_1 = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        CMB_NOC_HANG4_3 = new javax.swing.JComboBox();
        CMB_CENTIO_2 = new javax.swing.JComboBox();
        CMB_CENTIO_1 = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        CMB_CENTIO_3 = new javax.swing.JComboBox();
        CMB_CENTIE_2 = new javax.swing.JComboBox();
        CMB_CENTIE_1 = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        CMB_CENTIE_3 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        CMB_NOC_HANG5_2 = new javax.swing.JComboBox();
        CMB_NOC_HANG5_1 = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        CMB_NOC_HANG5_3 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        JtextPensamient = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Sin título-1.png"))); // NOI18N

        Centr.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        Centr.setText("Centro de Entrenamiento Aéreo");

        CEA.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        CEA.setText("C.E.A.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(CEA))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Centr)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(CEA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Centr))
                    .addComponent(jLabel1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel3.setText("Rol de Guardia");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setOpaque(false);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        jLabel12.setText("Bienvenido:");

        jLabel9.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel9.setText("jLabel7");

        jLabel10.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel10.setText("jLabel8");

        jLabel18.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel18.setText("Fecha:");

        jLabel29.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel29.setText("Hora:");

        JLnombreUSU.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLnombreUSU.setText("jLabel8");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLnombreUSU)))
                .addGap(31, 31, 31)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel29)
                                .addComponent(jLabel18)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(JLnombreUSU)))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel13.setText("OFICIAL SUPERVISOR DE VUELO BASE SUCRE:");

        jLabel17.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel15.setText("OFICIAL DE DÍA DEL CEA:");

        jLabel4.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel4.setText("Fecha");

        jLabel14.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel14.setText("INSPECCION G7:");

        jLabel5.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel5.setText("OFICIAL SUPERVISOR DE OPERACIONES AEREAS:");

        jLabel19.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel19.setText("INSPECCION G18:");

        jLabel22.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel22.setText("GUARDIA HANGAR 5:");

        jLabel20.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel20.setText("GUARDIA HANGAR 4:");

        jLabel21.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel21.setText("GUARDIA HANGAR 3:");

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel2.setText("C.- Servicio Diurno para el Dia");

        jLabel16.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel16.setText("OFICIAL SUPERVISOR DE VUELO BASE LIBERTADOR:");

        CMB_INSPG14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMB_INSPG14ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel6.setText("INSPECCION G14:");

        jLabel23.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel23.setText("INSPECCION G19:");

        jLabel24.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel24.setText("Servicio Nocturno");

        jLabel25.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel25.setText("GUARDIA HANGAR 3:");

        jLabel26.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel26.setText("GUARDIA HANGAR 4:");

        jLabel27.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel27.setText("Centinela Oste");

        jLabel28.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel28.setText("Centinela Este");

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel30.setText("GUARDIA HANGAR 5:");

        jLabel11.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel11.setText("A.-Situacion:");

        jLabel31.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel31.setText("B.-Transcripciones:");

        jLabel32.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel32.setText("PENSAMIENTO DEL COMANDANTE SUPREMO:");

        jLabel33.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel33.setText("REGLAMENTO DE CASTIGO DISCIPLINARIO:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(140, 140, 140))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14)
                            .addComponent(jLabel6)
                            .addComponent(jLabel19)
                            .addComponent(jLabel23)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel24)
                                .addComponent(jLabel15))
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(CMB_OFI_SUP_OP, 0, 174, Short.MAX_VALUE)
                                                                .addComponent(CMB_OFI_SUP_VU_SUCR, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(CMB_HANG5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addComponent(CMB_OFI_SUP_VU_LIBER, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(CMB_OFIDIA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(CMB_INSG7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(CMB_INSPG14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(CMB_INSPG18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(CMB_INSPG19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CMB_HANG3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(CMB_HANG4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CMB_NOC_HANG3_3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25)
                            .addComponent(CMB_NOC_HANG3_1, 0, 174, Short.MAX_VALUE)
                            .addComponent(CMB_NOC_HANG3_2, 0, 174, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CMB_NOC_HANG4_3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26)
                            .addComponent(CMB_NOC_HANG4_1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CMB_NOC_HANG4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CMB_NOC_HANG5_3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30)
                            .addComponent(CMB_NOC_HANG5_1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CMB_NOC_HANG5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CMB_CENTIO_3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27)
                            .addComponent(CMB_CENTIO_1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CMB_CENTIO_2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CMB_CENTIE_3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28)
                            .addComponent(CMB_CENTIE_1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CMB_CENTIE_2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel32))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JtextPensamient, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addGap(4, 4, 4)
                .addComponent(JtextPensamient, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CMB_OFI_SUP_OP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(CMB_OFI_SUP_VU_SUCR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(CMB_OFI_SUP_VU_LIBER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(CMB_OFIDIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(CMB_INSG7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CMB_INSPG14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(CMB_INSPG18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(CMB_INSPG19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(CMB_HANG3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(CMB_HANG4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(CMB_HANG5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_NOC_HANG3_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_NOC_HANG3_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_NOC_HANG3_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_NOC_HANG4_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_NOC_HANG4_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_NOC_HANG4_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_NOC_HANG5_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_NOC_HANG5_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_NOC_HANG5_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_CENTIO_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_CENTIO_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_CENTIO_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_CENTIE_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_CENTIE_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMB_CENTIE_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jScrollPane3.setViewportView(jPanel3);

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel19.setOpaque(false);

        jButton52.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton52.setText("Personal");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jButton53.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton53.setText("Guardias");
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        jButton54.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton54.setText("Actualizacion de Datos");
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jButton56.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton56.setText("Inicio ");
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        jButton57.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton57.setText("Formatos");
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        jButton58.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton58.setText("Parte");
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton57)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(719, 719, 719))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(885, 885, 885)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(253, 253, 253)
                                .addComponent(jLabel7))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addGap(639, 639, 639)
                .addComponent(jLabel7)
                .addGap(324, 324, 324))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:

        
        dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void CMB_INSPG14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMB_INSPG14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CMB_INSPG14ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        // TODO add your handling code here:

        Personal ir = new Personal();
        ir.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        // TODO add your handling code here:

        Guardia11 ir = new Guardia11();
        ir.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        // TODO add your handling code here:
        Situacion ir = new Situacion();
        ir.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        // TODO add your handling code here:
        IniCea ir = new IniCea();
        ir.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        // TODO add your handling code here:

        Formatos ir = new Formatos();
        ir.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        // TODO add your handling code here:

        Parte ir= new Parte();
        ir.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try{JasperReport reporte = JasperCompileManager.compileReport("C:\\Users\\ELI\\Documents\\MEGA\\proyecto 2015\\Cea 1.0.0\\ceaa\\src\\Reportes\\report1.jrxml");
        JasperPrint jaserPrint = JasperFillManager.fillReport(reporte, null,cn);
        
        
        viewer.setSize(1000,700);
        viewer.setLocationRelativeTo(null);
            JRViewer jrv= new JRViewer(jaserPrint);
            viewer.getContentPane().add(jrv);
            viewer.setVisible(true);
        
        }catch(JRException ex){
        Logger.getLogger(Guardia11.class.getName()).log(Level.SEVERE,null,ex);
        
        }
        
        
          /* List lista = new ArrayList();
   
   
        try {
            JasperReport reporte =(JasperReport) JRLoader.loadObject("\\src\\reportes\\reportGuardia.Jasper");
            Map parametro=new HashedMap();
            parametro.put("dato", JtextPensamient.getText());
            JasperPrint jprint= JasperFillManager.fillReport(reporte, parametro,new JRBeanCollectionDataSource(lista));
            JasperViewer.viewReport(jprint);
// TODO add your handling code here:
        } catch (JRException ex) {
            Logger.getLogger(Guardia11.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        /*
        
                try{
            String archivo = System.getProperty ("user.dir")+"\\src\\reportes\\reportGuardia.jasper";
            System.out.println("Cargando desde: " + archivo);
            if(archivo == null){
                JOptionPane.showMessageDialog(null,"Error al generar reporte, verifique impresoran", "Generar Reporte",JOptionPane.ERROR_MESSAGE);
            } JasperReport masterReport= null;
            try {
                masterReport= (JasperReport) JRLoader.loadObject(archivo);
            } catch (JRException e) {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                JOptionPane.showMessageDialog(null,"Error al generar reporte, verifique impresoran","Generar Reporte",JOptionPane.ERROR_MESSAGE);
            }
            Map parametro= new HashMap();
            parametro.put("dato",JtextPensamient.getText());
            
            JasperPrint jasperPrint= JasperFillManager.fillReport(masterReport,parametro,cn);
            
            JasperViewer jviewer= new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Titulo de mi Reporte");
            jviewer.setVisible(true);
        }catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
        */
        
        
        
        /* CODIGO DE RICARDO
        String dir="C:\\Users\\ELI\\Documents\\MEGA\\proyecto 2015\\Cea 1.0.0\\ceaa\\src\\Reportes\\reportGuardia.jasper";
        try {
            System.out.println("Holaaa");
            JasperReport reporte = (JasperReport)JRLoader.loadObjectFromFile(dir);
            JasperPrint print = JasperFillManager.fillReport(reporte,null,cn);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (JRException ex) {
            System.out.println("Chaoo"+ ex);
            Logger.getLogger(Guardia11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Guardia11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Guardia11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Guardia11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Guardia11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Guardia11().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CEA;
    private javax.swing.JComboBox CMB_CENTIE_1;
    private javax.swing.JComboBox CMB_CENTIE_2;
    private javax.swing.JComboBox CMB_CENTIE_3;
    private javax.swing.JComboBox CMB_CENTIO_1;
    private javax.swing.JComboBox CMB_CENTIO_2;
    private javax.swing.JComboBox CMB_CENTIO_3;
    private javax.swing.JComboBox CMB_HANG3;
    private javax.swing.JComboBox CMB_HANG4;
    private javax.swing.JComboBox CMB_HANG5;
    private javax.swing.JComboBox CMB_INSG7;
    private javax.swing.JComboBox CMB_INSPG14;
    private javax.swing.JComboBox CMB_INSPG18;
    private javax.swing.JComboBox CMB_INSPG19;
    private javax.swing.JComboBox CMB_NOC_HANG3_1;
    private javax.swing.JComboBox CMB_NOC_HANG3_2;
    private javax.swing.JComboBox CMB_NOC_HANG3_3;
    private javax.swing.JComboBox CMB_NOC_HANG4_1;
    private javax.swing.JComboBox CMB_NOC_HANG4_2;
    private javax.swing.JComboBox CMB_NOC_HANG4_3;
    private javax.swing.JComboBox CMB_NOC_HANG5_1;
    private javax.swing.JComboBox CMB_NOC_HANG5_2;
    private javax.swing.JComboBox CMB_NOC_HANG5_3;
    private javax.swing.JComboBox CMB_OFIDIA;
    private javax.swing.JComboBox CMB_OFI_SUP_OP;
    private javax.swing.JComboBox CMB_OFI_SUP_VU_LIBER;
    private javax.swing.JComboBox CMB_OFI_SUP_VU_SUCR;
    private javax.swing.JLabel Centr;
    private javax.swing.JLabel JLnombreUSU;
    private javax.swing.JTextField JtextPensamient;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
