package Vista;

import Modelo.login;
import Modelo.loginDAO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    loginDAO login = new loginDAO();
    login lg = new login();
    
    public static String dato = "";
           
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        ojo_pass_1.setVisible(false);
        userField.setBackground(new java.awt.Color(0,0,0,1));
        passField.setBackground(new java.awt.Color(0,0,0,1));
        enter();
    }
    
    public void enter(){
        panelGeneral.setLayout(null);
        setContentPane(panelGeneral);
        panelGeneral.setFocusable(true);

        panelGeneral.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                    //Aqui no funcionara
            }
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btn_login.doClick();
                }
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }
            public void keyReleased(KeyEvent e){
                    
            }
        });
        userField.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                    //Aqui no funcionara
            }
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btn_login.doClick();
                }
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }
            public void keyReleased(KeyEvent e){
                    
            }
        });
        passField.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                    //Aqui no funcionara
            }
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btn_login.doClick();
                }
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }
            public void keyReleased(KeyEvent e){
                    
            }
        });
    }
    
    public void validar(){        
        String user = userField.getText();
        String pass = String.valueOf(passField.getPassword());
        String u = "central";
        String p = "centralizado";
        if (!"".equals(user) || !"".equals(pass)) {
            lg = login.log(user, pass);
            if (lg.getUser() != null && lg.getPass() != null) {
                PanelGeneral pg = new PanelGeneral();
                pg.setVisible(true);
                PanelGeneral.nombreEmp.setText(lg.getNameEmp());
                PanelGeneral.extTienda1.setText(String.valueOf(lg.getId()));
                this.dispose();
            } else if(u.equals(user) && p.equals(pass)){
                PanelGeneral pc = new PanelGeneral();
                pc.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar un usuario y contraseña válidos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos no deben estar vacíos.");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        logo_user = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        userField = new javax.swing.JTextField();
        logo_pass = new javax.swing.JLabel();
        pass = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        ojo_pass_1 = new javax.swing.JButton();
        ojo_pass_2 = new javax.swing.JButton();
        passField = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        cerrar = new javax.swing.JButton();
        minimizar = new javax.swing.JButton();
        registro = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGeneral.setBackground(new java.awt.Color(255, 255, 255));
        panelGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/user.png"))); // NOI18N
        panelGeneral.add(logo_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 30, 30));

        user.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setText("Usuario:");
        panelGeneral.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOpaque(true);
        panelGeneral.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 180, 3));

        userField.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        userField.setForeground(new java.awt.Color(255, 255, 255));
        userField.setBorder(null);
        userField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userFieldActionPerformed(evt);
            }
        });
        panelGeneral.add(userField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 170, 35));

        logo_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pass.png"))); // NOI18N
        panelGeneral.add(logo_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 30, 30));

        pass.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setText("Contraseña:");
        panelGeneral.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOpaque(true);
        panelGeneral.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 180, 3));

        ojo_pass_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ojo_2.png"))); // NOI18N
        ojo_pass_1.setBorder(null);
        ojo_pass_1.setBorderPainted(false);
        ojo_pass_1.setContentAreaFilled(false);
        ojo_pass_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ojo_pass_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ojo_pass_1MouseClicked(evt);
            }
        });
        panelGeneral.add(ojo_pass_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 20, 20));

        ojo_pass_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ojo_1.png"))); // NOI18N
        ojo_pass_2.setBorder(null);
        ojo_pass_2.setBorderPainted(false);
        ojo_pass_2.setContentAreaFilled(false);
        ojo_pass_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ojo_pass_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ojo_pass_2MouseClicked(evt);
            }
        });
        panelGeneral.add(ojo_pass_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 20, 20));

        passField.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        passField.setForeground(new java.awt.Color(255, 255, 255));
        passField.setBorder(null);
        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        panelGeneral.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 170, 35));

        btn_login.setBackground(new java.awt.Color(102, 102, 255));
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iniciar_sesion_1.png"))); // NOI18N
        btn_login.setBorder(null);
        btn_login.setBorderPainted(false);
        btn_login.setContentAreaFilled(false);
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_login.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iniciar_sesion_2.png"))); // NOI18N
        btn_login.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iniciar_sesion_2.png"))); // NOI18N
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        panelGeneral.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 140, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo_tenth.png"))); // NOI18N
        panelGeneral.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 60, 150, 80));

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar.png"))); // NOI18N
        cerrar.setBorder(null);
        cerrar.setBorderPainted(false);
        cerrar.setContentAreaFilled(false);
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar_2.png"))); // NOI18N
        cerrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar_2.png"))); // NOI18N
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        panelGeneral.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 20, 20));

        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/minimizar_1.png"))); // NOI18N
        minimizar.setBorder(null);
        minimizar.setBorderPainted(false);
        minimizar.setContentAreaFilled(false);
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        panelGeneral.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 20, 20));

        registro.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        registro.setForeground(new java.awt.Color(255, 255, 255));
        registro.setText("¿Eres nuevo? Regístrate.");
        registro.setFocusTraversalPolicyProvider(true);
        registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registroMouseClicked(evt);
            }
        });
        panelGeneral.add(registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 165, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondo.png"))); // NOI18N
        fondo.setAlignmentX(0.5F);
        panelGeneral.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 500));

        getContentPane().add(panelGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        validar();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private void userFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userFieldActionPerformed

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_cerrarMouseClicked

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        
    }//GEN-LAST:event_btn_loginMouseClicked

    private void registroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registroMouseClicked
        RegisterDialog rd = new RegisterDialog(this, true);
        rd.setVisible(true);
        
    }//GEN-LAST:event_registroMouseClicked

    private void ojo_pass_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ojo_pass_2MouseClicked
        passField.setEchoChar((char)0);
        ojo_pass_2.setVisible(false);
        ojo_pass_1.setVisible(true);
    }//GEN-LAST:event_ojo_pass_2MouseClicked

    private void ojo_pass_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ojo_pass_1MouseClicked
        passField.setEchoChar((char)42);
        ojo_pass_2.setVisible(true);
        ojo_pass_1.setVisible(false);
        
    }//GEN-LAST:event_ojo_pass_1MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton cerrar;
    private javax.swing.JLabel fondo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logo_pass;
    private javax.swing.JLabel logo_user;
    private javax.swing.JButton minimizar;
    private javax.swing.JButton ojo_pass_1;
    private javax.swing.JButton ojo_pass_2;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JLabel pass;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel registro;
    private javax.swing.JLabel user;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
