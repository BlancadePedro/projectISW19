package icai.dtc.isw.domain.paneles;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.localidad.Hotel;
import icai.dtc.isw.domain.localidad.Museo;
import icai.dtc.isw.domain.localidad.Restaurante;
import icai.dtc.isw.domain.ocio.Evento;
import icai.dtc.isw.domain.ocio.Monumento;
import icai.dtc.isw.domain.ocio.Parque;
import icai.dtc.isw.domain.ui.MapaMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PnlBarrio extends JFrame {
    private JPanel panelCentro;
    private JPanel panelSur = new JPanel((new BorderLayout()));
    private JButton btnVolver = new JButton("Cerrar");

    public PnlBarrio(ArrayList<Object> barrioList, Customer perfil) {

        Font fuente = new Font("Tahoma", Font.ITALIC, 15);
        int size = barrioList.size();
        panelCentro = new JPanel((new GridLayout(size,2)));
        JButton btnFav;
        ArrayList<JButton> btnList = new ArrayList<JButton>();

        int contador=0;
        for (Object l : barrioList) {
            if (l instanceof Hotel){
                Hotel h = (Hotel)l;
                JLabel label = new JLabel("-"+h.getNombre()+"; Dirección: "+h.getDireccion());
                label.setFont(fuente);
                panelCentro.add(label);
            }else if(l instanceof Restaurante){
                Restaurante r = (Restaurante)l;
                JLabel label = new JLabel("-"+r.getNombre()+"; Dirección: "+r.getDireccion());
                label.setFont(fuente);
                panelCentro.add(label);
            }else if(l instanceof Museo) {
                Museo m = (Museo) l;
                JLabel label = new JLabel("-"+m.getNombre()+"; Dirección: "+m.getDireccion());
                label.setFont(fuente);
                panelCentro.add(label);
            }else if(l instanceof Parque) {
                Parque p = (Parque) l;
                JLabel label = new JLabel("-"+p.getNombre()+"; Dirección: "+p.getDireccion());
                label.setFont(fuente);
                panelCentro.add(label);
            }else if(l instanceof Monumento) {
                Monumento mo = (Monumento) l;
                JLabel label = new JLabel("-"+mo.getNombre()+"; Dirección: "+mo.getDireccion());
                label.setFont(fuente);
                panelCentro.add(label);
            }else if(l instanceof Evento) {
                Evento e = (Evento) l;
                JLabel label = new JLabel("-"+e.getNombre()+"; Dirección: "+e.getDireccion()+ "; Autor: "+e.getAutor());
                label.setFont(fuente);
                panelCentro.add(label);
            }

            btnFav = new JButton("Añadir a favoritos");
            int finalContador = contador;
            btnFav.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Se ha pulsado boton de "+barrioList.get(finalContador));
                    MapaMenu.addFavorito(barrioList.get(finalContador));
                    dispose();
                    new PnlBarrio(barrioList,perfil);
                }
            });
            btnList.add(btnFav);
            panelCentro.add(btnFav);
            contador=contador+1;
        }

        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent){

                dispose();

            }
        });

        panelSur.add(btnVolver);

        this.add(panelCentro,BorderLayout.CENTER);
        this.add(panelSur,BorderLayout.SOUTH);

        this.setTitle("Lugares y actividades en este barrio");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}