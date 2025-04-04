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
    protected int anyo;

    public Vehicle(String Matr, String Marca, String Model, double preu, Motor Motor, Roda[] Rodes, int anyo) {
        this.matricula = Matr;
        this.marca = Marca;
        this.model = Model;
        this.PreuBase = preu;
        this.Motor = Motor;
        this.Rodes = Rodes;
        this.anyo = anyo;
        calcularEtiquetaAmbiental();
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

    public int getAnyo() {
        return anyo;
    }

    public String getEtiquetaAmbiental() {
        return EtiquetaAmbiental;
    }

    public double calcularPreu(int dies) {
        return this.PreuBase * dies;
    }

    protected void calcularEtiquetaAmbiental() {
        String tipusMotor = Motor.getTipus().toLowerCase();

        if (tipusMotor.contains("electric") || tipusMotor.contains("hidrogen")) {
            EtiquetaAmbiental = "0";
        } else if (tipusMotor.contains("híbrid") || tipusMotor.contains("hibrid") || tipusMotor.contains("hybrid")) {
            EtiquetaAmbiental = "ECO";
        } else if (tipusMotor.contains("gasolina")) {
            if (anyo >= 2006) {
                EtiquetaAmbiental = "C";
            } else if (anyo >= 2001) {
                EtiquetaAmbiental = "B";
            } else {
                EtiquetaAmbiental = "Sense etiqueta";
            }
        } else if (tipusMotor.contains("diesel") || tipusMotor.contains("dièsel")) {
            if (anyo >= 2014) {
                EtiquetaAmbiental = "C";
            } else if (anyo >= 2006) {
                EtiquetaAmbiental = "B";
            } else {
                EtiquetaAmbiental = "Sense etiqueta";
            }
        } else {
            EtiquetaAmbiental = "Sense etiqueta";
        }
    }

    public String printVehicle() {
        String form = "Matricula: " + getMatricula() + "\n" +
                "Marca: " + getMarca() + "\n" +
                "Model: " + getModel() + "\n" +
                "PreuBase: " + getPreuBase() + "\n" +
                "Tipus(Motor): " + Motor.getTipus() + "\n" +
                "Potencia(Motor): " + Motor.getPotencia() + "\n" +
                "Any: " + getAnyo() + "\n" +
                "Etiqueta Ambiental: " + getEtiquetaAmbiental() + "\n";
        for (Roda i : Rodes) {
            form += "Roda(marca): " + i.getMarca() + "\nRoda(Diametre): " + i.getDiametre() + "\n";
        }
        System.out.println(form);
        return form;
    }
}
