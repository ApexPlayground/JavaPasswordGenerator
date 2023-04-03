import java.util.Random;
import java.util.Scanner;

public class generatingPassword {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int choice = 0;
        do{

            // Create a new instance of the Random class
            Random rand = new Random();

            // Define strings for each character set: uppercase letters, lowercase letters, special characters, and digits
            String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lower = "abcdefghijklmnopqrstuvwxyz";
            String special = "!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~";
            String numbers = "0123456789";

            // Combine the four character sets into a single string
            String unity = upper + lower + special + numbers;

            // Convert the unity string to a character array
            char[] chars = unity.toCharArray();

            // Shuffle the characters in the array using the Fisher-Yates algorithm
            for(int i = unity.length() - 1; i > 0;i--){
                int j = rand.nextInt(i + 1);
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }

            // Generate a random substring of length 10 from the shuffled characters
            String output = new String(chars).substring(0, 10);

            // Print the final output to the console
            System.out.println(output);


            System.out.println("Do you want to generate new random password \n 1.yes \n 2.no \n choose between 1 or 2 ");
            choice = scan.nextInt();
        }
        while (choice == 1);
    }
}
