package Multithreading;

public class MyYield extends Thread{
    
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() +" is running...");
            Thread.yield(); //dusrya thread la pn chance bhetel 
        }
     }


    public static void main(String[] args) {
        MyYield t = new MyYield();
        MyYield t1 = new MyYield();  //user thread
        t.start();
        t1.start();
      
    }
}
