package Multithreading;
/**
 * Thread is class which impliments runnable interface
 * Runnable inteface has run()
 * we can create referance of interface and object of class
 * If we want to used thread class : 1.extends Thread  OR  2.implements Runnable(need to create sep objects of thread and pass object)
 * 
 */
class A implements Runnable{
   public void run(){
       System.out.println("Hello Divya!");
   }
}
public class MyThread2 {
    public static void main(String[] args) {
        Runnable ob1 = new A();
        //  A ob1 = new A();
        //lambda ex : Works whenever we have @Functional interface
        //Runnable is actually a functional interface

        Runnable ob2 = () -> System.out.println("Good Day!");  //Lambda expression
        
        Runnable ob3 = new Runnable() {   //anonymous
            public void run(){
                System.out.println("Good Night!");
            }
        };
        Thread t1 = new Thread(ob1);  
        Thread t2 = new Thread(ob2);  
        Thread t3 = new Thread(ob3);  
        t1.start();
        t2.start();
        t3.start();
    }
}
