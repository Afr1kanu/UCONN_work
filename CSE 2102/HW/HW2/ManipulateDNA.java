import java.util.Scanner;
public class ManipulateDNA {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter DNA sequence:");
        String DNA = sc.nextLine(), reverse = "";

        int DNALength = DNA.length();
        System.out.println("Length of DNA sequence: " + DNALength);

        for (int i=0; i<DNA.length(); i++){
            reverse = DNA.charAt(i)+reverse;
        }
        System.out.println("Reverse sequence is: " + reverse);

    }
}
