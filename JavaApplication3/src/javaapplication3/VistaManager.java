/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

public class VistaManager {
    private Modelo.GestorDePacientes gestor;
    private Controlador controlador;

    public VistaManager() {
        // Inicializar el modelo y el controlador
        gestor = new Modelo.GestorDePacientes();
        controlador = new Controlador(gestor);

        // Añadir datos de prueba al modelo
        Modelo.Paciente paciente1 = new Modelo.Paciente("Juan Perez", 65);
        Modelo.Enfermedad enfermedad1 = new Modelo.Enfermedad("Diabetes", "Insulina", "5ml", "Diario", true);
        paciente1.añadirEnfermedad(enfermedad1);
        gestor.añadirPaciente(paciente1);
    }

    public void mostrarPantallaMedicamentoPaciente() {
        PantallaMedicamentoPaciente pantallaMedicamentoPaciente = new PantallaMedicamentoPaciente(controlador);
        pantallaMedicamentoPaciente.setVisible(true);
    }
    
    public void mostrarPantallaListaEnfermedades() {
        PantallaListaEnfermedades pantallaListaEnfermedades = new PantallaListaEnfermedades(controlador);
        pantallaListaEnfermedades.setVisible(true);
    }
    
    // Añadir más métodos para manejar otras pantallas si es necesario
}


