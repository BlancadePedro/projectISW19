package main.java.icai.dtc.isw.domain.exception;

import javax.swing.*;

public class InicioSesionException extends Exception{
    public InicioSesionException(){
        JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos. Pruebe otra vez");

    }
}
