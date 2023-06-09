package CreaacionDeHilos;

public class ArticuloMinorista {
    private String descripcion;
    private int unidadesDisponibles;
    private double precio;

    public ArticuloMinorista(String descripcion, int unidadesDisponibles, double precio) {
        this.descripcion = descripcion;
        this.unidadesDisponibles = unidadesDisponibles;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Descripción: " + descripcion + " - Unidades disponibles: " + unidadesDisponibles + " - Precio: " + precio;
    }
}
