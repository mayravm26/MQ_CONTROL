package edu.upc.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dron {
    public class Dron implements Comparable<Dron> {
        private String nombre;
        private String fabricante;
        private String modelo;
        private String identificador;
        private int numVuelos;
        private int horasVuelo;
        List<Dron> drons= new ArrayList<>();

        Collections.sort(drons, new Comparator<Dron>()
        {
            @override
            public int compare(Dron d1, Dron d2)
            {
                return Integer.compare(d2.getHorasVuelo(), d1.getHorasVuelo());
            }

        }
        public Dron() {
        }



        public Dron(String nombre, int horasVuelo, String identificador, String identificador, String modelo) {
            this.nombre = nombre;
            this.identificador = identificador;
            this.modelo = modelo;
            this.numVuelos = 0;
            this.horasVuelo = horasVuelo;
        }

        public void incrementarNumhorasv(int cantidad) {
            horasv += cantidad;
        }

        public int compareTo(Dron p) {
            return Double.compare(this.horasv, p.getNumVuelos());
        }

        public String getNombre() {
            return this.nombre;
        }

        public int getNumVuelos() {
            return numVuelos;
        }

        public double getHorasv() {
            return horasv;
        }

        public void setNumVuelos(int numVuelos) {
            this.numVuelos = numVuelos;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setHorasv(double horasv) {
            this.horasv = horasv;
        }

    }

}