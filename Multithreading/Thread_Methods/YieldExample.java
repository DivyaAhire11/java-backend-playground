package Multithreading.Thread_Methods;
/**
 * When want to give chance to others threads also
 */
public class YieldExample extends Thread{
    public void run(){
        for(int i=0;i<=5;i++){
            System.err.println(Thread.currentThread().getName());
            Thread.yield();
        }
    }
    public static void main(String[] args) {
        YieldExample t1 = new YieldExample();
        YieldExample t2 = new YieldExample();
        t1.start();
        t2.start();
    }
}
