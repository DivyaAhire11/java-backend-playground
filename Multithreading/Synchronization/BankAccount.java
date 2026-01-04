package Multithreading.Synchronization;

class BankAccount {
    private int balance = 1000;

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + "  is attempting to withdraw " + amount);

        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + "  proceding with withdraw ");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
            }

            balance -= amount;
            System.out
                    .println(Thread.currentThread().getName() + " Completed Withdrawal. Remaining VAlues :" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + "Insufficient Fund!!");
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