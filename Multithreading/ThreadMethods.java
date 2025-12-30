package Multithreading;

public class ThreadMethods extends Thread{
    public void run(){
          for(int i=0;i<5;i++){
               System.out.println(Thread.currentThread().getName()+" - Priority : "+Thread.currentThread().getPriority()+" - Count : "+i);
          }
    }

    public static void main(String[] args) {
            ThreadMethods t1 = new ThreadMethods();
            t1.start();
    }
}
