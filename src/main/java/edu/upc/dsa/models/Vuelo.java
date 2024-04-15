package edu.upc.dsa.models;

public class Vuelo
{
    String identificadorDron;
    String identificadorPiloto;
    String fecha;
    String porigen;
    String pdestino;
    int duracionVuelo;

    public Vuelo(String identificadorDron, String identificadorPiloto,String fecha, int duracionVuelo, String pdestino, String porigen)
    {
        this.identificadorDron = identificadorDron;
        this.identificadorPiloto = identificadorPiloto;
        this.duracionVuelo = duracionVuelo;
        this.fecha = fecha;
        this.porigen = porigen;
        this.pdestino = pdestino;

        //Gets y sets

    }

    @Override
    public String toString()
    {
        return "Vuelo{" + "idDron='" + identificadorDron + "idPiloto='"+ identificadorPiloto + "fechas='" + fecha
                + "Tiempo estimado="+ duracionVuelo + "Orige='"+porigen + "Destino='"+ pdestino + '}';
    }

    public int getidentificadorPiloto()
    {
        return identificadorPiloto;
    }
    public void setIdentificadorPiloto(String identificadorPiloto )
    {
        this.identificadorPiloto =identificadorPiloto;
    }
    public int getfecha()
    {
        return fecha;
    }


}
