package main.java.icai.dtc.isw.dao;

import main.java.icai.dtc.isw.dao.CustomerDAO;
import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerDAOTest extends TestCase {

    private static CustomerDAO dao;
    private static Customer customer;

    @BeforeEach
    public void setUp() throws Exception {
        dao = new CustomerDAO();

    }

    @Test
    public void testGetCliente() {

        Customer usuario = dao.getCliente("blancadepedr","blancadepedr");
        assertEquals(usuario.getUsuario(),"blancadepedr");
    }

    @Test
    public void testAddCliente() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","clave",1);
        dao.addCliente(customer);
        String usuario = customer.getUsuario();
        assertEquals(usuario, "usuario");
    }


    @Test
    public void testCambiarCorreo() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","contraseña",0);
        dao.cambiarCorreo(customer,"prueba@gmail.com");

        assertEquals(dao.getCliente("usuario","contraseña").getCorreo(), "prueba@gmail.com");
    }

    @Test
    public void testCambiarDescripcion() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","contraseña",0);
        dao.cambiarDescripcion(customer,"cambio de la descripcion");

        assertEquals(dao.getCliente("usuario","contraseña").getDescripcion(), "cambio de la descripcion");
    }

    @Test
    public void testCambiarEdad() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","contraseña",0);
        dao.cambiarEdad(customer,"20");

        assertEquals(dao.getCliente("usuario","contraseña").getEdad(), 20);
    }


    @Test
    public void testCambiarNacionalidad() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","contraseña",0);
        dao.cambiarNacionalidad(customer,"cambio de la nacionalidad");

        assertEquals(dao.getCliente("usuario","contraseña").getNacionalidad(), "cambio de la nacionalidad");
    }

    @Test
    public void testCambiarTelefono() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","contraseña",0);
        dao.cambiarTelefono(customer,"222222222");

        assertEquals(dao.getCliente("usuario","contraseña").getTelefono(), 222222222);
    }

    @Test
    public void testCambiarNombre() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","contraseña",0);
        dao.cambiarNombre(customer,"cambio del nombre");

        assertEquals(dao.getCliente("usuario","contraseña").getNombreCompleto(), "cambio del nombre");
    }
}