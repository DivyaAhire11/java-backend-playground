/*
     Write a Java Program to accept 'N' student names through command line ,
     store them into the appropriate Collection and display them by using Iterator and ListIterator interface.

 */

import java.util.*;  // ArrayList , Iterator, ListIterator

class ListDemo {

    public static void main(String[] args) {
        //create arraylist
        ArrayList<String> list = new ArrayList<>();
        if (args.length > 0) {
            //store command line arguments
            for (String name : args) {
                list.add(name);
            }

            System.out.println("\n-----------------Using Iterator-----------------------");
            //Display using Iterator

            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }

            System.out.println("\n------------------Using ListIterator(Forward) ----------------------");
            //Display using ListIterator(Forward)
            ListIterator<String> lit = list.listIterator();
            while (lit.hasNext()) {
                System.out.println(lit.next());
            }

            System.out.println("\n------------------Using ListIterator (Backward) ----------------------");
            //Display using ListIterator(backward)

            while (lit.hasPrevious()) {
                System.out.println(lit.previous());
            }
        } else {
            System.out.println("Plese Provide the Student Names in Command Line Arguments");
        }
    }
}
