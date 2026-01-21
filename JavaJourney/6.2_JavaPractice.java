package JavaJourney;

class TrafficSignal extends Thread {
    String color;
    int time; // time in millisecond

    TrafficSignal(String color, int time) {
        this.color = color;
        this.time = time;
    }

    public void run(){
        try {
            while(true){
                System.out.println("Signal : " + color);
                Thread.sleep(time);
            }
        } catch (Exception e) {
              System.out.println(e);
        }
    }
}

class TrafficSignalSimulation {
    public static void main(String[] args) {
       //Create thread for each signal
      
       TrafficSignal red = new TrafficSignal("RED - STOP", 4000);
       TrafficSignal yellow = new TrafficSignal("YELLOW - READY", 2000);
       TrafficSignal green = new TrafficSignal("GREEN - GO", 3000);
       try {
        while (true) {
            System.out.println("\nTraffic Signal Simulation Started....\n");

            //Red Signal
            System.out.println("RED - STOP ");
            Thread.sleep(4000);

            //yellow signal
              System.out.println("YELLOW - STOP ");
            Thread.sleep(4000);

            //green signal
              System.out.println("GREEN - STOP ");
            Thread.sleep(4000);
        }
       } catch (Exception e) {
           System.out.println(e);
       }
    }
}
