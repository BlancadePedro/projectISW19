package main.java.icai.dtc.isw.domain.localidad;

import main.java.icai.dtc.isw.domain.localidad.Localidad;

public class Restaurante extends Localidad {
    private String tipoComida;


    public Restaurante(String nombre, String direccion, String horario, String contacto, String precio, String tipoComida,String barrio, int id)  {
        super(nombre, direccion, horario, contacto, precio, barrio, id);
        this.tipoComida = tipoComida;

    }
    public String getTipoComida() {
        return tipoComida;
    }
    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }
}
