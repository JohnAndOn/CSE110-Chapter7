import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * This program reads a file containing two columns of floating point numbers,
 * then prints the average of each column
 */
public class AverageColumns {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);

        System.out.print("Input file : ");
        String inputFileName = console.next();
        File inputFile = new File(inputFileName);
        Scanner inputReader = new Scanner(inputFile);

        console.close();

        double total_1 = 0;
        double total_2 = 0;
        int i = 0;

        while (inputReader.hasNextLine()) {
            String line = inputReader.nextLine();
            Scanner lineReader = new Scanner(line);
            total_1 += lineReader.nextDouble();
            total_2 += lineReader.nextDouble();
            i++;
        }

        System.out.printf("The average for column %d is %.2f%n", 1, total_1 / i);
        System.out.printf("The average for column %d is %.2f%n", 2, total_2 / i);
    }

}
