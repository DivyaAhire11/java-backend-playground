package JavaJourney;

import java.util.TreeSet;
import java.util.Scanner;
/*
    write a java program to accept 'n' integers from the user and store them in a collection.
    Display them in the sorted order. The collection should not accept duplicate elements.
    (Use a suitable collection). Search for a particular element using predefined search method in the Collection framework.
*/
//TreeSet : does not allow duplicates ele
// automatically stores ele in sorted order
//provide search method : contains(Object o)

class SortedCollectionSearch{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //TreeSet : does not allow duplicates and stores elements in sorted order

       TreeSet<Integer> ts = new TreeSet<>();
        
        System.out.print("Enter How Many Numbers U Wnats to Enter? : ");
        int n = sc.nextInt();
         System.out.println("Enter "+n+" Elements in Collection : ");
        for(int i =0;i<n;i++){
            ts.add(sc.nextInt()); //duplicate are automatically ignored
        }

        System.out.println("\n----------- Elements in SORTED ORDER --------------"); 
         for(Integer sortedData : ts){
            System.out.println(sortedData + "\t");
        }

        //search for an element using predefined method
        System.out.print("\n Enter element to be searched? :");
        int key = sc.nextInt();

        if(ts.contains(key)){
            System.out.println("Element "+key+" is found in the Collection.");
        }else{
            System.out.println("Element "+key+" is NOT found in the Collection.");
        }
        sc.close();
    }
}
