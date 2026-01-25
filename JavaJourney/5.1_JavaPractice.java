package JavaJourney;

import java.util.Enumeration;
import java.util.Hashtable;

/* write a java program to create the hash table that will maintain the mobile number and student name. Display the details of student using Enumetation interface. */
class StudMobNo{
    public static void main(String[] args) {
        //create hashtable to store mobile number and student name
        Hashtable<String , String> ht = new Hashtable<>();
        //adding elements(mobile no --> Student name)
        ht.put("8932482363","Jiya");
        ht.put("2832846949","Sweta");
        ht.put("9340247839","Namrata");
        ht.put("5214303488","Bhavika");
        ht.put("2350347289","Mrunal");
        ht.put("6738552873","Gayatri");

        System.out.println("--------STUDENTS AND MOBILE NUMBER----------");
        //Enumeration to display keys(mobile no)
        Enumeration<String> info = ht.keys();

        //Using Enumeration to access Hashtable data
        
        while(info.hasMoreElements()){
            String mob = info.nextElement();
            String nm = ht.get(mob);
            System.out.println("\t"+nm+"  =  "+mob);
        }
    }
}
