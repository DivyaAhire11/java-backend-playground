package ThreadingPrograms;

class DaemonDemo extends Thread{
    public void run(){
        if(Thread.currentThread().isDaemon()){
           System.out.println(Thread.currentThread().getName() +" is a Daemon Thread.");
        }else{
           System.out.println(Thread.currentThread().getName() +" is a User Thread.");
        }
    }
}
class Demo{
    public static void main(String[] args) {
        DaemonDemo t1 = new DaemonDemo();
        DaemonDemo t2 = new DaemonDemo();

          t1.setDaemon(true);

          t1.start();  //Daemon Thread
          t2.start();  //User Thread
    }
}
