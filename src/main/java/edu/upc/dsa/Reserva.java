package edu.upc.dsa;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reserva
    {
        private Piloto piloto;
        private List<ListarReservas> reserva= new ArrayList<>();
        private String iddron;
        private Double factura;
        private Double porigen;
        private Double pdestino;
        private int horav;
        private String fecha;


        public Reserva(){}

        public Reserva(Piloto piloto)
        {
            this();
            this.piloto=piloto;
            this.reserva="edu.upc.ds.Reserva realizado -> "+ LocalDateTime.now()+"\n";

        }

        public void addLR(int cantidad,String idDron){
            ListarReservas dron = new ListarReservas(cantidad,idDron);
            this.comanda.add(dron);
        }
        //Cuidado es lo que vamos a reserva
        public void servirReserva(HashMap<String, Dron> catalogoDrons){
            for (int i=0;i< comanda.size();i++){
                ListarReservas elemento= comanda.get(i);
                Dron dron = catalogoDrons.get(elemento.getNombre());
                producto.incrementarNumVuelo(elemento.getCantidad());
                this.reserva+=elemento.getNombre() + " x "+elemento.getCantidad()+"\n";
                this.factura+= elemento.getCantidad()*dron.getPrecio();
            }
            this.reserva+="Precio total: "+ factura+"\nEntrega realizada -> "+LocalDateTime.now();
            piloto.añadirReserva(reserva,this);
        }

        public Piloto getPiloto() {
            return piloto;
        }
        public List<ListarReservas> getComanda(){return comanda;}

        public String getReserva() {
            return reserva;
        }

        public void setPiloto(Piloto piloto) {
            this.piloto = piloto;
        }
        public void setReserva(String reserva) {
            this.reserva = reserva;
        }

    }
}
