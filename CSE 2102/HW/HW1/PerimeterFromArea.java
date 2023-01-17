public class PerimeterFromArea{
    public static void main(String[] args) {
        double area = Double.parseDouble(args[0]);
        double perimeter = Math.sqrt(area) * 4;
        System.out.printf("The perimeter is: %.2f",perimeter);
    }
}
