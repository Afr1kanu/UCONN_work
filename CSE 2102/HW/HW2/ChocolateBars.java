import java.util.Scanner;
public class ChocolateBars {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the weight in pounds: ");
        int weight = sc.nextInt();

        System.out.print("Enter the height in inches: ");
        int height = sc.nextInt();

        System.out.print("Enter the age in years: ");
        int age = sc.nextInt();

        double BMRW = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
        double BMRM = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);

        int bars_women = (int)Math.floor(BMRW / 230);
        int bars_men = (int)Math.floor(BMRM / 230);

        System.out.println("");
        System.out.println("Number of chocolate bars for woman is " + bars_women);
        System.out.println("Number of chocolate bars for man is " + bars_men);



    }
}
