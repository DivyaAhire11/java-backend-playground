package ThreadingPrograms;

public class JoinDemo extends Thread {

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
        try {
            Thread.sleep(1000);
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
            t1.join();  //main thread waits for the t1 to finish
        t2.start();
            t2.join();  //main thread waits for the t2 to finish
        t3.start();
            t3.join();  //main thread waits for the t3 to finish

        System.out.println("Main Thread END!");

    }
}
