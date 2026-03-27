//Java Program to solve producer consumer problem in which a producer produces a value and consumer consume the value
//before producer generates the next value( Hint :use thread synchronization)

class Shared {
    int value;
    boolean available = false;

    synchronized void produce(int val) throws InterruptedException {

        // wait if value not consumed
        while (available) {
            wait();
        }

        value = val;
        System.out.println("Produced : " + value);
        available = true;
        notify(); // notify consumer
    }

    // Comsume method
    synchronized void consume() throws InterruptedException {

        // wait if no value available
        while (!available) {
            wait();
        }

        System.out.println("Consumed : " + value);
        available = false;

        notify(); // notify producer
    }
}

class Producer extends Thread {
    Shared s;

    Producer(Shared s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                s.produce(i);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Consumer extends Thread{
    Shared s;

    Consumer(Shared s){
        this.s = s;
    }
    @Override
    public void run() {
        try {
            for(int i=1;i<=5;i++){
                s.consume();
                Thread.sleep(500);
            }
        } catch (Exception e) {
           System.out.println(e);
        }
    }
}

class Demo{
    public static void main(String[] args) {
        Shared s = new Shared();

        Producer p = new Producer(s);
        Consumer c = new Consumer(s);

        p.start();
        c.start();
    }
}