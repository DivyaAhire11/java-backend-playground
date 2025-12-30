package Multithreading;
/**
 * run() contains the job of the thread
 * JVM calls run() automatically when start() is called
 * 
 * Runnable is a functional interface : only one method -> run()
 */
public class ThreadState2 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadState2 t1 = new ThreadState2();
        t1.start();  
        System.out.println(t1.getState());
        t1.join();
        System.out.println(t1.getState());
    }
}
