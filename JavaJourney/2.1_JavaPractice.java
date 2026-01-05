package JavaJourney;
/*
   Write a java program to read 'N' names of your friends , store it into HashSet and display them in ascending order.
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("How Many Friends?? : ");
        n = sc.nextInt();

        HashSet<String> names = new HashSet<>();
        System.out.print("Enter Names of your Friends :");
        for (int i = 0; i < n; i++) {
            names.add(sc.next());
        }
        System.out.println("----- WITHOUT SORTING ------");
        System.out.println(names);

        // Convert HashSet to TreeSet for ascending order
        TreeSet<String> sortedName = new TreeSet<>(names);
        System.out.println("-----Friends names in ascending order ------");
        for (String nm : sortedName) {
            System.out.println(nm);
        }

        sc.close();
    }
}
