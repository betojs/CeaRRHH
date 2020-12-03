/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G14;

import IniCea.*;
import G14.IniG14;
import G18.IniG18;
import G19.IniG19;
import G7.IniG7;
import Objetos.Auditoria;
import Objetos.Conectar;
import Objetos.fondo;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Objetos.limpiar;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Familia
 */
public class RegistrosG14 extends javax.swing.JFrame {

    /**
     * Creates new form IniCea
     */
    
    

         
    public RegistrosG14() {

        
        
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

 //        this.setSize(900,700);
        

 
  Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
       this.jLabel32.setText(date.format(now));
        this.jLabel33.setText(hour.format(now));
         
         datos();
         
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
          
      

         //Grupo de botnos
        GrupBtnAlergia.add(RBtnSi);
        GrupBtnAlergia.add(RBtnNo);
        TxtAAlergia.setEnabled(false);
        
TXAREOBSERVarm.setEnabled(false);

            BTNpregunta.setVisible(false);
        
        
       jPanel7.setVisible(false);
       
       
                                            //POP MENU DE MODIFICAR
                                            Modi.setVisible(false);
                                            ModiProm.setVisible(false);
                                            ModiArm.setVisible(false);
                                            ModiFami.setVisible(false);
                                            
                                                //Botones Modificar
                                                ModificarArma.setVisible(false);
                                                ModificarFami.setVisible(false);
                                                ModificarPromo.setVisible(false);
                                                ModificarPerso.setVisible(false);
                                                    //Botones Buscar
                                                    BuscarFami.setVisible(false);
                                                    BuscarPer.setVisible(false);
                                                    Buscararma.setVisible(false);
                                                    BuscarPromo.setVisible(false);
                                                
    }

        
      void mostrarPers(String valor){
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("cedula");
    model.addColumn("nombre");
    model.addColumn("apellido");
    model.addColumn("Serial del Carnet");
    model.addColumn("sexo");
    model.addColumn("alergias");
    model.addColumn("grupo sanguineos");
    model.addColumn("Unidad");
    model.addColumn("Grado");
    model.addColumn("Categoria");
    model.addColumn("Componente");
    model.addColumn("fecha de nacimiento");
    model.addColumn("estado civil");
    model.addColumn("serial de armamento");
    model.addColumn("fecha de ingreso al sistema");
    model.addColumn("telefono celular");
    model.addColumn("telefono otro ");
    model.addColumn("telefono de casa");
    model.addColumn("telefono de trabajo");
    model.addColumn("correo");
    model.addColumn("direccion ");
    model.addColumn("centro de votacion");
    model.addColumn("ubicacion del centro de votacion");
    
    TBperson.setModel(model);
    String sql="";
    String uni="G14";
    
    if(valor.equals("")){
        
            
     sql="SELECT * FROM personal WHERE unidad='"+uni+"'";
    
    }
    else{
    sql="SELECT * FROM personal WHERE ced_per='"+valor+"' && WHERE  unidad='"+uni+"'";
    
    }
        
    String []dato = new String[23];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            dato[0]=rs.getString(1);
            dato[1]=rs.getString(2);
            dato[2]=rs.getString(3); 
            dato[3]=rs.getString(4);
            dato[4]=rs.getString(5); 
            dato[5]=rs.getString(6);
            dato[6]=rs.getString(7);
            dato[7]=rs.getString(8);
            dato[8]=rs.getString(9);
            dato[9]=rs.getString(10);
            dato[10]=rs.getString(11);
            dato[11]=rs.getString(12);
            dato[12]=rs.getString(13);
            dato[13]=rs.getString(16);
            dato[14]=rs.getString(17);
            dato[15]=rs.getString(18);
            dato[16]=rs.getString(19);
            dato[17]=rs.getString(20);
            dato[18]=rs.getString(21);
            dato[19]=rs.getString(22);
            dato[20]=rs.getString(23);
            dato[21]=rs.getString(24);
            dato[22]=rs.getString(25);
            model.addRow(dato);
            }
            TBperson.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex+"  es aca");
           
        }



}
    
      
      
      
      void mostrarPromo(String valor){
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("id_prom");
    model.addColumn("nombre promo");
    model.addColumn("año promo");
    
    model.addColumn("escuela de promocion");
    model.addColumn("especialidad");
    model.addColumn("mencion");
    TBperson.setModel(model);
    String sql="";
    if(valor.equals("")){
    
    sql="SELECT * FROM promocion"; 
    
    }
    else{
    sql="SELECT * FROM promocion WHERE id_prom='"+valor+"'";
    
    }
        
    String []dato = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            dato[0]=rs.getString(1);
            dato[1]=rs.getString(2);
            dato[2]=rs.getString(3); 
            dato[3]=rs.getString(4);
            dato[4]=rs.getString(5); 
            dato[5]=rs.getString(6);  
               
            model.addRow(dato);
            }
            TBperson.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex+"  es aca");
           
        }



}
      
      
      void mostrararma (String valor){
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ser_armp");
    model.addColumn("tipo arma");
    model.addColumn("ubicacion");
    
    model.addColumn("observacion");
    model.addColumn("Status");
    TBperson.setModel(model);
    String sql="";
    if(valor.equals("")){
    
    sql="SELECT * FROM armamentop"; 
    
    }
    else{
    sql="SELECT * FROM armamentop WHERE ser_armp='"+valor+"'";
    
    }
        
    String []dato = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            dato[0]=rs.getString(1);
            dato[1]=rs.getString(2);
            dato[2]=rs.getString(3); 
            dato[3]=rs.getString(4);
            dato[4]=rs.getString(5);
            
               
            model.addRow(dato);
            }
            TBperson.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex+"  es aca");
           
        }



}
    
      
       void mostrarFamilia(String valor){
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Cedula");
    model.addColumn("Cedula personal");
    model.addColumn("Serial de Carne");
    model.addColumn("Nombre");
    model.addColumn("Apellido");
      
    model.addColumn("Parentezco");
    model.addColumn("Tlf");
    model.addColumn("Direccion");
    TBperson.setModel(model);
    String sql="";
    if(valor.equals("")){
    
    sql="SELECT * FROM familiares"; 
    
    }
    else{
    sql="SELECT * FROM familiares WHERE ced_per='"+valor+"'";
    
    }
        
    String []dato = new String[8];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            dato[0]=rs.getString(1);
            dato[1]=rs.getString(2);
            dato[2]=rs.getString(3); 
            dato[3]=rs.getString(4);
            dato[4]=rs.getString(5);
            dato[5]=rs.getString(6);
            dato[6]=rs.getString(7);
            dato[7]=rs.getString(8);    
            model.addRow(dato);
            }
            TBperson.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex+"  es aca");
           
        }



}
    
      
      
    
    
    public void datos(){
    //Estado Civil
    CMBEstado.addItem("");
    CMBEstado.addItem("Casado/a");
    CMBEstado.addItem("Soltero/a");
    CMBEstado.addItem("Divorciado/a");
    CMBEstado.addItem("Viudo/a");
    //Sexo
    CMBsexo.addItem("");
    CMBsexo.addItem("Masculino");
    CMBsexo.addItem("Femenino");
    //Componente
    CMBComponent.addItem("");
    CMBComponent.addItem("Ejercito(EJB)");
    CMBComponent.addItem("Armada(ARB)");
    CMBComponent.addItem("Aviacion(AVB");
    CMBComponent.addItem("Guardia(GNB)");
    
    //Categoria   ----, Comando, Tecnico, Asimilado, Tropa Profecional
    CMBtipo.addItem("");
    CMBtipo.addItem("Comando");
    CMBtipo.addItem("Tecnico");
    CMBtipo.addItem("Asimilado");
    CMBtipo.addItem("Tropa Profecional");
    //Rango

    //UNIDAD
  
    
    CMBunidad.addItem("G14");
   
    
    //parentezco
    CMBPAREN.addItem("");
    CMBPAREN.addItem("Padre");
    CMBPAREN.addItem("Madre");
    CMBPAREN.addItem("Esposo/a");
    CMBPAREN.addItem("Hijo/a");
    
    //AÑO ´PROMO
    
    CMBaño_pro.addItem(""); 
    for(int i=1984;i<2031;i++){
        
        String dato=String.valueOf(i);
    CMBaño_pro.addItem(dato); 
}
    
    CMBstatus.addItem("");
    CMBstatus.addItem("Activo");
    CMBstatus.addItem("Inactivo");
    CMBstatus.addItem("otro");
    
   
    
    
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel37 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        GrupBtnAlergia = new javax.swing.ButtonGroup();
        jPanel13 = new javax.swing.JPanel();
        JLNom_cond = new javax.swing.JLabel();
        JLFec_cond = new javax.swing.JLabel();
        placas_cond = new java.awt.Checkbox();
        barras_cond = new java.awt.Checkbox();
        JTNom_cond = new javax.swing.JTextField();
        JTFec_cond = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        Modi = new javax.swing.JMenuItem();
        ModiProm = new javax.swing.JMenuItem();
        ModiArm = new javax.swing.JMenuItem();
        ModiFami = new javax.swing.JMenuItem();
        globalVaria = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Centr = new javax.swing.JLabel();
        CEA = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Registro = new javax.swing.JTabbedPane();
        PanelPerso = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        texnom = new javax.swing.JTextField();
        texcedu = new javax.swing.JTextField();
        texgrup_san = new javax.swing.JTextField();
        texape = new javax.swing.JTextField();
        texser = new javax.swing.JTextField();
        texfec_nac = new javax.swing.JTextField();
        CMBsexo = new javax.swing.JComboBox();
        CMBEstado = new javax.swing.JComboBox();
        CMBtipo = new javax.swing.JComboBox();
        CMBrango = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        RBtnSi = new javax.swing.JRadioButton();
        RBtnNo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAAlergia = new javax.swing.JTextArea();
        CMBComponent = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        CMBunidad = new javax.swing.JComboBox();
        BuscarPer = new javax.swing.JButton();
        ModificarPerso = new javax.swing.JButton();
        PanelLoca = new javax.swing.JPanel();
        JLCorre = new javax.swing.JLabel();
        JLTel_celu = new javax.swing.JLabel();
        JLTel_trab = new javax.swing.JLabel();
        JLTel_otro = new javax.swing.JLabel();
        JLTel_cas = new javax.swing.JLabel();
        JLDirecc = new javax.swing.JLabel();
        JLCent_vot = new javax.swing.JLabel();
        JLUbic_cent = new javax.swing.JLabel();
        textel_cel = new javax.swing.JTextField();
        tex_tel_casa = new javax.swing.JTextField();
        textcent_vot = new javax.swing.JTextField();
        texubic_cent = new javax.swing.JTextField();
        texcorreo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tex_dirre = new javax.swing.JTextArea();
        textel_tra = new javax.swing.JTextField();
        tex_tel_ot = new javax.swing.JTextField();
        PanelFame = new javax.swing.JPanel();
        JLNom_fam1 = new javax.swing.JLabel();
        JTNom_fam1 = new javax.swing.JTextField();
        JTApe_fam1 = new javax.swing.JTextField();
        JLApe_fam1 = new javax.swing.JLabel();
        CMBPAREN = new javax.swing.JComboBox();
        JLDirrec_fam1 = new javax.swing.JLabel();
        JLParent_fam1 = new javax.swing.JLabel();
        JTCed_fam1 = new javax.swing.JTextField();
        JLCed_fam1 = new javax.swing.JLabel();
        JLTel_fam1 = new javax.swing.JLabel();
        JTTel_fam1 = new javax.swing.JTextField();
        BTNpregunta = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TXTareDireFam = new javax.swing.JTextArea();
        BTNREGISFAMILIA = new javax.swing.JButton();
        JLApe_fam2 = new javax.swing.JLabel();
        TXTSERFAM = new javax.swing.JTextField();
        BuscarFami = new javax.swing.JButton();
        ModificarFami = new javax.swing.JButton();
        PanelPromo = new javax.swing.JPanel();
        JLNom_pro = new javax.swing.JLabel();
        JLAño_pro = new javax.swing.JLabel();
        JLEscu_pro = new javax.swing.JLabel();
        JLEsp_pro = new javax.swing.JLabel();
        JLMencion_esp = new javax.swing.JLabel();
        texnom_pro = new javax.swing.JTextField();
        CMBaño_pro = new javax.swing.JComboBox();
        texescul = new javax.swing.JTextField();
        JTEsp_pro = new javax.swing.JTextField();
        JTMencion_esp = new javax.swing.JTextField();
        BuscarPromo = new javax.swing.JButton();
        ModificarPromo = new javax.swing.JButton();
        PanelArma = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        texser_arm = new javax.swing.JTextField();
        textubic = new javax.swing.JTextField();
        textipo = new javax.swing.JTextField();
        CMBstatus = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TXAREOBSERVarm = new javax.swing.JTextArea();
        Buscararma = new javax.swing.JButton();
        ModificarArma = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        texnom_car = new javax.swing.JTextField();
        tex_depe = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        JLnombreUSU = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        TXTced = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        scrolpane = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TBperson = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel37.setText("jLabel37");

        jLabel54.setText("jLabel54");

        jTextField36.setText("jTextField36");

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Condecoración", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        JLNom_cond.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLNom_cond.setText("Nombre:");

        JLFec_cond.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLFec_cond.setText("Fecha:");

        placas_cond.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        placas_cond.setLabel("Placas");

        barras_cond.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        barras_cond.setLabel("Barras\n");

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel3.setText("Observaciones:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(placas_cond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(barras_cond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(JLNom_cond)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTNom_cond, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(JLFec_cond)
                        .addGap(18, 18, 18)
                        .addComponent(JTFec_cond, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLNom_cond)
                    .addComponent(JLFec_cond)
                    .addComponent(JTNom_cond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFec_cond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(39, 39, 39)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(placas_cond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barras_cond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        Modi.setText("Modi");
        Modi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModiActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Modi);

        ModiProm.setText("Modii");
        ModiProm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModiPromActionPerformed(evt);
            }
        });
        jPopupMenu1.add(ModiProm);

        ModiArm.setText("Modi arma");
        ModiArm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModiArmActionPerformed(evt);
            }
        });
        jPopupMenu1.add(ModiArm);

        ModiFami.setText("Modi Fami");
        ModiFami.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModiFamiActionPerformed(evt);
            }
        });
        jPopupMenu1.add(ModiFami);

        globalVaria.setText("jLabel2");

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
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(CEA))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Centr)))
                .addContainerGap(49, Short.MAX_VALUE))
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
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setOpaque(false);

        jLabel11.setFont(new java.awt.Font("Traditional Arabic", 1, 16)); // NOI18N
        jLabel11.setText("Administrador");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Registro.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel4.setText("Nombres:");

        jLabel12.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel12.setText("Apellidos");

        jLabel13.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel13.setText("Cedula:");

        jLabel14.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel14.setText("Serial de Carnet:");

        jLabel15.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel15.setText("Sexo:");

        jLabel16.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel16.setText("Alergias:");

        jLabel17.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel17.setText("Fecha de Nacimiento:");

        jLabel18.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel18.setText("Grupo Sanguineo:");

        jLabel19.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel19.setText("Estado Civil.");

        texser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texserActionPerformed(evt);
            }
        });

        texfec_nac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texfec_nacActionPerformed(evt);
            }
        });

        CMBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMBEstadoActionPerformed(evt);
            }
        });

        CMBtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMBtipoActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel20.setText("Rango:");

        jLabel21.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel21.setText("Categoria:");

        RBtnSi.setText("Si");
        RBtnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBtnSiActionPerformed(evt);
            }
        });

        RBtnNo.setText("No");
        RBtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBtnNoActionPerformed(evt);
            }
        });

        TxtAAlergia.setColumns(20);
        TxtAAlergia.setRows(5);
        TxtAAlergia.setText("no");
        jScrollPane1.setViewportView(TxtAAlergia);

        jLabel27.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel27.setText("Componente:");

        jLabel28.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel28.setText("Unidad:");

        CMBunidad.setEnabled(false);

        BuscarPer.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        BuscarPer.setText("Buscar");
        BuscarPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarPerActionPerformed(evt);
            }
        });

        ModificarPerso.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        ModificarPerso.setText("Modificar");
        ModificarPerso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarPersoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPersoLayout = new javax.swing.GroupLayout(PanelPerso);
        PanelPerso.setLayout(PanelPersoLayout);
        PanelPersoLayout.setHorizontalGroup(
            PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPersoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPersoLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPersoLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CMBtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CMBrango, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CMBComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelPersoLayout.createSequentialGroup()
                                .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(texfec_nac)
                                    .addComponent(texgrup_san, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CMBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(PanelPersoLayout.createSequentialGroup()
                                    .addComponent(ModificarPerso)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BuscarPer))
                                .addGroup(PanelPersoLayout.createSequentialGroup()
                                    .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelPersoLayout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(texser, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelPersoLayout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(texcedu, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel4)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelPersoLayout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(CMBsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel28)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(CMBunidad, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelPersoLayout.createSequentialGroup()
                                            .addComponent(texnom, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(texape, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelPersoLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RBtnSi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RBtnNo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPersoLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPersoLayout.setVerticalGroup(
            PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPersoLayout.createSequentialGroup()
                .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPersoLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel5)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel6))
                    .addGroup(PanelPersoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BuscarPer)
                            .addComponent(ModificarPerso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(texcedu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(texnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(texape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(texser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(CMBsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(CMBunidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(CMBtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(CMBrango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CMBComponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(7, 7, 7)
                        .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(texfec_nac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(CMBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(texgrup_san, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelPersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(RBtnSi)
                            .addComponent(RBtnNo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        Registro.addTab("Datos Personales", PanelPerso);

        JLCorre.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLCorre.setText("Correo:");

        JLTel_celu.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLTel_celu.setText("Telefono celular:");

        JLTel_trab.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLTel_trab.setText("Telefono de trabajo:");

        JLTel_otro.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLTel_otro.setText("Telefono otro: ");

        JLTel_cas.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLTel_cas.setText("Telefono de casa:");

        JLDirecc.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLDirecc.setText("Direccion:");

        JLCent_vot.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLCent_vot.setText("Centro de votacion:");

        JLUbic_cent.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLUbic_cent.setText("Ubicacion del centro:");

        textel_cel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textel_celActionPerformed(evt);
            }
        });

        tex_tel_casa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tex_tel_casaActionPerformed(evt);
            }
        });

        tex_dirre.setColumns(20);
        tex_dirre.setRows(5);
        jScrollPane2.setViewportView(tex_dirre);

        javax.swing.GroupLayout PanelLocaLayout = new javax.swing.GroupLayout(PanelLoca);
        PanelLoca.setLayout(PanelLocaLayout);
        PanelLocaLayout.setHorizontalGroup(
            PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLocaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLocaLayout.createSequentialGroup()
                        .addComponent(JLCent_vot, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textcent_vot, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLocaLayout.createSequentialGroup()
                        .addComponent(JLDirecc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLocaLayout.createSequentialGroup()
                        .addGroup(PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLTel_celu)
                            .addComponent(JLTel_cas, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLCorre))
                        .addGap(20, 20, 20)
                        .addGroup(PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelLocaLayout.createSequentialGroup()
                                .addComponent(JLUbic_cent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(texubic_cent, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelLocaLayout.createSequentialGroup()
                                .addGroup(PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tex_tel_casa)
                                    .addComponent(textel_cel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLTel_trab)
                                    .addComponent(JLTel_otro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textel_tra)
                                    .addComponent(tex_tel_ot, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(texcorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        PanelLocaLayout.setVerticalGroup(
            PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLocaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLTel_celu)
                    .addComponent(JLTel_trab)
                    .addComponent(textel_cel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textel_tra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLTel_cas)
                    .addComponent(JLTel_otro)
                    .addComponent(tex_tel_casa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tex_tel_ot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLCorre)
                    .addComponent(texcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLDirecc)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(PanelLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLCent_vot)
                    .addComponent(textcent_vot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLUbic_cent)
                    .addComponent(texubic_cent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );

        Registro.addTab("Localizador", PanelLoca);

        PanelFame.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Familiares", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        PanelFame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLNom_fam1.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLNom_fam1.setText("Nombre de Familiar:");
        PanelFame.add(JLNom_fam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));
        PanelFame.add(JTNom_fam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 110, -1));
        PanelFame.add(JTApe_fam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 97, -1));

        JLApe_fam1.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLApe_fam1.setText("Apellido de Familiar:");
        PanelFame.add(JLApe_fam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 84, -1, -1));

        PanelFame.add(CMBPAREN, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 120, -1));

        JLDirrec_fam1.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLDirrec_fam1.setText("Dirección de Familiar:");
        PanelFame.add(JLDirrec_fam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 151, -1, -1));

        JLParent_fam1.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLParent_fam1.setText("Parentesco de Familiar:");
        PanelFame.add(JLParent_fam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));
        PanelFame.add(JTCed_fam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 97, -1));

        JLCed_fam1.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLCed_fam1.setText("Cedula de Familiar:");
        PanelFame.add(JLCed_fam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 50, -1, -1));

        JLTel_fam1.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLTel_fam1.setText("Telefono de Familiar:");
        PanelFame.add(JLTel_fam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 117, -1, -1));
        PanelFame.add(JTTel_fam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 97, -1));

        BTNpregunta.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        BTNpregunta.setText("Ingresar otro?");
        BTNpregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNpreguntaActionPerformed(evt);
            }
        });
        PanelFame.add(BTNpregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 120, -1));

        TXTareDireFam.setColumns(20);
        TXTareDireFam.setRows(5);
        jScrollPane3.setViewportView(TXTareDireFam);

        PanelFame.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 180, 495, -1));

        BTNREGISFAMILIA.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        BTNREGISFAMILIA.setText("Resgitrar");
        BTNREGISFAMILIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNREGISFAMILIAActionPerformed(evt);
            }
        });
        PanelFame.add(BTNREGISFAMILIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 312, -1, -1));

        JLApe_fam2.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLApe_fam2.setText("Serial del Carnet:");
        PanelFame.add(JLApe_fam2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));
        PanelFame.add(TXTSERFAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 110, -1));

        BuscarFami.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        BuscarFami.setText("Buscar");
        BuscarFami.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarFamiActionPerformed(evt);
            }
        });
        PanelFame.add(BuscarFami, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        ModificarFami.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        ModificarFami.setText("Modificar");
        ModificarFami.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarFamiActionPerformed(evt);
            }
        });
        PanelFame.add(ModificarFami, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        Registro.addTab("Datos Familiares", PanelFame);

        PanelPromo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Promociones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        JLNom_pro.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLNom_pro.setText("Nombre de la Promoción:");

        JLAño_pro.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLAño_pro.setText("Año de Promoción:");

        JLEscu_pro.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLEscu_pro.setText("Escuela de Promoción:");

        JLEsp_pro.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLEsp_pro.setText("Especialidad");

        JLMencion_esp.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLMencion_esp.setText("Mención de la Especialidad:");

        JTMencion_esp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTMencion_espActionPerformed(evt);
            }
        });

        BuscarPromo.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        BuscarPromo.setText("Buscar");
        BuscarPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarPromoActionPerformed(evt);
            }
        });

        ModificarPromo.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        ModificarPromo.setText("Modificar");
        ModificarPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarPromoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPromoLayout = new javax.swing.GroupLayout(PanelPromo);
        PanelPromo.setLayout(PanelPromoLayout);
        PanelPromoLayout.setHorizontalGroup(
            PanelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPromoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPromoLayout.createSequentialGroup()
                        .addGroup(PanelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLEscu_pro)
                            .addComponent(JLNom_pro))
                        .addGroup(PanelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelPromoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(texnom_pro))
                            .addGroup(PanelPromoLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(texescul, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(PanelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLAño_pro)
                            .addComponent(JLEsp_pro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CMBaño_pro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTEsp_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelPromoLayout.createSequentialGroup()
                        .addComponent(JLMencion_esp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTMencion_esp, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPromoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ModificarPromo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BuscarPromo)
                .addContainerGap())
        );
        PanelPromoLayout.setVerticalGroup(
            PanelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPromoLayout.createSequentialGroup()
                .addGroup(PanelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarPromo)
                    .addComponent(ModificarPromo))
                .addGap(54, 54, 54)
                .addGroup(PanelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLNom_pro)
                    .addComponent(texnom_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLAño_pro)
                    .addComponent(CMBaño_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLEscu_pro)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(texescul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLEsp_pro)
                        .addComponent(JTEsp_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLMencion_esp)
                    .addComponent(JTMencion_esp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        Registro.addTab("Promociones", PanelPromo);

        jLabel7.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel7.setText("Serial de Armamento:");

        jLabel8.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel8.setText("Tipo:");

        jLabel9.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel9.setText("Observacion:");

        jLabel10.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel10.setText("Status:");

        CMBstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMBstatusActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel29.setText("Ubicación : ");

        TXAREOBSERVarm.setColumns(20);
        TXAREOBSERVarm.setRows(5);
        jScrollPane4.setViewportView(TXAREOBSERVarm);

        Buscararma.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        Buscararma.setText("Buscar");
        Buscararma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscararmaActionPerformed(evt);
            }
        });

        ModificarArma.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        ModificarArma.setText("Modificar");
        ModificarArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarArmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelArmaLayout = new javax.swing.GroupLayout(PanelArma);
        PanelArma.setLayout(PanelArmaLayout);
        PanelArmaLayout.setHorizontalGroup(
            PanelArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArmaLayout.createSequentialGroup()
                .addGroup(PanelArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelArmaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelArmaLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(texser_arm, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelArmaLayout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(textubic, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addGroup(PanelArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelArmaLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CMBstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelArmaLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textipo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelArmaLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(PanelArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelArmaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ModificarArma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buscararma)
                .addGap(18, 18, 18))
        );
        PanelArmaLayout.setVerticalGroup(
            PanelArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArmaLayout.createSequentialGroup()
                .addGroup(PanelArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelArmaLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(PanelArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelArmaLayout.createSequentialGroup()
                        .addGroup(PanelArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelArmaLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(PanelArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(texser_arm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelArmaLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(PanelArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Buscararma)
                                    .addComponent(ModificarArma))))
                        .addGap(44, 44, 44)
                        .addGroup(PanelArmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textubic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(CMBstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))))
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        Registro.addTab("Armamentos", PanelArma);

        jLabel22.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel22.setText("Dependenciade Cargo:");

        jLabel23.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel23.setText("Nombre de Cargo:");

        jLabel24.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel24))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texnom_car, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tex_depe, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(321, 321, 321))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(texnom_car, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(tex_depe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel24)
                .addGap(303, 303, 303))
        );

        Registro.addTab("Cargos", jPanel8);

        jButton27.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton27.setText("Resgitrar");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton28.setText("Limpieza");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setOpaque(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit.png"))); // NOI18N
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        jLabel31.setText("Bienvenido:");

        JLnombreUSU.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLnombreUSU.setText(".");

        jLabel32.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel32.setText("jLabel7");

        jLabel33.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel33.setText("jLabel8");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLnombreUSU, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(JLnombreUSU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(jLabel33))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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

        jPanel7.setOpaque(false);

        jLabel25.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel25.setText("Buscar por Cedula");

        TBperson.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBperson.setComponentPopupMenu(jPopupMenu1);
        jScrollPane5.setViewportView(TBperson);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 2039, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        scrolpane.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTced, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrolpane, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(TXTced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrolpane, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jButton27)
                .addGap(138, 138, 138)
                .addComponent(jButton28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton27)
                    .addComponent(jButton28))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        Registro.getAccessibleContext().setAccessibleName("Localizador");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        
        
        try {
            
            
            
            PreparedStatement pst= cn.prepareStatement("INSERT INTO personal ("
                 
                    + "ced_per,"//1
                    + "nom_per,"//2
                    + "ape_per,"//3
                    + "ser_car_per,"//4
                    + "sex_per," //5
                    + "alerg_per,"//6
                    + "grup_sang_per,"//7
                    + "unidad,"//8
                    +"grado,"//9
                    +"categoria,"//10
                    +"componente,"//11
                    + "fec_nac_per,"//12
                    + "est_civ_per,"//13
                    + "id_prom,"//14
                    
                    + "id_car," //15
                    + "ser_armp,"//16
                    + "fec_ing_sis_per,"//17
                    + "tlf_cel_per,"//18
                    + "tlf_otr_per,"//19
                    + "tlf_casa_per,"//20
                    + "tlf_trab_per,"//21
                    + "mail_per,"//22
                    + "direcc_per,"//23
                    + "centro_vot_per,"//24
                    + "ubic_vot_per"//25
                    + ")VALUE"
                    + "(?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,?)");

          int cedu =Integer.parseInt(texcedu.getText());
          pst.setInt(1,cedu );
            
           if(texcedu==null){
           JOptionPane.showMessageDialog(null, "Cedula vacio");
           }
            
            pst.setString(2, texnom.getText());
           if(texnom==null){
           JOptionPane.showMessageDialog(null, "nombre vacio");
           }
                
            pst.setString(3, texape.getText());
        if(texape==null){
           JOptionPane.showMessageDialog(null, "apellido vacio");
           }
            
            
             int sera=Integer.parseInt(texser.getText());
             pst.setInt(4,sera);
             
             if(texser==null){
           JOptionPane.showMessageDialog(null, "serial carnet vacio");
           }
            
           String sele=(String)CMBsexo.getSelectedItem();
                  pst.setString(5,sele);
            

                  if(sele.equals("")){
           JOptionPane.showMessageDialog(null, "sexo vacio");
           }
           pst.setString(6, TxtAAlergia.getText());
          
           
           if(TxtAAlergia==null){
           JOptionPane.showMessageDialog(null, "Alergia vacio");
           }
           
           
           pst.setString(7, texgrup_san.getText());
           
           if(texgrup_san==null){
           JOptionPane.showMessageDialog(null, "Grupo Sanguineo vacio");
           }
           
           
           String uni=(String)CMBunidad.getSelectedItem();
           pst.setString(8, uni);
           
           
           if(uni.equals("")){
           JOptionPane.showMessageDialog(null, "Unidad vacio");
           }
           
           
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           
           String gra=(String)CMBrango.getSelectedItem();
         pst.setString(9,gra);
         if(CMBrango.equals("")){
           JOptionPane.showMessageDialog(null, "rango vacio");
           }
         
         
         String cat=(String)CMBtipo.getSelectedItem();
         pst.setString(10,cat);
         if(CMBtipo.equals("")){
           JOptionPane.showMessageDialog(null, "Tipo de rango vacio");
           }
         
         String com=(String)CMBComponent.getSelectedItem();
          pst.setString(11,com);
          if(CMBtipo.equals("")){
           JOptionPane.showMessageDialog(null, "Tipo de rango vacio");
          }
           
           
           pst.setString(12, texfec_nac.getText());
                   
           
          if(texfec_nac==null){
           JOptionPane.showMessageDialog(null, "Fecha de Nacimiento vacio");
           }
           
              
          String est=(String)CMBEstado.getSelectedItem();
                
           pst.setString(13, est);
            
           if(est.equals("")){
           JOptionPane.showMessageDialog(null, "Estado civil vacio");
           }
             
           
           
           PreparedStatement pstt= cn.prepareStatement("INSERT INTO promocion (nom_prom,año_prom,escuel_prom,espec,mencion)VALUE(?,?,?,?,?)");
             pstt.setString(1,texnom_pro.getText());
           
             if(texnom_pro==null){
           JOptionPane.showMessageDialog(null, "Nombre Promoción vacio");
           }
             String promo=(String)CMBaño_pro.getSelectedItem();
             pstt.setString(2,promo);
             
             
             if(promo.equals("")){
           JOptionPane.showMessageDialog(null, " vacio");
           }
             
             
             pstt.setString(3,texescul.getText());
         if(texescul==null){
           JOptionPane.showMessageDialog(null, " vacio");
           }
             
         
         
         pstt.setString(4, JTEsp_pro.getText());
         
         
         
         pstt.setString(5, JTMencion_esp.getText());
             pstt.executeUpdate();
           
           
           
           Statement ast = cn.createStatement();
            ResultSet ars = ast.executeQuery("SELECT MAX(id_prom) FROM promocion ");
            
            String prom="";
            
            while(ars.next()){
             prom=ars.getString(1);
            }
           
           
           
           System.out.println(prom);
           
              pst.setString(14,prom);
           
           
           
           
           
        
          
          
          
           PreparedStatement pst3 = cn.prepareStatement("INSERT INTO cargos (nom_car,dependc_car)VALUE(?,?)");
           
           pst3.setString(1,texnom_car.getText());
          if(texnom_car==null){
           JOptionPane.showMessageDialog(null, "Nombre de Cargo vacio");
          }
           
           pst3.setString(2,tex_depe.getText());
          
           if(tex_depe==null){
           JOptionPane.showMessageDialog(null, "depencia  vacia");
          }
           
           
           pst3.executeUpdate();
           
           
           
           
           
           
           Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(id_car) FROM cargos ");
            
            String carg="";
            
            while(rs.next()){
             carg=rs.getString(1);
            }
           
           
           
           System.out.println(carg);
           
           
            pst.setString(15,carg);
           
            PreparedStatement pst4 = cn.prepareStatement("INSERT INTO armamentop (ser_armp,tipo_arm,ubic_arm,observacion,status_arm)VALUE(?,?,?,?,?)");
          
         pst4.setString(1,texser_arm.getText());
         if(texser_arm==null){
           JOptionPane.showMessageDialog(null, "Seria Armamento vacio");
          }
         
         pst4.setString(2,textipo.getText());
         if(textipo==null){
           JOptionPane.showMessageDialog(null, "Tipo de Armamento vacio");
          }
         pst4.setString(3,textubic.getText());
         if(textubic==null){
           JOptionPane.showMessageDialog(null, "Ubicación de Armamento vacio");
          }
         pst4.setString(4, TXAREOBSERVarm.getText());
         String status=(String)CMBstatus.getSelectedItem();
         pst4.setString(5,status);
        if(CMBstatus==null){
           JOptionPane.showMessageDialog(null, "Status de Armamento vacio");
          }
           pst4.executeUpdate();
           pst.setString(16,texser_arm.getText());
           
           
                    
            String fecha="";

            Date now = new Date(System.currentTimeMillis());
            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
            fecha=(date.format(now));
            pst.setString(17, fecha);  
            
           
           pst.setString(18,textel_cel.getText());
           if(textel_cel==null){
           JOptionPane.showMessageDialog(null, "Celular vacio");
          }
           
          pst.setString(19,tex_tel_ot.getText());
          
          
           pst.setString(20,tex_tel_casa.getText());
           if(tex_tel_casa==null){
           JOptionPane.showMessageDialog(null, "Telefono de Casa Vacio");
          }
           
           
          pst.setString(21,textel_tra.getText());
          if(textel_tra==null){
           JOptionPane.showMessageDialog(null, "Telefono de Trabajo vacio");
          }
          
          
          pst.setString(22,texcorreo.getText());
          if(texcorreo==null){
           JOptionPane.showMessageDialog(null, "Correo vacio");
          }
          
          
          pst.setString(23,tex_dirre.getText());
          if(tex_dirre==null){
           JOptionPane.showMessageDialog(null, "Dirreción vacio");
          }
          
          
          pst.setString(24,textcent_vot.getText());
          if(textcent_vot==null){
           JOptionPane.showMessageDialog(null, "Centro de Votación vacio");
          }
          
          
          
          pst.setString(25,texubic_cent.getText());
          
            
            
             if(texubic_cent==null){
           JOptionPane.showMessageDialog(null, "Ubicación del Centro de Votación vacio");
          }
            
        
            
            
            
            
  



            pst.executeUpdate();

             
            
            
            
            
            
            
            
            
            
      
            if( cn==null){
                JOptionPane.showMessageDialog(null, "Error en el Registro");}
            else{JOptionPane.showMessageDialog(null, "Registrado");}
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            System.out.println(e+ " es esto");
            JOptionPane.showMessageDialog(null, "Error de Registro\nCompruebe los datos ingresados");
            System.err.println(e.getMessage());
        }
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void JTMencion_espActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTMencion_espActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTMencion_espActionPerformed

    private void textel_celActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textel_celActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textel_celActionPerformed

    private void RBtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBtnNoActionPerformed
        // TODO add your handling code here:

        TxtAAlergia.setEnabled(false);
        TxtAAlergia.setText("");

    }//GEN-LAST:event_RBtnNoActionPerformed

    private void RBtnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBtnSiActionPerformed
        // TODO add your handling code here:

        TxtAAlergia.setEnabled(true);

    }//GEN-LAST:event_RBtnSiActionPerformed

    private void CMBtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMBtipoActionPerformed
        // TODO add your handling code here:

        String sel=(String)CMBtipo.getSelectedItem();
        CMBrango.removeAllItems();

        if(sel.equals("Comando")
          
            ||sel.equals("Tecnico")
            ||sel.equals("Asimilado")){

            CMBrango.addItem("");
            CMBrango.addItem("G/B");
            CMBrango.addItem("Cnel");
            CMBrango.addItem("TCnel");
            CMBrango.addItem("May");
            CMBrango.addItem("Cap");
            CMBrango.addItem("1Tte");
            CMBrango.addItem("Tte");

        }
        else if( sel.equals("Tropa Profecional")){

            CMBrango.addItem("");
            CMBrango.addItem("SS");
            CMBrango.addItem("SA");
            CMBrango.addItem("SM1");
            CMBrango.addItem("SM2");
            CMBrango.addItem("SM3");
            CMBrango.addItem("S1");
            CMBrango.addItem("S2");

        }

    }//GEN-LAST:event_CMBtipoActionPerformed

    private void tex_tel_casaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tex_tel_casaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tex_tel_casaActionPerformed

    private void texserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texserActionPerformed

    private void BTNpreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNpreguntaActionPerformed
        // TODO add your handling code here:

           
            
            limpiar clear = new limpiar();
            clear.limpiarCampos(PanelFame);
            BTNREGISFAMILIA.setVisible(true);
        BTNpregunta.setVisible(false);
        
        
        TXTareDireFam.setText("");
        
        
        
        
    }//GEN-LAST:event_BTNpreguntaActionPerformed

    private void BTNREGISFAMILIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNREGISFAMILIAActionPerformed
        // TODO add your handling code here:
        
        try{

            PreparedStatement pst=cn.prepareStatement("INSERT INTO familiares("
                    + "ced_fam,"
                    + "ced_per,"
                    + "ser_car_fam,"
                    + "nom_fam,"
                    + "ape_fam,"
                    + "parent_fam,"
                    + "tlf_fam,"
                    + "direcc_fam) VALUES (?,?,?,?,?,?,?,?)");

            int cedfam=Integer.parseInt(JTCed_fam1.getText());
            pst.setInt(1, cedfam);

            
            
           
            int ced=Integer.parseInt(texcedu.getText());
            
            pst.setInt(2, ced);

           

            
         
            int seria=Integer.parseInt(TXTSERFAM.getText());

            pst.setInt(3, seria);

           pst.setString(4, JTNom_fam1.getText());
           pst.setString(5,JTApe_fam1.getText() );
                    
            
            
            String se=(String)CMBPAREN.getSelectedItem();
            pst.setString(6,se );

            pst.setString(7,JTTel_fam1.getText());
            pst.setString(8, TXTareDireFam.getText());
            

            pst.executeUpdate();
  

            if( cn==null){
                JOptionPane.showMessageDialog(null, "Error en el Registro");}
            else{JOptionPane.showMessageDialog(null, "Registrado");
            
            
            
            BTNpregunta.setVisible(true);
            
            limpiar clear = new limpiar();
            BTNREGISFAMILIA.setVisible(false);
            
            }
        } catch (Exception e) {
            System.out.println(e+ " fffff");
            JOptionPane.showMessageDialog(null, "ERRor de registro");
            System.err.println(e.getMessage());
        }
        
        
        
        
    }//GEN-LAST:event_BTNREGISFAMILIAActionPerformed

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        // TODO add your handling code here:

        Personal ir =new Personal();
        ir.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void CMBstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMBstatusActionPerformed
        // TODO add your handling code here:
        
        String opcion=(String)CMBstatus.getSelectedItem();
        
        if (opcion == "otro"){
    TXAREOBSERVarm.setEnabled(true);
    }
        
        
    }//GEN-LAST:event_CMBstatusActionPerformed

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
        
        
          if (!jPanel7.isVisible()){
                jPanel7.setVisible(true);
                                                    BuscarFami.setVisible(true);
                                                    BuscarPer.setVisible(true);
                                                    Buscararma.setVisible(true);
                                                    BuscarPromo.setVisible(true);
                                                
                                               
                                               
                
                
        }else  if (jPanel7.isVisible()){
                jPanel7.setVisible(false);
                                                    BuscarFami.setVisible(false);
                                                    BuscarPer.setVisible(false);
                                                    Buscararma.setVisible(false);
                                                    BuscarPromo.setVisible(false);
                                               
                                                
                                                
                                                
                
                
        }
          
          
          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ModiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModiActionPerformed
        // TODO add your handling code here:
        
         ModificarPerso.setVisible(true);
                int fila=TBperson.getSelectedRow();
       
        if(fila>=0){
        
            
            
            
            
            
            
            
        texcedu.setText(TBperson.getValueAt(fila, 0).toString());
        texnom.setText(TBperson.getValueAt(fila, 1).toString());
        texape.setText(TBperson.getValueAt(fila, 2).toString());
        texser.setText(TBperson.getValueAt(fila, 3).toString());
        CMBsexo.setSelectedItem(TBperson.getValueAt(fila, 4).toString());
        TxtAAlergia.setText(TBperson.getValueAt(fila, 5).toString());
        texgrup_san.setText(TBperson.getValueAt(fila, 6).toString());
        CMBunidad.setSelectedItem(TBperson.getValueAt(fila, 7).toString());
        
        CMBrango.setSelectedItem(TBperson.getValueAt(fila, 8).toString());
        
        String vari=TBperson.getValueAt(fila, 8).toString();
            System.out.println(vari);
        CMBtipo.setSelectedItem(TBperson.getValueAt(fila, 9).toString());
        CMBComponent.setSelectedItem(TBperson.getValueAt(fila, 10).toString());
        texfec_nac.setText(TBperson.getValueAt(fila, 11).toString());
        CMBEstado.setSelectedItem(TBperson.getValueAt(fila, 12).toString());
        
        
        //localizador
        
        
        textel_cel.setText(TBperson.getValueAt(fila, 15).toString());
       tex_tel_ot.setText(TBperson.getValueAt(fila, 16).toString());
       
       
       tex_tel_casa.setText(TBperson.getValueAt(fila, 17).toString());
                textel_tra.setText(TBperson.getValueAt(fila, 18).toString());
      texcorreo.setText(TBperson.getValueAt(fila, 19).toString());
               tex_dirre.setText(TBperson.getValueAt(fila,20).toString());
               
               
               
        textcent_vot.setText(TBperson.getValueAt(fila, 21).toString());
            
        texubic_cent.setText(TBperson.getValueAt(fila, 22).toString());
        
        
        
        
        
        
        
        }else{
        JOptionPane.showMessageDialog(null, "No ha Selecionado un Registro");}

    }//GEN-LAST:event_ModiActionPerformed

    private void texfec_nacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texfec_nacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texfec_nacActionPerformed

    private void CMBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMBEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CMBEstadoActionPerformed

    private void BuscarPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarPerActionPerformed
        // TODO add your handling code here:
            mostrarPers(TXTced.getText());


       ModiProm.setVisible(false);
       ModiArm.setVisible(false);
       ModiFami.setVisible(false);
        Modi.setVisible(true);
        
    }//GEN-LAST:event_BuscarPerActionPerformed

    private void BuscarPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarPromoActionPerformed
        // TODO add your handling code here:
        
       Modi.setVisible(false);
       
       ModiArm.setVisible(false);
       ModiFami.setVisible(false);
        ModiProm.setVisible(true);
        String dato="";
        try{
        Statement s = cn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM personal WHERE ced_per='"+TXTced.getText()+"'");
    
         while (rs.next()){
        dato=rs.getString("id_prom");
            System.out.println(dato);}}
         catch(Exception e){}
        mostrarPromo(dato);
        
        
    }//GEN-LAST:event_BuscarPromoActionPerformed

    private void BuscararmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscararmaActionPerformed
        // TODO add your handling code here:
        
       Modi.setVisible(false);
       ModiProm.setVisible(false);
       
       ModiFami.setVisible(false);
         ModiArm.setVisible(true);
        String dato="";
        try{
        Statement s = cn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM personal WHERE ced_per='"+TXTced.getText()+"'");
    
         while (rs.next()){
        dato=rs.getString("ser_armp");
            System.out.println(dato);}}
         catch(Exception e){}
        mostrararma(dato);
        
        
    }//GEN-LAST:event_BuscararmaActionPerformed

    private void ModiArmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModiArmActionPerformed
        // TODO add your handling code here:
        
                                                ModificarArma.setVisible(true);
                int fila=TBperson.getSelectedRow();
       
        if(fila>=0){
            
       texser_arm.setText(TBperson.getValueAt(fila, 0).toString());
        globalVaria.setText(TBperson.getValueAt(fila, 0).toString());            
       textipo.setText(TBperson.getValueAt(fila, 1).toString());
        textubic.setText (TBperson.getValueAt(fila, 2).toString());
        TXAREOBSERVarm.setText(TBperson.getValueAt(fila, 3).toString());
        CMBstatus.setSelectedItem(TBperson.getValueAt(fila, 4).toString());
        
  
        
          
        
        
        }else{
        JOptionPane.showMessageDialog(null, "No ha Selecionado un Registro");}        
        
        
        
        
        
        
    }//GEN-LAST:event_ModiArmActionPerformed

    private void BuscarFamiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarFamiActionPerformed
        // TODO add your handling code here:
        
       Modi.setVisible(false);
       ModiProm.setVisible(false);
       ModiArm.setVisible(false);
       
        ModiFami.setVisible(true);
        mostrarFamilia(TXTced.getText());
        
        
    }//GEN-LAST:event_BuscarFamiActionPerformed

    private void ModiPromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModiPromActionPerformed
        // TODO add your handling code here:
         ModificarPromo.setVisible(true);
                int fila=TBperson.getSelectedRow();
       
        if(fila>=0){
            
        globalVaria.setText(TBperson.getValueAt(fila, 0).toString());
            
       texnom_pro.setText(TBperson.getValueAt(fila, 1).toString());
        CMBaño_pro.setSelectedItem(TBperson.getValueAt(fila, 2).toString());
        texescul.setText(TBperson.getValueAt(fila, 3).toString());
        JTEsp_pro.setText(TBperson.getValueAt(fila, 4).toString());
        
        JTMencion_esp.setText(TBperson.getValueAt(fila, 5).toString());
        
          
        
        
        }else{
        JOptionPane.showMessageDialog(null, "No ha Selecionado un Registro");}        
        
        
    }//GEN-LAST:event_ModiPromActionPerformed

    private void ModiFamiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModiFamiActionPerformed
        // TODO add your handling code here:
        ModificarFami.setVisible(true);
        int fila=TBperson.getSelectedRow();
       
        if(fila>=0){
            
       JTCed_fam1.setText(TBperson. getValueAt(fila, 0).toString());
            globalVaria.setText(TBperson.getValueAt(fila, 1).toString());
       TXTSERFAM.setText(TBperson.getValueAt(fila, 2).toString());
        JTNom_fam1.setText(TBperson.getValueAt(fila, 3).toString());
        JTApe_fam1.setText(TBperson.getValueAt(fila, 4).toString());
        CMBPAREN.setSelectedItem(TBperson.getValueAt(fila, 5).toString());
        
        JTTel_fam1.setText(TBperson.getValueAt(fila, 6).toString());
        
        
        TXTareDireFam.setText(TBperson.getValueAt(fila,7).toString());
        
          
        
        
        }else{
        JOptionPane.showMessageDialog(null, "No ha Selecionado un Registro");}  
       
        
    }//GEN-LAST:event_ModiFamiActionPerformed

    private void ModificarArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarArmaActionPerformed
        // TODO add your handling code here:
        String Status=(String)CMBstatus.getSelectedItem();
       
   
        try {

            PreparedStatement pst = cn.prepareStatement("UPDATE armamentop SET ser_armp='"+texser_arm.getText()
                    +"',tipo_arm='"+textipo.getText()
                    +"',ubic_arm='"+textubic.getText()
                    +"',observacion='"+TXAREOBSERVarm.getText()
                    +"',status_arm='"+Status
                 
                  
                    
                    //en elregistro enque se va a guardar!
                    +"' WHERE ser_armp='"+globalVaria.getText()+"'");
            pst.executeUpdate();
            
            PreparedStatement pstP = cn.prepareStatement("UPDATE personal SET ser_armp='"+texser_arm.getText()
                    
                 
                  
                    
                    //en elregistro enque se va a guardar!
                    +"' WHERE ced_per='"+TXTced.getText()+"'");
            pstP.executeUpdate();
            
            //Mostrar los datos actualizados!!
            
            String dato="";
        try{
        Statement s = cn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM personal WHERE ced_per='"+TXTced.getText()+"'");
    
         while (rs.next()){
        dato=rs.getString("ser_armp");
            System.out.println(dato);}}
         catch(Exception e){}
        mostrararma(dato);
            
            lim.limpiarCampos(PanelArma);
 ModificarArma.setVisible(false);
            if( cn==null){
                JOptionPane.showMessageDialog(null, "Error en el Registro");}
            else{

                
                JOptionPane.showMessageDialog(null, "Actualizado");

                try{
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM variable WHERE id='1'");

                    String usu="";

                    while(rs.next()){
                        usu=rs.getString(2);
                    }

                    String accion="Modificar Registro Promocion";
                    System.out.println(usu);
                    auditar.auditoria(usu, accion, globalVaria.getText() );

                }catch(Exception e){

                    System.out.println("auditoria"+e);
                }
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e.getMessage());
            // Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }


        
        
        
        
    }//GEN-LAST:event_ModificarArmaActionPerformed

    private void ModificarPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarPromoActionPerformed
        // TODO add your handling code here:+
        
        
      
                
        String año_prom=(String)CMBaño_pro.getSelectedItem();
        
        
         int año=Integer.parseInt(año_prom);
         
   
        try {

            PreparedStatement pst = cn.prepareStatement("UPDATE promocion SET nom_prom='"+texnom_pro.getText()
                    +"',año_prom='"+año
                    +"',escuel_prom='"+texescul.getText()
                    +"',espec='"+JTEsp_pro.getText()
                    +"',mencion='"+JTMencion_esp.getText()
                  
                    
                    //en elregistro enque se va a guardar!
                    +"' WHERE id_prom='"+globalVaria.getText()+"'");
            pst.executeUpdate();
            //Mostrar los datos actualizados!!
            
            String dato="";
        try{
        Statement s = cn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM personal WHERE ced_per='"+TXTced.getText()+"'");
    
         while (rs.next()){
        dato=rs.getString("id_prom");
            System.out.println(dato);}}
         catch(Exception e){}
        mostrarPromo(dato);
            
            mostrarPromo(dato);
lim.limpiarCampos(PanelPromo);

ModificarPromo.setVisible(false);

            if( cn==null){
                JOptionPane.showMessageDialog(null, "Error en el Registro");}
            else{

                
                JOptionPane.showMessageDialog(null, "Actualizado");

                try{
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM variable WHERE id='1'");

                    String usu="";

                    while(rs.next()){
                        usu=rs.getString(2);
                    }

                    String accion="Modificar Registro Promocion";
                    System.out.println(usu);
                    auditar.auditoria(usu, accion, globalVaria.getText() );

                }catch(Exception e){

                    System.out.println("auditoria"+e);
                }
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e.getMessage());
            // Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }


        
        
        
        
    }//GEN-LAST:event_ModificarPromoActionPerformed

    private void ModificarFamiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarFamiActionPerformed
        // TODO add your handling code here:
        
        

        String parent=(String)CMBPAREN.getSelectedItem();
         int ced;
         
        ced=Integer.parseInt(TXTced.getText());
        try {

            PreparedStatement pst = cn.prepareStatement("UPDATE familiares SET ced_fam='"+JTCed_fam1.getText()
                    +"',ced_per='"+ced
                    +"',ser_car_fam='"+TXTSERFAM.getText()
                    +"',nom_fam='"+JTNom_fam1.getText()
                    +"',ape_fam='"+JTApe_fam1.getText()
                    +"',parent_fam='"+parent
                    +"',tlf_fam='"+JTTel_fam1.getText()
                    +"',direcc_fam='"+TXTareDireFam.getText()
                    
                    //en elregistro enque se va a guardar!
                    +"' WHERE ced_fam='"+JTCed_fam1.getText()+"'");
            pst.executeUpdate();
            //Mostrar los datos actualizados!!
            mostrarFamilia(TXTced.getText());
            lim.limpiarCampos(PanelFame);
ModificarFami.setVisible(false);
            
            if( cn==null){
                JOptionPane.showMessageDialog(null, "Error en el Registro");}
            else{

                
                JOptionPane.showMessageDialog(null, "Actualizado");

                try{
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM variable WHERE id='1'");

                    String usu="";

                    while(rs.next()){
                        usu=rs.getString(2);
                    }
                    String c=String.valueOf(ced);
                    String accion="Modificar Registro familiar";
                    System.out.println(usu);
                    auditar.auditoria(usu, accion, c );

                }catch(Exception e){

                    System.out.println("auditoria"+e);
                }
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e.getMessage());
            // Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_ModificarFamiActionPerformed

    private void ModificarPersoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarPersoActionPerformed
        // TODO add your handling code here:
        
        
        String sexo=(String)CMBsexo.getSelectedItem();
        String unidad=(String)CMBunidad.getSelectedItem();
        String cate=(String)CMBtipo.getSelectedItem();
        String rango=(String)CMBrango.getSelectedItem();
        String compone=(String)CMBComponent.getSelectedItem();
        String estadoCiv=(String)CMBEstado.getSelectedItem();

        
        try {

            PreparedStatement pst = cn.prepareStatement("UPDATE personal SET ced_per='"+texcedu.getText()
                    +"',nom_per='"+texnom.getText()
                    +"',ape_per='"+texape.getText()
                    +"',ser_car_per='"+texser.getText()
                    +"',sex_per='"+sexo
                    +"',alerg_per='"+TxtAAlergia.getText()
                    +"',grup_sang_per='"+texgrup_san.getText()
                    +"',unidad='"+unidad
                    +"',grado='"+rango
                    +"',categoria='"+cate
                    +"',componente='"+compone
                    +"',fec_nac_per='"+texfec_nac.getText()
                    +"',est_civ_per='"+estadoCiv                    
                    //LOCALIZADOR
                    
                    +"',tlf_cel_per='"+textel_cel.getText()
                    +"',tlf_otr_per='"+tex_tel_ot.getText()
                    +"',tlf_casa_per='"+tex_tel_casa.getText()
                    +"',tlf_trab_per='"+textel_tra.getText()
                    +"',mail_per='"+texcorreo.getText()
                    +"',direcc_per='"+tex_dirre.getText()
                    +"',centro_vot_per='"+textcent_vot.getText()
                    +"',ubic_vot_per='"+texubic_cent.getText()
                    
                    //en elregistro enque se va a guardar!
                    +"' WHERE ced_per='"+TXTced.getText()+"'");
            pst.executeUpdate();
            //Mostrar los datos actualizados!!
            mostrarPers(TXTced.getText());
            
            lim.limpiarCampos(PanelLoca);
            lim.limpiarCampos(PanelPerso);
            ModificarPerso.setVisible(false);
            if( cn==null){
                JOptionPane.showMessageDialog(null, "Error en el Registro");}
            else{

                
                JOptionPane.showMessageDialog(null, "Actualizado");

                try{
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM variable WHERE id='1'");

                    String usu="";

                    while(rs.next()){
                        usu=rs.getString(2);
                    }

                    String accion="Modificar Registro";
                    System.out.println(usu);
                    auditar.auditoria(usu, accion, TXTced.getText() );

                }catch(Exception e){

                    System.out.println("auditoria"+e);
                }
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e.getMessage());
            // Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ModificarPersoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrosG14.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrosG14.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrosG14.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrosG14.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new RegistrosG14().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNREGISFAMILIA;
    private javax.swing.JButton BTNpregunta;
    private javax.swing.JButton BuscarFami;
    private javax.swing.JButton BuscarPer;
    private javax.swing.JButton BuscarPromo;
    private javax.swing.JButton Buscararma;
    private javax.swing.JLabel CEA;
    private javax.swing.JComboBox CMBComponent;
    private javax.swing.JComboBox CMBEstado;
    private javax.swing.JComboBox CMBPAREN;
    private javax.swing.JComboBox CMBaño_pro;
    private javax.swing.JComboBox CMBrango;
    private javax.swing.JComboBox CMBsexo;
    private javax.swing.JComboBox CMBstatus;
    private javax.swing.JComboBox CMBtipo;
    private javax.swing.JComboBox CMBunidad;
    private javax.swing.JLabel Centr;
    private javax.swing.ButtonGroup GrupBtnAlergia;
    private javax.swing.JLabel JLApe_fam1;
    private javax.swing.JLabel JLApe_fam2;
    private javax.swing.JLabel JLAño_pro;
    private javax.swing.JLabel JLCed_fam1;
    private javax.swing.JLabel JLCent_vot;
    private javax.swing.JLabel JLCorre;
    private javax.swing.JLabel JLDirecc;
    private javax.swing.JLabel JLDirrec_fam1;
    private javax.swing.JLabel JLEscu_pro;
    private javax.swing.JLabel JLEsp_pro;
    private javax.swing.JLabel JLFec_cond;
    private javax.swing.JLabel JLMencion_esp;
    private javax.swing.JLabel JLNom_cond;
    private javax.swing.JLabel JLNom_fam1;
    private javax.swing.JLabel JLNom_pro;
    private javax.swing.JLabel JLParent_fam1;
    private javax.swing.JLabel JLTel_cas;
    private javax.swing.JLabel JLTel_celu;
    private javax.swing.JLabel JLTel_fam1;
    private javax.swing.JLabel JLTel_otro;
    private javax.swing.JLabel JLTel_trab;
    private javax.swing.JLabel JLUbic_cent;
    private javax.swing.JLabel JLnombreUSU;
    private javax.swing.JTextField JTApe_fam1;
    private javax.swing.JTextField JTCed_fam1;
    private javax.swing.JTextField JTEsp_pro;
    private javax.swing.JTextField JTFec_cond;
    private javax.swing.JTextField JTMencion_esp;
    private javax.swing.JTextField JTNom_cond;
    private javax.swing.JTextField JTNom_fam1;
    private javax.swing.JTextField JTTel_fam1;
    private javax.swing.JMenuItem Modi;
    private javax.swing.JMenuItem ModiArm;
    private javax.swing.JMenuItem ModiFami;
    private javax.swing.JMenuItem ModiProm;
    private javax.swing.JButton ModificarArma;
    private javax.swing.JButton ModificarFami;
    private javax.swing.JButton ModificarPerso;
    private javax.swing.JButton ModificarPromo;
    private javax.swing.JPanel PanelArma;
    private javax.swing.JPanel PanelFame;
    private javax.swing.JPanel PanelLoca;
    private javax.swing.JPanel PanelPerso;
    private javax.swing.JPanel PanelPromo;
    private javax.swing.JRadioButton RBtnNo;
    private javax.swing.JRadioButton RBtnSi;
    private javax.swing.JTabbedPane Registro;
    private javax.swing.JTable TBperson;
    private javax.swing.JTextArea TXAREOBSERVarm;
    private javax.swing.JTextField TXTSERFAM;
    private javax.swing.JTextArea TXTareDireFam;
    private javax.swing.JTextField TXTced;
    private javax.swing.JTextArea TxtAAlergia;
    private java.awt.Checkbox barras_cond;
    private javax.swing.JLabel globalVaria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField36;
    private java.awt.Checkbox placas_cond;
    private javax.swing.JScrollPane scrolpane;
    private javax.swing.JTextField tex_depe;
    private javax.swing.JTextArea tex_dirre;
    private javax.swing.JTextField tex_tel_casa;
    private javax.swing.JTextField tex_tel_ot;
    private javax.swing.JTextField texape;
    private javax.swing.JTextField texcedu;
    private javax.swing.JTextField texcorreo;
    private javax.swing.JTextField texescul;
    private javax.swing.JTextField texfec_nac;
    private javax.swing.JTextField texgrup_san;
    private javax.swing.JTextField texnom;
    private javax.swing.JTextField texnom_car;
    private javax.swing.JTextField texnom_pro;
    private javax.swing.JTextField texser;
    private javax.swing.JTextField texser_arm;
    private javax.swing.JTextField textcent_vot;
    private javax.swing.JTextField textel_cel;
    private javax.swing.JTextField textel_tra;
    private javax.swing.JTextField textipo;
    private javax.swing.JTextField textubic;
    private javax.swing.JTextField texubic_cent;
    // End of variables declaration//GEN-END:variables



Conectar cc=new Conectar();
Connection cn = cc.conexion();
    Auditoria auditar=  new Auditoria();

limpiar lim= new  limpiar();

}
