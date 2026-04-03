/* 
    Write a java program to display name of currently executing Thread in Multithreading
*/

class MyThread1 extends Thread{
    @Override
    public void run() {
        super.run();

        // Display the name of the currently executing thread
        System.out.println("Current Thread Name : "+ Thread.currentThread().getName());
    }
}
class CurrrentThreadDemo{
    public static void main(String[] args) {
       MyThread1 t1 = new MyThread1();
       MyThread1 t2 = new MyThread1();
       
       t1.start();
       t2.start();

       //Main Thread Name 
       System.out.println("Main Thread Name: " + Thread.currentThread().getName());
    }
}