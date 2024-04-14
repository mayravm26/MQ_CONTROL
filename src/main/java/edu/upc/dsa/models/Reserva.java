package edu.upc.dsa.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Reserva

{
    private List<Dron> drons;
    private List<Piloto> pilotos;
    private List<Reserva> reservas;

    public Reserva()
    {
        this.drons = new ArrayList<>();
        this.pilotos = new ArrayList<>();
        this.reservas = new ArrayList<>();

    }

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
                            if (reserva.overlaps(fecha, duracion, dron, piloto))
                                throw new ReservationConflicException("Conflicto en la reserva");
                        }
                        if (!reservaAdded)
                        {
                            Reserva reserva = new Reserva(dronId, fecha, duracion, porigen,pdestino,pilotoId);
                        reservas.add(reserva);
                        }
                    }
                    else
                    { this new PilotoNodisponibleException("Piloto No disponible.");}
                } else
                {throw new DronNodisponibleException("Dron no disponible.");}
            }else
            { throw  new PilotoNoEncontradoException("Piloto No encontrado.");}

        }else
        { throw new DronNoEncontradoException("Dron No encontrado");}

    }

    private boolean overlaps(LocalDateTime fecha, int duracion, Dron dron, Piloto piloto)
    {

    }

    private Optional<Dron> enDronxId(String dronId)
    {
        return Optional.empty();
    }

    private Optional<Piloto>enPilotoxId(String pilotoId)
    {
        return  Optional.empty();
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





}
