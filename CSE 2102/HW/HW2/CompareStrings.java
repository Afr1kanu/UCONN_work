import java.util.Scanner;
import java.lang.*;
public class CompareStrings {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String first = sc.nextLine();

        System.out.print("Enter the second string: ");
        String second = sc.nextLine();

        if (first.equals(second)) {
            System.out.println("The two strings are equal");
        } else if (first.toLowerCase().equals(second.toLowerCase())) {
            System.out.println("The two strings are not equal");
            System.out.println("The two strings are equal, ignoring case");
        } else {
            System.out.println("The two strings are not equal");
            System.out.println("The two strings are not equal, even ignoring case");
        }
    }
}
