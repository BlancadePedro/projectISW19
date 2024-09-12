package main.java.icai.dtc.isw.dao;

import main.java.icai.dtc.isw.dao.AgendaDAO;
import main.java.icai.dtc.isw.domain.ui.Agenda.FranjaHorariaReal;
import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AgendaDAOTest extends TestCase {

    private static AgendaDAO dao;
    private static FranjaHorariaReal franja;
    private static Customer customer;

    @BeforeEach
    public void setUp() throws Exception {
        dao = new AgendaDAO();
    }


    @Test
    public void testAddAgenda() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","contraseña",0);
        franja = new FranjaHorariaReal("00:00-1:00", " viernes 31", "diciembre", "Noche vieja", "2021");
        dao.addAgenda(franja,customer);
        assertEquals(franja.getHora(),"00:00-1:00");
    }

    @Test
    public void testDeleteAgenda() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","contraseña",0);
        franja = new FranjaHorariaReal("00:00-1:00", " viernes 31", "diciembre", "Noche vieja", "2021");
        dao.deleteAgenda(franja,customer);
    }

    @Test
    public void testGetInfo() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","contraseña",0);

        ArrayList<FranjaHorariaReal> lista = new ArrayList<>();
        dao.getInfo(lista,customer);
        assertEquals(lista.get(0).getHora(),"00:00-1:00");
    }


}
