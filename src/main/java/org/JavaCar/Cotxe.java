package org.JavaCar;

public class Cotxe extends Vehicle implements Llogable{
    private int nombrePlaces;
    public Cotxe(String Matr, String Marca, String Model, double preu, int places, Motor Motor,Roda[] Rodes, int anyo){
        super(Matr,Marca,Model,preu,Motor,Rodes,anyo);
        this.nombrePlaces = places;
    }
    public int getNombrePlaces(){
        return nombrePlaces;
    }
    @Override
    public double calcularPreu(int dies){
        return getPreuBase()*dies;
    }
}
