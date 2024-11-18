/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author dudu
 */
public class Controlador {
    private Modelo.GestorDePacientes gestor;
    private Modelo.Enfermedad enf;
    private Modelo.Paciente pac;
    public Controlador(Modelo.GestorDePacientes gestor) {
        this.gestor = gestor;
    }
    public List<Modelo.Paciente> obtenerPacientesConEnfermedadesConDosis() {
        List<Modelo.Paciente> pacientesConMedicacion = new ArrayList<>();
        for (Modelo.Paciente paciente : gestor.obtenerTodosLosPacientes()) {
            boolean tieneMedicacion = false;
            for (Modelo.Enfermedad enfermedad : paciente.getEnfermedades()) {
                if (enfermedad.tieneDosis()) {
                    tieneMedicacion = true;
                    break;
                }
            }
            if (tieneMedicacion) {
                pacientesConMedicacion.add(paciente);
            }
        }
        return pacientesConMedicacion;
    }
    
    public List<Modelo.Enfermedad> obtenerEnfermedadesPorNombre(String nombre){
        List<Modelo.Enfermedad> enfermedades = new ArrayList<>();
        for(Modelo.Enfermedad enfermedad : pac.getEnfermedades()) {
            if(enfermedad.getNombre() == nombre){
                enfermedades.add(enfermedad);
            }
        }
        return enfermedades;
    }
}
