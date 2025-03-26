package org.JavaCar;

public class Cotxe extends Vehicle implements Llogable {
    private int nombrePlaces;

    public Cotxe(String Matr, String Marca, String Model, double preu, int places, Motor Motor, Roda[] Rodes, int any, tipusVehicle tipus) {
        super(Matr, Marca, Model, preu, Motor, Rodes, any, tipus); // Llamada al constructor de Vehicle
        this.nombrePlaces = places;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    @Override
    public double calcularPreu(int dies) {
        return getPreuBase() * dies; // Cálculo simple para el precio
    }

    @Override
    public String printVehicle() {
        String form = super.printVehicle(); // Llamar al método de la clase padre
        form += "Número de Plazas: " + getNombrePlaces() + "\n"; // Añadir información específica del coche
        return form;
    }
}