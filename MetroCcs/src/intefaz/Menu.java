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
public class Menu extends javax.swing.JFrame {
    
    static Grafo test;

    /**
     * Creates new form Menu
     */
    public Menu(Grafo g) {
        
        initComponents();
        this.test = g;
        this.setVisible(true);
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
        addStation = new javax.swing.JButton();
        AddArista = new javax.swing.JButton();
        showGrafo = new javax.swing.JButton();
        addSucursal = new javax.swing.JButton();
        changeT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel1.setText("MENU INICIAL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 240, -1));

        addStation.setText("AGREGAR ESTACION");
        addStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStationActionPerformed(evt);
            }
        });
        jPanel1.add(addStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        AddArista.setText("AGREGAR ARISTA");
        jPanel1.add(AddArista, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        showGrafo.setText("MOSTRAR");
        jPanel1.add(showGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        addSucursal.setText("COLOCAR SUCURSAL");
        jPanel1.add(addSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        changeT.setText("CAMBIAR \"T\"");
        jPanel1.add(changeT, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStationActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu(test).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddArista;
    private javax.swing.JButton addStation;
    private javax.swing.JButton addSucursal;
    private javax.swing.JButton changeT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton showGrafo;
    // End of variables declaration//GEN-END:variables
}