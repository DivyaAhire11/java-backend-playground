import java.util.*; //Scanner , Thread

class VowelDisplay {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = sc.nextLine();
        System.out.println("Vowels (every 3 seconds) : ");
        
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));

            // check vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                try {
                    Thread.sleep(3000); // 3 seconds delay
                } catch (Exception e) {
                    System.out.println(e);
                }

                System.out.println(ch);
            }
        }
        sc.close();
    }
}
