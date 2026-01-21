package JavaJourney;

import java.util.*;

/*
    write a java program to store city names and their STD codes using an appropriate collection and perform operation:
    1. Add a new city and its code(No duplicates)
    2.Remove a city from the collection
    3.Search for a city name and display the code
*/
class CitySTD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // HashMap to store City name and STD code
        // No duplicate keys(city names) are allowed

        HashMap<String, String> citySTD = new HashMap<>();
        int choice;
        do {
            System.out.println("\n------------ CITY and STD Code Menu -----------\n");
            System.out.println("1. Add new city and STD code");
            System.out.println("2. Remove a city");
            System.out.println("3. Search city and display STD code");
            System.out.println("4. Display all cities");
            System.out.println("5. Exit");

            System.out.println("Enter your choice : ");
            choice = sc.nextInt();
            sc.nextLine(); // clear the buffer

            switch (choice) {
                case 1:
                    System.out.println("Enter City Name : ");
                    String city = sc.nextLine();
                    if (citySTD.containsKey(city)) {
                        System.out.println("City already exitsts! No duplicates allowed.");
                    } else {
                        System.out.println("Enter STD code : ");
                        String code = sc.nextLine();
                        citySTD.put(city, code);
                        System.out.println("City and Code added successfully!!");
                    }

                    break;
                case 2:
                    System.out.println("Enter city Name to Remove :");
                    String removeCity = sc.nextLine();
                    if (citySTD.remove(removeCity) != null) {
                        System.out.println("Remove city Successfully!!");
                    } else {
                        System.out.println("City Not Found!");
                    }
                    break;
                case 3:
                    System.out.println("Enter city Name to Search :");
                    String searchCity = sc.nextLine();

                    if (citySTD.containsKey(searchCity)) {
                        System.out.println("STD Code of " + searchCity + " is :" + citySTD.get(searchCity));
                    } else {
                        System.out.println("City Not Found");
                    }
                    break;
                case 4:
                    System.out.println("City \t\t STD Code");
                    System.out.println("-----------------------------");
                    for (Map.Entry<String, String> entry : citySTD.entrySet()) {
                        System.out.println(entry.getKey() + "\t\t" + entry.getValue());
                    }

                    break;
                case 5:
                    System.out.println("Exiting program.....");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}
