package JavaJourney;

import java.util.TreeSet;
import java.util.HashSet;
import java.util.Scanner;
/*
    write a java program to accept 'n' integers from the user and store them in a collection.
    Display them in the sorted order. The collection should not accept duplicate elements.
    (Use a suitable collection). Search for a particular element using predefined search method in the Collection framework.
*/
class NumberCollection{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> hs = new HashSet<>();
        
        System.out.println("Enter How Many Numbers U Wnats to Enter? : ");
        int n = sc.nextInt();
         System.out.println("Enter "+n+" Elements in Collection : ");
        for(int i =0;i<n;i++){
            hs.add(sc.nextInt());
        }

        System.out.println("\n----------- BEFORE SORTING ------------");
        for(Integer data : hs){
            System.out.println(data + "\t");
        }

        System.out.println("\n----------- AFTER SORTING --------------");
        TreeSet<Integer> ts = new TreeSet<>(hs);
         for(Integer sortedData : ts){
            System.out.println(sortedData + "\t");
        }
        sc.close();
    }
}
