package _19Contador._19Ejecucion_Hilos;

public class Main {
    public static void main (String [] args) {
        Thread t1 = new Thread (new Runner1 ());
        Thread t2 =new Thread (new Runner2 ());

        t1.start ();
        t2.start ();
    }
}
