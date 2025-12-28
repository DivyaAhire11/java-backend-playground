package Multithreading;

class A extends Thread{
    public void run() {
        for(int i=0;i<100;i++)
          System.out.println("hii");
    }
}

class B extends Thread{
    public void run() {
        for(int i=0;i<100;i++)
          System.out.println("Hello");
    }
}

public class MyThread1 {
    public static void main(String[] args) {
        A ob1 = new A();
        B ob2 = new B();

        ob1.start();
        ob2.start();

    }
}
