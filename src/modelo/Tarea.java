package modelo;
// Tarea
import java.util.ArrayList;
import java.util.List;
public class Tarea {
    private String titulo;
    private String descripcion;
    private String fechaLimite;
    private String estado;
    private int prioridad;
    private String etiqueta;
    private List<SubTarea> subTarea;

    public Tarea(String titulo, String descripcion, String fechaLimite, String estado, int prioridad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.estado = estado;
        this.prioridad = prioridad;
        this.etiqueta = etiqueta;
        this.subTarea = new ArrayList<SubTarea>();
    }

    // Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public List<SubTarea> getSubTarea() {
        return subTarea;
    }

    public void setSubTarea(List<SubTarea> subTarea) {
        this.subTarea = subTarea;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titulo: ").append(titulo).append("\n");
        sb.append("Descripcion: ").append(descripcion).append("\n");
        sb.append("Fecha limite: ").append(fechaLimite).append("\n");
        sb.append("Estado: ").append(estado).append("\n");
        sb.append("Prioridad: ").append(prioridad).append("\n");
        sb.append("Etiqueta: ").append(etiqueta).append("\n");

        if (!subTarea.isEmpty()) {
            sb.append("SubTareas: \n");
            for (SubTarea subTarea : subTarea) {
                sb.append("- ").append(subTarea.getDescripcion()).append("\n");
            }
        }

        return sb.toString();
    }

}
