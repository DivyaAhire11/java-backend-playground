package Multithreading;

public class ThreadMethods extends Thread {
    public ThreadMethods(String nm) {
        super(nm);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Priority : "
                    + Thread.currentThread().getPriority() + " - Count : " + i);
        }
    }

    public static void main(String[] args) {
        ThreadMethods t1 = new ThreadMethods("High Priority Thread"); // naming of thread Thread-0 -->High Priority Thread
        ThreadMethods t2 = new ThreadMethods("Low Priority Thread"); // naming of thread Thread-1 --> Low Priority Thread
        ThreadMethods t3 = new ThreadMethods("Medium Priority Thread"); // naming of thread Thread-2 --> Medium Priority Thread
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
