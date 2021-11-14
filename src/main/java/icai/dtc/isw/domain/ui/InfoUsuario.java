package icai.dtc.isw.domain.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;


public class InfoUsuario extends JFrame
{
   
    /*public static void main(String[] argv){
        int foto = 0;
        Customer perfil = new Customer("correo", "descripcion", 20, "nacionalidad","nombreCompleto", 646513445, "usuario","clave",foto);
        new InfoUsuario(perfil);

    }*/
    
    private JPanel info = new JPanel(new GridLayout(6, 1));
    private JPanel pnlfoto = new JPanel((new BorderLayout()));

    
    private JLabel lblNombre = new JLabel();
    private JLabel lblEdad = new JLabel();
    private JLabel lblNacionalidad = new JLabel();
    private JLabel lblDescripcion = new JLabel();
    private JLabel lblCorreo = new JLabel();
    private JLabel lblTelefono = new JLabel();
    private JLabel foto = new JLabel();
    private JButton btnVolver = new JButton("Volver menú principal");
    private JComboBox<String> opcionesFotos = new JComboBox<>();

    public InfoUsuario(Customer perfil){
    
        this.setLayout(new GridLayout(1,2));
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

        info.add(lblNombre);
        info.add(lblEdad);
        info.add(lblNacionalidad);
        info.add(lblCorreo);
        info.add(lblTelefono);
        info.add(lblDescripcion);

        opcionesFotos();
        pnlfoto.add(opcionesFotos, BorderLayout.NORTH);
        pnlfoto.add(btnVolver, BorderLayout.SOUTH);

        Image imagen = new ImageIcon("./src/main/java/icai/dtc/isw/resources/FotosPerfil/perfil"+perfil.getFoto()+".PNG").getImage();
        ImageIcon icono = new ImageIcon(imagen.getScaledInstance(250, 250 , Image.SCALE_SMOOTH));
        foto.setIcon(icono);
        pnlfoto.add(foto,BorderLayout.CENTER);

        opcionesFotos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int i = opcionesFotos.getSelectedIndex();
                int indice = i+1;

                perfil.setFoto(indice);
                Image imagen = new ImageIcon("./src/main/java/icai/dtc/isw/resources/FotosPerfil/perfil"+perfil.getFoto()+".PNG").getImage();
                ImageIcon icono = new ImageIcon(imagen.getScaledInstance(250, 250 , Image.SCALE_SMOOTH));
                foto.setIcon(icono);
                pnlfoto.add(foto,BorderLayout.CENTER);
                System.out.println(perfil.getFoto());

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("perfil",perfil);
                session.put("foto",indice);
                client.enviar("/updateUsuario",session);

            }
        });

        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                new MapaMenu(perfil);
                dispose();

            }
        });

        this.add(pnlfoto,BorderLayout.WEST);
        this.add(info,BorderLayout.EAST);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
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


    

