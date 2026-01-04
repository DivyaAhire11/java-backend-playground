package Multithreading.Synchronization;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock(time) -> //Acquires the lock if it is available and returns true ow
 * wait for given time check again ow return false
 */
class BankAccount {
    private int balance = 1000;

    private final Lock l = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + "  is attempting to withdraw " + amount);

        try {
            if (l.tryLock(4000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "  Proceeding withdraw " + amount);
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()
                                + "  Completed Withdrawal \n Remaining Balance :  " + balance);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    } finally {
                        l.unlock();
                    }

                } else {
                    System.out.println("Insufficient balance :" + balance);
                }
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " Could not aquuired the lock Please Try Again :  ");
            }
        } catch (Exception e) { // InterruptException can cause due to time
            System.out.println(e);
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