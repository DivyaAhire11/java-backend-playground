package ThreadingPrograms;
//Method level lock

//synchronized : only one thread can execute this method at a time 
// Other threads must wait until lock is released
// lock is taken on object c
// this create critical section : code that must be executed by only one thread
//Lock /Monitor : Mechanisms used by synchronized
// Mutual Exclusive : Only one thread allow at a time 

class Counter {
    int cnt = 0;

    synchronized public void increment() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        System.out.println("Thread Name : " + Thread.currentThread().getName());
        cnt++;
    }
}

class MyThread extends Thread {
    Counter c;

    MyThread(Counter c) {
        this.c = c;
    }

    public void run() {
        for (int i = 1; i <= 1000; i++) {
            c.increment();
        }
    }
}

public class Synchronization1 {
    public static void main(String[] args) {
        Counter c = new Counter();
        MyThread t1 = new MyThread(c);
        MyThread t2 = new MyThread(c);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Name : " + Thread.currentThread().getName());
        System.out.println("Final Count = " + c.cnt);
    }

}
//OUTPUT  : Thread Name : main
//          Final Count = 1602
