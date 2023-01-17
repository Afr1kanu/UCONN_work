import java.util.Scanner;
public class ChocolateBars {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Scanner sx = new Scanner(System.in); //needed another scanner to read man or woman -- kept on reading the input before
        Scanner sz = new Scanner(System.in); //needed another scanner to read activity -- kept on reading the input before

        System.out.print("Enter the weight in pounds: ");
        int weight = sc.nextInt(); //gets weight

        System.out.print("Enter the height in inches: ");
        int height = sc.nextInt(); //gets height

        System.out.print("Enter the age in years: ");
        int age = sc.nextInt(); //gets age

        //gets gender and makes sure it is M or W before moving on
        System.out.print("Enter M for man, W for woman: ");
        String gender = sx.nextLine();
        while (!gender.equals("M") && !gender.equals("W")){
            System.out.println("Error, please enter M or W");
            System.out.print("Enter M for man, W for woman: ");
            gender = sx.nextLine();
        }

        //gets activeness and makes sure it is S O A or H before moving on
        System.out.print("How active are you? Enter S for Sedentary, O for Occasionally, A for Active, H for Highly Active: ");
        String active = sz.nextLine();
        while (!active.equals("S") && !active.equals("O") && !active.equals("A") && !active.equals("H")){
            System.out.println("Error, please enter S, O, A, or H");
            System.out.print("Enter S for Sedentary, O for Occasionally, A for Active, H for Highly Active: ");
            active = sz.nextLine();
        }

        //determines what factor to increase the BMR by
        double increase;
        if (active.equals("S")){
            increase = 1.2;
        } else if (active.equals("O")){
            increase = 1.3;
        } else if (active.equals("A")){
            increase = 1.4;
        } else{
            increase = 1.5;
        }

        //calculates BMR depending on male or female and increases it accordingly
        double BMR;
        if (gender.equals("M")){
            BMR = (66 + (6.3 * weight) + (12.9 * height) - (6.8* age)) * increase;
        } else{
            BMR = ((655 + (4.3 * weight) + 4.7 * height) - (4.7 * age)) * increase;
        }

        //formats the BMR to two decimal places
        String BMRS = String.format("%.2f",BMR);

        //prints results and finds chocolate bars
        System.out.println("BMR adjusted for gender and lifestyle: " + BMRS);
        int bars = (int)Math.floor(BMR/230);

        System.out.println("Number of chocolate bars: " + bars);

    }
}
