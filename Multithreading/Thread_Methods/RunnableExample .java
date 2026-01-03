package Multithreading.Thread_Methods;
/**
 * Supports multiple inheritance
 * 
 */
class RunnableExample implements Runnable {
    public void run() {
        System.out.println("Thread running using Runnable");
    }

    public static void main(String[] args) {
        RunnableExample r = new RunnableExample();
        Thread t = new Thread(r);
        t.start();
    }
}
