/*
   Write a java program for the implementation of synchronization

   
Synchronization : Ensures only one thread accesses a resource at a time. It prevents data inconsistency and ensures thread safety when multiple threads access shared resources.
*/
class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        System.out.println("---------------------------------");
    }
}

class MyThread2 extends Thread {
    Table t;

    MyThread2(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);
    }
}

class MyThread3 extends Thread {
    Table t;

    MyThread3(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(10);
    }
}

class SyncDemo {
    public static void main(String[] args) {
        Table obj = new Table();

        MyThread2 t1 = new MyThread2(obj);
        MyThread3 t2 = new MyThread3(obj);

        t1.start();
        t2.start();
    }
}