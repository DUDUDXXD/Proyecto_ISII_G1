package javaapplication3;

import java.util.ArrayList;
import java.util.List;

public class Modelo {

    // Clase Paciente
    static class Paciente {
        private String nombre, sintom,apellidos;
        private int edad, hab;
        private List<Enfermedad> enfermedades;
        private List<HistorialEntrada> historial;

        public Paciente() {
            this.nombre = "Sin asignar";
            this.apellidos = "Sin asignar";
            this.edad = 0;
            this.hab = 0;
            this.sintom = "Sin asignar";
            this.enfermedades = new ArrayList<>();
            this.historial = new ArrayList<>();
        }

        public Paciente(String nombre, String apellidos, int edad, int hab, String sintom) {
            this.nombre = nombre;
            this.apellidos = apellidos;
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
        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
         }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }
        public int getHab() {
            return hab;
        }

        public void setHab(int hab) {
            this.hab = hab;
        }
        
        public void setSintom(String sintom) {
            this.sintom = sintom;
        }
        public String getSintom() {
            return sintom;
        }

        public List<Enfermedad> getEnfermedades() {
            return enfermedades;
        }

        public void setEnfermedades(List<Enfermedad> enfermedades) {
            this.enfermedades = enfermedades;
        }
        
        public List<HistorialEntrada> getHistorial() {
            return historial;
        }
        
        public boolean añadirEntradaHistorial(String fecha, String dni, String enfermedad, String tratamiento) {
            for (HistorialEntrada entrada : historial) {
                if (entrada.getFecha().equals(fecha) && entrada.getDni().equals(dni)) {
                    return false; // Entrada duplicada
                }
            }
            historial.add(new HistorialEntrada(fecha, dni, enfermedad, tratamiento));
            return true; // Añadido correctamente
        }
        
    }

    // Clase Enfermedad
    static class Enfermedad {
        private String nombre;
        private String medicacion;
        private String dosis;
        private String frecuencia;
        private boolean tieneDosis;

        public Enfermedad() {
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

    // Clase GestorDePacientes
    static class GestorDePacientes {
    private List<Paciente> pacientes;  // Eliminar `static`

    public GestorDePacientes() {
        pacientes = new ArrayList<>(); // Inicializar la lista

        // Pacientes por defecto
        Paciente paciente1 = new Paciente("Juan", "Perez", 65, 13, "Nada");
        paciente1.añadirEnfermedad(new Enfermedad("Diabetes", "Insulina", "5ml", "Diario", true));

        Paciente paciente2 = new Paciente("Maria", " Garcia", 70, 14, "Dolor");
        paciente2.añadirEnfermedad(new Enfermedad("Hipertensión", "Enalapril", "10mg", "Cada 12 horas", true));

        Paciente paciente3 = new Paciente("Carlos", "Ruiz", 55, 15, "Fiebre");
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

    public List<Paciente> obtenerTodosLosPacientes() {  // Eliminar `static`
        return pacientes;
    }
}


    // Clase GestorDeEnfermedades
    public static class GestorDeEnfermedades {
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
    public static class HistorialEntrada {
    private String fecha;
    private String dni;
    private String enfermedad;
    private String tratamiento;

    public HistorialEntrada(String fecha, String dni, String enfermedad, String tratamiento) {
        this.fecha = fecha;
        this.dni = dni;
        this.enfermedad = enfermedad;
        this.tratamiento = tratamiento;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDni() {
        return dni;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public String getTratamiento() {
        return tratamiento;
    }
}
}
