 package Multithreading.Thread_Methods;

public class SleepExample extends Thread{
    public void run(){
        for(int i=0;i<=5;i++){
            try {
                Thread.sleep(1000); //1second
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SleepExample s = new SleepExample();
        s.start();
    }
}
