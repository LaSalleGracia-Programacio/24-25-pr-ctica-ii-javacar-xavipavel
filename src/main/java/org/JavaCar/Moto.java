package org.JavaCar;

public class Moto extends Vehicle implements Llogable {
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preu, int cilindrada, Motor motor, Roda[] rodes, int año) {
        super(matricula, marca, model, preu, motor, rodes, año);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public double calcularPreu(int dies) {
        if (cilindrada >= 500) {
            return (getPreuBase() + 5.0) * dies;  // Aseguramos que el 5 sea un valor double
        } else {
            return getPreuBase() * dies;
        }
    }
}