 package Multithreading.Thread_Methods;

public class JoinExample extends Thread {
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " is running :" + i);
        }
    }

    public static void main(String[] args) {
        JoinExample t1 = new JoinExample();
        JoinExample t2 = new JoinExample();

        t1.start();
        try {
            t1.join(); // wait for t1 //Don’t call join() before start()
        } catch (Exception e) {
            System.out.println(e);
        }

        t2.start();

        System.out.println("End of main!!");
    }
}
/*
 * -------WITHOUT USING JOIN-------
 * 
 * End of main!!
 * Thread-1 is running :0
 * Thread-1 is running :1
 * Thread-1 is running :2
 * Thread-1 is running :3
 * Thread-0 is running :0
 * Thread-0 is running :1
 * Thread-0 is running :2
 * Thread-0 is running :3
 * 
 * -------USING JOIN--------
 * 
 * Thread-0 is running :0
 * Thread-0 is running :1
 * Thread-0 is running :2
 * Thread-0 is running :3
 * End of main!!
 * Thread-1 is running :0
 * Thread-1 is running :1
 * Thread-1 is running :2
 * Thread-1 is running :3
 */
