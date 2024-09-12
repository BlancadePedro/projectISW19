package main.java.icai.dtc.isw.domain.localidad;
public class Museo extends Localidad{
    private String tipoMuseo;
    public Museo(String nombre, String direccion, String horario, String contacto, String precio, String tipoMuseo,String barrio, int id) {
        super(nombre, direccion, horario, contacto, precio, barrio, id);
        this.tipoMuseo = tipoMuseo;
    }

    public String getTipoMuseo() {
        return tipoMuseo;
    }
    public void setTipoMuseo(String tipoMuseo) {
        this.tipoMuseo = tipoMuseo;
    }
    
}
