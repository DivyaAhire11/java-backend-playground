package Multithreading;

/**
 * Daemon threads : background threads(JVM not wait)
 * JVM does NOT wait for daemon threads to finish
 * When all non-daemon (user) threads end, the JVM terminates, even if daemon threads are still running.
 * ex : garbage collector , backgroud cleanup tasks
 */
public class ThreadMethods1 extends Thread {
    int cnt = 0;

    public void run() {
        while (true) {
            cnt++;
            System.out.println("Hello!! : " + cnt);
        }
    }

    public static void main(String[] args) {
        ThreadMethods1 t = new ThreadMethods1();
        ThreadMethods1 t1 = new ThreadMethods1();
        t.setDaemon(true);  //Marks the thread as a daemon thread
        //Must be called before start(), otherwise an exception occurs
        t.start(); //call run()
       
        t1.setDaemon(true);  //jr he nhi thevl tr JVM infinite running print - Hello!! 
        t1.start();

        System.out.println("Main() end!!");
    }
}
//output : see few or no "Hello!!" lines
