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
        private String nombre, sintom;
        private int edad, hab;
        private List<Enfermedad> enfermedades;

        public Paciente() {
            this.nombre = "Sin asignar";
            this.edad = 0;
            this.hab = 0;
            this.sintom = "Sin asignar";
        }

        public Paciente(String nombre, int edad, int hab, String sintom) {
            this.nombre = nombre;
            this.edad = edad;
            this.hab = hab;
            this.sintom = sintom;
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

        public Enfermedad(){
            this.nombre = "Sin asignar";
            this.medicacion = "Sin asignar";
            this.dosis = "Sin asignar";
            this.frecuencia = "Sin asignar";
            this.tieneDosis = false;
        }

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
        private static List<Paciente> pacientes;

        public GestorDePacientes() {
            //this.pacientes = new ArrayList<>();
            
             // Pacientes defecto
            Paciente paciente1 = new Paciente("Juan Perez", 65, 13, "Nada");
            paciente1.añadirEnfermedad(new Enfermedad("Diabetes", "Insulina", "5ml", "Diario", true));

            Paciente paciente2 = new Paciente("Maria Garcia", 70, 14, "Dolor");
            paciente2.añadirEnfermedad(new Enfermedad("Hipertensión", "Enalapril", "10mg", "Cada 12 horas", true));

            Paciente paciente3 = new Paciente("Carlos Ruiz", 55, 15, "Fiebre");
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

        public static List<Paciente> obtenerTodosLosPacientes() {
            return pacientes;
        }
    }
    
    
    public class GestorDeEnfermedades {
    private static List<Enfermedad> enfermedades = new ArrayList<>();

    // Método para inicializar enfermedades
    public static void precargarEnfermedades() {
        enfermedades.add(new Enfermedad("Gripe", "Paracetamol", "500mg", "2 veces al día", true));
        enfermedades.add(new Enfermedad("Covid-19", "Antivirales", "200mg", "1 vez al día", true));
        enfermedades.add(new Enfermedad("Migraña", "Ibuprofeno", "400mg", "1 vez cada 8 horas", false));
        // Agrega más enfermedades según sea necesario
    }

    public static List<Enfermedad> obtenerTodasLasEnfermedades() {
        return enfermedades;
    }
    }
   
}
