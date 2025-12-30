package Multithreading;

class Test implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("World"); // Thread-0
        }
    }

}

public class MyThread5 {
    public static void main(String[] args){
        // thread-1
        Test s = new Test();
        Thread t = new Thread(s); // thread obj is created by passing an instance of MyRunnable
        t.start();  // called on thread object

        // thread-2
        for (int i = 0; i < 1000; i++) {
            System.out.println("Hello"); // main thread
        }

    }
}

