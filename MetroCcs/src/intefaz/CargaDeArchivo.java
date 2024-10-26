/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package intefaz;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author adcd_
 */
public class CargaDeArchivo extends javax.swing.JFrame {

    /**
     * Creates new form CargaDeArchivo
     */
    public CargaDeArchivo() {
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
        botonCargarArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setText("Cargue un archivo JSON");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        botonCargarArchivo.setText("Cargar Archivo");
        botonCargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(botonCargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 827, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarArchivoActionPerformed
        // Crear una instancia de JFileChooser
        JFileChooser selectorArchivo = new JFileChooser();

        // Crear un filtro para permitir solo archivos .json
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON", "json");
        selectorArchivo.setFileFilter(filtro);

        // Mostrar el diálogo de abrir archivo
        int resultado = selectorArchivo.showOpenDialog(null);

        // Verificar si el usuario seleccionó un archivo
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File archivoSeleccionado = selectorArchivo.getSelectedFile();
            System.out.println("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());

            // Leer el contenido del archivo y guardarlo en un String
            StringBuilder contenidoArchivo = new StringBuilder();
            try {
                Scanner lector = new Scanner(archivoSeleccionado);
                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    contenidoArchivo.append(linea).append("\n");
                }
                lector.close();

                // Convertir StringBuilder a String
                String contenidoComoString = contenidoArchivo.toString();

                // Usar Gson para convertir el JSON en un Map
                Gson gson = new Gson();
                Map<String, List<Map<String, Object>>> metroDeCaracas = gson.fromJson(contenidoComoString, Map.class);

                // Iterar sobre el sistema de metro
                for (Map.Entry<String, List<Map<String, Object>>> sistemaEntry : metroDeCaracas.entrySet()) {
                    String nombreSistema = sistemaEntry.getKey();
                    System.out.println("Estaciones de " + nombreSistema + ":");

                    // Iterar sobre las líneas
                    List<Map<String, Object>> lineas = sistemaEntry.getValue();
                    for (Map<String, Object> linea : lineas) {
                        for (Map.Entry<String, Object> lineaEntry : linea.entrySet()) {
                            String nombreLinea = lineaEntry.getKey();
                            System.out.println("Línea: " + nombreLinea);

                            // Verificar si el valor de la línea es una lista de estaciones
                            if (lineaEntry.getValue() instanceof List) {
                                List<Object> estaciones = (List<Object>) lineaEntry.getValue();

                                // Iterar sobre las estaciones y mostrar la estación anterior y siguiente
                                for (int i = 0; i < estaciones.size(); i++) {
                                    Object estacion = estaciones.get(i);

                                    // Obtener la estación anterior y siguiente (si existen)
                                    String estacionAnterior = (i > 0) ? estaciones.get(i - 1).toString() : "N/A";
                                    String estacionSiguiente = (i < estaciones.size() - 1) ? estaciones.get(i + 1).toString() : "N/A";

                                    // Manejar el caso donde la estación es una conexión (Map)
                                    if (estacion instanceof String) {
                                        System.out.println("Estación actual: " + estacion + " - Anterior: " + estacionAnterior + " - Siguiente: " + estacionSiguiente);
                                    } else if (estacion instanceof Map) {
                                        Map<String, String> estacionConectada = (Map<String, String>) estacion;
                                        for (Map.Entry<String, String> conexion : estacionConectada.entrySet()) {
                                            System.out.println("Estacion actual: " + conexion.getKey() + " (conexion: " + conexion.getValue() + ") - Anterior: " + estacionAnterior + " - Siguiente: " + estacionSiguiente);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error procesando el archivo");
                e.printStackTrace();
            }

        } else {
            System.out.println("No se seleccionó ningún archivo");
        }

    }//GEN-LAST:event_botonCargarArchivoActionPerformed

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
            java.util.logging.Logger.getLogger(CargaDeArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaDeArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaDeArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaDeArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaDeArchivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargarArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
