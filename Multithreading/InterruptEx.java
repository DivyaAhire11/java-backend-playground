package Multithreading;

public class InterruptEx extends Thread{
    
    public void run(){
        try {
            Thread.sleep(1000);
            System.out.println("Thread is running...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }


    public static void main(String[] args) {
        InterruptEx t1 = new InterruptEx();
        t1.start();
       // t1.interrupt(); //InterruptedException: sleep interrupted
    }
}
