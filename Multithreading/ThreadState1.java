package Multithreading;
/**
 * RUNNABLE : either ready to execute OR in running
 * 
 */
public class ThreadState1 extends Thread {
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getState()); //main thread :  RUNNABLE 

        ThreadState1 ts = new ThreadState1(); //State : After Creating Thread Object
        System.out.println(ts.getState()); // NEW

        ts.start(); //State : After start method call
        System.out.println(ts.getState()); // RUNNABLE

        Thread.sleep(1000);//1sec
        System.out.println(ts.getState()); //TIMED_WAITING :  jevha thread sleep krto 

        ts.join(); //main thread waits for this thread to terminate 
        System.out.println(ts.getState()); // TERMINATED
    }
}
