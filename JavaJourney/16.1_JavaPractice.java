// write a java program to creattes a TreeSet, add some colors(String) add print out the content of Threeset in ascending order

import java.util.TreeSet;

class TreeSetEx {
    public static void main(String[] args) {
        //create TreeSet : duplicate values not allowed
        TreeSet<String> colors = new TreeSet<>(); // TreeSet automatically stores data inascending (sorted) order
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Black");
        
        //Display elements (automatically sorted)
        System.out.println("Colors in Ascending Order : ");
        for(String color : colors){
            System.out.println(color);
        }

    }
}
