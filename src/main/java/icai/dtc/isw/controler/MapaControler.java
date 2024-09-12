package main.java.icai.dtc.isw.controler;

import java.util.ArrayList;

import main.java.icai.dtc.isw.dao.MapaDAO;
import main.java.icai.dtc.isw.domain.localidad.Hotel;
import main.java.icai.dtc.isw.domain.ocio.Monumento;
import main.java.icai.dtc.isw.domain.localidad.Museo;
import main.java.icai.dtc.isw.domain.localidad.Restaurante;
import main.java.icai.dtc.isw.domain.ocio.Evento;
import main.java.icai.dtc.isw.domain.ocio.Parque;

public class MapaControler {

    //Relacionado con las localidades
    public  void getRestaurantes(ArrayList<Restaurante> lista) {MapaDAO.getRestaurantes(lista);}
    public void getHoteles(ArrayList<Hotel> lista) {
        MapaDAO.getHoteles(lista);
    }
    public void getMuseos(ArrayList<Museo> lista) {
        MapaDAO.getMuseos(lista);
    }
    //Relacionado ocio
    public  void getMonumentos(ArrayList<Monumento> lista) {MapaDAO.getMonumentos(lista);}
    public void getParques(ArrayList<Parque> lista) {
        MapaDAO.getParques(lista);
    }
    public void getEventos(ArrayList<Evento> lista) {
        MapaDAO.getEventos(lista);
    }

}
