package org.JavaCar;

public abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double PreuBase;
    protected Motor Motor;
    protected Roda[] Rodes;
    protected EtiquetaAmbiental EtiquetaAmbiental;  // Cambiado a Enum
    protected boolean disponibilidad = true;
    protected int año;

    // Constructor de la clase Vehicle
    public Vehicle(String Matr, String Marca, String Model, double preu, Motor motor, Roda[] rodes, int año) {
        this.matricula = Matr;
        this.marca = Marca;
        this.model = Model;
        this.PreuBase = preu;
        this.Motor = motor;
        this.Rodes = rodes;
        this.año = año;
    }

    // Setter para la disponibilidad
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    // Getter para la disponibilidad
    public boolean isDisponible() {
        return disponibilidad;
    }

    // Getter para el año
    public int getAño() {
        return año;
    }

    // Getter para la matrícula
    public String getMatricula() {
        return matricula;
    }

    // Getter para la marca
    public String getMarca() {
        return marca;
    }

    // Getter para el modelo
    public String getModel() {
        return model;
    }

    // Getter para el precio base, convirtiéndolo a entero
    public int getPreuBase() {
        return (int) PreuBase;
    }

    // Getter para el motor
    public Motor getMotor() {
        return Motor;
    }

    // Getter para las ruedas
    public Roda[] getRodes() {
        return Rodes;
    }

    // Método para calcular el precio total según los días de alquiler
    public double calcularPreu(int dies) {
        return this.PreuBase * dies;
    }

    // Método para calcular la etiqueta ambiental según el tipo de motor y el año
    public void calcularEtiquetaAmbiental(tipusVehicle tipus, int año) {
        // Verifica que el tipo y año sean correctos
        System.out.println("Calculando etiqueta para: " + tipus + ", Año: " + año);

        switch (tipus) {
            case ELECTRIC:
                this.EtiquetaAmbiental = EtiquetaAmbiental.ETIQUETA_0_EMISIONES;
                break;
            case HIBRID_DIESEL:
            case HIBRID_GASOLINA:
                this.EtiquetaAmbiental = EtiquetaAmbiental.ETIQUETA_ECO;
                break;
            case DIESEL:
                this.EtiquetaAmbiental = (año >= 2015) ? EtiquetaAmbiental.ETIQUETA_C : (año >= 2006) ? EtiquetaAmbiental.ETIQUETA_B : null;
                break;
            case GASOLINA:
                this.EtiquetaAmbiental = (año >= 2006) ? EtiquetaAmbiental.ETIQUETA_C : (año >= 2000) ? EtiquetaAmbiental.ETIQUETA_B : null;
                break;
            default:
                this.EtiquetaAmbiental = null;
        }
    }

    // Método para imprimir los detalles del vehículo
    public String printVehicle() {
        String form = "Matricula: " + getMatricula() + "\n" +
                "Marca: " + getMarca() + "\n" +
                "Model: " + getModel() + "\n" +
                "PreuBase: " + getPreuBase() + "\n" +
                "Tipus(Motor): " + Motor.getTipus() + "\n" +
                "Potencia(Motor): " + Motor.getPotencia() + "\n" +
                "Año: " + getAño() + "\n" +
                "Etiqueta Ambiental: " + (EtiquetaAmbiental != null ? EtiquetaAmbiental.getNombre() : "Sin etiqueta") + "\n";

        // Añadir información sobre las ruedas
        for (Roda i : Rodes) {
            form += "Roda(marca): " + i.getMarca() + "\nRoda(Diametre): " + i.getDiametre() + "\n";
        }

        // Imprimir los detalles en consola
        System.out.println(form);

        // Retornar los detalles como un String
        return form;
    }
}
