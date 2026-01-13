package Multithreading;
//The read lock may be held simultaneously by multiple reader threads, so long as there are no writers. The write lock is exclusive

//multiple thread can read.
//while writing not other read , write thread allowed.

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

public class ReadWriteCounter {
    private int count = 0;
    private final ReadWriteLock rrw = new ReentrantReadWriteLock();
    private final Lock rl = rrw.readLock();
    private final Lock wl = rrw.writeLock();

    public void increment() {
        wl.lock();
        try {
            count++;
        } finally {
            wl.unlock();
        }
    }

    public int getCount() {
        rl.lock();
        try {
            return count;
        } finally {
            rl.unlock();
        }

    }

    public static void main(String[] args) {
        ReadWriteCounter r = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                    System.out.println(Thread.currentThread().getName() + " read : " + r.getCount());
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    r.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented " + (i+1));

                }
            }
        };

        Thread t1 = new Thread(writeTask, "Write Thread ");
        Thread t2 = new Thread(readTask, "Read1 Thread ");
        Thread t3 = new Thread(readTask, "Read2 Thread ");

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
           System.out.println(e);
        }

        System.out.println("Final count : "+r.getCount());
    }
}
