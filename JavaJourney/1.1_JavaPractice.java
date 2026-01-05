package JavaJourney;
/**
 * Write a Java Program to display all the alphabets between 'A' to 'Z' after every 2 seconds.
 */

class Main {
    public static void main(String[] args) {
        for(char ch='A';ch<='Z';ch++){
            System.out.println("Charecter : "+ch);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
               System.out.println("Thread interrupted"+e);
            }
        }
    }
}
