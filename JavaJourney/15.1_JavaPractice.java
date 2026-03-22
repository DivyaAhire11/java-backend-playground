/* 
    Write a java program to display name and priority of a Thread
*/
class MyThread extends Thread{
    public void run(){
        //Display tread details
        String name = Thread.currentThread().getName();
        System.out.println("Thread Name : "+name );
        System.out.println(name +" Priority : "+Thread.currentThread().getPriority());
    }
}
class ThreadInfo{
 public static void main(String[] args) {
    MyThread t1 = new MyThread();
    MyThread t2 = new MyThread();

    //set Names
    t1.setName("First Thread");
    t2.setName("Second Thread");

    t1.setPriority(Thread.MIN_PRIORITY);  //0
    t2.setPriority(Thread.MAX_PRIORITY);  //10

    t1.start();
    t2.start();
 }
}