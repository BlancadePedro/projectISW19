package main.java.icai.dtc.isw.domain.ocio;
public class Parque extends Ocio{

    private String horario;

    public Parque(String nombre, String direccion, String horario, String barrio, int id) {
        super(nombre, direccion, barrio, id);
        this.horario = horario;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
}
