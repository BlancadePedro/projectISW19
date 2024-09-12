package main.java.icai.dtc.isw.domain.ui;

import main.java.icai.dtc.isw.client.Client;
import main.java.icai.dtc.isw.domain.localidad.Hotel;
import main.java.icai.dtc.isw.domain.ocio.Monumento;
import main.java.icai.dtc.isw.domain.localidad.Museo;
import main.java.icai.dtc.isw.domain.localidad.Restaurante;
import main.java.icai.dtc.isw.domain.ocio.Evento;
import main.java.icai.dtc.isw.domain.ocio.Parque;
import main.java.icai.dtc.isw.domain.ui.Agenda.FranjaHorariaReal;
import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;
import main.java.icai.dtc.isw.domain.ui.Usuario.InfoUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class MapaMenu extends JFrame{
    private static Customer customer;
    //variables y comtenedores
    private JLabel etiquetaSu;
    private JPanel pnlCentral, pnlSuperior;
    private JButton btnH, btnR, btnE, btnM, btnMu, btnP;
    private JComboBox<String> opciones;
    private JButton btnChueca, btnCondeDuque, btnMalasana, btnSalamanca, btnSalesas, btnLetras, btnLavaPies;
    private JButton btnAustrias, btnSol, btnPaseoArte, btnRetiro, btnMoncloa, btnLatina;

    public void contruyepnlCentral(Customer customer){
        pnlCentral = new JPanel();
        ImageIcon image1 = new ImageIcon("./src/main/java/icai/dtc/isw/resources/FotosMapa/madridcentro.jpg", null);

        //Click en los barrios
        Container c = new JLabel(image1);
        c.setLayout(null);

        btnChueca = new JButton("CHUECA");
        btnChueca.setBackground(new Color(182,255,220));
        Dimension size = btnChueca.getPreferredSize();
        btnChueca.setBounds(809, 295, 100, size.height);
        c.add(btnChueca);
        btnChueca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Chueca");
                ArrayList<Object> listaChueca= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("chueca",listaChueca);
                session.put("perfil",customer);
                client.enviar("/getChueca",session);
            }
        });

        btnCondeDuque = new JButton("CONDE DUQUE");
        btnCondeDuque.setBackground(new Color(255,200,180));
        btnCondeDuque.setBounds(450, 70, 143, size.height);
        c.add(btnCondeDuque);
        btnCondeDuque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Conde Duque");
                ArrayList<Object> listaConde= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("conde",listaConde);
                session.put("perfil",customer);
                client.enviar("/getCondeDuque",session);
            }
        });

        btnMalasana = new JButton("MALASAÑA");
        btnMalasana.setBackground(new Color(220,190,255));
        btnMalasana.setBounds(580, 300, 120, size.height);
        c.add(btnMalasana);
        btnMalasana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Malasaña");
                ArrayList<Object> listaMalasana= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("malasana",listaMalasana);
                session.put("perfil",customer);
                client.enviar("/getMalasana",session);            }
        });

        btnSalamanca = new JButton("SALAMANCA");
        btnSalamanca.setBackground(new Color(255,180,210));
        btnSalamanca.setBounds(1218, 82, 142, size.height);
        c.add(btnSalamanca);
        btnSalamanca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Salamanca");
                ArrayList<Object> listaSalamanca= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("salamanca",listaSalamanca);
                session.put("perfil",customer);
                client.enviar("/getSalamanca",session);            }
        });

        btnSalesas = new JButton("SALESAS");
        btnSalesas.setBackground(new Color(190,224,255));
        btnSalesas.setBounds(960, 320, 100, size.height);
        c.add(btnSalesas);
        btnSalesas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Salesas");
                ArrayList<Object> listaSalesas= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("salesas",listaSalesas);
                session.put("perfil",customer);
                client.enviar("/getSalesas",session);            }
        });

        btnLetras = new JButton("LETRAS");
        btnLetras.setBackground(new Color(186,121,93));
        btnLetras.setBounds(840, 645, 100, size.height);
        c.add(btnLetras);
        btnLetras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Letras");
                ArrayList<Object> listaLetras= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("letras",listaLetras);
                session.put("perfil",customer);
                client.enviar("/getLetras",session);            }
        });

        btnAustrias = new JButton("AUSTRIAS");
        btnAustrias.setBackground(new Color(224,224,224));
        btnAustrias.setBounds(400, 558, 110, size.height);
        c.add(btnAustrias);
        btnAustrias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Austrias");
                ArrayList<Object> listaAustrias= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("austrias",listaAustrias);
                session.put("perfil",customer);
                client.enviar("/getAustrias",session);            }
        });

        btnSol = new JButton("SOL");
        btnSol.setBackground(new Color(150,220,255));
        btnSol.setBounds(716, 595, 70, size.height);
        c.add(btnSol);
        btnSol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Sol");
                ArrayList<Object> listaSol= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("sol",listaSol);
                session.put("perfil",customer);
                client.enviar("/getSol",session);            }
        });

        btnRetiro = new JButton("EL RETIRO");
        btnRetiro.setBackground(new Color(210,255,204));
        btnRetiro.setBounds(1172, 525, 110, size.height);
        c.add(btnRetiro);
        btnRetiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio El Retiro");
                ArrayList<Object> listaRetiro= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("retiro",listaRetiro);
                session.put("perfil",customer);
                client.enviar("/getRetiro",session);            }
        });

        btnPaseoArte = new JButton("PASEO DEL ARTE");
        btnPaseoArte.setBackground(new Color(255,230,80));
        btnPaseoArte.setBounds(1048, 606, 150, size.height);
        c.add(btnPaseoArte);
        btnPaseoArte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Paseo del Arte");
                ArrayList<Object> listaPaseo= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("paseo",listaPaseo);
                session.put("perfil",customer);
                client.enviar("/getPaseoArte",session);            }
        });

        btnMoncloa = new JButton("MONCLOA");
        btnMoncloa.setBackground(new Color(255,255,202));
        btnMoncloa.setBounds(140, 180, 110, size.height);
        c.add(btnMoncloa);
        btnMoncloa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Ver barrio Moncloa");
                ArrayList<Object> listaMoncloa= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("moncloa",listaMoncloa);
                session.put("perfil",customer);
                client.enviar("/getMoncloa",session);
            }
        });

        btnLatina = new JButton("LA LATINA");
        btnLatina.setBackground(new Color(220,90,120));
        btnLatina.setBounds(260, 760, 110, size.height);
        c.add(btnLatina);
        btnLatina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio La Latina");
                ArrayList<Object> listaLatina= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("latina",listaLatina);
                session.put("perfil",customer);
                client.enviar("/getLatina",session);            }
        });

        btnLavaPies = new JButton("LAVAPIES");
        btnLavaPies.setBackground(new Color(220,250,120));
        btnLavaPies.setBounds(730, 800, 110, size.height);
        c.add(btnLavaPies);
        btnLavaPies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Lavapies");
                ArrayList<Object> listaLavapies= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("lavapies",listaLavapies);
                session.put("perfil",customer);
                client.enviar("/getLavapies",session);            }
        });

        pnlCentral.add(c);
    }

    public void contruyepnlSuperior(Customer customer){
        pnlSuperior = new JPanel(new FlowLayout());
        opciones= new JComboBox<String>();

        etiquetaSu = new JLabel("Para ver más información haga click en el mapa");
        Font aux=etiquetaSu.getFont();
        etiquetaSu.setFont(new Font(aux.getFontName(), aux.getStyle(), 16));

        btnH = new JButton("Hoteles");
        btnR = new JButton("Restaurantes");
        btnE = new JButton("Eventos");
        btnM = new JButton("Monumentos");
        btnMu = new JButton("Museos");
        btnP = new JButton("Parques");

        opciones.addItem("INFO");
        opciones.addItem("Mi perfil");
        opciones.addItem("Mi Agenda");
        opciones.addItem("Mis favoritos");
        opciones.addItem("Información importante");
        opciones.addItem("Darse de baja");
        opciones.addItem("Cerrar sesión");



        opciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String opcion = (String)opciones.getSelectedItem();
                if(opcion!=null){
                    if(opcion.equals("Mi perfil")){

                        new InfoUsuario(customer);
                        dispose();
                    }
                    if(opcion.equals("Mi Agenda")){

                        ArrayList<FranjaHorariaReal> listaInfo = new ArrayList<>();

                        Client client = new Client();
                        HashMap<String, Object> session = new HashMap<String, Object>();
                        session.put("listaAgenda",listaInfo);
                        session.put("perfilAgenda",customer);
                        client.enviar("/infoAgenda",session);
                        dispose();

                    }
                    if(opcion.equals("Información importante")){
                        JOptionPane.showMessageDialog(null,"Número de teléfono de emergencia: 112");
                    }
                    if(opcion.equals("Mis favoritos")){
                        MapaMenu.verFavoritos();
                    }
                    if(opcion.equals("Cerrar sesión")){
                        JOptionPane.showMessageDialog(null,"Adios, vuelva pronto!");
                        new PanelInicio();
                        dispose();
                    }
                    if(opcion.equals("Darse de baja")){
                        Object [] botones = {"Sí","No"};
                        int respuesta = JOptionPane.showOptionDialog(null,"¿Está seguro de que quiere darse de baja?","Darse de baja de la aplicación",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null, botones,botones[0]);
                        if(respuesta==0){
                            Client client = new Client();
                            HashMap<String, Object> session = new HashMap<String, Object>();
                            session.put("eliminarCliente",customer);
                            client.enviar("/dropUsuario",session);
                            dispose();
                        }
                        
                    }

                }
            }
        });


        btnH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Hotel> listaH= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("hotel",listaH);
                session.put("perfil",customer);
                client.enviar("/getHoteles",session);

            }
        });
        btnR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Restaurante> listaR = new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("restaurantes",listaR);
                session.put("perfil",customer);
                client.enviar("/getRestaurantes",session);

            }
        });
        btnE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Evento> listaE= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("eventos",listaE);
                session.put("perfil",customer);
                client.enviar("/getEventos",session);

            }
        });
        btnM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Monumento> listaM= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("monumento",listaM);
                session.put("perfil",customer);
                client.enviar("/getMonumentos",session);

            }
        });
        btnMu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Museo> listaM= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("museo",listaM);
                session.put("perfil",customer);
                client.enviar("/getMuseos",session);

            }
        });
        btnP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Parque> listaP= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("parques",listaP);
                session.put("perfil",customer);
                client.enviar("/getParques",session);
            }
        });

        pnlSuperior.add(opciones);
        pnlSuperior.add(btnH);
        pnlSuperior.add(btnR);
        pnlSuperior.add(btnE);
        pnlSuperior.add(btnM);
        pnlSuperior.add(btnMu);
        pnlSuperior.add(btnP);

    }


    public MapaMenu(Customer customer){

        this.customer=customer;
        contruyepnlCentral(customer);
        contruyepnlSuperior(customer);

        this.add(pnlSuperior,BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);

        //Configuramos el frame
        this.setSize(1400,1075);
        this.setTitle("Mapa de Madrid");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }


    public static void addFavorito(Object object){
        Client client = new Client();
        HashMap<String, Object> session = new HashMap<>();
        session.put("id",customer);
        session.put("lugar",object); //Contiene el lugar que se quiere poner como favorito
        client.enviar("/addFavorito",session);
    }
    public static void eliminarFavorito(Object object){
        Client client = new Client();
        HashMap<String, Object> session = new HashMap<>();
        session.put("id",customer);
        session.put("lugar",object); //Contiene el lugar que se quiere poner como favorito
        client.enviar("/eliminarFavorito",session);
    }

    public static void verFavoritos(){
        Client client = new Client();
        HashMap<String, Object> session = new HashMap<>();
        ArrayList<Object> listaFavoritos= new ArrayList<>();
        session.put("favoritos",listaFavoritos);
        session.put("id",customer);
        client.enviar("/verFavorito",session);
    }
}