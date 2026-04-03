/*
   Write a Java Program to create LinkedList of integer objects and perform the following :
    1. Add element at first position
    2. Delete last element
    3. Display the size of link list
*/

import java.util.LinkedList;

class LinkedListDemo{
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        //Add element 
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println("\n-------------------------------------------");
        System.out.println("Original List : "+list);

        //Add element at first position
        list.addFirst(5);
        list.addFirst(99);
        System.out.println("\n-------------------------------------------");
        System.out.println("After Adding element at First Position :"+list);

        list.removeLast();
        System.out.println("\n-------------------------------------------");
        System.out.println("After Deleting Last Element : "+list);

        System.out.println("\n-------------------------------------------");
        System.out.println("Size of Linked List : "+list.size());
    }
}