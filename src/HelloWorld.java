import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program writes "Hello, World!" to a file then reads the file to print
 * the string to console
 */
public class HelloWorld {

    public static void main(String[] args) throws FileNotFoundException {
        // String fileName = "hello.txt";
        File helloWorld = new File("hello.txt");

        PrintWriter helloPrinter = new PrintWriter(helloWorld);
        helloPrinter.println("Hello, World!");
        helloPrinter.close();

        Scanner helloReader = new Scanner(helloWorld);
        String message = helloReader.nextLine();
        helloReader.close();

        System.out.println(message);

    }

}
