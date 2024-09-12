package main.java.icai.dtc.isw.domain.ui.Mapa;

import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;
import main.java.icai.dtc.isw.domain.localidad.Hotel;
import main.java.icai.dtc.isw.domain.localidad.Museo;
import main.java.icai.dtc.isw.domain.localidad.Restaurante;
import main.java.icai.dtc.isw.domain.ocio.Evento;
import main.java.icai.dtc.isw.domain.ocio.Monumento;
import main.java.icai.dtc.isw.domain.ocio.Parque;
import main.java.icai.dtc.isw.domain.ui.MapaMenu;

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
        panelCentro.setBackground(new Color(174, 214, 241));
        JButton btnFav;
        ArrayList<JButton> btnList = new ArrayList<JButton>();

        int contador=0;
        int indice = contador;

        for (Object l : barrioList) {
            indice=indice+1;
            if (l instanceof Hotel){
                Hotel h = (Hotel)l;
                JLabel label = new JLabel(indice+"_"+h.getNombre()+"; Dirección: "+h.getDireccion());
                label.setFont(fuente);
                panelCentro.add(label);
            }else if(l instanceof Restaurante){
                Restaurante r = (Restaurante)l;
                JLabel label = new JLabel(indice+"_"+r.getNombre()+"; Dirección: "+r.getDireccion());
                label.setFont(fuente);
                panelCentro.add(label);
            }else if(l instanceof Museo) {
                Museo m = (Museo) l;
                JLabel label = new JLabel(indice+"_"+m.getNombre()+"; Dirección: "+m.getDireccion());
                label.setFont(fuente);
                panelCentro.add(label);
            }else if(l instanceof Parque) {
                Parque p = (Parque) l;
                JLabel label = new JLabel(indice+"_"+p.getNombre()+"; Dirección: "+p.getDireccion());
                label.setFont(fuente);
                panelCentro.add(label);
            }else if(l instanceof Monumento) {
                Monumento mo = (Monumento) l;
                JLabel label = new JLabel(indice+"_"+mo.getNombre()+"; Dirección: "+mo.getDireccion());
                label.setFont(fuente);
                panelCentro.add(label);
            }else if(l instanceof Evento) {
                Evento e = (Evento) l;
                JLabel label = new JLabel(indice+"_"+e.getNombre()+"; Dirección: "+e.getDireccion());
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
        btnVolver.setBackground(new Color(52, 152, 219));
        btnVolver.setForeground(Color.WHITE);
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
