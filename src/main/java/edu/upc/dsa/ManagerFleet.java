package edu.upc.dsa;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class ManagerFleet
{
    private List<Dron> drons;
    private List<Piloto> pilotos;
    private List<Reserva> reservas;

    public ManagerFleet()
    {
        this.drons = new ArrayList<>();
        this.pilotos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void addReserva(String dronId, LocalDateTime fecha, int duracion, double[] porigen, double[] pdestino, String pilotoId) {
        Opcional<Dron> dronOpcional = encontrarDronById(dronId);
        if (dronOpcional.isPresent()) {
            Dron dron = dronOpcional.get();
            Opcional<Piloto> pilotoOpcional = encontrarPilotoById(pilotoId);
            if (pilotoOpcional.isPresent()) {
                Piloto piloto = pilotoOpcional.get();
                if (dron.isOperational()) {
                    if (dron.isAvailable(fecha, duracion)) {
                        if (piloto.isAvailable(fecha, duracion)) {
                            boolean reservaAdded = false;
                            for (Reserva reserva : reservas) {
                                if (reserva.overlaps(fecha, duracion, dron, piloto)) {
                                    throw new ReservaConflictException("Reserva conflict.");
                                }
                            }
                            if (!reservaAdded) {
                                Reserva reserva = new Reserva(dronId, fecha, duracion, porigen, pdestino, pilotoId);
                                reservas.add(reserva);
                            }
                        } else {
                            throw new PilotoNodisponibleException("Piloto No disponible.");
                        }
                    } else {
                        throw new DronNodisponibleException("Dron No disponible.");
                    }
                } else {
                    throw new DronenMantenimentException("Dron en mantenimiento.");
                }
            } else {
                throw new PilotoNotFoundException("Piloto no encontrado.");
            }
        } else {
            throw new DronNotFoundException("Dron no encontrado.");
        }
    }


}
