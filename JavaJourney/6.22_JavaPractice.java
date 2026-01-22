package JavaJourney;

//  Write a java program to simulate traffice signsl using thread
class Signal implements Runnable {
    public void run() {
        try {
            while (true) {
                // Red Signal
                System.out.println("RED - STOP ");
                Thread.sleep(4000);

                // yellow signal
                System.out.println("YELLOW - READY ");
                Thread.sleep(2000);

                // green signal
                System.out.println("GREEN - GO ");
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Simulation {
    public static void main(String[] args) {

        // Create thread for each signal
        Signal ts = new Signal();
        Thread t = new Thread(ts);
        t.start();

    }
}
