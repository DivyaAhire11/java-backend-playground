package Multithreading.Synchronization;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * NOT USING SYNCHRONIZED KEYWORD USE INBUILD LOCK 
 * 
 * tryLock(time) -> //Acquires the lock if it is available and returns true ow
 * wait for given time check again ow return false
 * 
 * l.tryLock()
 * l.unlock()
 * l.lock()  : wait until lock hetat nhi to prnt
 * 
 *  private final Lock l = new ReentrantLock();  
 *   --> only this class can access the lock
 *   --> the reference cannot be reassigned (good for thread safety)
 *   --> The lock itself can still change state (locked/unlocked)
 */
class BankAccount {
    private int balance = 1000;

    private final Lock l = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + "  is attempting to withdraw " + amount);

        try {
           
            if (l.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "  Proceeding withdraw " + amount);
                        Thread.sleep(2000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()
                                + "  Completed Withdrawal \n Remaining Balance :  " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); //Good practice
                    } finally {
                        l.unlock();
                    }

                } else {
                    System.out.println("Insufficient balance :" + balance);
                }
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " Could not aquuired the lock , will try later :  ");
            }
        } catch (Exception e) { // InterruptException can cause due to time
            Thread.currentThread().interrupt();
        }

    }

    public int getBalance() {
        return balance;
    }
}

class Account {
    public static void main(String[] args) {
        BankAccount bk = new BankAccount();
        Runnable task = new Runnable() { // annonymous class
            public void run() {
                bk.withdraw(100);
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();

        System.out.println("Balance is : " + bk.getBalance());

    }
}
/*
  Balance is : 1000
  Thread 2  is attempting to withdraw 100
  Thread 1  is attempting to withdraw 100
  Thread 2  Proceeding withdraw 100
  Thread 2  Completed Withdrawal 
  Remaining Balance :  900
  Thread 1  Proceeding withdraw 100
  Thread 1  Completed Withdrawal 
  Remaining Balance :  800
 
 */