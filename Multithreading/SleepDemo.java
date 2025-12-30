package Multithreading;

/**
 * sleep() : pauses current thread
 * Thread enters TIME_WAITING state
 * After time : return to RUNNABLE
 * 
 * 
 * 
 */
public class SleepDemo extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread State inside run() : " + Thread.currentThread().getName() + " : " + i);

                System.out.println("Before Sleep : " + Thread.currentThread().getState());
                // Thread goes to sleep 1 sec
                Thread.sleep(2000);
                System.out.println("After Sleep : " + Thread.currentThread().getState());

            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        SleepDemo sd1 = new SleepDemo();
        SleepDemo sd2 = new SleepDemo();

        sd1.start();
        sd2.start();
        
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
    }
}