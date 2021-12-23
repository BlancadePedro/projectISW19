package icai.dtc.isw.dao;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.localidad.Hotel;
import icai.dtc.isw.domain.localidad.Museo;
import icai.dtc.isw.domain.localidad.Restaurante;
import icai.dtc.isw.domain.ocio.Evento;
import icai.dtc.isw.domain.ocio.Monumento;
import icai.dtc.isw.domain.ocio.Parque;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class MapaDAOTest {

    private static MapaDAO dao;

    @BeforeEach
    public void setUp() throws Exception {
        dao = new MapaDAO();

    }

    @Test
    public void testRestaurante(){
        ArrayList<Restaurante> lista = new ArrayList<>();
        dao.getRestaurantes(lista);

        assertEquals(lista.get(0).getNombre(),"MY Pasta Room");
    }

    @Test
    public void testHotel(){

        ArrayList<Hotel> lista = new ArrayList<Hotel>();

        dao.getHoteles(lista);

        assertEquals(lista.get(1).getNombre(),"Princesa Plaza Madrid");
    }

    @Test
    public void testMuseo(){

        ArrayList<Museo> lista = new ArrayList<Museo>();

        dao.getMuseos(lista);

        assertEquals(lista.get(0).getNombre(),"Museo Nacional Centro de Arte Reina Sofía");
    }

    @Test
    public void testEvento(){
        ArrayList<Evento> lista = new ArrayList<>();
        dao.getEventos(lista);

        assertEquals(lista.get(0).getNombre(),"Beret-concierto");
    }

    @Test
    public void testMonumento(){

        ArrayList<Monumento> lista = new ArrayList<Monumento>();

        dao.getMonumentos(lista);

        assertEquals(lista.get(1).getNombre(),"Plaza Mayor");
    }

    @Test
    public void testParque(){

        ArrayList<Parque> lista = new ArrayList<Parque>();

        dao.getParques(lista);

        assertEquals(lista.get(0).getNombre(),"Parque de El Retiro");
    }
}
