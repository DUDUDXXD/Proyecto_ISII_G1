/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication3;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author inesjasopernod
 */
public class PantallaListadoBotiquin extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    /**
     * Creates new form PantallaListadoBotiquin
     */
    public PantallaListadoBotiquin() {
        initComponents();
        cargarDatosIniciales();
    }
    
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Inventario = new javax.swing.JTable();
        Salir = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Configurar tabla con columnas: Medicamento, Existencias, Fecha Caducidad
        tableModel = new DefaultTableModel(
                new Object[]{"Medicamento", "Existencias", "Fecha de Caducidad"}, 0
        );
        Inventario.setModel(tableModel);
        jScrollPane1.setViewportView(Inventario);

        Salir.setText("Salir");
        Salir.addActionListener(evt -> SalirActionPerformed(evt));

        Agregar.setText("Agregar Medicamento");
        Agregar.addActionListener(evt -> AgregarMedicamentoActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Agregar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Salir)))
                                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Agregar)
                                        .addComponent(Salir))
                                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }

    private void cargarDatosIniciales() {
        // Datos de ejemplo
        Object[][] medicamentos = {
            {"Paracetamol", 5, "2024-01-01"},
            {"Ibuprofeno", 12, "2023-12-01"},
            {"Amoxicilina", 3, "2022-11-01"},
            {"Loratadina", 20, "2025-06-15"}
        };

        // Agregar datos y verificar
        for (Object[] medicamento : medicamentos) {
            try {
                agregarMedicamento((String) medicamento[0], (int) medicamento[1], (String) medicamento[2]);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Error en el Medicamento",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
    private void agregarMedicamento(String nombre, int existencias, String fechaCaducidad) throws Exception {
        // Verificar existencias
        if (existencias < 10) {
            throw new Exception("El medicamento '" + nombre + "' tiene existencias bajas: " + existencias);
        }

        // Verificar caducidad
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaCad;
        try {
            fechaCad = LocalDate.parse(fechaCaducidad, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            throw new Exception("Fecha de caducidad inválida para '" + nombre + "': " + fechaCaducidad);
        }
        if (fechaCad.isBefore(fechaActual)) {
            throw new Exception("El medicamento '" + nombre + "' ya está caducado: " + fechaCaducidad);
        }

        // Agregar al modelo si pasa las verificaciones
        tableModel.addRow(new Object[]{nombre, existencias, fechaCaducidad});
    }
    
    private void AgregarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {
        // Cuadros de diálogo para ingresar datos
        String nombre = JOptionPane.showInputDialog(this, "Nombre del Medicamento:");
        if (nombre == null || nombre.isBlank()) {
            JOptionPane.showMessageDialog(this, "El nombre del medicamento no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String existenciasStr = JOptionPane.showInputDialog(this, "Cantidad de Existencias:");
        int existencias;
        try {
            existencias = Integer.parseInt(existenciasStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fechaCaducidad = JOptionPane.showInputDialog(this, "Fecha de Caducidad (YYYY-MM-DD):");
        if (fechaCaducidad == null || fechaCaducidad.isBlank()) {
            JOptionPane.showMessageDialog(this, "La fecha de caducidad no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Intentar agregar medicamento y manejar excepciones
        try {
            agregarMedicamento(nombre, existencias, fechaCaducidad);
            JOptionPane.showMessageDialog(this, "Medicamento agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al Agregar Medicamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }


    /**
     * Main para ejecutar la aplicación.
     * @param args
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new PantallaListadoBotiquin().setVisible(true);
        });
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Inventario = new javax.swing.JTable();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Medicamento", "Existencias", "Estado"
            }
        ));
        jScrollPane1.setViewportView(Inventario);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Salir)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Salir)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        
    }//GEN-LAST:event_SalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Inventario;
    private javax.swing.JButton Salir;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
