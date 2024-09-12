package main.java.icai.dtc.isw.message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String context;
	private Map<String, Object> session;
	private boolean comprobar;

	public Message () {
		context=new String();
		session=new HashMap<String, Object>();
		comprobar = false;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setComprobar(boolean comprobar){
		this.comprobar=comprobar;
	}

	public boolean getComprobar(){
		return comprobar;
	}
}
