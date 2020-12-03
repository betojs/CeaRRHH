 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceaa;

import Objetos.fondo;
import Administrador.Adminn;
import Administrador.Adminn_usua;
import G14.IniG14;
import G18.IniG18;
import G19.IniG19;
import G7.IniG7;
import IniCea.IniCea;
import Objetos.ActualizaSituacion;
import Objetos.Auditoria;
import Objetos.Conectar;
import Objetos.usuarios;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.swing.JTextField;

/**
 *
 * @author Familia
 */
public class ingres extends javax.swing.JFrame {

    /**
     * Creates new form ingres
     */
    
    
    public String Us;
    
    public String Contraseña="";

    


    public ingres() {
        initComponents();
        this.setResizable(false);

          fondo imagen =new fondo();

          String imagenes=imagen.fond1();
          ((JPanel)getContentPane()).setOpaque(false);
          ImageIcon uno=new ImageIcon(this.getClass().getResource(imagenes));
          JLabel fondo= new JLabel(); 
          fondo.setIcon(uno);
          getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
          
          this.setLocationRelativeTo(null);
          fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
          
        ActualizaSituacion actuali = new ActualizaSituacion();
        actuali.Actualiza();
          
    }
    
    int a=0;
    
    @SuppressWarnings("UnusedAssignment")
    String acceder (String us, String pass) throws Exception{
    String usu="";
    String cont="";
    String accion="";
    String stat="";
    
    try{
       
        Statement s = cn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM usuario WHERE usu_us='"+us+"'");
        
        while (rs.next()){
        //rut.setText(rs.getString(1));
            
                usu=rs.getString("nivel_us");
                System.out.println(usu);
                cont=rs.getString("cont_us");
                System.out.println(cont);
                stat=rs.getString("status");
                   System.out.println(stat);     
            
            }
//Admin    roaRafael@gmail.com
        if((usu.equalsIgnoreCase("Admin")) && (cont.equalsIgnoreCase(pass)) && (stat.equalsIgnoreCase("Activo")) ){
        JOptionPane.showMessageDialog(null, "Bienvenido Administrador");
        Adminn ir = new Adminn();
        ir.setVisible(true);
        ir.setLocationRelativeTo(null);
   
        
        
        dispose();
         accion="Ingreso al Administrador";
        }
//CEA
        if((usu.equalsIgnoreCase("CEA")) && (cont.equalsIgnoreCase(pass)) && (stat.equalsIgnoreCase("Activo"))){
        JOptionPane.showMessageDialog(null, "Bienvenido CEA");
        IniCea  ir = new IniCea();
        ir.setVisible(true);
        ir.setLocationRelativeTo(null);
        dispose();
        accion="C.E.A.";
        
        }
//G14
                if((usu.equalsIgnoreCase("G14")) && (cont.equalsIgnoreCase(pass))&& (stat.equalsIgnoreCase("Activo"))){
       /* JOptionPane.showMessageDialog(null, "Bienvenido G14");
        IniG14 ir = new IniG14();
        ir.setVisible(true);
        ir.setLocationRelativeTo(null);
        dispose();
         accion="Grupo 14";*/
                    JOptionPane.showMessageDialog(null, "Actualmente No Disponible");
        }
//G7
        if(   (usu.equalsIgnoreCase("G7")) && (cont.equalsIgnoreCase(pass)) && (stat.equalsIgnoreCase("Activo")) ){
        JOptionPane.showMessageDialog(null, "Bienvenido G7");
        IniG7 ir = new IniG7();
        ir.setVisible(true);
        ir.setLocationRelativeTo(null);
        dispose();
         accion="Grupo 7";
        }
//G18
        if((usu.equalsIgnoreCase("G18")) && (cont.equalsIgnoreCase(pass))  && (stat.equalsIgnoreCase("Activo")) ){
       /* JOptionPane.showMessageDialog(null, "Bienvenido G18");
        IniG19 ir = new IniG19();
        ir.setVisible(true);
        ir.setLocationRelativeTo(null);
        dispose();
         accion="Grupo 18";*/
         JOptionPane.showMessageDialog(null, "Actualmente No Disponible");
        }
//G19
        if((usu.equalsIgnoreCase("G19")) && (cont.equalsIgnoreCase(pass))&& (stat.equalsIgnoreCase("Activo"))){
       /* JOptionPane.showMessageDialog(null, "Bienvenido G19");
        IniG18 ir = new IniG18();
        ir.setVisible(true);
        ir.setLocationRelativeTo(null);
        dispose();
        accion="Ingreso Grupo 19";*/
        JOptionPane.showMessageDialog(null, "Actualmente No Disponible");
        
        }
        
        if(stat.equalsIgnoreCase("Inactivo")){
            JOptionPane.showMessageDialog(this, "Su Usuario esta Inactivo");
        
        }
        
          
           
        if((!cont.equalsIgnoreCase(pass)) ){
        
        JOptionPane.showMessageDialog(this, "Contraseña o Uusuario invalidos");
       
       us=""; pass="";
        a++;
        if(a==3){
            JOptionPane.showMessageDialog(null, "Por seguridad Se Cerrara la Aplicación");
        System.exit(0);
        }
              
        }
        String campo=" ";
        auditar.auditoria(us, accion,campo);
        
    }catch(SQLException | HeadlessException e){
        System.out.println("Error Sql");
    }
        return accion;
    
    
    
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTUs = new javax.swing.JTextField();
        JLUs = new javax.swing.JLabel();
        JLCon = new javax.swing.JLabel();
        JTCon = new javax.swing.JPasswordField();
        CEA = new javax.swing.JLabel();
        Centr = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLUs1 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("C.E.A.");

        JLUs.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLUs.setText("Usuario:");

        JLCon.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLCon.setText("Contraseña:");

        CEA.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        CEA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CEA.setText("C.E.A.");

        Centr.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        Centr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Centr.setText("Centro de Entrenamiento Aéreo");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Sin título-1.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EA.png"))); // NOI18N

        JLUs1.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        JLUs1.setText("Version 1.2");

        jButton13.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton13.setText("Ingresar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton14.setText("Salir");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Centr, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                    .addComponent(CEA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLUs, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JLCon, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JTCon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTUs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JLUs1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CEA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Centr, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLUs))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLCon)
                            .addComponent(JTCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13)
                    .addComponent(jButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(JLUs1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JTextField getJTUs() {
        return JTUs;
    }


    usuarios enviar= new usuarios();

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
  Us=JTUs.getText();
        Contraseña= JTCon.getText();
        
     
        if((!Us.equalsIgnoreCase("")) && (!Us.equalsIgnoreCase(""))){
        
        try{
         acceder(Us, Contraseña);
      
         PreparedStatement pst =cn.prepareStatement("UPDATE variable SET usuario='"+JTUs.getText()+"' WHERE id='1'");
pst.executeUpdate();
        
        
        
        }catch(Exception e){
            System.out.println("error es: "+e);
        
        }
        }
        
      
          if(Contraseña.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Usuario y contraseña vacio");
        
        }
         else if(Contraseña.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Usuario y contraseña vacio");
        
        }
                
       
          
          
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_jButton14ActionPerformed

    /**
     * @param args the command line argumentsk
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
            java.util.logging.Logger.getLogger(ingres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ingres().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CEA;
    private javax.swing.JLabel Centr;
    private javax.swing.JLabel JLCon;
    private javax.swing.JLabel JLUs;
    private javax.swing.JLabel JLUs1;
    private javax.swing.JPasswordField JTCon;
    public javax.swing.JTextField JTUs;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables




Conectar cc=new Conectar();
Connection cn = cc.conexion();
    Auditoria auditar= new Auditoria();

    private void clearTxtField() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
