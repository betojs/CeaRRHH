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
import Objetos.Auditoria;
import Objetos.Conectar;
import Objetos.fondo;
import ceaa.ingres;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Familia
 */
public class Situacion extends javax.swing.JFrame {
    private Object JTUs;

    /**
     * Creates new form IniCea
     */
    public Situacion() {
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
         
           ingres usuarios = new ingres();
          String Usua=usuarios.Us;
          JLnombreUSU.setText(Usua);
         datos();
FECHA_SITUA();
pestañas.enable(false);

FECHA_SITUAPru();
        Nombre_situa();  
        
        
        Condicion();
        Nivel_Aca();
        cefa();
        BTN_save.setVisible(false);
         
    }
    
    public void datos(){
    
        
    Jcombox_prueb.addItem("");
    Jcombox_prueb.addItem("Fisica");
    Jcombox_prueb.addItem("Resistencia");
    Jcombox_prueb.addItem("Fisiologica");

        CMB_TIPO.addItem("");
        CMB_TIPO.addItem("Curso Militar");
        CMB_TIPO.addItem("Curso de Ascenso");
        CMB_TIPO.addItem("Otros");
        
        
        
        
    Jcomb_resul.addItem("");
    Jcomb_resul.addItem("Aprobado");
    Jcomb_resul.addItem("Reprobado");
        

    }
    
    
    void mostrarPrueba(String valor){
    
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Cedula");
    model.addColumn("Nombre");
    model.addColumn("Resultado");
    
    model.addColumn("Observacion");
    model.addColumn("Fecha");
    model.addColumn("Fecha de Vencimiento");
    TBPRU.setModel(model);
    String sql="";
    if(valor.equals("")){
    
    sql="SELECT * FROM prueba"; 
    
    }
    else{
    sql="SELECT * FROM prueba WHERE id_pru='"+valor+"'";
    
    }
        
    String []dato = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            dato[0]=rs.getString(2);
            dato[1]=rs.getString(3);
            dato[2]=rs.getString(4); 
            dato[3]=rs.getString(5);
            dato[4]=rs.getString(6);
            dato[5]=rs.getString(7);
            
               
            model.addRow(dato);
            }
            TBPRU.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex+"  es aca");
           
        }

    
    
    }
    
    void mostrarCurso(String valor){
    
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Cedula");
    model.addColumn("Tipo Curso");
    model.addColumn("Nombre");
    
    model.addColumn("Instituto");
    model.addColumn("Duracion");
    model.addColumn("Desde");
    model.addColumn("Hasta");
    TB_Cursos.setModel(model);
    String sql="";
    if(valor.equals("")){
    
    sql="SELECT * FROM cursos"; 
    
    }
    else{
    sql="SELECT * FROM cursos WHERE ced_per='"+valor+"'";
    
    }
        
    String []dato = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            dato[0]=rs.getString(2);
            dato[1]=rs.getString(3);
            dato[2]=rs.getString(4); 
            dato[3]=rs.getString(5);
            dato[4]=rs.getString(6);
            dato[5]=rs.getString(7);
            dato[6]=rs.getString(8);
               
            model.addRow(dato);
            }
            TB_Cursos.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex+"  es aca");
           
        }

    
    
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
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JLnombreUSU = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pestañas = new javax.swing.JTabbedPane();
        panelsit = new javax.swing.JPanel();
        jCon_status = new javax.swing.JComboBox();
        JTDescrip_sit = new javax.swing.JTextField();
        JLDescrip_sit = new javax.swing.JLabel();
        JLStat_sit = new javax.swing.JLabel();
        JLFec_fin_sit = new javax.swing.JLabel();
        JTUbic_sit = new javax.swing.JTextField();
        JLUbic_sit = new javax.swing.JLabel();
        JLNom_sit = new javax.swing.JLabel();
        JLFec_inic_sit = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        CMB_nomSit = new javax.swing.JComboBox();
        CMB_FEINI = new javax.swing.JComboBox();
        CMB_FEFI = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        JLSex = new javax.swing.JLabel();
        JLEst_civ = new javax.swing.JLabel();
        Jcombox_prueb = new javax.swing.JComboBox();
        JLGrup_sang = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        JtAreObs = new javax.swing.JTextArea();
        Jcomb_resul = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        TBPRU = new javax.swing.JTable();
        jButton29 = new javax.swing.JButton();
        JLFec_inic_sit1 = new javax.swing.JLabel();
        CMB_FEINIPru = new javax.swing.JComboBox();
        JLFec_fin_sit1 = new javax.swing.JLabel();
        CMB_FEFIpru = new javax.swing.JComboBox();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        JTmencion = new javax.swing.JTextField();
        JTaño = new javax.swing.JTextField();
        JTesp = new javax.swing.JTextField();
        JCombnivel = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        JTinsti = new javax.swing.JTextField();
        Jcombcefa = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        Jcombpericia = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        TBespe = new javax.swing.JTable();
        jButton28 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        CMB_CONDICION = new javax.swing.JComboBox();
        jPanel10 = new javax.swing.JPanel();
        JTnom_cur = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        JTdura = new javax.swing.JTextField();
        JTfec_fini = new javax.swing.JTextField();
        JTinst = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        JTfec_ini = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_Cursos = new javax.swing.JTable();
        BtnCusrMili = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        CMB_TIPO = new javax.swing.JComboBox();
        BTN_save = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        JTNom = new javax.swing.JTextField();
        JLNom = new javax.swing.JLabel();
        JLCed = new javax.swing.JLabel();
        JTCed = new javax.swing.JTextField();
        JLApe = new javax.swing.JLabel();
        JTApe = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
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

        jLabel11.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("C.E.A");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        JLnombreUSU.setText(".");

        jLabel10.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel10.setText("jLabel8");

        jLabel13.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel13.setText("Fecha:");

        jLabel9.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel9.setText("jLabel7");

        jLabel21.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel21.setText("Hora:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JLnombreUSU, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)
                            .addComponent(jLabel21)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(JLnombreUSU, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pestañas.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N

        jCon_status.setFont(new java.awt.Font("Traditional Arabic", 1, 10)); // NOI18N
        jCon_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Activo", "Inactivo" }));
        jCon_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCon_statusActionPerformed(evt);
            }
        });

        JLDescrip_sit.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLDescrip_sit.setText("Descripción:");

        JLStat_sit.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLStat_sit.setText("Status:");

        JLFec_fin_sit.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLFec_fin_sit.setText("Fecha de Finalización:");

        JLUbic_sit.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLUbic_sit.setText("Ubicación:");

        JLNom_sit.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLNom_sit.setText("Nombre de la Situación:");

        JLFec_inic_sit.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLFec_inic_sit.setText("Fecha de Inicio:");

        jButton27.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton27.setText("Registrar");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelsitLayout = new javax.swing.GroupLayout(panelsit);
        panelsit.setLayout(panelsitLayout);
        panelsitLayout.setHorizontalGroup(
            panelsitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsitLayout.createSequentialGroup()
                .addGroup(panelsitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelsitLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(JLNom_sit)
                        .addGap(0, 0, 0)
                        .addComponent(CMB_nomSit, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelsitLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(JLUbic_sit)
                        .addGap(2, 2, 2)
                        .addComponent(JTUbic_sit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelsitLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(JLFec_inic_sit)
                        .addGap(2, 2, 2)
                        .addComponent(CMB_FEINI, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(panelsitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelsitLayout.createSequentialGroup()
                        .addComponent(JLFec_fin_sit)
                        .addGap(4, 4, 4)
                        .addComponent(CMB_FEFI, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelsitLayout.createSequentialGroup()
                        .addGroup(panelsitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLDescrip_sit)
                            .addComponent(JLStat_sit))
                        .addGap(10, 10, 10)
                        .addGroup(panelsitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTDescrip_sit, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCon_status, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelsitLayout.createSequentialGroup()
                .addComponent(jButton27)
                .addContainerGap())
        );
        panelsitLayout.setVerticalGroup(
            panelsitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton27)
                .addGap(18, 18, 18)
                .addGroup(panelsitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLNom_sit)
                    .addComponent(JLDescrip_sit)
                    .addGroup(panelsitLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelsitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CMB_nomSit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTDescrip_sit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panelsitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelsitLayout.createSequentialGroup()
                        .addGroup(panelsitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLUbic_sit)
                            .addComponent(JLStat_sit)
                            .addGroup(panelsitLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(JTUbic_sit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelsitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLFec_inic_sit)
                            .addGroup(panelsitLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(panelsitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CMB_FEINI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLFec_fin_sit)
                                    .addGroup(panelsitLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(CMB_FEFI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jCon_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(188, 188, 188))
        );

        pestañas.addTab("Situacion", panelsit);

        JLSex.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLSex.setText("Tipo de prueba:");

        JLEst_civ.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLEst_civ.setText("Resultado:");

        Jcombox_prueb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcombox_pruebActionPerformed(evt);
            }
        });

        JLGrup_sang.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLGrup_sang.setText("Observaciones:");

        JtAreObs.setColumns(20);
        JtAreObs.setRows(5);
        jScrollPane8.setViewportView(JtAreObs);

        Jcomb_resul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcomb_resulActionPerformed(evt);
            }
        });

        TBPRU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(TBPRU);

        jButton29.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton29.setText("Registrar");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        JLFec_inic_sit1.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLFec_inic_sit1.setText("Fecha de Inicio:");

        JLFec_fin_sit1.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLFec_fin_sit1.setText("Fecha de Finalización:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane8)
                        .addGap(145, 145, 145))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton29)
                            .addComponent(JLGrup_sang))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(JLSex)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Jcombox_prueb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JLEst_civ)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Jcomb_resul, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(JLFec_inic_sit1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CMB_FEINIPru, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JLFec_fin_sit1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CMB_FEFIpru, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLSex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLEst_civ))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jcombox_prueb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jcomb_resul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLFec_inic_sit1)
                    .addComponent(JLFec_fin_sit1)
                    .addComponent(CMB_FEINIPru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMB_FEFIpru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLGrup_sang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pestañas.addTab("Prueba", jPanel2);

        jTabbedPane2.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel14.setText("Mención:");

        jLabel15.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel15.setText(" Cefa:");

        jLabel16.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel16.setText("Especialidad:");

        jLabel17.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel17.setText("Nivel:");

        jLabel18.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel18.setText("Año:");

        JTaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTañoActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel24.setText("Instituto:");

        JTinsti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTinstiActionPerformed(evt);
            }
        });

        Jcombcefa.setToolTipText("");

        jLabel27.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel27.setText("Nivel de Pericia");

        Jcombpericia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Avanzado", "Medio", "Bajo" }));

        TBespe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Especialidad", "Mencion", "Instituto", "Año", "Cefa", "Pericia", "Nivel"
            }
        ));
        jScrollPane4.setViewportView(TBespe);

        jButton28.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton28.setText("Registrar");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel20.setText("Condicion:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton28))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
                .addGap(14, 14, 14))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel27)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTmencion)
                    .addComponent(CMB_CONDICION, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jcombcefa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jcombpericia, 0, 107, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTesp, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(JCombnivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTaño)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTinsti, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton28)
                .addGap(9, 9, 9)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMB_CONDICION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(JCombnivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(JTinsti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel24)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTmencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(Jcombcefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(Jcombpericia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Especialidad", jPanel9);

        jLabel19.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel19.setText("Instituto:");

        JTinst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTinstActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel22.setText("Duración:");

        jLabel23.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel23.setText("Nombre de Curso:");

        jLabel25.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel25.setText("Fecha de Finalización:");

        jLabel26.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel26.setText("Fecha de Inicio:");

        TB_Cursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Instituto", "Nombre", "Duracion", "Fecha inicio", "Finalizacion"
            }
        ));
        jScrollPane1.setViewportView(TB_Cursos);

        BtnCusrMili.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        BtnCusrMili.setText("Resgitrar");
        BtnCusrMili.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCusrMiliActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel39.setText("Tipo de Curso:");

        BTN_save.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        BTN_save.setText("Guardar");
        BTN_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTinst, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTnom_cur, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTdura, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTfec_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTfec_fini, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CMB_TIPO, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(200, 200, 200)
                                .addComponent(BTN_save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnCusrMili)))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMB_TIPO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCusrMili)
                    .addComponent(BTN_save))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTinst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTnom_cur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTdura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTfec_ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25)
                        .addComponent(JTfec_fini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Cursos", jPanel10);

        pestañas.addTab("Estudios", jTabbedPane2);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));

        JTNom.setEditable(false);

        JLNom.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLNom.setText("Nombre:");

        JLCed.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLCed.setText("Cedula:");

        JTCed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTCedActionPerformed(evt);
            }
        });

        JLApe.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLApe.setText("Apellido:");

        JTApe.setEditable(false);

        jButton1.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLCed)
                    .addComponent(JLApe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JTApe, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTCed, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JLNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JTNom, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(120, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLCed)
                    .addComponent(JTCed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLApe)
                    .addComponent(JTApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLNom)
                    .addComponent(JTNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pestañas, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(39, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 43, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pestañas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:

   
        dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void JTCedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTCedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTCedActionPerformed

    private void jCon_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCon_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCon_statusActionPerformed

    void nombreSit(){
    
    CMB_nomSit.addItem("");
    
    CMB_nomSit.addItem("Reposo");
    
    CMB_nomSit.addItem("Comision");
    
    CMB_nomSit.addItem("Vacaciones");
    
    CMB_nomSit.addItem("");
    
    CMB_nomSit.addItem("");
    
    CMB_nomSit.addItem("");
    
    CMB_nomSit.addItem("");
    
    CMB_nomSit.addItem("");
    
    
    }
    
    
    
    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        

        try {

          
            
            PreparedStatement pst= cn.prepareStatement("INSERT INTO situacion ("
                    + "ced_per,"
                    + "nombre,"
                    + "descripcion,"
                    + "ubic_sit,"
                    + "fecha_ini_sit,"
                    + "fecha_fin_sit,"
                    + "status)VALUE(?,?,?,?,?,?,?)");

       int ced= Integer.parseInt(JTCed.getText());
            pst.setInt(1, ced);
            String selec=(String)CMB_nomSit.getSelectedItem();
           
            pst.setString(2, selec);
            pst.setString(3, JTDescrip_sit.getText());
            pst.setString(4, JTUbic_sit.getText());
            
            String sel_fechaIni =(String)CMB_FEINI.getSelectedItem();
            String sel_fechaFin =(String)CMB_FEFI.getSelectedItem();            
            pst.setString(5, sel_fechaIni);
            pst.setString(6, sel_fechaFin  );
       
           
      
            String sele=(String)jCon_status.getSelectedItem();
           
            pst.setString(7, sele);
           
            pst.executeUpdate();

            
            
            if( cn==null){
                JOptionPane.showMessageDialog(null, "Error en el Registro");}
            else{JOptionPane.showMessageDialog(null, "Registrado");
            
         
            //auditoria de este boton
            
            try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM variable WHERE id='1'");
            
            String usu="";
            
            while(rs.next()){
             usu=rs.getString(2);
            }
            
          
            String accion="Registro Nuevo situacion";
            System.out.println(usu);
            auditar.auditoria(usu, accion, JTCed.getText() );
            
            
        }catch(Exception e){
        
        System.out.println("auditoria"+e);
        }
            
            
            }
        } catch (SQLException | HeadlessException e) {
            System.out.println(e+ " fffff");
            JOptionPane.showMessageDialog(null, "ERRor de registro");
            System.err.println(e.getMessage());
        }

       
    }//GEN-LAST:event_jButton27ActionPerformed

    
    void Condicion () {
    
    CMB_CONDICION.addItem("");
    CMB_CONDICION.addItem("Instructor");
    CMB_CONDICION.addItem("Alumno");
    CMB_CONDICION.addItem("Tecnico");
  
    
    }
    
    void Nivel_Aca(){
    
    
    
    JCombnivel.addItem("");
        JCombnivel.addItem("TSU");
            JCombnivel.addItem("Lic/Ing");
                JCombnivel.addItem("Especialista");
                    JCombnivel.addItem("Magister");
                        JCombnivel.addItem("Doctorado");
                            
                        
    }
    
    
    void cefa(){
    
    
    Jcombcefa.addItem("");
        Jcombcefa.addItem("Tecnico 3");
            Jcombcefa.addItem("Espescialista 5");
                Jcombcefa.addItem("Avanzado 7");
                    Jcombcefa.addItem("Superintendente 0");
    
    
    
    }
    
    
    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
         
         try {

            
            PreparedStatement pst1= cn.prepareStatement("INSERT INTO prueba ("
                    + "ced_per,"
                    + "nom_pru,"
                    + "resul_per,"
                    + "observacion,"
                    + "fecha_ini_rper,"
                    + "fech_venc_rper)VALUE(?,?,?,?,?,?)");
            
            
            pst1.setString(1, JTCed.getText());
            String sele=(String)Jcombox_prueb.getSelectedItem();
           
            
           
           pst1.setString(2,sele);
           
           String sel=(String)Jcomb_resul.getSelectedItem();
            
           pst1.setString(3, sel);
           
           
           pst1.setString(4, JtAreObs.getText());
           
           
           Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        
           
           
           pst1.setString(5, date.format(now) );
           
           pst1.setString(6, date.format(now));
           
            pst1.executeUpdate();
            
            
            if( cn==null){
                JOptionPane.showMessageDialog(null, "Error en el Registro");}
            else{JOptionPane.showMessageDialog(null, "Registrado");
            
         
            //auditoria de este boton
            
            try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM variable WHERE id='1'");
            
            String usu="";
            
            while(rs.next()){
             usu=rs.getString(2);
            }
            
          
            String accion="Registro Nueva prueba";
            System.out.println(usu);
            auditar.auditoria(usu, accion, JTCed.getText() );
            
            
        }catch(Exception e){
        
        System.out.println("auditoria"+e);
        }
            
            
            }
        } catch (SQLException | HeadlessException e) {
            System.out.println(e+ " fffff");
            JOptionPane.showMessageDialog(null, "ERRor de registro");
            System.err.println(e.getMessage());
        }

       
    }                                         

    {      
    }//GEN-LAST:event_jButton29ActionPerformed

    
    
    
    
    
    private void Jcomb_resulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcomb_resulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jcomb_resulActionPerformed

    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////7
    //////////////////////////////////////////////////////////////////////////////////////////7
    /////////////////////////////////////////////////////////////////////
    
    
    public void MostrarEspe(String Dato){
    
    
    /// ACA VAS CAMBIAR LOS BOMBRES DE LOS CAMPOS QUE SE MOSTRARAN EN LA TABLA 
        //(VAN EN ESE ORDEN DESDE EL PRIMERO AL ULTIMO
    
     DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Cedula");
    model.addColumn("Condicion");    
    model.addColumn("Nomnre");
    model.addColumn("Mencion");
    model.addColumn("Nivel");
        model.addColumn("cefa");
    model.addColumn("Año");

    model.addColumn("nivel de pericia");

model.addColumn("instituto");
TBespe.setModel(model);
    
    // ACA ES DONDE HACE LA BUSQUEDA (SI DATO ES VACIO ("") MUESTRA TODO
    //SI TIENE UUN DATO (QUE SERIA LA CEDULA) MUESTRA SOLO EL REGISTRO DONDE APAREZCA LA CEDULA
    
    
    String sql="";
    if(Dato.equals("")){
    
    sql="SELECT * FROM especialidad"; 
    }
    else{
    sql="SELECT * FROM especialidad WHERE ced_per='"+Dato+"'";
    
    }
    ///ACA ASIGNAS LOS VALORES EN CADA UNO DE LOS CAMPOS DE LA TABLA DEL FORMULARIO
    String []dato = new String[9];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            dato[0]=rs.getString(2);
            dato[1]=rs.getString(3);
            dato[2]=rs.getString(4);
            dato[3]=rs.getString(5);
            dato[4]=rs.getString(6);
            dato[5]=rs.getString(7);
            dato[6]=rs.getString(8);
            dato[7]=rs.getString(9);
            dato[8]=rs.getString(10);
            model.addRow(dato);
            }
            TBespe.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex+"  es aca");
           
        }



    
    }

    
    
    
    void FECHA_SITUAPru(){

Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("d-MM-yyyy");
        
        String dato = date.format(now);
        
        System.out.println(dato);
        int a, b=0, c=0, i=0;
        
        CMB_FEINIPru.addItem("");
                     CMB_FEFIpru.addItem("");
        
          
                                   

                        

                        for(a=1; a<13;a++){

                    for(c=1;c<32;c++){
                            
                     CMB_FEINIPru .addItem(c+"-"+a+"-2015");
                     CMB_FEFIpru.addItem(c+"-"+a+"-2015");
                     
                     
                       }
                    }}


    
    
    
    
    
    
    
    
    void FECHA_SITUA(){

Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("d-MM-yyyy");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        
        String dato = date.format(now);
        
        System.out.println(dato);
        int a, b=0, c=0, i=0;
        
        CMB_FEINI.addItem("");
                     CMB_FEFI.addItem("");
        for(i=01;i<32;i++){
            String dia=String.valueOf(i);
                                    if(dato.equals(dia+"-01-2015")){

                        System.out.println("Enero");

                        for(a=1; a<13;a++){

                    for(c=i;c<32;c++){

                     CMB_FEINI.addItem(c+"-"+a+"-2015");
                     CMB_FEFI.addItem(c+"-"+a+"-2015");
                     
                     
                       }
                    }


                    }
                                    if(dato.equals(dia+"-02-2015")){

                        System.out.println("Febrero");

                        for(a=2; a<13;a++){

                    for(c=i;c<32;c++){

                     CMB_FEINI.addItem(c+"-"+a+"-2015");
                     CMB_FEFI.addItem(c+"-"+a+"-2015");
                    }
                    }


                    }
                                    if(dato.equals(dia+"-03-2015")){

                        System.out.println("Marzo");

                        for(a=3; a<13;a++){

                    for(c=i;c<32;c++){

                     CMB_FEINI.addItem(c+"-"+a+"-2015");
                                         CMB_FEFI.addItem(c+"-"+a+"-2015");
                    }
                    }


                    }
                        if(dato.equals(dia+"-04-2015")){

                        System.out.println("aril");

                        for(a=4; a<13;a++){

                    for(c=i;c<32;c++){

                     CMB_FEINI.addItem(c+"-"+a+"-2015");
                                         CMB_FEFI.addItem(c+"-"+a+"-2015");
                    }
                    }


                    }
                        if(dato.equals(dia+"-05-2015")){

                        System.out.println("mayo");

                        for(a=5; a<13;a++){

                    for(c=i;c<32;c++){

                     CMB_FEINI.addItem(c+"-"+a+"-2015");
                                         CMB_FEFI.addItem(c+"-"+a+"-2015");
                    }
                    }


                    }
                        if(dato.equals(dia+"-06-2015")){

                        System.out.println("junio");

                        for(a=6; a<13;a++){

                    for(c=i;c<32;c++){

                     CMB_FEINI.addItem(c+"-"+a+"-2015");
                                         CMB_FEFI.addItem(c+"-"+a+"-2015");
                    }
                    }


                    }
                        if(dato.equals(dia+"-07-2015")){

                        System.out.println("julio");

                        for(a=7; a<13;a++){

                    for(c=i;c<32;c++){

                     CMB_FEINI.addItem(c+"-"+a+"-2015");
                                         CMB_FEFI.addItem(c+"-"+a+"-2015");
                    }
                    }


                    }
                        if(dato.equals(dia+"-08-2015")){

                        System.out.println("agosto");

                        for(a=8; a<13;a++){

                    for(c=i;c<32;c++){

                     CMB_FEINI.addItem(c+"-"+a+"-2015");
                                         CMB_FEFI.addItem(c+"-"+a+"-2015");
                    }
                    }


                    }

                        if(dato.equals(dia+"-09-2015")){

                        System.out.println("septiembre");

                        for(a=9; a<13;a++){

                    for(c=i;c<32;c++){

                     CMB_FEINI.addItem(c+"-"+a+"-2015");
                                         CMB_FEFI.addItem(c+"-"+a+"-2015");
                    }
                    }

                    }
                        if(dato.equals(dia+"-10-2015")){

                        System.out.println("Octubre");

                        for(a=10; a<13;a++){

                    for(c=i;c<32;c++){

                     CMB_FEINI.addItem(c+"-"+a+"-2015");
                     CMB_FEFI.addItem(c+"-"+a+"-2015");                    
                    }
                    }


                    }


                    if(dato.equals(dia+"-11-2015")){

                        System.out.println("Noviembre");

                        for(a=11; a<13;a++){

                    for(c=i;c<32;c++){

                     CMB_FEINI.addItem(c+"-"+a+"-2015");
                     CMB_FEFI.addItem(c+"-"+a+"-2015");
                    }
                    }

                    if(dato.equals(dia+"-12-2015")){

                        System.out.println("Diciembre");

                        for(a=12; a<13;a++){

                    for(c=i;c<32;c++){

                     CMB_FEINI.addItem(c+"-"+a+"-2015");
                    
                    }
                    }

                    }else {System.out.println("NO ENTRO"+dia);}
        
        }
}
    }
    
    
    void Nombre_situa(){
    
    CMB_nomSit.addItem("");
    
    CMB_nomSit.addItem("Presente");
    
    CMB_nomSit.addItem("Exceptuado");
    
    CMB_nomSit.addItem("Guardia");
    
    CMB_nomSit.addItem("Reposo");
    
    CMB_nomSit.addItem("Permiso");
    
    CMB_nomSit.addItem("Vacaciones");
    
    CMB_nomSit.addItem("Retardado");
    
    CMB_nomSit.addItem("Presunto Desestor");
    
    
    CMB_nomSit.addItem("curso 'Pais");
    
    CMB_nomSit.addItem("Destado");
    
    CMB_nomSit.addItem("Curso Exterior");
    
    CMB_nomSit.addItem("Hozpitalizado");
    
    CMB_nomSit.addItem("Otro");
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        
        String valor= JTCed.getText();
        String sql="";
    sql="SELECT * FROM personal WHERE ced_per='"+valor+"'";
    
     String []dato = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            dato[0]=rs.getString(2);
            dato[1]=rs.getString(3);
           
           
            }
            JTNom.setText(dato[0]);
            JTApe.setText(dato[1]);
            
            
        } catch (SQLException ex) {
            System.out.println(ex+"  es aca");
           
        }
        MostrarEspe(JTCed.getText());
        
        
        
        String datos="";
        try{
        Statement s = cn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM prueba WHERE ced_per='"+JTCed.getText()+"'");
    
         while (rs.next()){
        datos=rs.getString("id_pru");
            System.out.println(datos);}}
         catch(Exception e){}
        mostrarPrueba(datos);
       mostrarCurso(JTCed.getText());

        
