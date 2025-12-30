package Multithreading;

class Test extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()); // Thread-0
        }
    }

}

public class ThreadState {
    public static void main(String[] args) {
        System.out.println("Hello Divya!!");

        // thread-1
        Test t = new Test();
        t.start();   //initiate new thread

        // thread-2
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()); // main thread
        }

    }
}
