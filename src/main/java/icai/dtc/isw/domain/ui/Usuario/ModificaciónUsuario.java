package main.java.icai.dtc.isw.domain.ui.Usuario;

import main.java.icai.dtc.isw.client.Client;
import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;
import main.java.icai.dtc.isw.domain.ui.Usuario.InfoUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ModificaciónUsuario extends JFrame {

    private JButton btnNombre = new JButton("Nombre");
    private JButton btnEdad = new JButton("Edad");
    private JButton btnNacionalidad = new JButton("Nacionalidad");
    private JButton btnDescripcion = new JButton("Descripción");
    private JButton btnCorreo = new JButton("Correo");
    private JButton btnTelefono = new JButton("Telefono");
    private JButton btnVolver = new JButton("Volver a mi perfil");

    private JLabel lblMensaje = new JLabel("Elija la opción que sea cambiar");

    private JPanel pnlMensaje = new JPanel(new FlowLayout());
    private JPanel pnlBotones = new JPanel(new GridLayout(3,2,6, 6));
    private JPanel pnlTerminar = new JPanel(new FlowLayout());

    public ModificaciónUsuario(Customer perfil){

        pnlMensaje.add(lblMensaje);

        pnlBotones.add(btnNombre);
        pnlBotones.add(btnEdad);
        pnlBotones.add(btnNacionalidad);
        pnlBotones.add(btnDescripcion);
        pnlBotones.add(btnCorreo);
        pnlBotones.add(btnTelefono);

        pnlTerminar.add(btnVolver);

        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                new InfoUsuario(perfil);
                dispose();

            }
        });

        btnNombre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String nombre = JOptionPane.showInputDialog("Introduzca su nuevo nombre: ");
                System.out.println(nombre);
                perfil.setNombreCompleto(nombre);
                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("perfilNombre",perfil);
                session.put("cambioNombre",nombre);
                client.enviar("/updateNombre",session);


            }
        });

        btnEdad.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String edad = JOptionPane.showInputDialog("Introduzca su edad: ");
                perfil.setEdad(Integer.parseInt(edad));
                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("perfilEdad",perfil);
                session.put("cambioEdad",edad);
                client.enviar("/updateEdad",session);


            }
        });

        btnCorreo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String correo = JOptionPane.showInputDialog("Introduzca su nuevo correo: ");
                perfil.setCorreo(correo);
                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("perfilCorreo",perfil);
                session.put("cambioCorreo",correo);
                client.enviar("/updateCorreo",session);
            }
        });

        btnDescripcion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String descripcion = JOptionPane.showInputDialog("Introduzca una descripción breve (máx 16 caracteres): ");
                perfil.setDescripcion(descripcion);
                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("perfilDescripcion",perfil);
                session.put("cambioDescripcion",descripcion);
                client.enviar("/updateDescripcion",session);
            }
        });

        btnTelefono.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String telefono = JOptionPane.showInputDialog("Introduzca su telefono: ");
                perfil.setTelefono(Integer.parseInt(telefono));
                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("perfilTelefono",perfil);
                session.put("cambioTelefono",telefono);
                client.enviar("/updateTelefono",session);
            }

        });

        btnNacionalidad.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String nacionalidad = JOptionPane.showInputDialog("Introduzca su nacionalidad: ");
                perfil.setNacionalidad(nacionalidad);
                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("perfilNacionalidad",perfil);
                session.put("cambioNacionalidad",nacionalidad);
                client.enviar("/updateNacionalidad",session);
            }

        });

        this.add(pnlMensaje,BorderLayout.NORTH);
        this.add(pnlBotones,BorderLayout.CENTER);
        this.add(pnlTerminar, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(false);//Para que se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }
}
