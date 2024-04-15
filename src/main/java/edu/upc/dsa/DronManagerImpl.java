package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.Reserva;
import edu.upc.dsa.models.Vuelo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class DronManagerImpl implements DronManager
{
    final static Logger logger = Logger.getLogger(String.valueOf(DronManagerImpl.class));
    private static DronManager instance;
    protected List<Dron> drons;
    protected List<Piloto> pilotos;
    protected List<Reserva> reservas;
    protected List<Vuelo> vuelos;

    public DronManagerImpl()
    {
        this.drons = new ArrayList<>();
        this.pilotos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.vuelos = new ArrayList<>();

    }
    public static DronManager getInstance()
    {

        return null;
    }
    

    public Dron AddDronAlmacen(String dronId)
    {
        logger.info("Añadir Dron al almacen con el identificador" + dronId + "El equipo esta pendiente de mantenimiento");
        
        
        Dron dron = AddDronAlmacen (dronId);
        drons.add(dron);
        if (AddDronAlmacen() != null)
        {
            drons.add(AddDronAlmacen());
            AddDronAlmacen();
        }
        else
        {
            throw new RuntimeException("Dron no encontrado");
        }
        return dron;
    }

    public void addDron(String id, String nombre, String fabricante, String modelo) {

        logger.info("Agregar droncon  identificador " + id);
        for (Dron dron : drons) {
            if (dron.getId().equals(id)) {

                logger.error("El dron con Identificador " + id + " ya esta en la lista.");
                return;
            }
        }

        Dron addDron = addDron(id,nombre,fabricante,modelo);
        drons.add(addDron);
        logger.info("Se añadido correctament : " + addDron);
    }

    public  void  addPiloto(String identificador, String nombre, String apellido, int horasVuelop)
    {
        logger.info("Agregar piloto con identificador"+ identificador);
        for (Piloto piloto: pilotos)
        {
            if (piloto.getIdentificador().equals(identificador))
            {
                logger.error("El piloto con Identificador" + identificador+ "ya esta en la lista");
                return;
            }
        }

        Piloto addPiloto = addPiloto(identificador,nombre,apellido,horasVuelop);
        pilotos.add(addPiloto);
        logger.info("Se añadido correctament : " + addPiloto);

    }
public void AddAlmacen (String dronId)
{
    logger.info("Agregar dron "+ dronId + "para revisar si necesita mantenimiento");
    for (Dron dron : drons)
    {
        if (dron.getId().equals(dronId)) {
            logger.error("El dron con idententificador " + dronId + " ya esta en la lista.");
            return;
        }
    }
    Dron dron = addDron(dronId);
    drons.add(dron);
    logger.info("Se añadido correctament : " + addDron(););

}

    public void repararDronenAlmacen()
    {
        logger.info("Dron en almacen en proceso de reparación");


        if (drons.isEmpty()) {
            logger.error("Todos los drones estan reparados el almacen se encuentra vacio.");
            return;
        }

        Dron dronaReparar = drons.get(0);

        dronaReparar.setEnMantenimiento(true);
        drons.remove(dronaReparar);
        logger.info("Mantenimiento del dron" + dronaReparar.getId() + "finalizado ya esta disponible");
    }

    public void AddVuelo(String identificadorDron, String identificadorPiloto, String fecha, int duracion, String porigen, String pdestino) {
        logger.info("Reservar plan de vuela para  dron " + identificadorDron + " con piloto " + identificadorPiloto);


        Dron dron = null;
        for (Dron d : drons) {
            if (d.getId().equals(identificadorDron)) {
                dron = d;
                break;
            }
        }
        if (dron == null) {
            logger.error("El dron " + identificadorDron + " no esta en la lista.");
            return;
        }

        if (!dron.disponible())
        {
            logger.error("El dron  " + identificadorDron + " no esta en mantenimiento .");
            return;
        }


        Piloto piloto = null;
        for (Piloto p : pilotos) {
            if (p.getIdentificador().equals(identificadorPiloto)) {
                piloto = p;
                break;
            }
        }
        if (piloto == null) {
            logger.error("El piloto " + identificadorPiloto + " no esta en la lista.");
            return;
        }

        if (piloto.disponible()) {
            logger.error("El piloto " + identificadorPiloto + " ya no esta disponible tiene un  vuelo  ya asignado.");
            return;
        }


        for (Vuelo reserva : reservas) {
            if (reserva.getidentificadorPiloto().equals(identificadorPiloto) && reserva.getfecha().equals(fecha)) {
                logger.error("El piloto " + identificadorPiloto + " ya tiene un vuelo asignado para la  " + fecha + ".");
                return;
            }
        }

        Vuelo addReserva = Vuelo(identificadorDron, identificadorPiloto, fecha, duracion, porigen, pdestino);
        reservas.add(addReserva);
        logger.info("Reserva de vuelo añadida correctamente: " + addReserva);
    }

}
