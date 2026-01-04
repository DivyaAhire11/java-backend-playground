package Multithreading.Synchronization;
/**
 * 1.synchronized keyword used
      --> Only one thread can execute this method at a time
      -->Lock is on the object


    2. SYNCHRONIZED BLOCK : Locks only a specific section of code.
       --> More efficient than synchronized methods
       --> Allows non-critical code to run concurrently
       
       synchronized(this){
           cnt++;
       } 
 */
class Counter {
    private int cnt = 0;

    public synchronized void increment() {  //Locks the entire method.  --> CRITICAL SECTION 
       cnt++;
    }
    
    public int getCount() {
        return cnt;
    }

}

class Test {
    public static void main(String[] args) {
        Counter c = new Counter();
        MyThread t1 = new MyThread(c); // common resource : c (1ch object shared)
        MyThread t2 = new MyThread(c); // common resource : c

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            System.out.println("Interrupt Exception : " + e);
        }

        System.out.println("Counter Value in main() : " + c.getCount());
        // without join() jr print kel tr eka instance la print hoil -> 0
        // t1.join() and t2.join() --> either any value(1846) OR 2000  
        // eakhdya instance la thread simultaneous chalto : ek object shared krto between multiple threads 
    }
}

class MyThread extends Thread {
    private Counter counter;

    MyThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();  //synchronized method call
        }
    }
}
