package edu.upc.dsa.services;

public class ManagerOperacionsDron
{
    public interface OperacionesDron
    {
        void addDron(String id, String nombre, String fabricante, String modelo);
        void AddPiloto(String id, String nombre, String apellido);
        void listarDronxHorasDeVuelo();
        void listarPilotosxHorasDeVuelo();
        void almacenarDron(String id);
        void repararDronEnAlmacen();
        void addReservaPlanVuelo(String idDron, Date fecha, int tReserva, String pOrigen, String pDestino, String idPiloto);
        void listarReservasPorPiloto(String idPiloto);
        void listarPlanesVueloPorDron(String idDron);
    }
}
