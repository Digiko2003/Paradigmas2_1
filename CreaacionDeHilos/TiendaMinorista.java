package CreaacionDeHilos;

    public class TiendaMinorista implements Runnable {
        public void run() {
            ArticuloMinorista articulo1 = new ArticuloMinorista("Chaqueta", 12, 59.95);
            ArticuloMinorista articulo2 = new ArticuloMinorista("Jeans de diseñador ", 40, 34.95);
            ArticuloMinorista articulo3 = new ArticuloMinorista("Camisa", 20, 24.95);

            System.out.println("Descripcion: "+ articulo1.getDescripcion()+ " - Unidades disponibles: " + articulo1.getUnidadesDisponibles() + " - Precio: " + articulo1.getPrecio());
            System.out.println("Descripcion: "+ articulo2.getDescripcion()+ " - Unidades disponibles: " + articulo2.getUnidadesDisponibles() + " - Precio: " + articulo2.getPrecio());
            System.out.println("Descripcion: "+ articulo3.getDescripcion()+ " - Unidades disponibles: " + articulo3.getUnidadesDisponibles() + " - Precio: " + articulo3.getPrecio());
        }
}
