package org.example.leerdatosfirebase.modelo;

public class Medida {

    private int temperatura;
    private int humedad;


    public Medida(){}


    public int getTemperatura() {
        return temperatura;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }




    @Override
    public String toString() {
        return "Medida: \n" +
                "  temperatura=" + temperatura + "\n" +
                "  humedad=" + humedad + "\n" ;
    }
}
