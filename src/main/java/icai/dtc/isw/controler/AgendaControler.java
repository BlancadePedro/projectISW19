package main.java.icai.dtc.isw.controler;

import java.util.ArrayList;

import main.java.icai.dtc.isw.dao.AgendaDAO;
import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;
import main.java.icai.dtc.isw.domain.ui.Agenda.FranjaHorariaReal;

public class AgendaControler {
    public void getInfo(ArrayList<FranjaHorariaReal> lista, Customer customer) {
        AgendaDAO.getInfo(lista,customer);
    }
    public  void deleteAgenda(FranjaHorariaReal lista, Customer customer){
        AgendaDAO.deleteAgenda(lista,customer);}
    public void addAgenda(FranjaHorariaReal lista, Customer customer){
        AgendaDAO.addAgenda(lista,customer);
    }

}
