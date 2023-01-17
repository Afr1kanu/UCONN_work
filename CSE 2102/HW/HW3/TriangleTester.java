import java.util.*;
public class TriangleTester {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first length: ");
        int s1 = sc.nextInt();
        System.out.print("Enter the second length: ");
        int s2 = sc.nextInt();
        System.out.print("Enter the third length: ");
        int s3 = sc.nextInt();

        if (s1+s2>=s3){
            System.out.println("These lengths can form a triangle");
            if (s3*s3 < (s1*s1 + s2*s2)){System.out.println("These lengths form an acute triangle");}
            else if (s3*s3 > (s1*s1 + s2*s2)){System.out.println("These lengths form an obtuse triangle");}
            else {System.out.println("These lengths form a right triangle");}
        } else{
            System.out.println("These lengths cannot form a triangle");
        }

    }
}
