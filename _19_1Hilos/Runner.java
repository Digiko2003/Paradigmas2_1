package _19_1Hilos;

public class Runner implements Runnable {

    @Override
    public void run () {
        for (int i=0; i <  10; i++){
            System.out .println ("Elemento "+ i );


            try {
                Thread.sleep (1000); //Duerme durante 1 segundo
            }catch (InterruptedException e) { e.printStackTrace ();
            }
        }
    }
}
