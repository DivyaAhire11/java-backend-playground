package JavaJourney;

/*
   write a Java program to show lifecycle(creation,sleep and dead)of a thread.
   program should print randomly the name of thread and value of sleep time.
   The name of the thread should be hard coded through constructor.
   The sleep time of a thread will be a random integer in the range 0 to 4999.


*) creation State : 
      LifeCycleThread t1 = new LifeCycleThread("THREAD-A");

*) sleep state : 
      sleepTime = r.nextInt(5000);
     Thread.sleep(sleepTime)

*) Dead state : after execution of run() method completes,the thread enters dead state

*/



import java.util.Random;

class LifeCycleThread extends Thread{
    String tname;
    int sleepTime;

    //constructor to set hard coded thread name
    LifeCycleThread(String tname){
        this.tname = tname;
        setName(tname);   //setting thread name

        System.out.println("Thread Created : "+getName());
    }

    public void run(){
        try {
            //generate random sleep time between 0 to 4999
            Random r = new Random();
            sleepTime = r.nextInt(5000);

            System.out.println("Thread Running : "+getName());
            System.out.println(getName() + " will sleep for "+ sleepTime + " millisec");

            //sleep state
            Thread.sleep(sleepTime);

            //after sleep
            System.out.println(getName() + " woke up from sleep");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Thread Dead : "+getName());
    }
}

class ThreadLifeCycleDemo{
    public static void main(String[] args) {
        //creating threads (creation state)
        LifeCycleThread t1 = new LifeCycleThread("THREAD-A");
        LifeCycleThread t2 = new LifeCycleThread("THREAD-B");
        LifeCycleThread t3 = new LifeCycleThread("THREAD-C");

        t1.start();
        t2.start();
        t3.start();
    }
}
