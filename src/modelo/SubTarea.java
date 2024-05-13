package modelo;


public class SubTarea {
    private String descripcion;
    private boolean completa;

    public SubTarea(String descripcion) {
        this.descripcion = descripcion;
        this.completa = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void marcarCompleta() {
        this.completa = true;
    }

    @Override
    public String toString() {
        return "- " + this.descripcion; // Devolver una representación significativa de la subTarea
    }
}
