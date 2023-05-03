package CreaacionDeHilos;

public class Main {
    public static void main(String[] args) {
        System.out.println("Articulos:");
        TiendaMinorista tienda = new TiendaMinorista();
        Thread hilo = new Thread(tienda);
        hilo.start();
    }
}
