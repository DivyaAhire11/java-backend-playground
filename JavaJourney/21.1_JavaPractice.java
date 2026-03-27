//write a java program to accept 'N' Subject Names from a user store them into LinkedList Collection
// and Display them by using Iterator interface

//Iterator methods:
    //hasNext() -> checks next element
    //next() -> return element

import java.util.*;

class SubjectList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Subjects(N): ");
        int n = sc.nextInt();
        sc.nextLine(); //clear buffer

        LinkedList<String> ll = new LinkedList<>();
        System.out.print("Enter Subject name : ");
        for(int i=0;i<n;i++){
            ll.add(sc.next());
        }
 
       System.out.println("\n------------------------------------------\n");

        System.out.println("Sujects List :");
        Iterator<String> it = ll.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        sc.close();
    }
}