package main.java.icai.dtc.isw.domain.ocio;

import java.io.Serializable;

public class Ocio implements Serializable {
    private String nombre;
    private String direccion;
    private String barrio;
    private int id;

    public Ocio(String nombre, String direccion, String barrio, int id) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.barrio = barrio;
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return direccion;
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
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return nombre + direccion;
    }
}