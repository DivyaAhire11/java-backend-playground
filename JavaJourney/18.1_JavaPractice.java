/*
    Write a java program to display name and priority of a Thread
*/

class MyThread extends Thread{
    @Override
    public void run() {
        String name = getName();
        System.out.println("NAME : "+name);
        System.out.println(name+" PRIORITY : "+getPriority());
    }
}
class ThreadDemo{
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.setPriority(3);
        t2.setPriority(8);

        t1.start();
        t2.start();
    }
}