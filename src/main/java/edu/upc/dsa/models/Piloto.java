package edu.upc.dsa.models;
import java.util.*;

public class Piloto
{
         String identificador;
        String nombre;
        String apellido;
         int horasVuelop;
         boolean Ocupado;
        private ArrayList<String> vuelosRealizados =new ArrayList<>();
        private List<Vuelo> horasRealizadas = new ArrayList<>();

    public Piloto(String identificador, String nombre, String apellido, int horasVuelop)
    {
        this.identificador = identificador;
        this.apellido = apellido;
        this.nombre = nombre;
        this.horasVuelop = 0;
        this.Ocupado =false;
    }

    public String toString()
    {
        return "Piloto{" + "id='" +identificador + "- nombre='" + nombre + ", apellido='" + apellido + '\''
                + ", horasVuelop=" + horasVuelop + '}';
    }
    public ArrayList<String> listarVuelosString()
    {
        return vuelosRealizados;
    }
    public List<Vuelo> ListarVuelos()
    {
        return horasRealizadas;
    }
    public void AddVuelo(String vueloRealizado, Vuelo vuelo)
    {
        horasRealizadas.add(vuelo);
        vuelosRealizados.add(vueloRealizado);
    }
    public void setIdentificador(String identificador)
    {
        this.identificador = identificador;
    }

    //Ordenarpilotos por horas de vuelo

    public static void ordenarPilotosxhVuelo(List<Piloto> pilotos)
    {
        Collections.sort(pilotos, new Comparator<Piloto>() {
            @Override
            public int compare(Piloto o1, Piloto o2) {
                return Integer.compare(o2.getHorasVuelop(),o1.getHorasVuelop());
            }
        });
    }

    //Get set de cada atributo
    public String getIdentificador()
    {
        return  this.identificador;
    }
    public String getNombre()
    {
        return this.nombre;
    }
    public String getApellido()
    {
        return this.apellido;
    }
    public int getHorasVuelop()
    {
        return horasVuelop;
    }
    public void setHorasVuelop(int horasVuelop)
    {
        this.horasVuelop = horasVuelop;
    }

    public boolean disponible()
    {

        return false;
    }
}


