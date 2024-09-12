package main.java.icai.dtc.isw.domain.ui.Mapa;

import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;
import main.java.icai.dtc.isw.domain.ocio.Evento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PnlEventos extends JFrame {
    private JPanel panelCentro = new JPanel((new GridLayout()));
    private JPanel panelSur = new JPanel((new BorderLayout()));
    private JButton btnVolver = new JButton("Cerrar");

    public PnlEventos(ArrayList<Evento> lista, Customer perfil){

        super("Información de todos los eventos disponibles");
        Font fuente = new Font("Tahoma", Font.ITALIC, 17);
        int size = lista.size();

        panelCentro = new JPanel((new GridLayout(size*2,1)));
        panelCentro.setBackground(new Color(174, 214, 241));
        int contador=0;

        for (Evento l : lista) {
            int indice = contador+1;
            JLabel label = new JLabel(indice+"_"+l.getNombre()+"; Dirección: "+l.getDireccion()+ "; Autor: "+l.getAutor()+"; Precio: "+l.getPrecio()+"; Fecha: "+l.getFecha()+"; Es un "+l.getCelebracion()+"\n");
            label.setFont(fuente);
            JLabel espacio = new JLabel(" ");
            panelCentro.add(label);
            panelCentro.add(espacio);
            contador=contador+1;
        }
        btnVolver.setBackground(new Color(52, 152, 219));
        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent){

                dispose();

            }
        });

        panelSur.add(btnVolver);

        this.add(panelCentro,BorderLayout.CENTER);
        this.add(panelSur,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
