package JavaJourney;

import java.util.Random;

/*
  write a java program that implements a multi-thread application that has three threads.
  first thread generates random integer number after every one second,if the number is even
  second thread computes the square of that number and print it. If the number is Odd
  the third thread computes of cube of that number and print it. 
*/

class NumberGenerator implements Runnable {
   SharedData data;
  NumberGenerator(SharedData data) {
     this.data = data;
  }

  public void run() {
    Random r = new Random();
    try {
      while (true) {
        int num = r.nextInt(100); // generate number from 0 - 99

        data.setNumber(num);
        
        System.out.println("\n Generated Number : " + num);
        Thread.sleep(1000);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

// shared class to store number
class SharedData {
  int number;

  synchronized void setNumber(int number) {
    this.number = number;
    notifyAll(); // wake up other waiting threads
  }

  synchronized int getNumber() {
    return number;
  }

}

// Thread to calculate square if number is even
class SquareThread implements Runnable {
  SharedData data;

  SquareThread(SharedData data) {
    this.data = data;
  }

  public void run() {
    try {
      while (true) {
        synchronized (data) {
          data.wait();// wait until number is generated
          int n = data.getNumber();
          if (n % 2 == 0)
            System.out.println("Square of " + n + " = " + (n * n));
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}

// Thread to calculate cube if number is odd
class CubeThread implements Runnable {
  SharedData data;

  CubeThread(SharedData data) {
    this.data = data;
  }

  public void run() {
    try {
      while (true) {
        synchronized (data) {
          data.wait();// wait until number is generated
          int n = data.getNumber();
          if (n % 2 != 0)
            System.out.println("Cube of " + n + " = " + (n * n * n));
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class MultiThreadApplication {
  public static void main(String[] args) {
    SharedData data = new SharedData();

    Thread t1 = new Thread(new NumberGenerator(data));
    Thread t2 = new Thread(new SquareThread(data));
    Thread t3 = new Thread(new CubeThread(data));

    t1.start(); // number generator thread
    t2.start(); // square thread
    t3.start(); // cube thread
  }
}
