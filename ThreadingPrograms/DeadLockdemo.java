package ThreadingPrograms;

class Pen {
    public synchronized void writeWithPenAndPaper(Paper paper) {  //The thread must acquire the intrinsic lock (monitor) of that object
     System.out.println(Thread.currentThread().getName() + "--> holds pen -->" + this + " --> writing for paper");//locks the Pen object
        paper.finishWriting(); 
    }

    public synchronized void finishWriting() {
         System.out.println(Thread.currentThread().getName() + " Finish using pen " + this);
    }
}

class Paper {
   public synchronized void writeWithPaperandPen(Pen pen){
       System.out.println(Thread.currentThread().getName() + "--> holds paper --> " + this+ "--> writing for pen"); //locks the paper object
       pen.finishWriting();
   }
    public synchronized void finishWriting() {
         System.out.println(Thread.currentThread().getName() + " Finish using paper " + this);
    }
}

class Task1 implements Runnable{
    private Pen pen;
    private Paper paper;
  
    public Task1(Pen pen,Paper paper){
        this.pen = pen;
        this.paper = paper;
    }


    public void run(){
        pen.writeWithPenAndPaper(paper);  //thread1 locks pen and tries to lock paper
       
    }
}
class Task2 implements Runnable{
    private Pen pen;
    private Paper paper;
  
    Task2(Pen pen,Paper paper){
        this.pen = pen;
        this.paper = paper;
    }
    public void run(){
       paper.writeWithPaperandPen(pen); //thread2 locks paper and tries to lock pen
    }
}
public class DeadLockdemo {
    public static void main(String[] args) {
      Pen pen = new Pen();
      Paper paper = new Paper();

      Thread t1 = new Thread(new Task1(pen, paper),"Thread-1");
      Thread t2 = new Thread(new Task2(pen, paper),"Thread-2");
     
      t1.start();
      t2.start();
    }
}
/*
   Thread-1 starts : aquire the lock on Pen and try to aquire lock on paper
   Thread-2 starts : aquire lock on paper and try to aquire on pen

   Deadlock occurs 
   Thread-1 holds Pen and waits for Paper
   Thread-2 holds Paper and waits for Pen
   naither can processed -> infinite waiting

Why this is a Deadlock (4 conditions)

   1.Mutual exclusion – only one thread can hold a lock
   2.Hold and wait – thread holds one lock and waits for another
   3.No preemption – locks can’t be forcibly taken
   4.Circular wait – Thread-1 → Thread-2 → Thread-1

*/