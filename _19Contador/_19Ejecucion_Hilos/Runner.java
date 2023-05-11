package _19Contador._19Ejecucion_Hilos;

class Runner1 implements Runnable {
    @Override
    public void run () {
        for (int i = 0; i <  1000; ++i) System.out .println("Runner1: " + i );
    }
}

class Runner2 implements Runnable {
    @Override
    public void run () {
        for (int i = 0; i <  1000; ++i) System.out.println ("\t\tRunner2 :" + i );
    }
}
