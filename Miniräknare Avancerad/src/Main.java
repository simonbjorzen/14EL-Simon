
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        boolean run = true;
        char ans;

        System.out.println("Welcome to the calculator of doom");
        while (run == true) {
            System.out.print("Enter the calculation: ");
            String input = reader.next();
            String numbers[] = input.split("[+-/*]");
            double[] num;
            num = new double[2];
            num[0] = Integer.parseInt(numbers[0]);
            num[1] = Integer.parseInt(numbers[1]);

            double sum = 0;

            if (input.contains("+")) {
                sum = num[0] + num[1];
            }
            if (input.contains("-")) {
                sum = num[0] - num[1];
            }
            if (input.contains("*")) {
                sum = num[0] * num[1];
            }
            if (input.contains("/")) {
                sum = num[0] / num[1];
            }
            System.out.println(sum);
            System.out.println("Do you want to run the calculator again? (Y/N)");
            ans = reader.next().charAt(0);
            if (ans != 'y')
                run = false;


        }
    }
}           