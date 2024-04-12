package edu.upc.dsa;
import java.util.*;

public class Piloto
{
        private String identificador;
        private String nombre;
        private String apellido;
        private ArrayList<String> vuelosRealizados=new ArrayList<>();
        private List<Vuelo> horasRealizadas= new LinkedList<>();

        public Piloto(){}

        public Piloto(String identificador, String nombre, String apellido) {
            this.identificador = identificador;
            this.apellido=apellido;
            this.nombre=nombre;

        }

        List<Piloto> pilotos =new ArrayList<>();
        Collections.sort(pilotos,new Comparator<Piloto>){
        @Override
                public int compare(Piloto p1, Piloto p2){
            return Integer.compare(p2.getHorasVuelo(), p1.getHorasVuelo));
    }
        }


        public ArrayList<String> listarVuelosString() {
            return vuelosRealizados;
        }
        public List<Vuelo>  listarVuelos() {
            return horasRealizadas;
        }

        public void añadirVuelo(String vueloRealizado,Vuelo vuelo) {
            horasRealizadas.add(vuelo);
            vuelosRealizados.add(vueloRealizado);
        }

        public void setIdentificador (String identificador) {
            this.identificador = identificador;
        }
        public String getIdentificador()
        {
            return this.identificador;
        }
        public String getNombre()
        {
            return this.nombre;
        }
        public String getApellido()
        {
            return  this.apellido;
        }
    }

