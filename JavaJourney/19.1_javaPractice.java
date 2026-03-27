
/*
     write a java program to accept 'N' Integer from a user store them into LinkedList collection.
     and display only negative integers
*/
import java.util.Scanner;
import java.util.LinkedList;

class NegativeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements(N) :");
        int n = sc.nextInt();

        // create LinkedList
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("Enter " + n + " integers :");

        // store elements
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Display only negative numbers
        System.out.println("Negative Integers:");
        for (int num : list) {
            if (num < 0) {
                System.out.println(num);
            }
        }
        sc.close();
    }
}
