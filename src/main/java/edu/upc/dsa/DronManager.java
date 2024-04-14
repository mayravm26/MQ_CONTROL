package edu.upc.dsa;

import java.util.Date;

public interface DronManager
{


void listarDronxHorasDeVuelo();
void listarPilotosxHorasDeVuelo();
void almacenarDron(String id);
void repararDronEnAlmacen();
void addReservaPlanVuelo(String idDron, Date fecha, int tReserva, String pOrigen, String pDestino, String idPiloto);
void listarReservasPorPiloto(String idPiloto);
void listarPlanesVueloPorDron(String idDron);

}
