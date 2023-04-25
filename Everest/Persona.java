package Everest;

public class Persona {
    private String nombre;
    private String fecha;
    private double edad;
    private String expedicion;
    private String nacionalidad;
    private String causaDeMuerte;
    private String ubicacion;

    public Persona(String nombre, String fecha, double edad, String expedicion, String nacionalidad, String causaDeMuerte, String ubicacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.edad = edad;
        this.expedicion = expedicion;
        this.nacionalidad = nacionalidad;
        this.causaDeMuerte = causaDeMuerte;
        this.ubicacion = ubicacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getCausaDeMuerte() {
        return causaDeMuerte;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public double getEdad() {
        return edad;
    }

    public String getExpedicion() {
        return expedicion;
    }
}
