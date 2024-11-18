/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author dudu
 */
public class Modelo {
    

    static class Paciente {
        private String nombre;
        private int edad;
        private List<Enfermedad> enfermedades;

        public Paciente(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
            this.enfermedades = new ArrayList<>();
        }
        public void añadirEnfermedad(Enfermedad enfermedad) {
            this.enfermedades.add(enfermedad);
        }
        // Getters y Setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public List<Enfermedad> getEnfermedades() {
            return enfermedades;
        }

        public void setEnfermedades(List<Enfermedad> enfermedades) {
            this.enfermedades = enfermedades;
        }
    }
    static class Enfermedad {
        private String nombre;
        private String medicacion;
        private String dosis;
        private String frecuencia;
        private boolean tieneDosis;

        public Enfermedad(String nombre, String medicacion, String dosis, String frecuencia, boolean tieneDosis) {
            this.nombre = nombre;
            this.medicacion = medicacion;
            this.dosis = dosis;
            this.frecuencia = frecuencia;
            this.tieneDosis = tieneDosis;
        }

        // Getters y Setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getMedicacion() {
            return medicacion;
        }

        public void setMedicacion(String medicacion) {
            this.medicacion = medicacion;
        }

        public String getDosis() {
            return dosis;
        }

        public void setDosis(String dosis) {
            this.dosis = dosis;
        }

        public String getFrecuencia() {
            return frecuencia;
        }
          public void setFrecuencia(String frecuencia) {
            this.frecuencia = frecuencia;
        }
        public boolean tieneDosis() {
            return tieneDosis;
        }

        public void setTieneDosis(boolean tieneDosis) {
            this.tieneDosis = tieneDosis;
        }
    }
    static class GestorDePacientes {
        private List<Paciente> pacientes;

        public GestorDePacientes() {
            this.pacientes = new ArrayList<>();
            
             // Pacientes defecto
            Paciente paciente1 = new Paciente("Juan Perez", 65);
            paciente1.añadirEnfermedad(new Enfermedad("Diabetes", "Insulina", "5ml", "Diario", true));

            Paciente paciente2 = new Paciente("Maria Garcia", 70);
            paciente2.añadirEnfermedad(new Enfermedad("Hipertensión", "Enalapril", "10mg", "Cada 12 horas", true));

            Paciente paciente3 = new Paciente("Carlos Ruiz", 55);
            paciente3.añadirEnfermedad(new Enfermedad("Asma", "Salbutamol", "2 inhalaciones", "Cada 8 horas", true));

            // Añadir los pacientes a la lista
            pacientes.add(paciente1);
            pacientes.add(paciente2);
            pacientes.add(paciente3);
        }

        public void añadirPaciente(Paciente paciente) {
            pacientes.add(paciente);
        }

        public Paciente buscarPacientePorNombre(String nombre) {
            for (Paciente paciente : pacientes) {
                if (paciente.getNombre().equalsIgnoreCase(nombre)) {
                    return paciente;
                }
            }
            return null; // Devuelve null si no se encuentra el paciente
        }

        public List<Paciente> obtenerTodosLosPacientes() {
            return pacientes;
        }
    }
    
   
}
