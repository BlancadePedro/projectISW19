package main.java.icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;


public class CustomerDAO implements Iterator {


	public static void getClientes(ArrayList<Customer> lista) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Customer(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static Customer getCliente(String usuario, String contraseña) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		Customer customer = null;
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
			 ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				if (usuario.equals(rs.getString(7)) && (contraseña.equals(rs.getString(8)))) {
					customer = new Customer(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9));
				}
			}


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return customer;
	}


	public static void addCliente(Customer perfil) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios(correo,descripcion,edad,nacionalidad,nombrecompleto,telefono,usuario,clave,foto) VALUES ('" + perfil.getCorreo() + "','" + perfil.getDescripcion() + "'," + perfil.getEdad() + ",'" + perfil.getNacionalidad() + "','" + perfil.getNombreCompleto() + "'," + perfil.getTelefono() + ",'" + perfil.getUsuario() + "','" + perfil.getClave() + "'," + perfil.getFoto() + ")");
			 ResultSet rs = pst.executeQuery()) {

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void dropCliente(Customer perfil) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("DELETE FROM usuarios WHERE usuario = '" + perfil.getUsuario() + "'");
			 ResultSet rs = pst.executeQuery()) {

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void cambiarFoto(int foto, Customer perfil) {

		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET foto ='" + foto + "' WHERE usuario = '" + perfil.getUsuario() + "'");
			 ResultSet rs = pst.executeQuery()) {

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void cambiarCorreo(Customer perfil, String correo) {

		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET correo ='" + correo + "' WHERE usuario = '" + perfil.getUsuario() + "'");
			 ResultSet rs = pst.executeQuery()) {

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void cambiarDescripcion(Customer perfil, String descripcion) {

		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET descripcion ='" + descripcion + "' WHERE usuario = '" + perfil.getUsuario() + "'");
			 ResultSet rs = pst.executeQuery()) {

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void cambiarEdad(Customer perfil, String edad) {

		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET edad ='" + edad + "' WHERE usuario = '" + perfil.getUsuario() + "'");
			 ResultSet rs = pst.executeQuery()) {

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void cambiarNacionalidad(Customer perfil, String nacionalidad) {

		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET nacionalidad ='" + nacionalidad + "' WHERE usuario = '" + perfil.getUsuario() + "'");
			 ResultSet rs = pst.executeQuery()) {

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void cambiarTelefono (Customer perfil, String telefono){

			Connection con = ConnectionDAO.getInstance().getConnection();
			try (PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET telefono ='" + telefono + "' WHERE usuario = '" + perfil.getUsuario() + "'");
				 ResultSet rs = pst.executeQuery()) {

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

	}
	public static void cambiarNombre(Customer perfil, String nombrecompleto){

			Connection con = ConnectionDAO.getInstance().getConnection();
			try (PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET nombrecompleto ='" + nombrecompleto + "' WHERE usuario = '" + perfil.getUsuario() + "'");
				 ResultSet rs = pst.executeQuery()) {

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Object next() {
		return null;
	}
}







