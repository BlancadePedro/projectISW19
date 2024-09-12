package main.java.icai.dtc.isw.dao;

import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;
import main.java.icai.dtc.isw.domain.localidad.Hotel;
import main.java.icai.dtc.isw.domain.localidad.Museo;
import main.java.icai.dtc.isw.domain.localidad.Restaurante;
import main.java.icai.dtc.isw.domain.ocio.Evento;
import main.java.icai.dtc.isw.domain.ocio.Monumento;
import main.java.icai.dtc.isw.domain.ocio.Parque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class BarriosDAO implements Iterator {
    public static void getAustrias(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='Austrias'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='Austrias'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='Austrias'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='Austrias'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='Austrias'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='Austrias'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void getChueca(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='Chueca'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='Chueca'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='Chueca'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='Chueca'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='Chueca'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='Chueca'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void getCondeDuque(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='Conde Duque'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='Conde Duque'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='Conde Duque'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='Conde Duque'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='Conde Duque'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='Conde Duque'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void getLatina(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='La Latina'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='La Latina'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='La Latina'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='La Latina'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='La Latina'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='La Latina'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void getLavapies(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='Lavapies'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='Lavapies'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='Lavapies'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='Lavapies'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='Lavapies'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='Lavapies'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void getLetras(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='Letras'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='Letras'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='Letras'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='Letras'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='Letras'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='Letras'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void getMalasana(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='Malasana'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='Malasana'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='Malasana'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='Malasana'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='Malasana'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='Malasana'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void getMoncloa(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='Moncloa'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='Moncloa'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='Moncloa'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='Moncloa'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='Moncloa'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='Moncloa'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void getPaseoArte(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='Paseo del Arte'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='Paseo del Arte'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='Paseo del Arte'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='Paseo del Arte'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='Paseo del Arte'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='Paseo del Arte'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void getRetiro(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='El Retiro'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='El Retiro'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='El Retiro'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='El Retiro'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='El Retiro'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='El Retiro'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void getSalamanca(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='Salamanca'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='Salamanca'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='Salamanca'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='Salamanca'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='Salamanca'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='Salamanca'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void getSalesas(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='Salesas'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='Salesas'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='Salesas'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='Salesas'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='Salesas'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='Salesas'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void getSol(ArrayList<Object> lista) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles WHERE barrio='Sol'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE barrio='Sol'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos WHERE barrio='Sol'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento WHERE barrio='Sol'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento WHERE barrio='Sol'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque WHERE barrio='Sol'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }

    public static void addFavorito(Object lugar, Customer perfil) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        if (lugar instanceof Hotel){
            Hotel h = (Hotel)lugar;
            try (PreparedStatement pst = con.prepareStatement("INSERT INTO favoritos(usuario,idlugar) VALUES('"+perfil.getUsuario()+"',"+h.getId()+")");
                 ResultSet rs = pst.executeQuery()){
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }else if(lugar instanceof Restaurante){
            Restaurante r = (Restaurante)lugar;
            try (PreparedStatement pst = con.prepareStatement("INSERT INTO favoritos(usuario,idlugar) VALUES('"+perfil.getUsuario()+"',"+r.getId()+")");
                 ResultSet rs = pst.executeQuery()){
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }else if(lugar instanceof Museo) {
            Museo m = (Museo) lugar;
            try (PreparedStatement pst = con.prepareStatement("INSERT INTO favoritos(usuario,idlugar) VALUES('"+perfil.getUsuario()+"',"+m.getId()+")");
                 ResultSet rs = pst.executeQuery()){
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }else if(lugar instanceof Parque) {
            Parque p = (Parque) lugar;
            try (PreparedStatement pst = con.prepareStatement("INSERT INTO favoritos(usuario,idlugar) VALUES('"+perfil.getUsuario()+"',"+p.getId()+")");
                 ResultSet rs = pst.executeQuery()){
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }else if(lugar instanceof Monumento) {
            Monumento mo = (Monumento) lugar;
            try (PreparedStatement pst = con.prepareStatement("INSERT INTO favoritos(usuario,idlugar) VALUES('"+perfil.getUsuario()+"',"+mo.getId()+")");
                 ResultSet rs = pst.executeQuery()){
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }else if(lugar instanceof Evento) {
            Evento e = (Evento) lugar;
            try (PreparedStatement pst = con.prepareStatement("INSERT INTO favoritos(usuario,idlugar) VALUES('"+perfil.getUsuario()+"',"+e.getId()+")");
                 ResultSet rs = pst.executeQuery()){
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void eliminarFavorito(Object lugar, Customer perfil) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        if (lugar instanceof Hotel){
            Hotel h = (Hotel)lugar;
            try (PreparedStatement pst = con.prepareStatement("DELETE FROM favoritos WHERE usuario='"+perfil.getUsuario()+"' AND idlugar='"+h.getId()+"'");
                 ResultSet rs = pst.executeQuery()){
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }else if(lugar instanceof Restaurante){
            Restaurante r = (Restaurante)lugar;
            try (PreparedStatement pst = con.prepareStatement("DELETE FROM favoritos WHERE usuario='"+perfil.getUsuario()+"' AND idlugar='"+r.getId()+"'");
                 ResultSet rs = pst.executeQuery()){
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }else if(lugar instanceof Museo) {
            Museo m = (Museo) lugar;
            try (PreparedStatement pst = con.prepareStatement("DELETE FROM favoritos WHERE usuario='"+perfil.getUsuario()+"' AND idlugar='"+m.getId()+"'");
                 ResultSet rs = pst.executeQuery()){
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }else if(lugar instanceof Parque) {
            Parque p = (Parque) lugar;
            try (PreparedStatement pst = con.prepareStatement("DELETE FROM favoritos WHERE usuario='"+perfil.getUsuario()+"' AND idlugar='"+p.getId()+"'");
                 ResultSet rs = pst.executeQuery()){
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }else if(lugar instanceof Monumento) {
            Monumento mo = (Monumento) lugar;
            try (PreparedStatement pst = con.prepareStatement("DELETE FROM favoritos WHERE usuario='"+perfil.getUsuario()+"' AND idlugar='"+mo.getId()+"'");
                 ResultSet rs = pst.executeQuery()){
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }else if(lugar instanceof Evento) {
            Evento e = (Evento) lugar;
            System.out.println("EVENTO BORRAR "+e.getId());
            try (PreparedStatement pst = con.prepareStatement("DELETE FROM favoritos WHERE usuario='"+perfil.getUsuario()+"' AND idlugar='"+e.getId()+"'");
                 ResultSet rs = pst.executeQuery()){
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void verFavoritos(Customer perfil,ArrayList<Object> lista){
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * \n" + "FROM hoteles\n" + "JOIN favoritos\n" + "ON cast(hoteles.idhotel as text) = favoritos.idlugar WHERE favoritos.usuario='"+perfil.getUsuario()+"';");
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * \n" + "FROM restaurantes\n" + "JOIN favoritos\n" + "ON cast(restaurantes.idrestaurante as text) = favoritos.idlugar WHERE favoritos.usuario='"+perfil.getUsuario()+"';");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * \n" + "FROM museos\n" + "JOIN favoritos\n" + "ON cast(museos.idmuseo as text) = favoritos.idlugar WHERE favoritos.usuario='"+perfil.getUsuario()+"';");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * \n" + "FROM monumento\n" + "JOIN favoritos\n" + "ON cast(monumento.idmonumento as text) = favoritos.idlugar WHERE favoritos.usuario='"+perfil.getUsuario()+"';");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Monumento(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * \n" + "FROM evento\n" + "JOIN favoritos\n" + "ON cast(evento.idevento as text) = favoritos.idlugar WHERE favoritos.usuario='"+perfil.getUsuario()+"';");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        try (PreparedStatement pst = con.prepareStatement("SELECT * \n" + "FROM parque\n" + "JOIN favoritos\n" + "ON cast(parque.idparque as text) = favoritos.idlugar WHERE favoritos.usuario='"+perfil.getUsuario()+"';");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
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
