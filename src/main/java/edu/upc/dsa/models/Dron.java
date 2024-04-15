package edu.upc.dsa.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Dron implements Comparable<Dron> {
    private String nom;
    private String fabricante;
    private String modelo;
    private String id;
    private int horasVuelo;
    private int numVuelos;
    private int posicion;
    private boolean operativo;
    private boolean enMantenimiento;
    private static List<Dron> drons = new ArrayList<>(); //agrego lista

    public Dron()
    {
    }

    public Dron(String nombre, int horasVuelo, String identificador, String id, String modelo, int numVuelos, int posicion) {
        this.nom = nombre;
        this.id = identificador;
        this.modelo = modelo;
        this.numVuelos = numVuelos;
        this.horasVuelo = horasVuelo;
        this.operativo = false;
    }
    @Override
    public String toString()
    {
        return "Dron{" +
                "id='" + id + ", nombre ='" + nom +
                ", fabricante='" + fabricante + ", modelo='" + modelo +
                ", horasVuelo=" + horasVuelo + ", numVuelos=" + numVuelos +
                '}';
    }



    public static void ordenarDronsxhoasVuelo() {
        Collections.sort(drons, new Comparator<Dron>() {
            @Override
            public int compare(Dron d1, Dron d2) {
                return Integer.compare(d2.getHorasvuelo(), d1.getHorasvuelo());
            }
        });
    }

    public void sumarHorasVuelo(int cantidad) {
        horasVuelo += cantidad;
    }

    @Override

    public int compareTo(Dron otroDron) {
        return Integer.compare(this.horasVuelo, otroDron.getHorasvuelo());
    }

    public boolean disponible()
    {
        return true;
    }
    public boolean disponible(LocalDateTime fecha, int duracion)
    {

    }


    //getysets de cada elemento
    public int getHorasvuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(int horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public void setHorasvuelo(int horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public String getNom() {
        return this.nom;
    }
    public String getId(){ return this.id;}

    public int getNumVuelos() {
        return numVuelos;
    }
    public int getPosicion()
    {
        return posicion;
    }
    public void setPosicion(int posicion)
    {
        this.posicion =posicion;
    }

    public String setId()
    {
        return this.id = id;

    }

    public void setEnMantenimiento(boolean enMantenimiento)
    {
        this.enMantenimiento = enMantenimiento;
    }



}

