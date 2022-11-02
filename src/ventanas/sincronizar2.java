/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;


import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author bvr217
 */
public class sincronizar2 extends javax.swing.JFrame {


    public sincronizar2() {
        initComponents();
        setIconImage(getIconImage());
        setTitle("Sincronizado");
        Avanzar1 avanzando1 = new Avanzar1();
        boton1.setEnabled(false);
        avanzando1.setBar(progres);
        avanzando1.setboton(boton1);
        avanzando1.settext(text);

        Thread hilo = new Thread(avanzando1);

        hilo.start();
        setLocationRelativeTo(this);
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

        boton1 = new javax.swing.JButton();
        progres = new javax.swing.JProgressBar();
        text = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        boton1.setText("cerrar");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        text.setText("sincronizando base local");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(boton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text)
                            .addComponent(progres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed

        this.dispose();
    }//GEN-LAST:event_boton1ActionPerformed

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
            java.util.logging.Logger.getLogger(sincronizar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sincronizar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sincronizar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sincronizar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sincronizar2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton1;
    private javax.swing.JProgressBar progres;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}

class Avanzar1 implements Runnable {

    private int barra = 0;
    JProgressBar bar;
    JButton boton;
    JLabel text;
    String date;

    @Override
    public void run() {
        int i = 0;
        float j;
        float k;
        try {
            
             

            PreparedStatement pst2;
            PreparedStatement pst = mantenerConexion.conectando.getconec1().getcn().prepareStatement("SELECT count(*) FROM `login` WHERE estado = '1' and id != 0");
            ResultSet rs = pst.executeQuery();

            pst2 = mantenerConexion.conectando.getconec2().getcn().prepareStatement("DELETE FROM `login` where id >'0'");
            pst2.execute();
            pst2 = mantenerConexion.conectando.getconec2().getcn().prepareStatement("alter table `login` AUTO_INCREMENT=0");
            pst2.execute();

            if (rs.next()) {
                i = Integer.parseInt(rs.getString("count(*)"));
                this.gettext().setText("analizando...");
            }

            pst = mantenerConexion.conectando.getconec1().getcn().prepareStatement("SELECT * FROM login WHERE estado = '1' and id != 0");
            rs = pst.executeQuery();

            j = (float) 1 / i;
            k = 0;
            if (rs.next()) {
                do {
                    this.gettext().setText("sincronizando Login...");

                    PreparedStatement pst1 = mantenerConexion.conectando.getconec2().getcn().prepareStatement("insert into login values(?,?,?,?,?,?)");
                    pst1.setString(1, rs.getString("id"));
                    pst1.setString(2, rs.getString("username"));
                    pst1.setString(3, rs.getString("privilege"));
                    pst1.setString(4, rs.getString("nombre"));
                    pst1.setString(5, rs.getString("correo"));
                    pst1.setString(6, rs.getString("password"));
                    pst1.executeUpdate();
                    k = (float) k + (j * 100);

                    barra = (int) k;

                    this.getBar().setValue(barra);

                } while (rs.next());
                JOptionPane.showMessageDialog(null, "sincronizado completado");

            }

            this.getboton().setEnabled(true);
            this.getboton().doClick();
            IniciarSession ini = new IniciarSession();
            ini.setVisible(true);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo sincronizar " + e);
            this.getboton().setEnabled(true);
            this.getboton().doClick();
        }

    }

    public void setBar(JProgressBar bar) {
        this.bar = bar;
    }

    public void setboton(JButton boton) {
        this.boton = boton;
    }

    public JButton getboton() {
        return boton;
    }

    public JProgressBar getBar() {
        return bar;
    }

    public JLabel gettext() {
        return text;
    }

    public void settext(JLabel text) {
        this.text = text;
    }

}