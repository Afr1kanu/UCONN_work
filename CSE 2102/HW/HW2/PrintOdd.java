import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class PrintOdd {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the input file: ");
        String inputFile = sc.nextLine();
        System.out.print("Enter the name of the output file: ");
        String outputFile = sc.nextLine();

        Scanner inputStream = null;
        PrintWriter outputStream = null;

        try
        {
            inputStream = new Scanner(new File(inputFile));
            outputStream = new PrintWriter(outputFile);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file " + inputFile);
            System.exit(0);
        }
        while (inputStream.hasNextLine())
        {
            String line = inputStream.nextLine();
            String [] arr = line.split(" ", 2);
            line = arr[1];
            outputStream.println(line);
        }
        outputStream.close();


    }
}
