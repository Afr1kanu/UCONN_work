public class DispenseChange{
    public static void main(String[] args){
        int initial = Integer.parseInt(args[0]);
        int quarters, dimes, nickels, pennies, amount;
        amount = initial;
        quarters = amount / 25;
        amount = amount % 25;
        dimes = amount / 10;
        amount = amount % 10;
        nickels = amount / 5;
        amount = amount % 5;
        pennies = amount;
        System.out.printf("%d cents in coins can be given as:\n", initial);
        System.out.printf("%d quarters\n", quarters);
        System.out.printf("%d dimes\n", dimes);
        System.out.printf("%d nickels and\n", nickels);
        System.out.printf("%d pennies\n", pennies);
    }
}