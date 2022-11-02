/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import clases.Archivo;
import clases.conexion;
import clases.consultarNickPas;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URI;
import javax.swing.JOptionPane;

/**
 *
 * @author fvr
 */
public class IniciarSession extends javax.swing.JFrame {

    /**
     * Creates new form IniciarSession
     */
    public static String NombreInicio;
    public static String Username;
    public static String privilege;
    Archivo usr = new Archivo();

    public IniciarSession() {
        mantenerConexion hola = new mantenerConexion();
        String[] datos = {"", ""};
        String user = "";
        String passw = "";
        datos = usr.leer();

        initComponents();
        if (!datos[0].toString().equals("")) {
            try {
                user = datos[0];
                passw = datos[1]; 
                Nick.setText(user);
                pass.setText(passw);
            } catch (Exception e) {
            }

        }
        setLocationRelativeTo(this);
        setIconImage(getIconImage());
        setTitle("Bienvenido");
    }

    @Override
    public Image getIconImage() {
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/fututel-icon.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nick = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nick.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Nick.setForeground(new java.awt.Color(255, 255, 255));
        Nick.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Nick.setBackground(new java.awt.Color(0,0,0,120));
        getContentPane().add(Nick, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 80, 180, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/door_internet_key_lock_password_safe_security_icon_127075.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 115, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_icon-icons.com_57997 (1).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 72, -1, -1));

        pass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        pass.setBackground(new java.awt.Color(0,0,0,120));
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passKeyReleased(evt);
            }
        });
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 120, 180, 20));

        jButton1.setBackground(new java.awt.Color(0, 204, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton1KeyTyped(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/este es.png"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setAlignmentY(0.0F);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 290));

        jMenu1.setText("opciones de conexion");

        jMenuItem1.setText("modificar acceso");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("sincronizar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("actualizar aplicacion");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        usr.escribir(Nick.getText(), pass.getText());
        consultarNickPas consul = new consultarNickPas();
        if (consul.devolver(Nick.getText(), pass.getText())) {
            NombreInicio = consul.tipo[1];
            privilege = consul.tipo[0];
            Username = Nick.getText();
            switch (consul.tipo[0]) {
                case "0":
                    
                    admin iadmin = new admin();
                    iadmin.setVisible(true);
                    this.dispose();
                    break;
                case "1":
                    
                    Inicio user = new Inicio();
                    user.setVisible(true);
                    this.dispose();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "descarga la app movil para acceder como tecnico");
                    break;

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult;
        dialogResult = JOptionPane.showConfirmDialog(null, "la informacion de conexion sera modificada, si ingresa informacion erronea puede perder todos sus datos", "¿esta seguro de continuar?", dialogButton);

        if (dialogResult == JOptionPane.YES_OPTION) {
            modificarConexion modificar = new modificarConexion();
            modificar.setVisible(true);
        } else {
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        desde sinc = new desde();
        sinc.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed

    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyTyped

    private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            usr.escribir(Nick.getText(), pass.getText());
            conexion conec = new conexion();
            conec.establecer();
            consultarNickPas consul = new consultarNickPas();
            if (consul.devolver(Nick.getText(), pass.getText())) {
                NombreInicio = consul.tipo[1];
                privilege = consul.tipo[0];
                Username = Nick.getText();
                switch (consul.tipo[0]) {
                    case "0":
                        admin iadmin = new admin();
                        iadmin.setVisible(true);
                        this.dispose();
                        break;
                    case "1":
                        Inicio user = new Inicio();
                        user.setVisible(true);
                        this.dispose();
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null, "descarga la app movil para acceder como tecnico");
                        break;

                }
            }
        }
    }//GEN-LAST:event_jButton1KeyReleased

    private void passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            conexion conec = new conexion();
            usr.escribir(Nick.getText(), pass.getText());
            conec.establecer();
            consultarNickPas consul = new consultarNickPas();
            if (consul.devolver(Nick.getText(), pass.getText())) {
                NombreInicio = consul.tipo[1];
                privilege = consul.tipo[0];
                Username = Nick.getText();
                switch (consul.tipo[0]) {
                    case "0":
                        admin iadmin = new admin();
                        iadmin.setVisible(true);
                        this.dispose();
                        break;
                    case "1":
                        Inicio user = new Inicio();
                        user.setVisible(true);
                        this.dispose();
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null, "descarga la app movil para acceder como tecnico");
                        break;

                }
            }
        }
    }//GEN-LAST:event_passKeyReleased

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                URI uri = new URI("https://agenda.fututel.com");
                desktop.browse(uri);
            } catch (Exception e) {
                System.err.println("Error: No se pudo abrir el enlace" + e.getMessage());
            }
        } else {
            System.err.println("Error: No se puede abrir enlaces web.");
        }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(IniciarSession.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSession.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSession.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSession.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSession().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Nick;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables
}