package org.example.leerdatosfirebase.modelo;

public class Medida {

    private double Temperatura;
    private double Humedad;


    public Medida(){}


    public double getTemperatura() {
        return Temperatura;
    }

    public double getHumedad() {
        return Humedad;
    }

    public void setTemperatura(double Temperatura) {
        this.Temperatura = Temperatura;
    }

    public void setHumedad(double Humedad) {
        this.Humedad = Humedad;
    }




    @Override
    public String toString() {
        return "Medida: \n" +
                "  temperatura=" + Temperatura + "\n" +
                "  humedad=" + Humedad + "\n" ;
    }
}
