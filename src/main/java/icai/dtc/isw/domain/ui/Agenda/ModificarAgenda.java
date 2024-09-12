package main.java.icai.dtc.isw.domain.ui.Agenda;

import main.java.icai.dtc.isw.client.Client;
import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class ModificarAgenda extends  JFrame{

    private JPanel panelCentro;
    private JPanel panelSur = new JPanel((new BorderLayout()));
    private JButton btnVolver = new JButton("Cerrar");


    public ModificarAgenda(Customer perfil,ArrayList<FranjaHorariaReal> lista){

        Font fuente = new Font("Tahoma", Font.ITALIC, 17);
        Font fuenteTitulo = new Font("Tahoma", Font.BOLD, 17);

        int size = lista.size();
        panelCentro = new JPanel((new GridLayout(size*2,2)));
        ArrayList<JButton> eliminarList = new ArrayList<>();
        ArrayList<JButton> editarList = new ArrayList<>();

        int contador=0;
        for (FranjaHorariaReal f : lista){
            int indice = contador+1;

            JButton btnEliminar = new JButton("Eliminar");
            JButton btnEditar = new JButton("Editar");

            JLabel hora = new JLabel(indice+"_"+"Hora: "+f.getHora());
            hora.setFont(fuenteTitulo);
            JLabel dia = new JLabel("Día: "+f.getDia());
            dia.setFont(fuenteTitulo);
            JLabel mes = new JLabel("Mes: "+f.getMes());
            mes.setFont(fuenteTitulo);
            JLabel año = new JLabel("Año: "+f.getAño());
            año.setFont(fuenteTitulo);

            JLabel descripcion = new JLabel("Descripcion: "+f.getDescripcion());
            descripcion.setFont(fuenteTitulo);
            panelCentro.add(hora);
            panelCentro.add(dia);
            panelCentro.add(mes);
            panelCentro.add(año);
            panelCentro.add(descripcion);

            int finalContador = contador;
            btnEliminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Se ha pulsado boton de eliminar");
                    Client client = new Client();
                    HashMap<String, Object> session = new HashMap<>();
                    session.put("delete",f);
                    session.put("idDelete",perfil); //Contiene el lugar que se quiere poner como favorito
                    client.enviar("/deleteAgenda",session);

                }
            });


            eliminarList.add(btnEliminar);
            panelCentro.add(btnEliminar);
            contador=contador+1;
        }
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                ArrayList<FranjaHorariaReal> listaInfo = new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("listaAgenda",listaInfo);
                session.put("perfilAgenda",perfil);
                client.enviar("/infoAgenda",session);
                dispose();
            }
        });

        panelSur.add(btnVolver);

        this.add(panelCentro,BorderLayout.CENTER);
        this.add(panelSur,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }



}
