package main.java.icai.dtc.isw.controler;


import java.util.ArrayList;

import main.java.icai.dtc.isw.dao.CustomerDAO;
import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;


public class CustomerControler {

	public void getCustomer(ArrayList<Customer> lista) {
		CustomerDAO.getClientes(lista);
	}
	public Customer getCliente(String usuario, String contraseña){
		return CustomerDAO.getCliente(usuario, contraseña);}
	public void addCliente(Customer perfil){ CustomerDAO.addCliente(perfil);}
	public void updateNombre(Customer perfil,String cambio){CustomerDAO.cambiarNombre(perfil, cambio);}
	public void updateEdad(Customer perfil, String cambio){CustomerDAO.cambiarEdad(perfil,cambio);}
	public void updateCorreo(Customer perfil,String cambio){CustomerDAO.cambiarCorreo(perfil,cambio);}
	public void updateDescripcion(Customer perfil, String cambio){CustomerDAO.cambiarDescripcion(perfil,cambio);}
	public void updateTelefono(Customer perfil,String cambio){CustomerDAO.cambiarTelefono(perfil,cambio);}
	public void updateNacionalidad(Customer perfil, String cambio){CustomerDAO.cambiarNacionalidad(perfil,cambio);}

	public void updateFoto(Customer perfil,int foto){CustomerDAO.cambiarFoto(foto, perfil);}
	public void darsedeBaja(Customer perfil){ CustomerDAO.dropCliente(perfil);}

}
