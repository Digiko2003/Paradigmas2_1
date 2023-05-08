package Hilos;

public class PruebaHiloSleep {
    public static void main (String []args ){
        Thread hl = new Thread (new Runner ()); hl.start();
    }
}
