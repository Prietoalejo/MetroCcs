/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package intefaz;
import edd.*;
/**
 *
 * @author guante
 */
public class VentanaArista extends javax.swing.JFrame {
    
    static Grafo test;

    /**
     * Creates new form VentanaArista
     */
    public VentanaArista(Grafo g) {
        this.test = g;
        this.setVisible(true);
        
        initComponents();
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
        botonAddArista = new javax.swing.JButton();
        espacioUno = new javax.swing.JTextField();
        espacioDos = new javax.swing.JTextField();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setText("VENTA DE ARISTAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        botonAddArista.setText("INSERTAR ARISTAS");
        botonAddArista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAddAristaActionPerformed(evt);
            }
        });
        jPanel1.add(botonAddArista, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        espacioUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espacioUnoActionPerformed(evt);
            }
        });
        jPanel1.add(espacioUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 190, -1));
        jPanel1.add(espacioDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 190, -1));

        back.setText("ATRAS");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAddAristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAddAristaActionPerformed
        this.test.insertArista(this.espacioUno.getText(), this.espacioDos.getText());
        this.espacioUno.setText("");
        this.espacioDos.setText("");
    }//GEN-LAST:event_botonAddAristaActionPerformed

    private void espacioUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espacioUnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_espacioUnoActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Menu v = new Menu(test);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaArista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaArista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaArista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaArista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaArista(test).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton botonAddArista;
    private javax.swing.JTextField espacioDos;
    private javax.swing.JTextField espacioUno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}