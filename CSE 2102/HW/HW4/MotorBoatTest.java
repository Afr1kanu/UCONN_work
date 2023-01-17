import java.util.Scanner;

public class MotorBoatTest{
    public static void main(String[] args) {
    	MotorBoat boat;

		Scanner main_scanner = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the capacity of the fuel tank: ");
		Double max_fuel = main_scanner.nextDouble();
		while (max_fuel > 250 || max_fuel < 0){ //Ensures fuel can't be negative or above 250 G
			max_fuel = main_scanner.nextDouble();
		}

		System.out.print("Enter the amount of fuel in the tank: ");
		Double current_fuel = main_scanner.nextDouble();
		while(current_fuel < 0 || current_fuel > max_fuel){ //Amount of fuel is lower than the capacity of the tank.
			current_fuel = main_scanner.nextDouble();
		}

		System.out.print("Enter the maximum speed: ");
		Double max_speed = main_scanner.nextDouble();
		while(max_speed < 0 || max_speed > 50){ //Maximum speed of the motorboat should be no more than 50 knots.
			max_speed = main_scanner.nextDouble();
		}


		System.out.print("Enter the current speed: ");
		Double current_speed = main_scanner.nextDouble();
		while(current_speed < 0 || current_speed > max_speed){ //Current speed of the motorboat is lower than the maximum speed. 
			current_speed = main_scanner.nextDouble();
		}


		System.out.print("Enter the efficiency (Percentage): ");
		Double efficiency = main_scanner.nextDouble();
		while(efficiency < 0 || efficiency > 100){ //Efficiency, expressed as a percentage should be less than or equal to 100.
			efficiency = main_scanner.nextDouble();
		}


		System.out.print("Enter the distance traveled so far: ");
		Double distance = main_scanner.nextDouble();
		while(distance < 0){ //Ensures user cannot enter a negative distance.
			distance = main_scanner.nextDouble();
		}


		boat = new MotorBoat(max_fuel, current_fuel, max_speed, current_speed, efficiency, distance); //Create boat with constructer

		System.out.println("\nFuel Amount: " + boat.fuel());

		System.out.print("Would you like to add more fuel? (y/n): ");
		if (sc.nextLine().equals("y")) { //If the user enters y, prompt the user to enter the amount of fuel to add to the tank.
			System.out.print("How much fuel would you like to add: ");
			Double fuel_to_add = main_scanner.nextDouble();
			boat.addFuel(fuel_to_add); //Total amount of fuel, after refueling is lower than the capacity of the tank. This is checked in boat.addFuel method, limits added fuel to maxFuel amount.
		}

		System.out.println("Fuel Amount:" + boat.fuel());

		System.out.print("How long would you like to operate the boat: ");
		Double time = main_scanner.nextDouble();
		while(time < 0 || time > 8){ //Time is less than or equal to 8 hours.
			time = main_scanner.nextDouble();
		}
		
		boat.operateBoat(time);

		System.out.println("Fuel Amount: " + boat.fuel());
		System.out.println("Updated Distance: " + boat.distance());
    	    
    }
}