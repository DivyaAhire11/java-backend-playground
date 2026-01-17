package ThreadingPrograms;

// If t1 , t2 both are daemon thread then : O/P --> nothing display
// if only daemon thread and remove user thread : O/P --> nothing display
// JVM may exit immediately

class DaemonDemo extends Thread {
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println(Thread.currentThread().getName() + " is a Daemon Thread.");
        } else {
            System.out.println(Thread.currentThread().getName() + " is a User Thread.");
        }
    }
}

class Demo {
    public static void main(String[] args) {
        DaemonDemo t1 = new DaemonDemo();
        DaemonDemo t2 = new DaemonDemo();

        t1.setDaemon(true);

        t1.start(); // Daemon Thread
        t2.start(); // User Thread
    }
}
