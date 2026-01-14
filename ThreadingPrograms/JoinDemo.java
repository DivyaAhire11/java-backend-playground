package ThreadingPrograms;

public class JoinDemo extends Thread {

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class JOIN {
    public static void main(String[] args) throws InterruptedException {
        JoinDemo t1 = new JoinDemo();
        JoinDemo t2 = new JoinDemo();
        JoinDemo t3 = new JoinDemo();

        t1.start();
           t1.join(1000); // main thread waits for the t1 to finish
        t2.start();
           t2.join(); // main thread waits for the t2 to finish
        t3.start();
           t3.join(); // main thread waits for the t3 to finish

        System.out.println("Main Thread END!");

    }
}
/*
 * order is guaranteed
 * 
 * t2.start() cannot happen until t1.join() finishes
 * t3.start() cannot happen until t2.join() finishes
 * Main thread ends only after all three threads finish
 * 
 * So no thread overlap happens here
 * // join(); // wait indefinitely
 * // join(long millis); // wait up to millis : 
 *      --->join(1000) is the maximum wait time in milliseconds
        -->If the target thread finishes earlier, join() returns immediately
 */
