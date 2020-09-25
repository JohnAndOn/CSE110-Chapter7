import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Backwards {

    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName;

        if (args.length == 0) {
            Scanner console = new Scanner(System.in);
            System.out.print("Input file : ");
            inputFileName = console.next();
            console.close();
        } else {
            inputFileName = args[0];
        }

        File inputFile = new File(inputFileName);
        Scanner inputReader = new Scanner(inputFile);

        ArrayList<String> lines = new ArrayList<String>();

        while (inputReader.hasNextLine()) {
            Scanner lineReader = new Scanner(inputReader.nextLine());
            lineReader.useDelimiter("");

            String backwards = "";
            while (lineReader.hasNext()) {
                backwards = lineReader.next() + backwards;
            }
            lines.add(backwards);

            lineReader.close();
        }

        inputReader.close();

        PrintWriter outputWriter = new PrintWriter(inputFile);

        for (String line : lines) {
            outputWriter.println(line);
        }

        outputWriter.close();
    }

}
