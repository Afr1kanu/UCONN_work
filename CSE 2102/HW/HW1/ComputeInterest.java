public class ComputeInterest{
    public static void main(String[] args){
        double principle = Double.parseDouble(args[0]);
        final double interest = Double.parseDouble(args[1]) / 100;
        double duration = Double.parseDouble(args[2]);
        double simple = principle * (1 + interest * duration);
        double compound = principle * Math.pow((1 + (interest / 1)), (duration));
        double difference = Math.abs(simple - compound);
        System.out.printf("The amount with simple interest is: %.2f\n", simple);
        System.out.printf("The amount with compound interest is: %.2f\n", compound);
        System.out.printf("The difference is: %.2f\n", difference);
    }
}