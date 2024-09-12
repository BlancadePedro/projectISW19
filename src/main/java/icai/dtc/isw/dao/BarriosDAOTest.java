package main.java.icai.dtc.isw.dao;

import main.java.icai.dtc.isw.dao.BarriosDAO;
import main.java.icai.dtc.isw.domain.localidad.Hotel;
import main.java.icai.dtc.isw.domain.localidad.Museo;
import main.java.icai.dtc.isw.domain.localidad.Restaurante;
import main.java.icai.dtc.isw.domain.ocio.Monumento;
import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BarriosDAOTest {

    private static BarriosDAO dao;
    private static Customer customer;

    @BeforeEach
    public void setUp() {
        dao = new BarriosDAO();
    }

    @Test
    public void getAustrias() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getAustrias(lista);

        assertEquals(((Restaurante)lista.get(0)).getNombre(),"Asador Real");
    }

    @Test
    public void getChueca() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getChueca(lista);

        assertEquals(((Restaurante)lista.get(0)).getNombre(),"Oven Mozzarella");
    }

    @Test
    public void getCondeDuque() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getCondeDuque(lista);

        assertEquals(((Hotel)lista.get(0)).getNombre(),"Hotel RIU Plaza España");
    }

    @Test
    public void getLatina() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getLatina(lista);

        assertEquals(((Restaurante)lista.get(0)).getNombre(),"La Musa Latina");
    }

    @Test
    public void getLavapies() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getLavapies(lista);

        assertEquals(((Restaurante)lista.get(0)).getNombre(),"Mas Al Sur");
    }

    @Test
    public void getLetras() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getLetras(lista);

        assertEquals(((Restaurante)lista.get(0)).getNombre(),"El Rincon de Esteban");
    }

    @Test
    public void getMalasana() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getMalasana(lista);

        assertEquals(((Hotel)lista.get(0)).getNombre(),"Hotel ibis Madrid Centro)");
    }

    @Test
    public void getMoncloa() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getMoncloa(lista);

        assertEquals(((Hotel)lista.get(0)).getNombre(),"Princesa Plaza Madrid");
    }

    @Test
    public void getPaseoArte() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getPaseoArte(lista);

        assertEquals(((Hotel)lista.get(0)).getNombre(),"Mandarin Oriental Ritz");
    }

    @Test
    public void getRetiro() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getRetiro(lista);

        assertEquals(((Museo)lista.get(0)).getNombre(),"Museo Nacional del Prado");
    }

    @Test
    public void getSalamanca() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getSalamanca(lista);

        assertEquals(((Monumento)lista.get(0)).getNombre(),"Fuente de Cibeles");
    }

    @Test
    public void getSalesas() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getSalesas(lista);

        assertEquals(((Restaurante)lista.get(0)).getNombre(),"Toto e Peppino");
    }

    @Test
    public void getSol() {
        ArrayList<Object> lista = new ArrayList<>();
        dao.getSol(lista);

        assertEquals(((Hotel)lista.get(0)).getNombre(),"Generator Madrid");
    }

    @Test
    public void addFavorito() {
        customer = new Customer("a","a",1,"a","a",1,"prueba","prueba",0);
        Object object = new Monumento("Monumento a Felipe IV","Plaza de Oriente","Austrias",308);
        dao.addFavorito(object,customer);
        ArrayList<Object> lista = new ArrayList<>();
        dao.verFavoritos(customer,lista);

        assertEquals(((Monumento)lista.get(0)).getNombre(),"Monumento a Felipe IV");
    }

    @Test
    public void verFavoritos() {
        customer = new Customer("a","a",1,"a","a",1,"prueba","prueba",0);
        ArrayList<Object> lista = new ArrayList<>();
        dao.verFavoritos(customer,lista);

        assertEquals(((Monumento)lista.get(0)).getNombre(),"Monumento a Felipe IV");
    }
}