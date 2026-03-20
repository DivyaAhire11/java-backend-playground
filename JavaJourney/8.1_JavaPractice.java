// package JavaJourney;

/*
  write a java program to define a thread for printing text on output screen for 'n' number of times. Create 3 threads and run them. Pass the text 'n' parameters to the thread constructor.
   Example : 
        1.First thread prints "COVID19" 10 times.
        2. Second thread prints "LOCKDOWN2020" 20 times.
        3. Third thread prints "VACCINSTION2021" 30 times
*/
// because threads run concurrently, the output will bw interleaved 

class PrintTextThread extends Thread{
   String text;
   int n;

   //constructor to accept text and number of times
    PrintTextThread(String nm,int n){
       this.text = nm;
       this.n = n;
    }
    //Thread Execution
    public void run(){
       for(int i=1;i<= n;i++){
        System.out.println(text + " : "+i);
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }
       }
    }

}

class MultiThreadPrint {
    public static void main(String[] args) {
       //create three threads with different text and count
      PrintTextThread t1 = new PrintTextThread("COVID 19", 10);
      PrintTextThread t2 = new PrintTextThread("LOCKDOWN 2020", 20);
      PrintTextThread t3 = new PrintTextThread("VACCINSTION 2021", 30);

      //start all thread
      t1.start();
      t2.start();
      t3.start();

    }
}
