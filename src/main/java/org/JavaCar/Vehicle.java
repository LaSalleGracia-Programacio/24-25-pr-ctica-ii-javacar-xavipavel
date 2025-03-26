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
    protected int año;  // Nuevo atributo para el año

    public Vehicle(String Matr, String Marca, String Model, double preu, Motor Motor, Roda[] Rodes, int año) {
        this.matricula = Matr;
        this.marca = Marca;
        this.model = Model;
        this.PreuBase = preu;
        this.Motor = Motor;
        this.Rodes = Rodes;
        this.año = año;
        this.EtiquetaAmbiental = calcularEtiquetaAmbiental(tipusVehicle.valueOf(Motor.getTipus().toUpperCase()), año);// Calcula etiqueta automáticamente
    }

    public int getAño() {
        return año;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public int getPreuBase() {
        return (int) PreuBase;
    }

    public Motor getMotor() {
        return Motor;
    }

    public Roda[] getRodes() {
        return Rodes;
    }

    public double calcularPreu(int dies) {
        return this.PreuBase * dies;
    }

    // Método ajustado para calcular la etiqueta ambiental
    public String calcularEtiquetaAmbiental(tipusVehicle tipus, int año) {
        switch (tipus) {
            case ELECTRIC:
                return "Etiqueta 0 Emisiones";
            case HIBRID_DIESEL:
            case HIBRID_GASOLINA:
                return (año >= 2015) ? "Etiqueta ECO" : "Etiqueta B";
            case DIESEL:
                return (año >= 2006) ? "Etiqueta C" : "Etiqueta B";
            case GASOLINA:
                return (año >= 2006) ? "Etiqueta C" : (año >= 2000) ? "Etiqueta B" : "Sin etiqueta";
            default:
                return "Sin etiqueta";
        }
    }

    public String printVehicle() {
        String form = "Matricula: " + getMatricula() + "\n" +
                "Marca: " + getMarca() + "\n" +
                "Model: " + getModel() + "\n" +
                "PreuBase: " + getPreuBase() + "\n" +
                "Tipus(Motor): " + Motor.getTipus() + "\n" +
                "Potencia(Motor): " + Motor.getPotencia() + "\n" +
                "Año: " + getAño() + "\n" +
                "Etiqueta Ambiental: " + EtiquetaAmbiental + "\n";
        for (Roda i : Rodes) {
            form += "Roda(marca): " + i.getMarca() + "\nRoda(Diametre): " + i.getDiametre() + "\n";
        }
        System.out.println(form);
        return form;
    }
}
