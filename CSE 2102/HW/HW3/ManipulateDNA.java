import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class ManipulateDNA {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //gets input file and catches error if the file does not exist
        System.out.print("Enter the name of the input file: ");
        String inputFile = sc.nextLine();
        Scanner inputStream = null;
        try
        {
            inputStream = new Scanner(new File(inputFile));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file " + inputFile);
            System.exit(0);
        }

        //while loop reads through each DNA sequence line by line in the file
        int lineCount = 1;
        while (inputStream.hasNextLine())
        {
            //displays line number and the DNA dequence
            System.out.println("Sequence number: " + lineCount);
            String DNA = inputStream.nextLine();
            System.out.println("Input sequence: " + DNA);

            //finds reverse of original sequence
            String reverse = "";
            for (int i=0; i<DNA.length(); i++){
                reverse = DNA.charAt(i)+reverse;
            }
            System.out.println("Reverse sequence: " + reverse);

            //switches all As and Ts, using x as a placeholder
            String complement = DNA.replace('T', 'x');
            complement = complement.replace('A','T');
            complement = complement.replace('x','A');

            //switches all Gs and Cs, using y as a placeholder
            complement = complement.replace('G', 'y');
            complement = complement.replace('C','G');
            complement = complement.replace('y', 'C');
            System.out.println("Complement: " + complement);

            //finds the reverse of the complement
            String reverseComp = "";
            for (int i =0; i<complement.length(); i++){
                reverseComp = complement.charAt(i)+reverseComp;
            }
            System.out.println("Reverse complement: " + reverseComp + "\n");

            lineCount++; //adds one to the line count and while loop ends if last line was read
        }
    }
}
