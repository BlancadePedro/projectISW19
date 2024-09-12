package main.java.icai.dtc.isw.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;
import main.java.icai.dtc.isw.domain.ui.Agenda.FranjaHorariaReal;

public class AgendaDAO implements Iterator {
    public static void addAgenda(FranjaHorariaReal lista, Customer perfil) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("INSERT INTO agenda (usuario,hora,dia,mes,descripcion,año) VALUES ('"+perfil.getUsuario()+"','"+lista.getHora()+"','"+lista.getDia()+"','"+lista.getMes()+"','"+lista.getDescripcion()+"','"+lista.getAño()+"')");
             ResultSet rs = pst.executeQuery()) {

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteAgenda(FranjaHorariaReal lista, Customer perfil) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("DELETE FROM agenda WHERE usuario = '"+perfil.getUsuario()+"' and descripcion = '"+lista.getDescripcion()+"' and hora='"+lista.getHora()+"'");
             ResultSet rs = pst.executeQuery()) {

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }


    public static void getInfo(ArrayList<FranjaHorariaReal> lista, Customer perfil) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM agenda WHERE usuario = '"+perfil.getUsuario()+"'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                    lista.add(new FranjaHorariaReal(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

            }

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
