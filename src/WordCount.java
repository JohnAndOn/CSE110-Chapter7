import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program analyzes a file and prints the number of characters, words, and
 * lines in the file.
 */
public class WordCount {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("Input File : ");
        String inputFileName = console.next();
        File inputFile = new File(inputFileName);
        Scanner inputReader = new Scanner(inputFile);

        console.close();

        int lines = 0;
        int words = 0;
        int chars = 0;
        boolean word = false;

        while (inputReader.hasNextLine()) {
            lines++;
            Scanner line = new Scanner(inputReader.nextLine());
            line.useDelimiter(""); // read line one character at a time
            while (line.hasNext()) {
                chars++;
                char currentChar = line.next().charAt(0);
                if (!word) {
                    if (!Character.isWhitespace(currentChar)) {
                        word = true;
                        words++;
                    }
                } else {
                    if (Character.isWhitespace(currentChar)) {
                        word = false;
                    }
                }
            }
            word = false;
        }

        inputReader.close();

        System.out.printf("%s contains :%n", inputFileName);
        System.out.printf("    %d %s%n", lines, "lines");
        System.out.printf("    %d %s%n", words, "words");
        System.out.printf("    %d %s%n", chars, "chars");
    }

}
