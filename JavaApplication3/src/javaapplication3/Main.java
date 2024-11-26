/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

public class Main {
    public static void main(String[] args) {
        // Establecer la apariencia (opcional)
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Iniciar la aplicación usando VistaManager
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaManager vistaManager = new VistaManager(); // Crear el gestor de vistas
//                vistaManager.mostrarPantallaMedicamentoPaciente(); // Mostrar la pantalla inicial
                  //vistaManager.mostrarPantallaListaEnfermedades();
                 // vistaManager.mostrarPantallaLogin();
                  //vistaManager.mostrarPantallaHistorialPaciente();
            }
        });
    }
}


   