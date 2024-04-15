package edu.upc.dsa;

import edu.upc.dsa.services.ManagerOperacionsDron;
import org.junit.Before;
import org.junit.Test;

public class TestManagerDron
{
    private DronManager fachada;
    @Before
    public void setUp() throws Exception
    {
        this.fachada = DronManagerImpl.getInstance();
    }

    @Test
    public void testAddDron() throws Exception
    {
        portada.addDron("1", "Dron1", "Fabricante1", "Modelo1");

    }
    @Test
            public void listaDronesxhorasdVueloDes()
    {
        portada.addDron("1", "Dron1", "Fabricante1", "Modelo1", "horasVuelo");
    }



}
