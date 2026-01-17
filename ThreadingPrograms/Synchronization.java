package ThreadingPrograms;
//Race condition Problem: when multiple threads access same data at a same time , result becomes wrong.
// 2 threads do it together : thread interference
//without synchronization
class Counter{
    int cnt =0;

    public void increment(){
        cnt++;
    }
}
class MyThread extends Thread{
    Counter c;
    MyThread(Counter c){
        this.c = c;
    }
    public void run(){
        for(int i=1;i<= 1000;i++){
            c.increment();
        }
    }
}
public class Synchronization {
    public static void main(String[] args) {
        Counter c = new Counter();
        MyThread t1 = new MyThread(c);
        MyThread t2 = new MyThread(c);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count = "+c.cnt);
    }
}
