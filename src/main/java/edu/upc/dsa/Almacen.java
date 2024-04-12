package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;
import java.util.PrimitiveIterator;

public class Almacen
{
    private List<Dron> drons;
    public Almacen()
    {
        this.drons=new LinkedList<>();
    }


    public void addDronAlmacen(String dronId) {
        Dron dronToStore = encontrarDronxId(dronId);
        if (dronToStore != null) {
            drons.add(dronToStore);
            mouDronEntrada();
        } else {
            throw new DronNotFoundException("Dron no encontrado");
        }
    }

    public void repararDronAlmacen()
    {
        if(!drons.isEmpty())
        {
            Dron dronToReparar != null)
            {
               ferManteniDron(dronToReparar);
               drons.remove(dronToReparar);
            }
            else
            {
                return " No hay drons en el almacen";
            }
        }
        else
        {
            return "El almacen esta vacio.";
        }
    }



    private Dron encontrarDronxId(String dronId)
    {

    }

    private void mouDronEntrada()
    {

    }
    private Dron EncontrarDrontoEntrada()
    {
        if (!drons.isEmpty())
        {
            Dron mascercano=drons.get(0);
            for (Dron dron: drons)
            {
                if (dron.getPosition() < mascercano.getPosition())
                {
                    mascercano = dron;
                }
            }
            return mascercano;
        }
        return null;
    }
    private void ferManteniDron(Dron dron)
    {
        dron.setPosition(0);
    }
}
    class DronNotFoundException extends RuntimeException
    {
        public DronNotFoundException(String message)
        {
            super(message);
        }
    }
class Dron {

    private String identificador;

    private int posicion;


    public Dron(String identificador, int posicion) {

        this.identificador = identificador;

        this.posicion = posicion;

    }

    public String getId() {

        return identificador;

    }
    public int getPosition() {

        return posicion;

    }
    public void setPosition(int posicion) {

        this.posicion = posicion;

    }

}
