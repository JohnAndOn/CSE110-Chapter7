import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * This program reads each line of a text file, then sends it to an output file
 * with line numbers
 */
public class LineNumbers {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);

        System.out.print("Input File  : ");
        String inputFileName = console.next();
        File inputFile = new File(inputFileName);
        Scanner inputReader = new Scanner(inputFile);

        System.out.print("Output File : ");
        String outputFileName = console.next();
        File outputFile = new File(outputFileName);
        PrintWriter outputWriter = new PrintWriter(outputFile);

        console.close();

        int i = 1;
        while (inputReader.hasNextLine()) {
            String line = inputReader.nextLine();
            outputWriter.printf("/* %d */ %s%n", i, line);
            i++;
        }

        inputReader.close();
        outputWriter.close();

    }

}
