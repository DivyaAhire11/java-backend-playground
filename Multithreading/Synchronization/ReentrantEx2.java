package Multithreading.Synchronization;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class ReentrantEx2 {

    final Lock lock = new ReentrantLock();

    // outer is waiting for inner method execute and inner method want to aquire
    // lock when Outer release then inner aquired lock : outer --> inner cha wait to
    // execute and inner --> wait to release lock = this condition occured DeadLock

    // same thread can lock it multiple times
     
    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer Method");
            innerMethod(); // outer mathod is calling inner Method
        } finally {
            System.out.println("Outer Lock Released");
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock(); // again lock aquired
        try {
            System.out.println("Inner Method");
        } finally {
            System.out.println("Inner Lock Released");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantEx2 re = new ReentrantEx2();
        re.outerMethod();
    }
}
/*
 * Outer Method
 * Inner Method
 * Inner Lock Released
 * Outer Lock Released
 */