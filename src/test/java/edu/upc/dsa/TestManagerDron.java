package edu.upc.dsa;

import edu.upc.dsa.services.ManagerOperacionsDron;
import org.junit.Before;
import org.junit.Test;

public class TestManagerDron
{
    private ManagerOperacionsDron fachada;
    @Before
    public void setUp(
    {
        fachada = DronManager
    }
    )
    @Test
    public void testAddDron()
    {
        ManagerFleetDronsImpl portada = ManagerFleetDronsImpl.getInstance();
        portada.addDron("1", "Dron1", "Fabricante1", "Modelo1");
        //Comprobamso que el drons se añadio correctamente
    }
}
