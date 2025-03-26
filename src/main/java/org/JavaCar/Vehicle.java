package org.JavaCar;

public abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double PreuBase;
    protected Motor Motor;
    protected Roda[] Rodes;
    protected String EtiquetaAmbiental;
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
    public String calcularEtiquetaAmbiental(tipusVehicle tipus, int año) {
        switch (tipus) {
            case ELECTRIC:
                return "Etiqueta 0 Emisiones";
            case HIBRID_DIESEL:
            case HIBRID_GASOLINA:
                return "Etiqueta ECO";
            case DIESEL:
                // Etiqueta C para diésel de 2015 en adelante, B de 2006 a 2014, o "Sin etiqueta"
                return (año >= 2015) ? "Etiqueta C" : (año >= 2006) ? "Etiqueta B" : "Sin etiqueta";
            case GASOLINA:
                // Etiqueta C para gasolina de 2006 en adelante, B de 2000 a 2005, o "Sin etiqueta"
                return (año >= 2006) ? "Etiqueta C" : (año >= 2000) ? "Etiqueta B" : "Sin etiqueta";
            default:
                return "Sin etiqueta";
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
                "Etiqueta Ambiental: " + EtiquetaAmbiental + "\n";

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
