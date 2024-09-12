package main.java.icai.dtc.isw.domain.ocio;

public class Evento extends Ocio{

    private String precio;
    private String autor;
    private String celebracion;//Concierto, lectura de libros, festival...
    private String fecha;

    public Evento(String nombre, String direccion, String precio, String autor, String celebracion, String fecha, String barrio, int id) {
        super(nombre, direccion, barrio, id);
        this.precio = precio;
        this.autor = autor;
        this.celebracion = celebracion;
        this.fecha = fecha;
    }

    public String getAutor() {
        return autor;
    }
    public String getPrecio(){return precio;}
    public String getCelebracion() {
        return celebracion;
    }
    public String getFecha(){return fecha;}

    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setPrecio(String precio){this.precio = precio;}
    public void setCelebracion(String celebracion) {
        this.celebracion = celebracion;
    }
    public void setFecha(String fecha){this.fecha = fecha;}
}
