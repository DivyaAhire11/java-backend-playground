package JavaJourney;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

class MainTest {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n1 : Add element at the end of the list");
            System.out.println("2 : Delete first element of the list");
            System.out.println("3 : Display the content of the list in reverse order");
            System.out.println("4 : Exit");
            System.out.print("Enter Your Choice : ");

            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter String : ");
                    list.add(sc.next());
                    System.out.println("List : " + list);
                    break;

                case 2:
                    if (!list.isEmpty()) {
                        list.removeFirst();
                        System.out.println("After deleting first element : " + list);
                    } else {
                        System.out.println("List is empty. Cannot delete.");
                    }
                    break;

                case 3:
                    if (!list.isEmpty()) {
                        System.out.println("List in Reverse Order :");
                        ListIterator<String> itr = list.listIterator(list.size());
                        while (itr.hasPrevious()) {
                            System.out.println(itr.previous());
                        }
                    } else {
                        System.out.println("List is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Exited Program");
                    sc.close();
                    break;

                default:
                    System.out.println("Enter Valid Choice");
            }

        } while (ch != 4);
    }
}
