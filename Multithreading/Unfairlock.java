package Multithreading;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Unfairlock {
    private final Lock uf = new ReentrantLock(true);  //fair true if this lock should use a fair ordering policy :  avoid starvation 

    public void accessResources(){
        uf.lock();
        try{
        System.out.println(Thread.currentThread().getName() +" acquired the lock...");
        Thread.sleep(1000);
        }catch(InterruptedException e){
          Thread.currentThread().interrupt();
        }finally{
            System.out.println(Thread.currentThread().getName() +" Released the lock...");
            uf.unlock();
        }
    }
    
    
    public static void main(String[] args) {
        Unfairlock ul = new Unfairlock();

        Runnable task = new Runnable(){
            public void run(){
                ul.accessResources();
            }
        };

        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        Thread t3 = new Thread(task,"Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
