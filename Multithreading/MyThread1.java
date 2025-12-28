package Multithreading;

class A extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("hii");
            try {
                Thread.sleep(10); // 10 milli sec
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(10); // 10 milli sec
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

public class MyThread1 {
    public static void main(String[] args) {
        A ob1 = new A();
        B ob2 = new B();

        // System.out.println(ob1.getName()); // Thread-0
        // System.out.println(ob2.getName()); // Thread-1

        /**
         * Priority goes from 1 to 10
         * 1 is the less priority
         * 10 is the High priority
         * 5 is the normal priority(ByDefault priority)
         */
        System.out.println("Priority of ob1 : " + ob1.getPriority()); // 5
        System.out.println("Priority of ob1 : " + ob2.getPriority()); // 5

        ob1.setPriority(Thread.MAX_PRIORITY - 1);

        System.out.println("After Set Priority Maximum : " + ob1.getPriority()); // 9

        // System.out.println(Thread.MAX_PRIORITY); //10
        // System.out.println(Thread.MIN_PRIORITY); //1
        // System.out.println(Thread.NORM_PRIORITY); //5

        ob1.start();
        ob2.start();

    }
}
