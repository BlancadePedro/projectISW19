package main.java.icai.dtc.isw.domain.ui.Usuario;

import main.java.icai.dtc.isw.client.Client;
import main.java.icai.dtc.isw.domain.ui.MapaMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;


public class InfoUsuario extends JFrame
{

    private JPanel pnlInfo = new JPanel(new GridLayout(6, 1));
    private JPanel pnlFoto = new JPanel((new BorderLayout()));
    private JPanel pnlBotones = new JPanel(new FlowLayout());
    private JPanel pnlPrueba = new JPanel(new GridLayout(1,2));
    
    private JLabel lblNombre = new JLabel();
    private JLabel lblEdad = new JLabel();
    private JLabel lblNacionalidad = new JLabel();
    private JLabel lblDescripcion = new JLabel();
    private JLabel lblCorreo = new JLabel();
    private JLabel lblTelefono = new JLabel();
    private JLabel foto = new JLabel();
    private JButton btnVolver = new JButton("Volver menú principal");
    private JButton btnModificar= new JButton("Modificar perfil");
    private JComboBox<String> opcionesFotos = new JComboBox<>();

    public InfoUsuario(Customer perfil){

        this.setLayout(new BorderLayout());
        this.setVisible(true);

        String nombre = perfil.getNombreCompleto();
        int edad = perfil.getEdad();
        String nacionalidad = perfil.getNacionalidad();
        String descripcion = perfil.getDescripcion();
        int telefono = perfil.getTelefono();
        String correo = perfil.getCorreo();

        lblNombre.setText(" Nombre: "+nombre);
        lblEdad.setText(String.valueOf(" Edad: "+edad));
        lblNacionalidad.setText(" Nacionalidad:  "+ nacionalidad);
        lblTelefono.setText(String.valueOf(" Contacto:  "+telefono));
        lblCorreo.setText(" Correo:  "+correo);
        lblDescripcion.setText(" Descripción:  "+descripcion);

        pnlInfo.add(lblNombre);
        pnlInfo.add(lblEdad);
        pnlInfo.add(lblNacionalidad);
        pnlInfo.add(lblCorreo);
        pnlInfo.add(lblTelefono);
        pnlInfo.add(lblDescripcion);


        opcionesFotos();
        pnlFoto.add(opcionesFotos, BorderLayout.NORTH);
        pnlBotones.add(btnVolver);
        pnlBotones.add(btnModificar);


        Image imagen = new ImageIcon("./src/main/java/icai/dtc/isw/resources/FotosPerfil/perfil"+perfil.getFoto()+".PNG").getImage();
        ImageIcon icono = new ImageIcon(imagen.getScaledInstance(250, 250 , Image.SCALE_SMOOTH));
        foto.setIcon(icono);
        pnlFoto.add(foto,BorderLayout.CENTER);

        opcionesFotos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int i = opcionesFotos.getSelectedIndex();
                int indice = i+1;

                perfil.setFoto(indice);
                Image imagen = new ImageIcon("./src/main/java/icai/dtc/isw/resources/FotosPerfil/perfil"+perfil.getFoto()+".PNG").getImage();
                ImageIcon icono = new ImageIcon(imagen.getScaledInstance(250, 250 , Image.SCALE_SMOOTH));
                foto.setIcon(icono);
                pnlFoto.add(foto,BorderLayout.CENTER);
                System.out.println(perfil.getFoto());

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("perfil",perfil);
                session.put("foto",indice);
                client.enviar("/updateFoto",session);

            }
        });

        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                new MapaMenu(perfil);
                dispose();

            }
        });

        btnModificar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                new ModificaciónUsuario(perfil);
                System.out.println("Me voy a modificar mis datos");
                dispose();

            }
        });

        pnlPrueba.add(pnlFoto,BorderLayout.WEST);
        pnlPrueba.add(pnlInfo,BorderLayout.EAST);
        this.add(pnlPrueba,BorderLayout.NORTH);
        this.add(pnlBotones,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(500,350);
        this.setResizable(true);//Para que se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }
    public void opcionesFotos(){
        opcionesFotos.removeAllItems();
        opcionesFotos.addItem("Personaje 1");
        opcionesFotos.addItem("Personaje 2");
        opcionesFotos.addItem("Personaje 3");
        opcionesFotos.addItem("Personaje 4");
        opcionesFotos.addItem("Personaje 5");

    }


}


    

