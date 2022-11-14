package Paneles;

import Modelo.Empleados;
import Modelo.EmpleadosDAO;
import javax.swing.JOptionPane;

public class RegistroJornada extends javax.swing.JPanel {
    
    EmpleadosDAO empds = new EmpleadosDAO();
    Empleados em = new Empleados();

    public RegistroJornada() {
        initComponents();
        ojo_pass_1.setVisible(false);
        dniField.setBackground(new java.awt.Color(0,0,0,1));
        passField.setBackground(new java.awt.Color(0,0,0,1));
        panel.setVisible(false);
    }
    
     
    public void inicioSesion(){        
        String dni = dniField.getText();
        String pass = String.valueOf(passField.getPassword());
        if (!"".equals(dni) || !"".equals(pass)) {
            em = empds.login(dni, pass);
            if (em.getDni() != null && em.getPass() != null) {
                panel.setVisible(true);
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

        user1 = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        logo_user = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        dniField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        pass = new javax.swing.JLabel();
        logo_pass = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        ojo_pass_2 = new javax.swing.JButton();
        ojo_pass_1 = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        entradaTxt = new javax.swing.JLabel();
        registroEntradaBtn = new javax.swing.JButton();
        salidaTxt = new javax.swing.JLabel();
        registroSalidaBtn = new javax.swing.JButton();

        user1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        user1.setForeground(new java.awt.Color(255, 255, 255));
        user1.setText("DNI:");

        setBackground(new java.awt.Color(121, 177, 202));
        setPreferredSize(new java.awt.Dimension(550, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fechaLabel.setFont(new java.awt.Font("Decker", 1, 16)); // NOI18N
        fechaLabel.setForeground(new java.awt.Color(255, 255, 255));
        fechaLabel.setText("Ingrese DNI y contraseña para registrar la jornada:");
        add(fechaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        user.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setText("DNI:");
        add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        logo_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/user.png"))); // NOI18N
        add(logo_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 30, 30));

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
        add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 140, -1));

        dniField.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        dniField.setBorder(null);
        dniField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniFieldActionPerformed(evt);
            }
        });
        add(dniField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 170, 35));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOpaque(true);
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 118, 180, -1));

        pass.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setText("Contraseña:");
        add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        logo_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pass.png"))); // NOI18N
        add(logo_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 30, 30));

        passField.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        passField.setBorder(null);
        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 170, 35));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOpaque(true);
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 180, -1));

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
        add(ojo_pass_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 20, 20));

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
        add(ojo_pass_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 20, 20));

        panel.setBackground(new java.awt.Color(121, 177, 202));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        entradaTxt.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        entradaTxt.setForeground(new java.awt.Color(255, 255, 255));
        entradaTxt.setText("Registrar entrada");
        entradaTxt.setFocusable(false);
        panel.add(entradaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 47, -1, -1));

        registroEntradaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_1.png"))); // NOI18N
        registroEntradaBtn.setBorder(null);
        registroEntradaBtn.setOpaque(false);
        registroEntradaBtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_2.png"))); // NOI18N
        registroEntradaBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_2.png"))); // NOI18N
        registroEntradaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroEntradaBtnActionPerformed(evt);
            }
        });
        panel.add(registroEntradaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        salidaTxt.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        salidaTxt.setForeground(new java.awt.Color(255, 255, 255));
        salidaTxt.setText("Registrar salida");
        salidaTxt.setFocusable(false);
        panel.add(salidaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 47, -1, -1));

        registroSalidaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_1.png"))); // NOI18N
        registroSalidaBtn.setBorder(null);
        registroSalidaBtn.setOpaque(false);
        registroSalidaBtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_2.png"))); // NOI18N
        registroSalidaBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_2.png"))); // NOI18N
        registroSalidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroSalidaBtnActionPerformed(evt);
            }
        });
        panel.add(registroSalidaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 270, 480, 280));
    }// </editor-fold>//GEN-END:initComponents

    private void dniFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniFieldActionPerformed

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private void ojo_pass_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ojo_pass_1MouseClicked
        ojo_pass_2.setVisible(true);
        ojo_pass_1.setVisible(false);
        passField.setEchoChar((char)42);
    }//GEN-LAST:event_ojo_pass_1MouseClicked

    private void ojo_pass_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ojo_pass_2MouseClicked
        ojo_pass_2.setVisible(false);
        ojo_pass_1.setVisible(true);
        passField.setEchoChar((char)0);
    }//GEN-LAST:event_ojo_pass_2MouseClicked

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked

    }//GEN-LAST:event_btn_loginMouseClicked

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        inicioSesion();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void registroEntradaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroEntradaBtnActionPerformed
        empds.RegistrarHoraIncio(dniField.getText());
        registroEntradaBtn.setEnabled(false);
    }//GEN-LAST:event_registroEntradaBtnActionPerformed

    private void registroSalidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroSalidaBtnActionPerformed
        empds.RegistrarHoraFinal(dniField.getText());
        registroSalidaBtn.setEnabled(false);
    }//GEN-LAST:event_registroSalidaBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JTextField dniField;
    private javax.swing.JLabel entradaTxt;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logo_pass;
    private javax.swing.JLabel logo_user;
    private javax.swing.JButton ojo_pass_1;
    private javax.swing.JButton ojo_pass_2;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel pass;
    private javax.swing.JPasswordField passField;
    private javax.swing.JButton registroEntradaBtn;
    private javax.swing.JButton registroSalidaBtn;
    private javax.swing.JLabel salidaTxt;
    private javax.swing.JLabel user;
    private javax.swing.JLabel user1;
    // End of variables declaration//GEN-END:variables
}
