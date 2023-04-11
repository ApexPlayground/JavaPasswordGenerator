import java.util.Random;
import java.util.Scanner;

public class generatingPassword {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int reply;
        do {
            System.out.println("Enter the length for for password");
            int length = scan.nextInt();
            System.out.println(passwordGenerator(length));
            System.out.println("to generate new password press 1");
            reply = scan.nextInt();

        } while (reply == 1);
    }

    public static String passwordGenerator(int length) {
        String numbers = "1234567890";
        // Lower case characters
        String lower = "abcdefghijklmnopqrstuvwzyx";
        // Uppercase characters5
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // regex for speacial characters
        String special = "[!@#$%^&*(),.?\":{}|<>]";
        // combining all characters in pool variable
        String pool = lower + upper + special + numbers;

        // converting String pool to char values
        char[] values = pool.toCharArray();

        // looping throught values to randomize it
        for (int i = values.length - 1; i > 0; i--) {
            int randSwap = new Random().nextInt(i + 1);
            char randValue = values[i];
            values[i] = values[randSwap];
            values[randSwap] = randValue;
        }

        // Creating password of desired length
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = new Random().nextInt(values.length);
            password.append(values[index]);
        }

        return password.toString();
    }
}
