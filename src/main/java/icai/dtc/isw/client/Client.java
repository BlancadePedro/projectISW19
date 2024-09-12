package main.java.icai.dtc.isw.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import main.java.icai.dtc.isw.domain.localidad.Hotel;
import main.java.icai.dtc.isw.domain.ocio.Monumento;
import main.java.icai.dtc.isw.domain.localidad.Museo;
import main.java.icai.dtc.isw.domain.localidad.Restaurante;
import main.java.icai.dtc.isw.domain.ocio.Evento;
import main.java.icai.dtc.isw.domain.ocio.Parque;
import main.java.icai.dtc.isw.domain.ui.*;
import main.java.icai.dtc.isw.domain.ui.Agenda.Agenda;
import main.java.icai.dtc.isw.domain.ui.Agenda.FranjaHorariaReal;
import main.java.icai.dtc.isw.domain.ui.Mapa.*;
import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;
import main.java.icai.dtc.isw.domain.ui.PanelInicio;
import org.apache.log4j.Logger;

import main.java.icai.dtc.isw.configuration.PropertiesISW;
import main.java.icai.dtc.isw.message.Message;

public class Client {
	private String host;
	private int port;
	final static Logger logger = Logger.getLogger(Client.class);

	public void enviar(String contexto, HashMap<String, Object> session)
		{
		//Configure connections
		String host = PropertiesISW.getInstance().getProperty("host");
		int port = Integer.parseInt(PropertiesISW.getInstance().getProperty("port"));
		Logger.getRootLogger().info("Host: "+host+" port"+port);
		//Create a cliente class
		Client cliente=new Client(host, port);

		Message mensajeEnvio=new Message();
		Message mensajeVuelta=new Message();

		mensajeEnvio.setSession(session);
		mensajeEnvio.setContext(contexto);
		cliente.sent(mensajeEnvio,mensajeVuelta);
		Customer perfil = (Customer)(mensajeVuelta.getSession().get("perfil"));
		
		switch (mensajeVuelta.getContext()) {

			case "/getCustomerResponse":
				ArrayList<Customer> customerList=(ArrayList<Customer>)(mensajeVuelta.getSession().get("Customer"));
				 for (Customer customer : customerList) {
						System.out.println("Nombre: "+customer.getNombreCompleto()+"; Edad: "+customer.getEdad()+ "; Nacionalidad: "+customer.getNacionalidad());
					}
				break;
			case "/getClienteResponse":
				Customer customer = (Customer)(mensajeVuelta.getSession().get("Usuario"));
				new MapaMenu(customer);
				System.out.println("Usuario: "+customer.getUsuario());
				break;
			case "/updateNombreResponse":
				System.out.println("\nSe ha actualizado");
				break;
			case "/addClienteResponse":
				System.out.println("\nSe ha enviado");
				Customer customerNuevo = (Customer)(mensajeVuelta.getSession().get("id"));
				new MapaMenu(customerNuevo);
				if(mensajeVuelta.getComprobar()){
					System.out.println("\nSe ha introducido adecuadamente en la base de datos");
				}else System.out.println("\nNO se ha introducido adecuadamente en la base de datos");
				break;
			case "/dropClienteResponse":
				System.out.println("\nSe ha eliminado");
				new PanelInicio();
				break;
			case "/updateFotoResponse":
				System.out.println("\nSe ha actualizado");
				break;
			case "/addClienteResponseError":
				System.out.println("\nEl cliente ya está en la base de datos");
				break;
			case "/dropClienteResponseError":
				System.out.println("\nEl cliente no se ha eliminado correctamente");
				break;
			case "/getRestaurantesResponse":
				System.out.println("\nEstos son los restaurantes guardados en la base de datos");
				ArrayList<Restaurante> restauranteList=(ArrayList<Restaurante>)(mensajeVuelta.getSession().get("restaurantes"));
				new PnlRestaurantes(restauranteList,perfil);
				break;
			case "/getHotelesResponse":
				System.out.println("\nEstos son los hoteles guardados en la base de datos");
				ArrayList<Hotel> hotelList=(ArrayList<Hotel>)(mensajeVuelta.getSession().get("hotel"));
				new PnlHoteles(hotelList,perfil);
				break;
			case "/getMuseosResponse":
				System.out.println("\nEstos son los museos guardados en la base de datos");
				ArrayList<Museo> museoList=(ArrayList<Museo>)(mensajeVuelta.getSession().get("museo"));
				new PnlMuseos(museoList,perfil);
				break;
			case "/getMonumentosResponse":
				System.out.println("\nEstos son los monumentos guardados en la base de datos");
				ArrayList<Monumento> monumentoList=(ArrayList<Monumento>)(mensajeVuelta.getSession().get("monumento"));
				new PnlMonumentos(monumentoList,perfil);
				break;
			case "/getEventosResponse":
				System.out.println("\nEstos son los hoteles eventos en la base de datos");
				ArrayList<Evento> eventosList=(ArrayList<Evento>)(mensajeVuelta.getSession().get("eventos"));
				new PnlEventos(eventosList,perfil);
				break;
			case "/getParquesResponse":
				System.out.println("\nEstos son los parques guardados en la base de datos");
				ArrayList<Parque> parqueList=(ArrayList<Parque>)(mensajeVuelta.getSession().get("parques"));
				new PnlParques(parqueList,perfil);
				break;
			case "/getAustriasResponse":
				System.out.println("\nEstos son los lugares en el barrio de Austrias");
				ArrayList<Object> austriasList=(ArrayList<Object>)(mensajeVuelta.getSession().get("austrias"));
				new PnlBarrio(austriasList,perfil);
				break;
			case "/getChuecaResponse":
				System.out.println("\nEstos son los lugares en el barrio de Chueca");
				ArrayList<Object> chuecaList=(ArrayList<Object>)(mensajeVuelta.getSession().get("chueca"));
				new PnlBarrio(chuecaList,perfil);
				break;
			case "/getCondeDuqueResponse":
				System.out.println("\nEstos son los lugares en el barrio de Conde Duque");
				ArrayList<Object> condeList=(ArrayList<Object>)(mensajeVuelta.getSession().get("conde"));
				new PnlBarrio(condeList,perfil);
				break;
			case "/getLatinaResponse":
				System.out.println("\nEstos son los lugares en el barrio de La Latina");
				ArrayList<Object> latinaList=(ArrayList<Object>)(mensajeVuelta.getSession().get("latina"));
				new PnlBarrio(latinaList,perfil);
				break;
			case "/getLavapiesResponse":
				System.out.println("\nEstos son los lugares en el barrio de Lavapies");
				ArrayList<Object> lavapiesList=(ArrayList<Object>)(mensajeVuelta.getSession().get("lavapies"));
				new PnlBarrio(lavapiesList,perfil);
				break;
			case "/getLetrasResponse":
				System.out.println("\nEstos son los lugares en el barrio de Letras");
				ArrayList<Object> letrasList=(ArrayList<Object>)(mensajeVuelta.getSession().get("letras"));
				new PnlBarrio(letrasList,perfil);
				break;
			case "/getMalasanaResponse":
				System.out.println("\nEstos son los lugares en el barrio de Malasaña");
				ArrayList<Object> malasanaList=(ArrayList<Object>)(mensajeVuelta.getSession().get("malasana"));
				new PnlBarrio(malasanaList,perfil);
				break;
			case "/getMoncloaResponse":
				System.out.println("\nEstos son los lugares en el barrio de Moncloa");
				ArrayList<Object> moncloaList=(ArrayList<Object>)(mensajeVuelta.getSession().get("moncloa"));
				new PnlBarrio(moncloaList,perfil);
				break;
			case "/getPaseoArteResponse":
				System.out.println("\nEstos son los lugares en el barrio de Paseo del Arte");
				ArrayList<Object> paseoList=(ArrayList<Object>)(mensajeVuelta.getSession().get("paseo"));
				new PnlBarrio(paseoList,perfil);
				break;
			case "/getRetiroResponse":
				System.out.println("\nEstos son los lugares en el barrio de El Retiro");
				ArrayList<Object> retiroList=(ArrayList<Object>)(mensajeVuelta.getSession().get("retiro"));
				new PnlBarrio(retiroList,perfil);
				break;
			case "/getSalamancaResponse":
				System.out.println("\nEstos son los lugares en el barrio de Salamanca");
				ArrayList<Object> salamancaList=(ArrayList<Object>)(mensajeVuelta.getSession().get("salamanca"));
				new PnlBarrio(salamancaList,perfil);
				break;
			case "/getSalesasResponse":
				System.out.println("\nEstos son los lugares en el barrio de Salesas");
				ArrayList<Object> salesasList=(ArrayList<Object>)(mensajeVuelta.getSession().get("salesas"));
				new PnlBarrio(salesasList,perfil);
				break;
			case "/getSolResponse":
				System.out.println("\nEstos son los lugares en el barrio de Sol");
				ArrayList<Object> solList=(ArrayList<Object>)(mensajeVuelta.getSession().get("sol"));
				new PnlBarrio(solList,perfil);
				break;

			case "/addAgendaResponse":
				System.out.println("\nSe ha añadido contenido a la agenda");
				ArrayList<FranjaHorariaReal> listaInfo = new ArrayList<>();
				Customer add = (Customer)(mensajeVuelta.getSession().get("perfilAgenda"));
				break;

			case "/deleteAgendaResponse":
				System.out.println("\nSe ha borrado parte del contenido de la agenda");
				break;
			case "/addFavoritoResponse":
				System.out.println("\nSe ha guardado el favorito");
				break;
			case "/infoAgendaResponse":
				System.out.println("Tenemos la info guardada en la base de datos");
				Customer perfilAgenda = (Customer)(mensajeVuelta.getSession().get("perfilAgenda"));
				ArrayList<FranjaHorariaReal> listaAgenda = (ArrayList<FranjaHorariaReal>)(mensajeVuelta.getSession().get("listaAgenda"));
				//listaAgenda = Agenda.establecerID(listaAgenda,perfilAgenda);
				new Agenda(perfilAgenda,listaAgenda);
				break;
			case "/eliminarFavoritoResponse":
				System.out.println("\nSe ha eliminado el favorito");
				break;
			case "/verFavoritosResponse":
				System.out.println("\nEstos son los lugares en el barrio de Salesas");
				ArrayList<Object> favoritosList=(ArrayList<Object>)(mensajeVuelta.getSession().get("favoritos"));
				new PnlFavoritos(favoritosList,perfil);
				break;

			default:
				Logger.getRootLogger().info("Option not found");
				System.out.println("\nError a la vuelta");
				break;


		}
		//System.out.println("3.- En Main.- El valor devuelto es: "+((String)mensajeVuelta.getSession().get("Nombre")));
	}
	public Client(){
	}

