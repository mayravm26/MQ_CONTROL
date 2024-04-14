package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class Almacen
{
    private static Logger LOG = Logger.getLogger(Almacen.class.getName());
    private static Almacen instance;
    private List<Dron> drons;
    public Almacen()
    {
        this.drons = new LinkedList<>();
    }
    public static Almacen getInstance()
    {
        if(instance ==null)
        {
            instance = new Almacen();
        }
        return  instance;
    }

    public void AddDronAlmacen(String dronId)
    {
        Dron dronalmacenar = eDronxId(dronId);
        if (dronalmacenar != null)
        {
            drons.add(dronalmacenar);
            mouDronaEntrada();
        }
        else
        {
            throw new RuntimeException("Dron no encontrado");
        }
    }
    private void mouDronaEntrada()
    {
    }

    private Dron eDronxId (String dronId)
    {
        for (Dron dron : drons)
        {
            if (dron.setId()) {
                return dron;
            }
        }
        return null;
    }

    public void repararDronenAlmacen()
    {
        LOG.info("Dron en almacen en proceso de reparación");
        if (!drons.isEmpty())
        {
            Dron dronaReparar = eDroncercaEntrada();
            if(dronaReparar != null)
            {
                ferMantenimentdDron(dronaReparar);
                drons.remove(dronaReparar);
                LOG.info("Dron reparado y removido del almacen");
            }
            else
            {
                LOG.info("No hay drons en el almacén");
            }
        }
        else
        {
            LOG.info("El almacen se encuentra vacio");
        }
        LOG.info("Ha finalizado la reparación del dron en el almacen");
    }

    private void ferMantenimentdDron(Dron dronaReparar)
    {
        dronaReparar.setEnMantenimiento(false);
    }

    private Dron eDroncercaEntrada()
    {
        if(!drons.isEmpty())
        {
            Dron dronproperaEntrada = drons.get(0);
            for (Dron dron : drons)
            {
                if (dron.getPosicion() < dronproperaEntrada.getPosicion())
                {
                    dronproperaEntrada = dron;
                }
            }
            return dronproperaEntrada;
        }
        return null;
    }

    private void ferMantenimentDron (Dron dron)
    {
        dron.setPosicion(0);
    }
    private void mouDronaEntrada(String idDron)
    {
        
    }


}
