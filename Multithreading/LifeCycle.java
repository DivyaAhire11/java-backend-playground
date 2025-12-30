package Multithreading;
/**
 *  NEW : thread object created , Thread not started yet
 * RUNNABLE : thready to run,waiting for CPU from scheduler
 * (Internally RUNNING is a part of RUNNABLE in java)
 */
public class LifeCycle extends Thread{
    public void run(){
        System.out.println("Thread State inside run() : "+Thread.currentThread().getState());
       try {
        Thread.sleep(500);
       } catch (Exception e) { }
        
    }

    public static void main(String[] args) {
        LifeCycle lc = new LifeCycle();

        //State 1 : NEW
        System.out.println("State after creation : "+lc.getState());
        
        //State 2 : RUNNABLE
        lc.start();
        System.out.println("State after start() : "+lc.getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        //State 3 : TERMINATED OR if thread-0 is sleep : TIMED_WAITING
        System.out.println("State after completion : "+lc.getState());
    }
}
