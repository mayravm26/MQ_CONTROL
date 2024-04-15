package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.Reserva;


import java.util.Date;
import java.util.List;

public interface DronManager
{
    void addDron (Dron dron);
    void addPiloto(Piloto piloto);
    List<Dron> listaDronesxhorasdVueloDes();
    List<Piloto> listaPilotosxhvoladasDes();


   public  void listarDronxHorasDeVuelo();
    public  void listarPilotosxHorasDeVuelo();
    public  void almacenarDron(String id);
public void repararDronEnAlmacen();
public void addReservaPlanVuelo(String idDron, Date fecha, int tReserva, String pOrigen, String pDestino, String idPiloto);
public void listarReservasPorPiloto(String idPiloto);
public void listarPlanesVueloPorDron(String idDron);
}


