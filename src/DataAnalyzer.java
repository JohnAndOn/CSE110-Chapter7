import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class DataAnalyzer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Keep trying until there are no more exceptions

        boolean done = false;
        while (!done) {
            try {
                System.out.print("Please enter the file name : ");
                String filename = in.next();

                double[] data = readFile(filename);

                // As an example for processing the data, we compute the sum

                double sum = 0;
                for (double d : data) {
                    sum += d;
                }
                System.out.printf("The sum is %.2f%n", sum);

                done = true;
            } catch (FileNotFoundException exception) {
                System.out.println("File not found.");
            } catch (NoSuchElementException exception) {
                System.out.println("File contents invalid.");
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } // End of program loop

        in.close();
    } // End of main

    /**
     * Opens a file and reads a data set.
     * 
     * @param filename the name of the file holding the data
     * @return the data in the file
     * @throws IOException
     */
    public static double[] readFile(String filename) throws IOException {
        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);
        try {
            return readData(in);
        } finally {
            in.close();
        }
    } // End of readFile

    /**
     * Reads a data set.
     * 
     * @param in the scanner that scans the data
     * @return the data set
     * @throws IOException
     */
    public static double[] readData(Scanner in) throws IOException {
        int numberOfValues = in.nextInt(); // May throw NoSuchElementException
        double[] data = new double[numberOfValues];

        for (int i = 0; i < numberOfValues; i++) {
            data[i] = in.nextDouble(); // May throw NoSuchElementException
        }

        if (in.hasNext()) {
            throw new IOException("End of file expected");
        }

        return data;
    }

} // End of class
