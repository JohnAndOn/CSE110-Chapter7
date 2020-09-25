import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Reverse {

    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName;
        if (args.length == 0) {
            Scanner console = new Scanner(System.in);
            System.out.print("Input File : ");
            inputFileName = console.next();
            console.close();
        } else {
            inputFileName = args[0];
        }

        File inputFile = new File(inputFileName);
        Scanner inputReader = new Scanner(inputFile);

        ArrayList<String> lines = new ArrayList<String>();

        while (inputReader.hasNextLine()) {
            String line = inputReader.nextLine();
            lines.add(line);
        }

        inputReader.close();

        PrintWriter outputWriter = new PrintWriter(inputFile);

        for (int i = lines.size() - 1; i >= 0; i--) {
            outputWriter.println(lines.get(i));
        }

        outputWriter.close();
    }

}
