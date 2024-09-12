package main.java.icai.dtc.isw.domain.ui.Usuario;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	//Inicio de sesión
	private String clave = null;
	private String usuario = null;
	//Caracteristicas usuario
	private String nombreCompleto;
	private int edad;
	private String nacionlidad;
	private String descripcion;
	//Opcional
	private int telefono = 0;
	private String correo = null;
	private int foto = 0;
	public Customer(String correo, String descripcion, int edad, String nacionlidad, String nombreCompleto, int telefono, String usuario, String clave, int foto) {
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.nacionlidad = nacionlidad;
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.correo = correo;
		this.usuario = usuario;
		this.clave = clave;
		this.foto = foto;
	}


	public String getUsuario() {
		return usuario;
	}

	public String getClave() {
		return clave;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public int getEdad() {
		return edad;
	}

	public String getNacionalidad() {
		return nacionlidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public int getFoto() {
		return foto;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionlidad = nacionalidad;
	}

	public void setDescripcion(String descripcion) {

		if(descripcion.length()>15){
			this.descripcion = descripcion.substring(0,15);
		}else this.descripcion = descripcion;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setFoto(int foto) {
		this.foto = foto;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return nombreCompleto + edad + nacionlidad;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof Customer){
			Customer perfil = (Customer)o;
			if(perfil.getUsuario().equals(this.usuario) || perfil.getClave().equals(this.clave))
			{ return true;}else return false;
		}else return false;
	}
}











