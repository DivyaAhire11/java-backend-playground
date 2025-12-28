package Multithreading;

/**
 * Thraeds and Mutation are together are not a good idea
 * If we are working with threads always try that you work with data which are
 * immutable
 * if there is a method which can can do some mutation make it thread safe
 * thread safe : One thread at a time
 * using synchronized keyword avoid race condition : One method at a time
 */
class Counter {
    int count; // instance variable by default intialize : 0

    public synchronized void increment() { 
        count++;
    }

}

public class MyThread3 {
    public static void main(String[] args) {
        Counter c = new Counter();

        Runnable ob1 = () -> {
            for (int i = 0; i < 10000; i++) {
                c.increment();
            }
        };

        Runnable ob2 = () -> {
            for (int i = 0; i < 10000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(ob1); 
        Thread t2 = new Thread(ob2); 

        t1.start();
        t2.start();

        try {
            t1.join(); //which allows main thread to wait for the other 2 thread to come back and join
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Counter : " + c.count); 

    }
}
