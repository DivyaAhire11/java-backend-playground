package Multithreading.Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantExample {
    private int cnt =0;
    private final Lock lk = new ReentrantLock();

    public void increment(){
        lk.lock();   // aquire the lock
        try{
            cnt++;
        }finally{
          lk.unlock(); //Always release the lock
        }
    }

    public int getCount(){
        return cnt;
    }
   
}
class Main {
    public static void main(String[] args)throws InterruptedException {
        ReentrantExample rt = new ReentrantExample();

        Thread t1 = new Thread(() ->{
            for(int i=0;i<1000;i++){
                rt.increment();
            }
        });

        Thread t2 = new Thread(() ->{
            for(int i=0;i<1000;i++){
                rt.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count is : "+rt.getCount()); //2000
   
//    Without the lock, the result might be less than 2000 due to race conditions.
    }
}

/* Reentrant : A reentrant lock means the same thread can lock it multiple times.
     lock.lock();
     try {
         methodA();
     } finally {
         lock.unlock();
     }
     
     void methodA() {
         lock.lock();   // same thread can lock again
         try {
             // do something
         } finally {
             lock.unlock();
         }
     }
     
*/
