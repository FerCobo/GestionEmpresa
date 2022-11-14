package Vista;

import Modelo.Empleados;
import Modelo.EmpleadosDAO;
import Modelo.login;
import Modelo.loginDAO;
import Paneles.RegistroJornada;
import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelGeneral extends javax.swing.JFrame{
    Empleados em = new Empleados();
    EmpleadosDAO empds = new EmpleadosDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    loginDAO login = new loginDAO();
    login lg = new login();
    Paneles.RegistroJornada registro = new RegistroJornada();
    
    public PanelGeneral() {
        initComponents();
        
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        fechaActual.setText(formato1.format(LocalDateTime.now()));
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        reloj.setText(formato2.format(LocalDateTime.now()));
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
        
        setBackground(new Color(0,0,0,0));
        this.setLocationRelativeTo(null);
        menu.initMoving(PanelGeneral.this);
        dniField.setBackground(new java.awt.Color(0,0,0,1));
        nameField.setBackground(new java.awt.Color(0,0,0,1));
        lastnameField.setBackground(new java.awt.Color(0,0,0,1));
        passField.setBackground(new java.awt.Color(0,0,0,1));
        mailField2.setBackground(new java.awt.Color(0,0,0,1));
        categoryComboBox.setSelectedItem(null);
        categoryField.setSelectedItem(null);
    }
    
    public void ListarEmpleados(){
        List<Empleados> ListarEmp = empds.ListarEmpleados();
        modelo = (DefaultTableModel) TablaEmpleados.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < ListarEmp.size(); i++) {
            ob[0] = ListarEmp.get(i).getDni();
            ob[1] = ListarEmp.get(i).getNombre();
            ob[2] = ListarEmp.get(i).getApellidos();
            ob[3] = ListarEmp.get(i).getCorreo();
            ob[4] = ListarEmp.get(i).getCategoria();
            modelo.addRow(ob);
        }
        TablaEmpleados.setModel(modelo);
    }
    
    public void LimpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    public void RegistrarEmpleado(){
        if (!"".equals(dniField.getText()) && !"".equals(nameField.getText()) && !"".equals(passField.getPassword()) && !"".equals(mailField2.getText())){
            em.setDni(dniField.getText());
            em.setNombre(nameField.getText());
            em.setApellidos(lastnameField.getText());
            em.setCategoria(categoryComboBox.getSelectedItem().toString());
            em.setCorreo(mailField2.getText());
            em.setPass(String.valueOf(passField.getPassword()));
            em.setExtension_tienda(Integer.parseInt(extTienda1.getText()));
            empds.RegistrarEmpleado(em);
            empds.CrearTabla(dniField.getText());
            JOptionPane.showMessageDialog(null, "Emplead@ registrad@ con éxito.");
            dniField.setText("");
            nameField.setText("");
            lastnameField.setText("");
            mailField2.setText("");
            passField.setText("");
            categoryComboBox.setSelectedItem(null);
        } else {
            JOptionPane.showMessageDialog(null, "No ha podido llevarse a cabo el registro.");
        }
    }
    
    /*
    public void BuscarEmpleado(){
        if ("".equals(dniField1.getText())) {
            JOptionPane.showMessageDialog(null, "Inserte un DNI de empleado");
        } else{
            String dni = dniField1.getText();
            em = empds.BuscarEmpleado(dni);
            nameField1.setText(em.getNombre());
            lastnameField1.setText(em.getApellidos());
            categoryField.setText(em.getCategoria());
            mailField1.setText(em.getCorreo());
        }
    }
    */
    
    public void ModificarEmpleado(){
        if (!"".equals(nameField1.getText()) && !"".equals(lastnameField1.getText()) && !"".equals(mailField1.getText())){
            em.setNombre(nameField1.getText());
            em.setApellidos(lastnameField1.getText());
            em.setCategoria(categoryField.getSelectedItem().toString());
            em.setCorreo(mailField1.getText());
            em.setDni(dniField1.getText());
            empds.ModificarEmpleado(em);
            JOptionPane.showMessageDialog(null, "Datos del empleado modificados");
            dniField1.setText("");
            nameField1.setText("");
            lastnameField1.setText("");
            mailField1.setText("");
            categoryField.setSelectedItem(null);
        } else {
            JOptionPane.showMessageDialog(null, "No ha podido llevarse a cabo la modificación.");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homeTxt = new javax.swing.JLabel();
        btn_home = new javax.swing.JButton();
        ventasTxt = new javax.swing.JLabel();
        btn_ventas = new javax.swing.JButton();
        ajustesTxt = new javax.swing.JLabel();
        btn_ajustes = new javax.swing.JButton();
        correoTxt = new javax.swing.JLabel();
        btn_correo = new javax.swing.JButton();
        webTxt = new javax.swing.JLabel();
        btn_web = new javax.swing.JButton();
        altaUsuarioTxt = new javax.swing.JLabel();
        btn_gestion_empleados = new javax.swing.JButton();
        volverTxt = new javax.swing.JLabel();
        btn_volver = new javax.swing.JButton();
        fechaActual = new javax.swing.JLabel();
        reloj = new javax.swing.JLabel();
        menu = new Paneles.Menu();
        panelGeneral1 = new Paneles.PanelGeneral();
        minimizar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        cabecera = new Paneles.Cabecera();
        panelCentral = new javax.swing.JTabbedPane();
        menuPrincipal = new javax.swing.JPanel();
        nombreEmp = new javax.swing.JLabel();
        ficharTxt = new javax.swing.JLabel();
        btn_fichar = new javax.swing.JButton();
        btn_briefing = new javax.swing.JButton();
        btn_vacaciones = new javax.swing.JButton();
        panelVarios = new javax.swing.JPanel();
        gestionEmpleado = new javax.swing.JPanel();
        encabezado1 = new javax.swing.JLabel();
        encabezado2 = new javax.swing.JLabel();
        encabezado3 = new javax.swing.JLabel();
        dni1 = new javax.swing.JLabel();
        dniField1 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        extTienda1 = new javax.swing.JLabel();
        extTienda = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        mail = new javax.swing.JLabel();
        mailField2 = new javax.swing.JTextField();
        pass = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lastnameField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        dni = new javax.swing.JLabel();
        lastname = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        category = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        dniField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        nameField = new javax.swing.JTextField();
        eliminarTxt = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        modificarTxt = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        registerTxt = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        nameField1 = new javax.swing.JTextField();
        name1 = new javax.swing.JLabel();
        lastnameField1 = new javax.swing.JTextField();
        lastname1 = new javax.swing.JLabel();
        category1 = new javax.swing.JLabel();
        mail1 = new javax.swing.JLabel();
        mailField1 = new javax.swing.JTextField();
        categoryField = new javax.swing.JComboBox<>();
        refrescar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        cuadro1 = new javax.swing.JLabel();
        cuadro2 = new javax.swing.JLabel();
        cuadro3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeTxt.setBackground(new java.awt.Color(107, 173, 220));
        homeTxt.setFont(new java.awt.Font("Decker", 0, 13)); // NOI18N
        homeTxt.setForeground(new java.awt.Color(255, 255, 255));
        homeTxt.setText("Menú principal");
        getContentPane().add(homeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 87, 110, 20));

        btn_home.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_home.png"))); // NOI18N
        btn_home.setBorder(null);
        btn_home.setBorderPainted(false);
        btn_home.setContentAreaFilled(false);
        btn_home.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_home_2.png"))); // NOI18N
        btn_home.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_home_2.png"))); // NOI18N
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
        });
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, 30));

        ventasTxt.setBackground(new java.awt.Color(107, 173, 220));
        ventasTxt.setFont(new java.awt.Font("Decker", 0, 13)); // NOI18N
        ventasTxt.setForeground(new java.awt.Color(255, 255, 255));
        ventasTxt.setText("Histórico de ventas");
        getContentPane().add(ventasTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 125, 120, 20));

        btn_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_ventas_1.png"))); // NOI18N
        btn_ventas.setBorder(null);
        btn_ventas.setBorderPainted(false);
        btn_ventas.setContentAreaFilled(false);
        btn_ventas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_ventas_2.png"))); // NOI18N
        btn_ventas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_ventas_2.png"))); // NOI18N
        btn_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ventasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 30));

        ajustesTxt.setBackground(new java.awt.Color(107, 173, 220));
        ajustesTxt.setFont(new java.awt.Font("Decker", 0, 13)); // NOI18N
        ajustesTxt.setForeground(new java.awt.Color(255, 255, 255));
        ajustesTxt.setText("Ajustes");
        getContentPane().add(ajustesTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 205, 120, 20));

        btn_ajustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_ajustes_1.png"))); // NOI18N
        btn_ajustes.setBorder(null);
        btn_ajustes.setBorderPainted(false);
        btn_ajustes.setContentAreaFilled(false);
        btn_ajustes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_ajustes_2.png"))); // NOI18N
        btn_ajustes.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_ajustes_2.png"))); // NOI18N
        btn_ajustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ajustesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ajustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, -1));

        correoTxt.setBackground(new java.awt.Color(107, 173, 220));
        correoTxt.setFont(new java.awt.Font("Decker", 0, 13)); // NOI18N
        correoTxt.setForeground(new java.awt.Color(255, 255, 255));
        correoTxt.setText("Correo");
        getContentPane().add(correoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 245, 120, 20));

        btn_correo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_correo_1.png"))); // NOI18N
        btn_correo.setBorder(null);
        btn_correo.setBorderPainted(false);
        btn_correo.setContentAreaFilled(false);
        btn_correo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_correo_2.png"))); // NOI18N
        btn_correo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_correo_2.png"))); // NOI18N
        btn_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_correoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 210, -1));

        webTxt.setBackground(new java.awt.Color(107, 173, 220));
        webTxt.setFont(new java.awt.Font("Decker", 0, 13)); // NOI18N
        webTxt.setForeground(new java.awt.Color(255, 255, 255));
        webTxt.setText("Página web");
        getContentPane().add(webTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 285, 120, 20));

        btn_web.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_web_1.png"))); // NOI18N
        btn_web.setBorder(null);
        btn_web.setBorderPainted(false);
        btn_web.setContentAreaFilled(false);
        btn_web.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_web_2.png"))); // NOI18N
        btn_web.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_web_2.png"))); // NOI18N
        btn_web.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_webMouseClicked(evt);
            }
        });
        btn_web.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_webActionPerformed(evt);
            }
        });
        getContentPane().add(btn_web, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 210, -1));

        altaUsuarioTxt.setBackground(new java.awt.Color(107, 173, 220));
        altaUsuarioTxt.setFont(new java.awt.Font("Decker", 0, 13)); // NOI18N
        altaUsuarioTxt.setForeground(new java.awt.Color(255, 255, 255));
        altaUsuarioTxt.setText("Gestión empleados");
        getContentPane().add(altaUsuarioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 165, 120, 20));

        btn_gestion_empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_gestion_empleados_1.png"))); // NOI18N
        btn_gestion_empleados.setBorder(null);
        btn_gestion_empleados.setBorderPainted(false);
        btn_gestion_empleados.setContentAreaFilled(false);
        btn_gestion_empleados.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_gestion_empleados_2.png"))); // NOI18N
        btn_gestion_empleados.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_gestion_empleados_2.png"))); // NOI18N
        btn_gestion_empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_gestion_empleadosMouseClicked(evt);
            }
        });
        btn_gestion_empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gestion_empleadosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_gestion_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 210, 30));

        volverTxt.setBackground(new java.awt.Color(107, 173, 220));
        volverTxt.setFont(new java.awt.Font("Decker", 0, 13)); // NOI18N
        volverTxt.setForeground(new java.awt.Color(255, 255, 255));
        volverTxt.setText("Cerrar sesión");
        getContentPane().add(volverTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 435, 110, 20));

        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_volver_1.png"))); // NOI18N
        btn_volver.setBorder(null);
        btn_volver.setBorderPainted(false);
        btn_volver.setContentAreaFilled(false);
        btn_volver.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_volver_2.png"))); // NOI18N
        btn_volver.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_volver_2.png"))); // NOI18N
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        getContentPane().add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 210, 30));

        fechaActual.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        fechaActual.setForeground(new java.awt.Color(255, 255, 255));
        fechaActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechaActual.setFocusable(false);
        fechaActual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(fechaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 170, 30));

        reloj.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        reloj.setForeground(new java.awt.Color(255, 255, 255));
        reloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reloj.setFocusable(false);
        reloj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(reloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 648, 170, 30));
        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelGeneral1.setBackground(new java.awt.Color(232, 232, 232));
        panelGeneral1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/minimizar_3.png"))); // NOI18N
        minimizar.setBorder(null);
        minimizar.setBorderPainted(false);
        minimizar.setContentAreaFilled(false);
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        panelGeneral1.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 20, 20));

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar_3.png"))); // NOI18N
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
        panelGeneral1.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, 20, 20));
        panelGeneral1.add(cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, -1));

        menuPrincipal.setBackground(new java.awt.Color(230, 239, 243));
        menuPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreEmp.setBackground(new java.awt.Color(107, 173, 220));
        nombreEmp.setFont(new java.awt.Font("Decker", 1, 36)); // NOI18N
        nombreEmp.setForeground(new java.awt.Color(107, 173, 220));
        menuPrincipal.add(nombreEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 50));

        ficharTxt.setBackground(new java.awt.Color(107, 173, 220));
        ficharTxt.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        ficharTxt.setForeground(new java.awt.Color(107, 173, 220));
        ficharTxt.setText("Registro de jornada");
        menuPrincipal.add(ficharTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, 20));

        btn_fichar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_registro_jornada_1.png"))); // NOI18N
        btn_fichar.setBorder(null);
        btn_fichar.setBorderPainted(false);
        btn_fichar.setContentAreaFilled(false);
        btn_fichar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_registro_jornada_2.png"))); // NOI18N
        btn_fichar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_registro_jornada_2.png"))); // NOI18N
        btn_fichar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ficharActionPerformed(evt);
            }
        });
        menuPrincipal.add(btn_fichar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 200, 200));

        btn_briefing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_briefing_1.png"))); // NOI18N
        btn_briefing.setBorder(null);
        btn_briefing.setBorderPainted(false);
        btn_briefing.setContentAreaFilled(false);
        btn_briefing.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_briefing_2.png"))); // NOI18N
        btn_briefing.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_briefing_2.png"))); // NOI18N
        menuPrincipal.add(btn_briefing, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 200, 200));

        btn_vacaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_vacaciones_1.png"))); // NOI18N
        btn_vacaciones.setBorder(null);
        btn_vacaciones.setBorderPainted(false);
        btn_vacaciones.setContentAreaFilled(false);
        btn_vacaciones.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_vacaciones_2.png"))); // NOI18N
        btn_vacaciones.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_vacaciones_2.png"))); // NOI18N
        menuPrincipal.add(btn_vacaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 200, 200));

        panelVarios.setBackground(new java.awt.Color(121, 177, 202));
        panelVarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelVarios.setLayout(new javax.swing.BoxLayout(panelVarios, javax.swing.BoxLayout.LINE_AXIS));
        menuPrincipal.add(panelVarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 550, 600));

        panelCentral.addTab("tab1", menuPrincipal);

        gestionEmpleado.setBackground(new java.awt.Color(230, 239, 243));
        gestionEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        encabezado1.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        encabezado1.setForeground(new java.awt.Color(94, 167, 208));
        encabezado1.setText("REGISTRAR EMPLEADO");
        gestionEmpleado.add(encabezado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        encabezado2.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        encabezado2.setForeground(new java.awt.Color(94, 167, 208));
        encabezado2.setText("MODIFICAR DATOS DE DE EMPLEADOS");
        gestionEmpleado.add(encabezado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        encabezado3.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        encabezado3.setForeground(new java.awt.Color(94, 167, 208));
        encabezado3.setText("LISTADO DE EMPLEADOS");
        gestionEmpleado.add(encabezado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        dni1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        dni1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dni1.setText("DNI:");
        gestionEmpleado.add(dni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 120, -1));

        dniField1.setBackground(new java.awt.Color(255, 255, 255));
        dniField1.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        dniField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gestionEmpleado.add(dniField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 190, 30));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        gestionEmpleado.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 220, 10));

        extTienda1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        gestionEmpleado.add(extTienda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 467, 200, 30));

        extTienda.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        extTienda.setText("Extensión tienda:");
        gestionEmpleado.add(extTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        gestionEmpleado.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 220, 10));

        mail.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        mail.setText("Correo:");
        gestionEmpleado.add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        mailField2.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        mailField2.setBorder(null);
        mailField2.setOpaque(false);
        mailField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailField2ActionPerformed(evt);
            }
        });
        gestionEmpleado.add(mailField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 210, 30));

        pass.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        pass.setText("Contraseña:");
        gestionEmpleado.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        gestionEmpleado.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 220, 10));

        lastnameField.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        lastnameField.setBorder(null);
        lastnameField.setOpaque(false);
        lastnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameFieldActionPerformed(evt);
            }
        });
        gestionEmpleado.add(lastnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 210, 30));

        passField.setBackground(new java.awt.Color(0,0,0,1)
        );
        passField.setFont(passField.getFont().deriveFont(passField.getFont().getSize()+2f));
        passField.setBorder(null);
        passField.setOpaque(false);
        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        gestionEmpleado.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 210, 30));

        dni.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        dni.setText("DNI:");
        gestionEmpleado.add(dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        lastname.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lastname.setText("Apellidos");
        gestionEmpleado.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        categoryComboBox.setEditable(true);
        categoryComboBox.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        categoryComboBox.setForeground(new java.awt.Color(245, 155, 65));
        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ayudante de dependiente", "Dependiente", "2º Encargado", "Encargado" }));
        categoryComboBox.setBorder(null);
        categoryComboBox.setOpaque(false);
        gestionEmpleado.add(categoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 220, -1));

        category.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        category.setText("Categoría:");
        gestionEmpleado.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        name.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        name.setText("Nombre:");
        gestionEmpleado.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        gestionEmpleado.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 220, 10));

        dniField.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        dniField.setBorder(null);
        dniField.setOpaque(false);
        dniField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniFieldActionPerformed(evt);
            }
        });
        gestionEmpleado.add(dniField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 210, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        gestionEmpleado.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 220, 10));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        gestionEmpleado.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 220, 10));

        nameField.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        nameField.setBorder(null);
        nameField.setOpaque(false);
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        gestionEmpleado.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 210, 30));

        eliminarTxt.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        eliminarTxt.setForeground(new java.awt.Color(255, 255, 255));
        eliminarTxt.setText("ELIMINAR");
        eliminarTxt.setFocusable(false);
        gestionEmpleado.add(eliminarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, -1, -1));

        eliminar.setBackground(new java.awt.Color(102, 102, 255));
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_1.png"))); // NOI18N
        eliminar.setBorder(null);
        eliminar.setBorderPainted(false);
        eliminar.setContentAreaFilled(false);
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_2.png"))); // NOI18N
        eliminar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_2.png"))); // NOI18N
        eliminar.setVerifyInputWhenFocusTarget(false);
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
        });
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        gestionEmpleado.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 140, -1));

        modificarTxt.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        modificarTxt.setForeground(new java.awt.Color(255, 255, 255));
        modificarTxt.setText("MODIFICAR");
        modificarTxt.setFocusable(false);
        gestionEmpleado.add(modificarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, -1, -1));

        modificar.setBackground(new java.awt.Color(102, 102, 255));
        modificar.setForeground(new java.awt.Color(255, 255, 255));
        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_1.png"))); // NOI18N
        modificar.setBorder(null);
        modificar.setBorderPainted(false);
        modificar.setContentAreaFilled(false);
        modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        modificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_2.png"))); // NOI18N
        modificar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_2.png"))); // NOI18N
        modificar.setVerifyInputWhenFocusTarget(false);
        modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarMouseClicked(evt);
            }
        });
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        gestionEmpleado.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, 140, -1));

        registerTxt.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        registerTxt.setForeground(new java.awt.Color(255, 255, 255));
        registerTxt.setText("REGISTRARSE");
        gestionEmpleado.add(registerTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, -1, -1));

        register.setBackground(new java.awt.Color(102, 102, 255));
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_1.png"))); // NOI18N
        register.setBorder(null);
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        register.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        register.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_2.png"))); // NOI18N
        register.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_2.png"))); // NOI18N
        register.setVerifyInputWhenFocusTarget(false);
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        gestionEmpleado.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 140, -1));

        nameField1.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        nameField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nameField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nameField1.setOpaque(false);
        nameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameField1ActionPerformed(evt);
            }
        });
        gestionEmpleado.add(nameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 190, 30));

        name1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        name1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        name1.setText("Nombre:");
        gestionEmpleado.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 122, -1));

        lastnameField1.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        lastnameField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lastnameField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lastnameField1.setOpaque(false);
        lastnameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameField1ActionPerformed(evt);
            }
        });
        gestionEmpleado.add(lastnameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 190, 30));

        lastname1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lastname1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lastname1.setText("Apellidos:");
        gestionEmpleado.add(lastname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 122, -1));

        category1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        category1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        category1.setText("Categoría:");
        gestionEmpleado.add(category1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 122, -1));

        mail1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        mail1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mail1.setText("Correo:");
        gestionEmpleado.add(mail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 122, -1));

        mailField1.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        mailField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mailField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        mailField1.setOpaque(false);
        mailField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailField1ActionPerformed(evt);
            }
        });
        gestionEmpleado.add(mailField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 190, 30));

        categoryField.setEditable(true);
        categoryField.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        categoryField.setForeground(new java.awt.Color(245, 155, 65));
        categoryField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ayudante de dependiente", "Dependiente", "2º Encargado", "Encargado" }));
        categoryField.setBorder(null);
        categoryField.setOpaque(false);
        gestionEmpleado.add(categoryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 190, -1));

        refrescar.setBackground(new java.awt.Color(102, 102, 255));
        refrescar.setForeground(new java.awt.Color(255, 255, 255));
        refrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_1.png"))); // NOI18N
        refrescar.setBorder(null);
        refrescar.setBorderPainted(false);
        refrescar.setContentAreaFilled(false);
        refrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        refrescar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_2.png"))); // NOI18N
        refrescar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registro_2.png"))); // NOI18N
        refrescar.setVerifyInputWhenFocusTarget(false);
        refrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refrescarMouseClicked(evt);
            }
        });
        refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarActionPerformed(evt);
            }
        });
        gestionEmpleado.add(refrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 25, 25));

        TablaEmpleados.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Apellidos", "Correo", "Categoría"
            }
        ));
        TablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaEmpleados);

        gestionEmpleado.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 610, 240));

        cuadro1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gestionEmpleado.add(cuadro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 260, 570));

        cuadro2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gestionEmpleado.add(cuadro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 650, 250));

        cuadro3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gestionEmpleado.add(cuadro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 650, 310));

        panelCentral.addTab("tab2", gestionEmpleado);

        panelGeneral1.add(panelCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 990, 690));

        getContentPane().add(panelGeneral1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_gestion_empleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gestion_empleadosActionPerformed
        LimpiarTabla();
        ListarEmpleados();
        panelCentral.setSelectedIndex(1);
    }//GEN-LAST:event_btn_gestion_empleadosActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        panelCentral.setSelectedIndex(0);
        registro.setVisible(false);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_ajustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ajustesActionPerformed
        
    }//GEN-LAST:event_btn_ajustesActionPerformed

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setExtendedState(PanelGeneral.ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_cerrarMouseClicked

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        
    }//GEN-LAST:event_btn_homeMouseClicked

    private void btn_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ventasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ventasActionPerformed

    private void btn_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_correoActionPerformed

    private void btn_webActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_webActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_webActionPerformed

    private void btn_webMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_webMouseClicked
             
        try {
            Desktop.getDesktop().browse(new URI("https://www.decimas.com/es-es/?gclid=CjwKCAjwzNOaBhAcEiwAD7Tb6MzvQNXdxqCGmqtlzvQ2F0XOvDOM8cq2UbaS7KKDsE9J-86yLWmR1xoCmBcQAvD_BwE"));
        } catch (URISyntaxException ex) {
            System.out.println(ex);
        }catch(IOException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_webMouseClicked

    private void mailField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailField2ActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        RegistrarEmpleado();
        LimpiarTabla();
        ListarEmpleados();
    }//GEN-LAST:event_registerActionPerformed

    private void lastnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameFieldActionPerformed

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private void dniFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniFieldActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void btn_gestion_empleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gestion_empleadosMouseClicked
        
    }//GEN-LAST:event_btn_gestion_empleadosMouseClicked

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
        
    }//GEN-LAST:event_eliminarMouseClicked

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar los datos?");
        if (pregunta == 0){
            String dni = dniField1.getText();
            empds.EliminarEmpleado(dni);
            dniField1.setText("");
            nameField1.setText("");
            lastnameField1.setText("");
            mailField1.setText("");
            categoryField.setSelectedItem(null);
            LimpiarTabla();
            ListarEmpleados();
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void nameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameField1ActionPerformed

    private void lastnameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameField1ActionPerformed

    private void mailField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailField1ActionPerformed

    private void modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMouseClicked
        
    }//GEN-LAST:event_modificarMouseClicked

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        ModificarEmpleado();
    }//GEN-LAST:event_modificarActionPerformed

    private void TablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEmpleadosMouseClicked
        int fila = TablaEmpleados.rowAtPoint(evt.getPoint());
        dniField1.setText(TablaEmpleados.getValueAt(fila, 0).toString());
        nameField1.setText(TablaEmpleados.getValueAt(fila, 1).toString());
        lastnameField1.setText(TablaEmpleados.getValueAt(fila, 2).toString());
        mailField1.setText(TablaEmpleados.getValueAt(fila, 3).toString());
        categoryField.setSelectedItem(TablaEmpleados.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_TablaEmpleadosMouseClicked

    private void refrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refrescarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_refrescarMouseClicked

    private void refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarActionPerformed
        LimpiarTabla();
        ListarEmpleados();
    }//GEN-LAST:event_refrescarActionPerformed

    private void btn_ficharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ficharActionPerformed
        panelVarios.add(registro);
        panelVarios.repaint();
        panelVarios.updateUI();
        panelVarios.revalidate();
        registro.setVisible(true);
    }//GEN-LAST:event_btn_ficharActionPerformed
        
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
            java.util.logging.Logger.getLogger(PanelGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelGeneral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JLabel ajustesTxt;
    private javax.swing.JLabel altaUsuarioTxt;
    private javax.swing.JButton btn_ajustes;
    private javax.swing.JButton btn_briefing;
    private javax.swing.JButton btn_correo;
    private javax.swing.JButton btn_fichar;
    private javax.swing.JButton btn_gestion_empleados;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_vacaciones;
    private javax.swing.JButton btn_ventas;
    private javax.swing.JButton btn_volver;
    private javax.swing.JButton btn_web;
    private Paneles.Cabecera cabecera;
    private javax.swing.JLabel category;
    private javax.swing.JLabel category1;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JComboBox<String> categoryField;
    private javax.swing.JButton cerrar;
    private javax.swing.JLabel correoTxt;
    private javax.swing.JLabel cuadro1;
    private javax.swing.JLabel cuadro2;
    private javax.swing.JLabel cuadro3;
    private javax.swing.JLabel dni;
    private javax.swing.JLabel dni1;
    private javax.swing.JTextField dniField;
    public static javax.swing.JLabel dniField1;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel eliminarTxt;
    private javax.swing.JLabel encabezado1;
    private javax.swing.JLabel encabezado2;
    private javax.swing.JLabel encabezado3;
    private javax.swing.JLabel extTienda;
    public static javax.swing.JLabel extTienda1;
    private javax.swing.JLabel fechaActual;
    private javax.swing.JLabel ficharTxt;
    private javax.swing.JPanel gestionEmpleado;
    private javax.swing.JLabel homeTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lastname;
    private javax.swing.JLabel lastname1;
    private javax.swing.JTextField lastnameField;
    private javax.swing.JTextField lastnameField1;
    private javax.swing.JLabel mail;
    private javax.swing.JLabel mail1;
    private javax.swing.JTextField mailField1;
    private javax.swing.JTextField mailField2;
    private Paneles.Menu menu;
    private javax.swing.JPanel menuPrincipal;
    private javax.swing.JButton minimizar;
    private javax.swing.JButton modificar;
    private javax.swing.JLabel modificarTxt;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nameField1;
    public static javax.swing.JLabel nombreEmp;
    private javax.swing.JTabbedPane panelCentral;
    private Paneles.PanelGeneral panelGeneral1;
    private javax.swing.JPanel panelVarios;
    private javax.swing.JLabel pass;
    private javax.swing.JPasswordField passField;
    private javax.swing.JButton refrescar;
    private javax.swing.JButton register;
    private javax.swing.JLabel registerTxt;
    private javax.swing.JLabel reloj;
    private javax.swing.JLabel ventasTxt;
    private javax.swing.JLabel volverTxt;
    private javax.swing.JLabel webTxt;
    // End of variables declaration//GEN-END:variables
}
