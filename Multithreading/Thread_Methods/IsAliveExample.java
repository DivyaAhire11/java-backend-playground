package Multithreading.Thread_Methods;
/**
 * Don’t use for synchronization
 */
public class IsAliveExample extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        IsAliveExample t = new IsAliveExample();
        System.out.println(t.isAlive()); //false
        t.start();
        System.out.println(t.isAlive()); //true
    }
}
/* OUTPUT
    false
    true
    Thread is running
 */