package Multithreading;
/**
 * t.start() : create new thread , JVM call internally 
 *            o/p -> Thread-0
 * t.run() : No new thread created , treated like a normal method call
 *            run on main method  o/p --> main
 * 
 *  
 */
public class DemoThread extends Thread{
    public void run(){
        System.out.println("Running Thread Name : "+Thread.currentThread().getName());
    }
    
    public static void main(String[] args) {
        DemoThread t = new DemoThread();
      
        //Case : 1 Calling start()
        t.start();  
        // t.start();  : IllegalThreadStateException : It is thrown when start() is called twice. 

        //Case : 2 Calling run() directly
        t.run();

        // output : order vary due to scheduling
        // Running Thread Name : main
        // Running Thread Name : Thread-0  
        
    }
}
