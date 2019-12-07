package org.example.leerdatosfirebase.modelo;

public class Medida {

    private int Temperatura;
    private int Humedad;


    public Medida(){}


    public int getTemperatura() {
        return Temperatura;
    }

    public int getHumedad() {
        return Humedad;
    }

    public void setTemperatura(int Temperatura) {
        this.Temperatura = Temperatura;
    }

    public void setHumedad(int Humedad) {
        this.Humedad = Humedad;
    }




    @Override
    public String toString() {
        return "Medida: \n" +
                "  temperatura=" + Temperatura + "\n" +
                "  humedad=" + Humedad + "\n" ;
    }
}
