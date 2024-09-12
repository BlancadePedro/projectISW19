package main.java.icai.dtc.isw.domain.ui.Agenda;

import main.java.icai.dtc.isw.client.Client;
import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class AñadirAgenda extends JFrame {
    private JTextField txtHora;
    private JTextField txtDia;
    private JTextField txtMes;
    private JTextField txtAño;
    private JTextField txtDescripcion;
    private JPanel pnlRellenar;
    private JPanel pnlDescripcion;
    private JButton btnAñadir,btnVolver;
    public AñadirAgenda(Customer perfil,int idagenda){

        LocalDate hoy = LocalDate.now();
        String fecha = "Agenda para el día " + hoy.getDayOfMonth() + " de " + hoy.getMonth() + " de " + hoy.getYear();

        pnlRellenar = new JPanel(new FlowLayout());
        pnlDescripcion = new JPanel(new FlowLayout());

        txtHora = new JTextField("Introduzca la hora");
        txtDia = new JTextField("Introduzca el día");
        txtMes = new JTextField("Introduzca el mes");
        txtAño = new JTextField("Introduzca el año");

        pnlRellenar.add(txtHora);
        pnlRellenar.add(txtDia);
        pnlRellenar.add(txtMes);
        pnlRellenar.add(txtAño);

        txtDescripcion = new JTextField("Introdca la descripcion");
        pnlDescripcion.add(txtDescripcion);
        btnAñadir = new JButton("Añadir");
        btnVolver = new JButton("Volver");

        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                ArrayList<FranjaHorariaReal> listaInfo = new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("listaAgenda",listaInfo);
                session.put("perfilAgenda",perfil);
                client.enviar("/infoAgenda",session);
                dispose();

            }
        });


        btnAñadir.addActionListener(new ActionListener() {
            int contador=idagenda;
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                contador = contador+1;
                FranjaHorariaReal add = new FranjaHorariaReal(txtHora.getText(),txtDia.getText(),txtMes.getText(),txtDescripcion.getText(),txtAño.getText());

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("add",add);
                session.put("idAdd",perfil);
                client.enviar("/addAgenda",session);

            }
        });

        pnlDescripcion.add(btnAñadir);
        pnlDescripcion.add(btnVolver);

        this.add(pnlRellenar,BorderLayout.CENTER);
        this.add(pnlDescripcion,BorderLayout.SOUTH);
        this.setTitle(fecha);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}
