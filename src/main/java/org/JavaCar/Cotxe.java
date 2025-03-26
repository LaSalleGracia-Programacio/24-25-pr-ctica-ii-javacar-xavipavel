package org.JavaCar;

public class Cotxe extends Vehicle implements Llogable {
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preu, int nombrePlaces, Motor motor, Roda[] rodes, int año) {
        super(matricula, marca, model, preu, motor, rodes, año);
        this.nombrePlaces = nombrePlaces;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    @Override
    public double calcularPreu(int dies) {
        return getPreuBase() * dies;
    }
}
