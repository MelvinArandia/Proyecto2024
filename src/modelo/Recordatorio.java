package modelo;

public class Recordatorio {
    private Tarea tarea;
    private String fecha;
    private String hora;

    public Recordatorio(Tarea tarea, String fecha, String hora) {
        this.tarea = tarea;
        this.fecha = fecha;
        this.hora = hora;
    }

    // Getters y Setters

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}