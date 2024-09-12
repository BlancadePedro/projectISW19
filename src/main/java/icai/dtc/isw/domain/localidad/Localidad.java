package main.java.icai.dtc.isw.domain.localidad;

import java.io.Serializable;

public class Localidad implements Serializable {
    private String nombre;
    private String direccion;
    private String horario;
    private String contacto;
    private String precio;
    private String barrio;
    private int id;

    public Localidad(String nombre, String direccion, String horario, String contacto, String precio, String barrio, int id) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.contacto = contacto;
        this.precio = precio;
        this.barrio = barrio;
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getHorario() {
        return horario;
    }
    public String getContacto() {
        return contacto;
    }
    public String getPrecio() {
        return precio;
    }
    public String getBarrio() {
        return barrio;
    }
    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return nombre + direccion + horario + contacto;
    }

}
