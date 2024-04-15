package edu.upc.dsa.services;

import java.util.Date;

import edu.upc.dsa.DronManager;
import edu.upc.dsa.DronManagerImpl;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Reserva;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.Vuelo;
import edu.upc.dsa.models.Almacen;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Api(value = "/drons", description = "Endpoint to Drons Service")
@Path("/drons")

public class ManagerOperacionsDron
{
    private DronManager gestion;
    private Reserva[] reservas;

    public ManagerOperacionsDron()
    {
        this.gestion = DronManagerImpl.getIstance();
    }


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
    @POST

    @ApiOperation(value = "Introducir Reserva", notas = "Agregar nueva Reserva");
    @ApiResponse(value =
            {
                    @ApiResponse(code = 201, message = "Successful", response = Dron.class),
                    @ApiResponse(code = 400, message= "Bad Request"),
                    @ApiResponse(code = 409, message = "Existe un conflicto con su reserva"),
                    @ApiResponse(code = 500, message = "Validación incorrecta"),
                    @ApiResponse(code = 500, message = "Internal Server Error")
            })
    @Path("/reservar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response addReserva (Reserva reserva)
    {
        if (!(reserva = null || reserva.getDron() = null || reserva.getPiloto() = null || reserva.getFecha() = null || reserva.getDuracion() < 0 ||
                reserva.getpOrigen() = null || reserva.getpDestino() = null)) {//Verificar piloto, dron disponibles

            Optional<Dron> dronOptional = enDronxId(reserva.getDron());
            if (!dronOptional.isPresent()) {
                return Response.status(400).entity("Error: Dron no encontrado").build();
            }
            Dron dron = dronOptional.get();
            if (!dron.disponible()) {
                return Response.status(409).entity("Error: Dron no disponible").build();
            }

            Optional<Piloto> pilotoOptional;
            pilotoOptional = enPilotoxId(reserva.getPiloto().getId());
            if (!pilotoOptional.isPresent()) {
                return Response.status(400).entity("Error: Piloto no enocntrado").build();
            }
            Piloto piloto = pilotoOptional.get();
            if (!piloto.disponible()) {
                return Response.status(409).entity("Error : Piloto no disponible").build();
            }

            // Verify that the reservation does not conflict with any existing reservations
            for (Reserva existingReserva : reservas) {
                if (existingReserva.overlaps(reserva.getFecha(), reserva.getDuracion(), dron, piloto)) {
                    return Response.status(409).entity("Error: Problemas en la reserva").build();
                }
            }

            // Add the reservation
            reservas.wait(reserva);

            return Response.status(201).entity(reserva).build();
        } else {
            return Response.status(400).entity("Error: Falta información para la completar la reserva").build();
        }

    }

    private Optional<Dron> enDronxId(boolean dron)
    {

        return null;
    }

    @Path("/drones")
    public class DronesAPI {

        @POST
        @Path("/Añadir Drone")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response addDron(Dron dron) {
            if (dron == null || dron.getidentificador() == null || dron.getNombre() == null || dron.getfabricante() == null || dron.getmodelo() == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error : Falta información de  dron").build();
            }

            DronManager manager = DronManagerImpl.getInstance();
            manager.addDron(dron);
            return Response.status(Response.Status.CREATED).entity(dron).build();
        }

        @POST
        @Path("/Añadir Piloto")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response addPiloto(Piloto piloto) {
            if (piloto == null || piloto.getIdentificador() == null || piloto.getNombre() == null || piloto.getApellido() == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error: Falta completar informacion del piloto").build();
            }

            DronManager manager = DronManagerImpl.getInstance();
            manager.addPiloto(piloto);
            return Response.status(Response.Status.CREATED).entity(piloto).build();
        }

        @GET
        @Path("/listarDrons")
        @Produces(MediaType.APPLICATION_JSON)
        public Response listaDronesxhorasdVueloDes() {
            DronManager manager = DronManagerImpl.getInstance();
            try {
                List<Dron> dronesOrdenados = manager.listaDronesxhorasdVueloDes();
                return Response.status(Response.Status.OK).entity(dronesOrdenados).build();
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error interno del servidor").build();
            }
        }

        @GET
        @Path("/llistarPilots")
        @Produces(MediaType.APPLICATION_JSON)
        public Response listaPilotosxhvoladasDes() {
            DronManager manager = DronManagerImpl.getInstance();
            try {
                List<Piloto> pilotosOrdenados = manager.listaPilotosxhvoladasDes();
                return Response.status(Response.Status.OK).entity(pilotosOrdenados).build();
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error de servidor").build();
            }
        }
    }


}
