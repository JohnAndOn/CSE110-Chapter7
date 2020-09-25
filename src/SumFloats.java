import java.util.Scanner;

public class SumFloats {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int tries = 0;
        double sum = 0;

        do {
            System.out.print("Enter a number : ");
            try {
                sum += console.nextDouble();
                tries = 0;
            } catch (Exception exception) {
                System.out.printf("Input incorrect. (%d) tries remaining%n", 1 - tries);
                console.next();
                tries++;
            }
        } while (tries < 2);

        System.out.printf("The sum is : %f%n", sum);

        console.close();
    } // end of main

} // end of class
