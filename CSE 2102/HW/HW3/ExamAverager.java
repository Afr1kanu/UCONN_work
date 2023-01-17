import java.util.*;
public class ExamAverager {
    public static void main(String[] args){
        System.out.println("This program computes tha average of a list of (nonnegative) exam scores.");
        Scanner sc = new Scanner(System.in);
        Scanner sx = new Scanner(System.in);

        //while loop repeats until there is not an exam to average
        String exam = "y";
        while (exam.toLowerCase().equals("y")){
            System.out.println("Enter all the scores to be averaged.\nEnter a negative number once you have entered all the scores.");
            double score=0;
            List<Double> scores = new ArrayList<Double>(); //creates an empty list to add the scores to
            while (score>=0){ //while loop takes scores until a negative number is entered
                score = sc.nextInt();
                if (score>=0){scores.add(score);} //the if statement is needed so the negative number doesn't get added to the list
                }
            double sum = 0;
            for (int i=0; i < scores.size(); i++){ //for loop adds each number in the list to the sum
                sum += scores.get(i);
            }
            double avg = sum / scores.size(); //computes the average
            System.out.println("The average is: " + avg);
            for (int i=0; i < scores.size(); i++){ //for loop goes through each score again and prints out if they are below/above/equal to average
                if (scores.get(i) < avg){
                    System.out.println("Score #"+(i+1)+": "+scores.get(i)+" -- Below Average");
                } else if (scores.get(i) > avg){
                    System.out.println("Score #"+(i+1)+": "+scores.get(i)+" -- Above Average");
                } else{
                    System.out.println("Score #"+(i+1)+": "+scores.get(i)+" -- Equal to Average");
                }
            }
            System.out.println("");
            System.out.print("Want to average another exam?\nEnter y or n: "); //asks user if they want to average another exam, if not then the while loop ends
            exam = sx.nextLine();

        }
    }
}
