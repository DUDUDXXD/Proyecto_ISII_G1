package javaapplication3;

import java.util.ArrayList;
import java.util.Date;
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
    
    
    static class Medicamento {
    private String nombre;
    private String tratamiento;
    private String dosis;
    private String es;


    public Medicamento(String nombre, String tratamiento, String dosis, String es) {
        this.nombre = nombre;
        this.tratamiento = tratamiento;
        this.dosis = dosis;
        this.es = es;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getEfectoSecundario() {
        return es;
    }

    public void setEfectoSecundario(String efecto) {
        this.es = efecto;
    }
}
    
    static class MedicamentoBotiquin {
    private String nombre;
    private int cantidad;
    private Date fechaCaducidad;

    public MedicamentoBotiquin(String nombre, int cantidad, Date fechaCaducidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    public boolean tienePocasExistencias() {
        return cantidad < 10;
    }

    public boolean estaCaducado() {
        return fechaCaducidad.before(new Date());
    }
    
}
    
    static class GestorDeBotiquin {

    private List<MedicamentoBotiquin> medicamentosBotiquin;

    public GestorDeBotiquin() {
        medicamentosBotiquin = new ArrayList<>();
        // Cargar los medicamentos con datos predefinidos o aleatorios
        cargarMedicamentos();
    }

    private void cargarMedicamentos() {
        // Medicamentos con datos de ejemplo
        medicamentosBotiquin.add(new MedicamentoBotiquin("Paracetamol", 15, new Date(System.currentTimeMillis() + 1000000000L)));
        medicamentosBotiquin.add(new MedicamentoBotiquin("Ibuprofeno", 8, new Date(System.currentTimeMillis() - 1000000000L))); // Caducado
        medicamentosBotiquin.add(new MedicamentoBotiquin("Amoxicilina", 5, new Date(System.currentTimeMillis() + 2000000000L))); // Pocas existencias
        medicamentosBotiquin.add(new MedicamentoBotiquin("Aspirina", 25, new Date(System.currentTimeMillis() + 500000000L)));
        medicamentosBotiquin.add(new MedicamentoBotiquin("Omeprazol", 0, new Date(System.currentTimeMillis() - 500000000L)));  // Sin existencias y caducado
        medicamentosBotiquin.add(new MedicamentoBotiquin("Loratadina", 27, new Date(System.currentTimeMillis() + 5000000000L)));
medicamentosBotiquin.add(new MedicamentoBotiquin("Claritromicina", 12, new Date(System.currentTimeMillis() + 2000000000L)));
medicamentosBotiquin.add(new MedicamentoBotiquin("Diclofenaco", 4, new Date(System.currentTimeMillis() - 3000000000L))); // Caducado
medicamentosBotiquin.add(new MedicamentoBotiquin("Naproxeno", 8, new Date(System.currentTimeMillis() + 8000000000L)));
medicamentosBotiquin.add(new MedicamentoBotiquin("Losartan", 10, new Date(System.currentTimeMillis() + 1000000000L)));
medicamentosBotiquin.add(new MedicamentoBotiquin("Metformina", 17, new Date(System.currentTimeMillis() - 2000000000L))); // Caducado
medicamentosBotiquin.add(new MedicamentoBotiquin("Furosemida", 3, new Date(System.currentTimeMillis() - 10000000000L))); // Caducado
medicamentosBotiquin.add(new MedicamentoBotiquin("Bromhexina", 9, new Date(System.currentTimeMillis() + 4000000000L)));
medicamentosBotiquin.add(new MedicamentoBotiquin("Cefalexina", 5, new Date(System.currentTimeMillis() - 5000000000L))); // Caducado
medicamentosBotiquin.add(new MedicamentoBotiquin("Ciprofloxacino", 20, new Date(System.currentTimeMillis() + 6000000000L)));
medicamentosBotiquin.add(new MedicamentoBotiquin("Fluoxetina", 14, new Date(System.currentTimeMillis() + 3500000000L)));
medicamentosBotiquin.add(new MedicamentoBotiquin("Diazepam", 0, new Date(System.currentTimeMillis() - 6000000000L)));  // Sin existencias y caducado
medicamentosBotiquin.add(new MedicamentoBotiquin("Levodopa", 18, new Date(System.currentTimeMillis() + 2000000000L)));
medicamentosBotiquin.add(new MedicamentoBotiquin("Lorazepam", 7, new Date(System.currentTimeMillis() + 1000000000L)));
medicamentosBotiquin.add(new MedicamentoBotiquin("Paroxetina", 11, new Date(System.currentTimeMillis() + 9000000000L)));
medicamentosBotiquin.add(new MedicamentoBotiquin("Enalapril", 22, new Date(System.currentTimeMillis() + 3000000000L)));
medicamentosBotiquin.add(new MedicamentoBotiquin("Ranitidina", 4, new Date(System.currentTimeMillis() - 7000000000L))); // Caducado
medicamentosBotiquin.add(new MedicamentoBotiquin("Prednisona", 25, new Date(System.currentTimeMillis() + 12000000000L)));
medicamentosBotiquin.add(new MedicamentoBotiquin("Tamsulosina", 19, new Date(System.currentTimeMillis() - 9000000000L))); // Caducado
medicamentosBotiquin.add(new MedicamentoBotiquin("Simvastatina", 15, new Date(System.currentTimeMillis() + 1000000000L)));
        
    }

    // Obtener todos los medicamentos del botiquín
    public List<MedicamentoBotiquin> obtenerMedicamentos() {
        return medicamentosBotiquin;
    }

    // Verificar si algún medicamento tiene pocas existencias o está caducado
    public List<String> verificarMedicamentos() {
        List<String> advertencias = new ArrayList<>();
        for (MedicamentoBotiquin medicamento : medicamentosBotiquin) {
            if (medicamento.tienePocasExistencias()) {
                advertencias.add("El medicamento " + medicamento.getNombre() + " tiene pocas existencias.");
            }
            if (medicamento.estaCaducado()) {
                advertencias.add("El medicamento " + medicamento.getNombre() + " ha caducado.");
            }
        }
        return advertencias;
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
        private static List<Enfermedad> enfermedades;
        
        public GestorDeEnfermedades(){
            enfermedades = new ArrayList<>();
            precargarEnfermedades();
        }

        // Método para inicializar enfermedades
        public void precargarEnfermedades() {
        enfermedades.add(new Enfermedad("Gripe", "Paracetamol", "500mg", "2 veces al día", true));
        enfermedades.add(new Enfermedad("Covid-19", "Antivirales", "200mg", "1 vez al día", true));
        enfermedades.add(new Enfermedad("Migraña", "Ibuprofeno", "400mg", "1 vez cada 8 horas", false));
        enfermedades.add(new Enfermedad("Diabetes", "Insulina", "10ml", "Diario", true));
        enfermedades.add(new Enfermedad("Hipertensión", "Enalapril", "10mg", "Cada 12 horas", true));
        enfermedades.add(new Enfermedad("Asma", "Salbutamol", "2 inhalaciones", "Cada 8 horas", true));
        enfermedades.add(new Enfermedad("Anemia", "Sulfato ferroso", "325mg", "Diario", true));
        enfermedades.add(new Enfermedad("Artritis", "Ibuprofeno", "400mg", "Cada 12 horas", true));
        enfermedades.add(new Enfermedad("Osteoporosis", "Vitamina D", "1 cápsula", "Diaria", false));
        enfermedades.add(new Enfermedad("Gastritis", "Omeprazol", "20mg", "Cada 24 horas", true));
        enfermedades.add(new Enfermedad("EPOC", "Broncodilatador", "2 inhalaciones", "Cada 12 horas", true));
        enfermedades.add(new Enfermedad("Rinitis alérgica", "Antihistamínico", "10mg", "Diario", false));
        enfermedades.add(new Enfermedad("Dermatitis atópica", "Corticoides tópicos", "Según indicación", "Diario", false));
        enfermedades.add(new Enfermedad("Colesterol alto", "Atorvastatina", "20mg", "Diario", true));
        enfermedades.add(new Enfermedad("Alergia alimentaria", "Antihistamínico", "10mg", "Según necesidad", false));
        enfermedades.add(new Enfermedad("Hipotiroidismo", "Levotiroxina", "50mcg", "Diario", true));
        enfermedades.add(new Enfermedad("Hipertiroidismo", "Metimazol", "15mg", "Diario", true));
        enfermedades.add(new Enfermedad("Epilepsia", "Ácido valproico", "500mg", "Cada 12 horas", true));
        enfermedades.add(new Enfermedad("Enfermedad de Crohn", "Infliximab", "Dosis según peso", "Cada 6 semanas", true));
        enfermedades.add(new Enfermedad("Síndrome de colon irritable", "Antiespasmódico", "Según necesidad", "Según síntomas", false));
        enfermedades.add(new Enfermedad("Psoriasis", "Cremas tópicas", "Según indicación", "Según necesidad", false));
        enfermedades.add(new Enfermedad("Insuficiencia cardíaca", "Digoxina", "0.25mg", "Diario", true));
        enfermedades.add(new Enfermedad("Depresión", "Sertralina", "50mg", "Diario", true));
        enfermedades.add(new Enfermedad("Ansiedad", "Alprazolam", "0.5mg", "Según necesidad", false));
        enfermedades.add(new Enfermedad("Parkinson", "Levodopa", "300mg", "Cada 8 horas", true));
        enfermedades.add(new Enfermedad("Esclerosis múltiple", "Interferón beta", "Dosis según peso", "Cada semana", true));
        enfermedades.add(new Enfermedad("Cáncer de mama", "Quimioterapia", "Dosis personalizada", "Según protocolo", true));
        enfermedades.add(new Enfermedad("Cáncer de pulmón", "Immunoterapia", "Dosis personalizada", "Según protocolo", true));
        enfermedades.add(new Enfermedad("Alzheimer", "Donepezilo", "10mg", "Diario", true));
        enfermedades.add(new Enfermedad("Hepatitis B", "Antivirales", "Dosis según peso", "Diario", true));
        enfermedades.add(new Enfermedad("Hepatitis C", "Ribavirina", "200mg", "Cada 12 horas", true));
        enfermedades.add(new Enfermedad("Varicela", "Aciclovir", "800mg", "5 veces al día", true));
        enfermedades.add(new Enfermedad("Tuberculosis", "Isoniazida", "300mg", "Diario", true));
        enfermedades.add(new Enfermedad("Dengue", "Paracetamol", "500mg", "Según necesidad", false));
    }

        public static List<Enfermedad> obtenerTodasLasEnfermedades() {
            return enfermedades;
        }
        
        // Método para buscar una enfermedad por nombre
    public Enfermedad buscarEnfermedadPorNombre(String nombre) {
        for (Enfermedad enfermedad : enfermedades) {
            if (enfermedad.getNombre().equalsIgnoreCase(nombre)) {
                return enfermedad;
            }
        }
        return null; // Devuelve null si no se encuentra la enfermedad
    }
    
    }
    
    static class GestorDeMedicamentos {
    private static List<Medicamento> medicamentos;

    public GestorDeMedicamentos() {
        medicamentos = new ArrayList<>();
        precargarMedicamentos();
    }

    // Método para inicializar los medicamentos
    private void precargarMedicamentos() {
        
        medicamentos.add(new Medicamento("Paracetamol", "Dolor leve", "500mg", "No"));
        medicamentos.add(new Medicamento("Ibuprofeno", "Inflamación", "400mg", "Sí"));
        medicamentos.add(new Medicamento("Aspirina", "Dolor y fiebre", "300mg", "No"));
        medicamentos.add(new Medicamento("Amoxicilina", "Antibiótico", "500mg", "No"));
        medicamentos.add(new Medicamento("Salbutamol", "Asma", "2 inhalaciones", "No"));
        medicamentos.add(new Medicamento("Rifampicina", "Tuberculosis", "10mg", "Sí"));
        medicamentos.add(new Medicamento("Dexametasona", "Inflamación grave", "5mg", "No"));
        medicamentos.add(new Medicamento("Prednisona", "Inflamación", "20mg", "No"));
        medicamentos.add(new Medicamento("Fluconazol", "Hongos", "200mg", "No"));
        medicamentos.add(new Medicamento("Diazepam", "Ansiedad", "5mg", "Sí"));
        medicamentos.add(new Medicamento("Clonazepam", "Ansiedad", "2mg", "Sí"));
        medicamentos.add(new Medicamento("Metronidazol", "Antibiótico", "500mg", "No"));
        medicamentos.add(new Medicamento("Budesonida", "Asma", "200mg", "No"));
        medicamentos.add(new Medicamento("Verapamilo", "Hipertensión", "240mg", "Sí"));
        medicamentos.add(new Medicamento("Mirtazapina", "Depresión", "15mg", "No"));
        medicamentos.add(new Medicamento("Venlafaxina", "Depresión", "75mg", "Sí"));
        medicamentos.add(new Medicamento("Amlodipino", "Hipertensión", "5mg", "Sí"));
        medicamentos.add(new Medicamento("Atorvastatina", "Colesterol alto", "20mg", "No"));
        medicamentos.add(new Medicamento("Fentanilo", "Dolor severo", "25mcg/hora", "No"));
        medicamentos.add(new Medicamento("Buspirona", "Ansiedad", "10mg", "Sí"));
        medicamentos.add(new Medicamento("Duloxetina", "Depresión", "30mg", "Sí"));
        medicamentos.add(new Medicamento("Levamisol", "Parásitos", "150mg", "No"));
        medicamentos.add(new Medicamento("Tamsulosina", "Hiperplasia benigna de próstata", "0.4mg", "Sí"));
        medicamentos.add(new Medicamento("Naproxeno", "Dolor e inflamación", "250mg", "Sí"));
        medicamentos.add(new Medicamento("Ciclosporina", "Inmunosupresor", "50mg", "No"));
        medicamentos.add(new Medicamento("Loratadina", "Alergias", "10mg", "Sí"));
        medicamentos.add(new Medicamento("Hydrocortisone", "Corticosteroides", "10mg", "Sí"));
        medicamentos.add(new Medicamento("Topiramato", "Epilepsia", "100mg", "Sí"));
        medicamentos.add(new Medicamento("Loperamida", "Diarrea", "2mg", "No"));
        medicamentos.add(new Medicamento("Metoclopramida", "Náuseas y vómitos", "10mg", "Sí"));
        medicamentos.add(new Medicamento("Zolpidem", "Insomnio", "10mg", "No"));
        medicamentos.add(new Medicamento("Clemastina", "Alergias", "1mg", "Sí"));
        medicamentos.add(new Medicamento("Atenolol", "Hipertensión", "50mg", "Sí"));
        
        
    }

    // Método para obtener todos los medicamentos
    public static List<Medicamento> obtenerTodosLosMedicamentos() {
        return medicamentos;
    }

    // Método para buscar un medicamento por nombre
    public Medicamento buscarMedicamentoPorNombre(String nombre) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getNombre().equalsIgnoreCase(nombre)) {
                return medicamento;
            }
        }
        return null; // Devuelve null si no se encuentra el medicamento
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