	public Client(String host, int port) {
		this.host=host;
		this.port=port;
	}
	

	public void sent(Message messageOut, Message messageIn) {
		try {

			System.out.println("Connecting to host " + host + " on port " + port + ".");

			Socket echoSocket = null;
			OutputStream out = null;
			InputStream in = null;

			try {
				echoSocket = new Socket(host, port);
				in = echoSocket.getInputStream();
				out = echoSocket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
				
				//Create the objetct to send
				objectOutputStream.writeObject(messageOut);
				
				// create a DataInputStream so we can read data from it.
		        ObjectInputStream objectInputStream = new ObjectInputStream(in);
		        Message msg=(Message)objectInputStream.readObject();
		        messageIn.setContext(msg.getContext());
		        messageIn.setSession(msg.getSession());
				messageIn.setComprobar(msg.getComprobar());
		        /*System.out.println("\n1.- El valor devuelto es: "+messageIn.getContext());
		        String cadena=(String) messageIn.getSession().get("Nombre");
		        System.out.println("\n2.- La cadena devuelta es: "+cadena);*/
				
			} catch (UnknownHostException e) {
				System.err.println("Unknown host: " + host);
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Unable to get streams from server");
				System.exit(1);
			}		

			/** Closing all the resources */
			out.close();
			in.close();			
			echoSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}