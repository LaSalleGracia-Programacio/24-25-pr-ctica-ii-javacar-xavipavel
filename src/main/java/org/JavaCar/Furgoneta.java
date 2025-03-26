package org.JavaCar;

public class Furgoneta extends Vehicle implements Llogable {
    private int capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preu, int capacitatCarga, Motor motor, Roda[] rodes, int año) {
        super(matricula, marca, model, preu, motor, rodes, año);
        this.capacitatCarga = capacitatCarga;
    }

    public int getCapacitatCarga() {
        return capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        if (capacitatCarga >= 1000) {
            return (getPreuBase() + 10.0) * dies;  // Aseguramos que el 10 sea un valor double
        } else {
            return getPreuBase() * dies;
        }
    }
}