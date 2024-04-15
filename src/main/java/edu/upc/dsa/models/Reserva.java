package edu.upc.dsa.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Reserva

{
    String id;
   String idDron;
   String idPiloto;
     String fecha;
     int duracion;
     String pOrigen;
     String pDestino;
    private List<Dron> drons;
    private List<Piloto> pilotos;
    private List<Reserva> reservas;



    public void addReserva(String dronId, LocalDateTime fecha, int duracion, double[]porigen, double[] pdestino, String pilotoId)
    {
        Optional<Dron> dronOptional =enDronxId(dronId);
        if (dronOptional.isPresent())
        {
            Dron dron= dronOptional.get();
            Optional<Piloto> pilotoOptional = enPilotoxId(pilotoId);
            if (pilotoOptional.isPresent())
            {
                Piloto piloto =pilotoOptional.get();
                if (dron.disponible())
                {
                    if(dron.disponible())
                    {
                        boolean reservaAdded =false;
                        for (Reserva reserva : reservas)
                        {
                            if (reserva.overlaps(fecha, duracion, dron, piloto)) {
                                throw new ReservationConflicException("Conflicto en la reserva");
                            }
                        }
                        if (!reservaAdded)
                        {
                            Reserva reserva = new Reserva();
                        reservas.add(reserva);
                        }
                    }
                    else
                    {
                        new PilotoNodisponibleException("Piloto No disponible.");}
                } else
                {throw new DronNodisponibleException("Dron no disponible.");}
            }else
            { throw  new PilotoNoEncontradoException("Piloto No encontrado.");}

        }else
        { throw new DronNoEncontradoException("Dron No encontrado");}

    }

   public boolean overlaps(LocalDateTime fecha, int duracion, Dron dron, Piloto piloto)
    {

        return false;
    }

    private Optional<Dron> enDronxId(String dronId)
    {
        return Optional.empty();
    }

    private Optional<Piloto>enPilotoxId(String pilotoId)
    {
        return  Optional.empty();
    }
    public static Optional<Reserva> enReservaxId(String id)
    {
        return null;
    }

    public String disponible()
    {

        return null;
    }
    public boolean disponible(LocalDateTime fecha, int duracion)
    {

        return false;
    }
    public static int totañDuracion(List<Reserva> reservas, String idDron)
    {

        return 0;
    }

    public boolean getDron()
    {
        return false;
    }

    public boolean getPiloto()
    {
    }


    class ResercaConflictoException extends RuntimeException
    {
        public ResercaConflictoException(String message)
        {
            super(message);
        }
    }
    class PilotoNodisponibleException extends RuntimeException
    {
        public PilotoNodisponibleException(String message)
        {
            super(message);
        }
    }
    class DronNodisponibleException extends RuntimeException
    {
        public DronNodisponibleException(String message)
        {
            super(message);
        }
    }

    class PilotoNoEncontradoException extends RuntimeException
    {
        public PilotoNoEncontradoException(String message)
        {
            super(message);
        }
    }
    class DronenMantenimientoException extends RuntimeException
    {
        public DronenMantenimientoException(String message)
        {
            super(message);
        }
    }
    //gets y sets
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDron() {
        return idDron;
    }

    public void setIdDron(String idDron) {
        this.idDron = idDron;
    }

    public String getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(String idPiloto) {
        this.idPiloto = idPiloto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getpOrigen() {
        return pOrigen;
    }

    public void setpOrigen(String pOrigen) {
        this.pOrigen = pOrigen;
    }

    public String getpDestino() {
        return pDestino;
    }

    public void setpDestino(String pDestino) {
        this.pDestino = pDestino;
    }
}


