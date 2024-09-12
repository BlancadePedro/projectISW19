package main.java.icai.dtc.isw.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import main.java.icai.dtc.isw.controler.AgendaControler;
import main.java.icai.dtc.isw.controler.BarriosControler;
import main.java.icai.dtc.isw.controler.CustomerControler;
import main.java.icai.dtc.isw.controler.MapaControler;
import main.java.icai.dtc.isw.domain.localidad.Hotel;
import main.java.icai.dtc.isw.domain.ocio.Monumento;
import main.java.icai.dtc.isw.domain.localidad.Museo;
import main.java.icai.dtc.isw.domain.localidad.Restaurante;
import main.java.icai.dtc.isw.domain.ocio.Evento;
import main.java.icai.dtc.isw.domain.ocio.Parque;
import main.java.icai.dtc.isw.domain.ui.Agenda.FranjaHorariaReal;
import main.java.icai.dtc.isw.domain.ui.Usuario.Customer;
import main.java.icai.dtc.isw.message.Message;

public class SocketServer extends Thread {
	public static final int PORT_NUMBER = 8081;

	protected Socket socket;

	private SocketServer(Socket socket) {
		this.socket = socket;
		System.out.println("New client connected from " + socket.getInetAddress().getHostAddress());
		start();
	}

	public void run(){
		InputStream in = null;
		OutputStream out = null;
		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			//first read the object that has been sent
			ObjectInputStream objectInputStream = new ObjectInputStream(in);
		    Message mensajeIn= (Message)objectInputStream.readObject();
		    //Object to return informations 
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
		    Message mensajeOut=new Message();

			HashMap<String,Object> session=new HashMap<String, Object>();
			CustomerControler customerControler=new CustomerControler();
			MapaControler mapaControler = new MapaControler();
			BarriosControler barriosControler = new BarriosControler();
			AgendaControler agendaControler = new AgendaControler();


			ArrayList<Customer> lista=new ArrayList<Customer>();
			Customer customer;

		    switch (mensajeIn.getContext()) {

		    	case "/getCustomer":
		    		customerControler.getCustomer(lista);
		    		mensajeOut.setContext("/getCustomerResponse");
		    		session.put("Customer",lista);
		    		mensajeOut.setSession(session);
		    		objectOutputStream.writeObject(mensajeOut);		    		
		    		break;

				case "/getUsuario":
					String usuario = (String)mensajeIn.getSession().get("usuario");
					String contraseña = (String)mensajeIn.getSession().get("contraseña");
					customer = customerControler.getCliente(usuario, contraseña);
					mensajeOut.setContext("/getClienteResponse");
					session.put("Usuario",customer);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/dropUsuario":
					customer= (Customer)mensajeIn.getSession().get("eliminarCliente");
					customerControler.darsedeBaja(customer);
					mensajeOut.setContext("/dropClienteResponse");

					objectOutputStream.writeObject(mensajeOut);
					break;

				case "/altaUsuario":
					customer = (Customer)mensajeIn.getSession().get("id");
					if(comprobacion(customer)==null){
						customerControler.addCliente(customer);
						mensajeOut.setContext("/addClienteResponse");
						session.put("id",customer);
						mensajeOut.setSession(session);
						if(comprobacion(customer)!=null){
							mensajeOut.setComprobar(true);
						}
					}else{
						mensajeOut.setContext("/addClienteResponseError");
					}
					objectOutputStream.writeObject(mensajeOut);
					break;

				case "/updateNombre":
					customer = (Customer)mensajeIn.getSession().get("perfilNombre");
					String nombre = (String)mensajeIn.getSession().get("cambioNombre");
					customerControler.updateNombre(customer, nombre);
					mensajeOut.setContext("/updateNombreResponse");
					session.put("perfilNombre",customer);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/updateEdad":
					customer = (Customer)mensajeIn.getSession().get("perfilEdad");
					String edad = (String)mensajeIn.getSession().get("cambioEdad");
					customerControler.updateEdad(customer, edad);
					mensajeOut.setContext("/updateEdadResponse");
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/updateCorreo":
					customer = (Customer)mensajeIn.getSession().get("perfilCorreo");
					String cambio = (String)mensajeIn.getSession().get("cambioCorreo");
					customerControler.updateCorreo(customer, cambio);
					mensajeOut.setContext("/updateCorreoResponse");
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/updateNacionalidad":
					customer = (Customer)mensajeIn.getSession().get("perfilNacionalidad");
					String nacionalidad = (String)mensajeIn.getSession().get("cambioNacionalidad");
					customerControler.updateNacionalidad(customer, nacionalidad);
					mensajeOut.setContext("/updateNacionalidadResponse");

					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/updateDescripcion":
					customer = (Customer)mensajeIn.getSession().get("perfilDescripcion");
					String descripcion = (String)mensajeIn.getSession().get("cambioDescripcion");
					customerControler.updateDescripcion(customer,descripcion);
					mensajeOut.setContext("/updateDescripcionResponse");
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/updateTelefono":
					customer = (Customer)mensajeIn.getSession().get("perfilTelefono");
					String telefono = (String)mensajeIn.getSession().get("cambioTelefono");
					customerControler.updateTelefono(customer, telefono);
					mensajeOut.setContext("/updateTelefonoResponse");
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/updateFoto":
					int foto = (int)mensajeIn.getSession().get("foto");
					Customer perfil = (Customer)mensajeIn.getSession().get("perfil");
					customerControler.updateFoto(perfil, foto);
					mensajeOut.setContext("/updateFotoResponse");
					objectOutputStream.writeObject(mensajeOut);
					break;

				case "/getRestaurantes":
					ArrayList<Restaurante> restaurantes = (ArrayList<Restaurante>)mensajeIn.getSession().get("restaurantes");
					mapaControler.getRestaurantes(restaurantes);
					mensajeOut=new Message();
					mensajeOut.setContext("/getRestaurantesResponse");
					session.put("restaurantes",restaurantes);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getHoteles":
					ArrayList<Hotel> hoteles = (ArrayList<Hotel>)mensajeIn.getSession().get("hotel");
					mapaControler.getHoteles(hoteles);
					mensajeOut=new Message();
					mensajeOut.setContext("/getHotelesResponse");
					session.put("hotel",hoteles);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getMuseos":
					ArrayList<Museo> museos = (ArrayList<Museo>)mensajeIn.getSession().get("museo");
					mapaControler.getMuseos(museos);
					mensajeOut=new Message();
					mensajeOut.setContext("/getMuseosResponse");
					session.put("museo",museos);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getMonumentos":
					ArrayList<Monumento> monumentos = (ArrayList<Monumento>)mensajeIn.getSession().get("monumento");
					mapaControler.getMonumentos(monumentos);
					mensajeOut=new Message();
					mensajeOut.setContext("/getMonumentosResponse");
					session.put("monumento",monumentos);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getEventos":
					ArrayList<Evento> eventos = (ArrayList<Evento>)mensajeIn.getSession().get("eventos");
					mapaControler.getEventos(eventos);
					mensajeOut=new Message();
					mensajeOut.setContext("/getEventosResponse");
					session.put("eventos",eventos);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getParques":
					ArrayList<Parque> parques = (ArrayList<Parque>)mensajeIn.getSession().get("parques");
					mapaControler.getParques(parques);
					mensajeOut=new Message();
					mensajeOut.setContext("/getParquesResponse");
					session.put("parques",parques);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getAustrias":
					ArrayList<Object> austrias = (ArrayList<Object>)mensajeIn.getSession().get("austrias");
					barriosControler.getAustrias(austrias);
					mensajeOut=new Message();
					mensajeOut.setContext("/getAustriasResponse");
					session.put("austrias",austrias);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getChueca":
					ArrayList<Object> chueca = (ArrayList<Object>)mensajeIn.getSession().get("chueca");
					barriosControler.getChueca(chueca);
					mensajeOut=new Message();
					mensajeOut.setContext("/getChuecaResponse");
					session.put("chueca",chueca);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getCondeDuque":
					ArrayList<Object> conde = (ArrayList<Object>)mensajeIn.getSession().get("conde");
					barriosControler.getCondeDuque(conde);
					mensajeOut=new Message();
					mensajeOut.setContext("/getCondeDuqueResponse");
					session.put("conde",conde);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getLatina":
					ArrayList<Object> latina = (ArrayList<Object>)mensajeIn.getSession().get("latina");
					barriosControler.getLatina(latina);
					mensajeOut=new Message();
					mensajeOut.setContext("/getLatinaResponse");
					session.put("latina",latina);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getLavapies":
					ArrayList<Object> lavapies = (ArrayList<Object>)mensajeIn.getSession().get("lavapies");
					barriosControler.getLavapies(lavapies);
					mensajeOut=new Message();
					mensajeOut.setContext("/getLavapiesResponse");
					session.put("lavapies",lavapies);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getLetras":
					ArrayList<Object> letras = (ArrayList<Object>)mensajeIn.getSession().get("letras");
					barriosControler.getLetras(letras);
					mensajeOut=new Message();
					mensajeOut.setContext("/getLetrasResponse");
					session.put("letras",letras);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getMalasana":
					ArrayList<Object> malasana = (ArrayList<Object>)mensajeIn.getSession().get("malasana");
					barriosControler.getMalasana(malasana);
					mensajeOut=new Message();
					mensajeOut.setContext("/getMalasanaResponse");
					session.put("malasana",malasana);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getMoncloa":
					ArrayList<Object> moncloa = (ArrayList<Object>)mensajeIn.getSession().get("moncloa");
					barriosControler.getMoncloa(moncloa);
					mensajeOut=new Message();
					mensajeOut.setContext("/getMoncloaResponse");
					session.put("moncloa",moncloa);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getPaseoArte":
					ArrayList<Object> paseo = (ArrayList<Object>)mensajeIn.getSession().get("paseo");
					barriosControler.getPaseoArte(paseo);
					mensajeOut=new Message();
					mensajeOut.setContext("/getPaseoArteResponse");
					session.put("paseo",paseo);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getRetiro":
					ArrayList<Object> retiro = (ArrayList<Object>)mensajeIn.getSession().get("retiro");
					barriosControler.getRetiro(retiro);
					mensajeOut=new Message();
					mensajeOut.setContext("/getRetiroResponse");
					session.put("retiro",retiro);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getSalamanca":
					ArrayList<Object> salamanca = (ArrayList<Object>)mensajeIn.getSession().get("salamanca");
					barriosControler.getSalamanca(salamanca);
					mensajeOut=new Message();
					mensajeOut.setContext("/getSalamancaResponse");
					session.put("salamanca",salamanca);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getSalesas":
					ArrayList<Object> salesas = (ArrayList<Object>)mensajeIn.getSession().get("salesas");
					barriosControler.getSalesas(salesas);
					mensajeOut=new Message();
					mensajeOut.setContext("/getSalesasResponse");
					session.put("salesas",salesas);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getSol":
					ArrayList<Object> sol = (ArrayList<Object>)mensajeIn.getSession().get("sol");
					barriosControler.getSol(sol);
					mensajeOut=new Message();
					mensajeOut.setContext("/getSolResponse");
					session.put("sol",sol);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/infoAgenda":
					ArrayList<FranjaHorariaReal> listaInfo = (ArrayList<FranjaHorariaReal>)mensajeIn.getSession().get("listaAgenda");
					customer = (Customer)mensajeIn.getSession().get("perfilAgenda");
					agendaControler.getInfo(listaInfo,customer);
					mensajeOut=new Message();
					mensajeOut.setContext("/infoAgendaResponse");
					session.put("perfilAgenda",customer);
					session.put("listaAgenda", listaInfo);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/addAgenda":
					customer=(Customer)mensajeIn.getSession().get("idAdd");
					FranjaHorariaReal listaAdd = (FranjaHorariaReal) mensajeIn.getSession().get("add");
					agendaControler.addAgenda(listaAdd,customer);
					mensajeOut=new Message();
					mensajeOut.setContext("/addAgendaResponse");
					session.put("idAdd", customer);
					objectOutputStream.writeObject(mensajeOut);
					break;

				case "/deleteAgenda":
					customer=(Customer)mensajeIn.getSession().get("idDelete");
					FranjaHorariaReal delete = (FranjaHorariaReal)mensajeIn.getSession().get("delete");
					agendaControler.deleteAgenda(delete,customer);
					mensajeOut.setContext("/deleteAgendaResponse");
					session.put("idDelete", customer);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;

				case "/addFavorito":
					customer = (Customer)mensajeIn.getSession().get("id");
					Object lugar = (Object)mensajeIn.getSession().get("lugar");
					BarriosControler.addFavorito(lugar,customer);
					mensajeOut.setContext("/addFavoritoResponse");
					session.put("id",customer);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/eliminarFavorito":
					customer = (Customer)mensajeIn.getSession().get("id");
					Object sitio = (Object)mensajeIn.getSession().get("lugar");
					BarriosControler.eliminarFavorito(sitio,customer);
					mensajeOut.setContext("/eliminarFavoritoResponse");
					session.put("id",customer);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/verFavorito":
					ArrayList<Object> favoritos = (ArrayList<Object>)mensajeIn.getSession().get("favoritos");
					customer = (Customer)mensajeIn.getSession().get("id");
					BarriosControler.verFavoritos(customer,favoritos);
					mensajeOut.setContext("/verFavoritosResponse");
					session.put("favoritos",favoritos);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;



				default:
		    		System.out.println("\nParámetro no encontrado");
		    		break;
		    }
		    
		    //Lógica del controlador 
		    //System.out.println("\n1.- He leído: "+mensaje.getContext());
		    //System.out.println("\n2.- He leído: "+(String)mensaje.getSession().get("Nombre"));
		    
		    
		    
		    //Prueba para esperar
		    /*try {
		    	System.out.println("Me duermo");
				Thread.sleep(15000);
				System.out.println("Me levanto");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			// create an object output stream from the output stream so we can send an object through it
			/*ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
			
			Create the object to send
			String cadena=((String)mensaje.getSession().get("Nombre"));
			cadena+=" añado información";
			mensaje.getSession().put("Nombre", cadena);
			//System.out.println("\n3.- He leído: "+(String)mensaje.getSession().get("Nombre"));
			objectOutputStream.writeObject(mensaje);*
			*/

		} catch (IOException ex) {
			System.out.println("Unable to get streams from client"+ex.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static Customer comprobacion(Customer perfil){
		CustomerControler customerControler = new CustomerControler();
		ArrayList<Customer> lista = new ArrayList<Customer>();
		customerControler.getCustomer(lista);
		for(Customer c : lista){
			if(perfil.equals(c)){
				return perfil;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("SocketServer Example");
		ServerSocket server = null;
		try {
			server = new ServerSocket(PORT_NUMBER);
			while (true) {
				/**
				 * create a new {@link SocketServer} object for each connection
				 * this will allow multiple client connections
				 */
				new SocketServer(server.accept());
			}
		} catch (IOException ex) {
			System.out.println("Unable to start server.");
		} finally {
			try {
				if (server != null)
					server.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}