pestañas.enable(true);
panelsit.enable(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Jcombox_pruebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcombox_pruebActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jcombox_pruebActionPerformed

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

    private void BtnCusrMiliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCusrMiliActionPerformed
        // TODO add your handling code here:

        try {

            PreparedStatement pst= cn.prepareStatement("INSERT INTO cursos ("

                + "ced_per,"
                + "tipo,"
                + "nombre,"
                + "instituto,"
                + "duracion,"
                + "desde,"
                + "hasta)VALUE(?,?,?,?,?,?,?)");

            pst.setString(1, JTCed.getText());

            
            String tipo=(String)CMB_TIPO.getSelectedItem();
            pst.setString(2, tipo);

            pst.setString(3, JTnom_cur.getText());
            pst.setString(4, JTinst.getText());
            pst.setString(5, JTdura.getText());

            pst.setString(6, JTfec_ini.getText());

            pst.setString(7, JTfec_fini.getText());

            pst.executeUpdate();

            if( cn==null){
                JOptionPane.showMessageDialog(null, "Error en el Registro");}
            else{JOptionPane.showMessageDialog(null, "Registrado");

                //auditoria de este boton

                try{
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM variable WHERE id='1'");

                    String usu="";

                    while(rs.next()){
                        usu=rs.getString(2);
                    }

                    String accion="Registro Nuevo Curso Militar";
                    System.out.println(usu);
                    auditar.auditoria(usu, accion, JTCed.getText() );

                }catch(Exception e){

                    System.out.println("auditoria"+e);
                }

            }
        } catch (SQLException | HeadlessException e) {
            System.out.println(e+ " fffff");
            JOptionPane.showMessageDialog(null, "ERRor de registro");
            System.err.println(e.getMessage());
        }
            mostrarCurso(JTCed.getText());

    }//GEN-LAST:event_BtnCusrMiliActionPerformed

    private void JTinstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTinstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTinstActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        try {

            PreparedStatement pst= cn.prepareStatement("INSERT INTO especialidad ("
                + "ced_per,"
                + "condicion,"
                + "nom_esp,"
                + "menc_esp,"
                + "nivel,"
                + "cefa,"
                + "año,"
                + "nivelperi,"
                + "instituto"
                + ")VALUE(?,?,?,?,?,?,?,?,?)");

            pst.setString(1, JTCed.getText());
            String condi=(String)CMB_CONDICION.getSelectedItem();
            pst.setString(2, condi);
            pst.setString(3, JTesp.getText());

            pst.setString(4, JTmencion.getText());

            String nivel=(String)JCombnivel.getSelectedItem();
            pst.setString(5, nivel);

            String cefa=(String)Jcombcefa.getSelectedItem();
            pst.setString(6, cefa);
            pst.setString(7, JTaño.getText());

            String Nivperi=(String)Jcombpericia.getSelectedItem();
            pst.setString(8, Nivperi);

            pst.setString(9, JTinsti.getText());

            String sele=(String)JCombnivel.getSelectedItem();

            pst.setString(6, sele);

            String sel=(String)Jcombpericia.getSelectedItem();

            pst.setString(7, sel);

            pst.executeUpdate();

            if( cn==null){
                JOptionPane.showMessageDialog(null, "Error en el Registro");}
            else{JOptionPane.showMessageDialog(null, "Registrado");

                //auditoria de este boton

                try{
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM variable WHERE id='1'");

                    String usu="";

                    while(rs.next()){
                        usu=rs.getString(2);
                    }

                    String accion="Registro Nuevo especialidad";
                    System.out.println(usu);
                    auditar.auditoria(usu, accion, JTCed.getText() );

                }catch(Exception e){

                    System.out.println("auditoria"+e);
                }

            }
        } catch (SQLException | HeadlessException e) {
            System.out.println(e+ " fffff");
            JOptionPane.showMessageDialog(null, "ERRor de registro");
            System.err.println(e.getMessage());
        }
        MostrarEspe(JTCed.getText());

    }//GEN-LAST:event_jButton28ActionPerformed

    private void JTinstiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTinstiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTinstiActionPerformed

    private void JTañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTañoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTañoActionPerformed

    private void BTN_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_saveActionPerformed
        // TODO add your handling code here:
        
        
        
        
        
        
        
        
        
        
        mostrarCurso(JTCed.getText());
    }//GEN-LAST:event_BTN_saveActionPerformed

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
            java.util.logging.Logger.getLogger(Situacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Situacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Situacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Situacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            @Override
            public void run() {
                new Situacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_save;
    private javax.swing.JButton BtnCusrMili;
    private javax.swing.JLabel CEA;
    private javax.swing.JComboBox CMB_CONDICION;
    private javax.swing.JComboBox CMB_FEFI;
    private javax.swing.JComboBox CMB_FEFIpru;
    private javax.swing.JComboBox CMB_FEINI;
    private javax.swing.JComboBox CMB_FEINIPru;
    private javax.swing.JComboBox CMB_TIPO;
    private javax.swing.JComboBox CMB_nomSit;
    private javax.swing.JLabel Centr;
    private javax.swing.JComboBox JCombnivel;
    private javax.swing.JLabel JLApe;
    private javax.swing.JLabel JLCed;
    private javax.swing.JLabel JLDescrip_sit;
    private javax.swing.JLabel JLEst_civ;
    private javax.swing.JLabel JLFec_fin_sit;
    private javax.swing.JLabel JLFec_fin_sit1;
    private javax.swing.JLabel JLFec_inic_sit;
    private javax.swing.JLabel JLFec_inic_sit1;
    private javax.swing.JLabel JLGrup_sang;
    private javax.swing.JLabel JLNom;
    private javax.swing.JLabel JLNom_sit;
    private javax.swing.JLabel JLSex;
    private javax.swing.JLabel JLStat_sit;
    private javax.swing.JLabel JLUbic_sit;
    private javax.swing.JLabel JLnombreUSU;
    private javax.swing.JTextField JTApe;
    private javax.swing.JTextField JTCed;
    private javax.swing.JTextField JTDescrip_sit;
    private javax.swing.JTextField JTNom;
    private javax.swing.JTextField JTUbic_sit;
    private javax.swing.JTextField JTaño;
    private javax.swing.JTextField JTdura;
    private javax.swing.JTextField JTesp;
    private javax.swing.JTextField JTfec_fini;
    private javax.swing.JTextField JTfec_ini;
    private javax.swing.JTextField JTinst;
    private javax.swing.JTextField JTinsti;
    private javax.swing.JTextField JTmencion;
    private javax.swing.JTextField JTnom_cur;
    private javax.swing.JComboBox Jcomb_resul;
    private javax.swing.JComboBox Jcombcefa;
    private javax.swing.JComboBox Jcombox_prueb;
    private javax.swing.JComboBox Jcombpericia;
    private javax.swing.JTextArea JtAreObs;
    private javax.swing.JTable TBPRU;
    private javax.swing.JTable TB_Cursos;
    private javax.swing.JTable TBespe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JComboBox jCon_status;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel panelsit;
    private javax.swing.JTabbedPane pestañas;
    // End of variables declaration//GEN-END:variables


Conectar cc=new Conectar();
Connection cn = cc.conexion();
    Auditoria auditar= new Auditoria();


}
