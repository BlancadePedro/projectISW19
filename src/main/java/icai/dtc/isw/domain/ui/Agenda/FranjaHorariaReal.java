package main.java.icai.dtc.isw.domain.ui.Agenda;

import java.io.Serializable;

public class FranjaHorariaReal implements FranjaHoraria{

    private String descripcion;
    private String hora;
    private String dia;
    private String mes;
    private String año;

    private boolean comprobacion;

    public FranjaHorariaReal(String hora, String dia, String mes, String descripcion, String año) {

        this.hora = hora;
        this.dia=dia;
        this.mes = mes;
        this.descripcion = descripcion;
        this.año=año;

    }

    public String getHora() {
        return hora;
    }
    public String getDescripcion() {return descripcion;}
    public String getDia(){return dia;}
    public String getMes(){return mes;}
    public String getAño(){return año;}



    public void setHora(String hora) {this.hora= hora;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public void setDia(String dia) {this.dia= dia;}
    public void setMes(String mes) {this.mes = mes;}
    public void setAño(String año){this.año = mes;}


    public boolean getComprobacion(){if(descripcion == null){
        comprobacion = false;
    }else comprobacion = true;
        return comprobacion;
    }


}
