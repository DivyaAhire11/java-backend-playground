//write a java program to accept 'N' integers from a user. Store and display integers in sorted order having proper collection class. Thre collection shuld not accept duplicate elements

//TreeSet : sorted + no duplicates
import java.util.*; //Scanner ,TreeSet

class SortedInteger{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Elements (N) : ");
        int n = sc.nextInt();

        //TreeSet -> sorted + no duplicates
        TreeSet<Integer> num = new TreeSet<>();
        System.out.println("Enter "+ n + " integers:");
        for(int i=0;i<n;i++){
            num.add(sc.nextInt());  //duplicated automatically ignored
        }

        //Display sorted elements
        System.out.println("Sorted (No Duplicates) : ");
        for(int nn : num)
            System.out.println(nn);
    
    sc.close();
   }
}
