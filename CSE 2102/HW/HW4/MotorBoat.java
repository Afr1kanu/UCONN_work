import java.lang.Math;

public class MotorBoat {
	private double maxFuel; 
	private double fuel; 		
	private double maxSpeed; 	
	private double speed; 		
	private double efficiency;
	private double distance; 

//	Constructor that sets everything to some default values.
    public MotorBoat() {
        this.maxFuel = 250; 	//	The capacity of the fuel tank (G)
	    this.fuel = 30; 		//	The amount of fuel in the tank (G)
	    this.maxSpeed = 50; 	//	The maximum speed of the boat (Knots)
	    this.speed = 0; 		//	The current speed of the boat (Knots)
	    this.efficiency = 0.015; //	The efficiency of the boat’s motor (Must be less or equal to 100)
	    this.distance = 0; 	//	The distance traveled (km)

    }
//	Constructor that sets the capacity, fuel in the tank, max speed and efficiency
	public MotorBoat(double maxFuel, double fuel, double maxSpeed, double speed, double efficiency, double distance){
		this.maxFuel = maxFuel;
		this.fuel = fuel;
		this.maxSpeed = maxSpeed;
		this.speed = speed;
		this.efficiency = efficiency / 100; //Converts efficiency to a decimal
		this.distance = distance;
	}

	//Set the current speed of the boat
	public void setSpeed(double speed){
		if (speed > maxSpeed){
			this.speed = maxSpeed; //If the speed is greater than the max speed, set the speed to the max speed
		}
		else{
			this.speed = speed;
		}
	}

	//Operate the boat for an amount of time at the current speed (set the distance traveled and reduce the amount of fuel in the tank by the appropriate amount).
	public void operateBoat(double time){
		if (fuelUsed(time) == 0){ 
			return;
		}
		else{
			System.out.println("\nOperating the motorboat\n");
			fuel = fuel - fuelUsed(time);
			distance += speed*time;	
		}
	}

	//Calculate (e * s^2 * t) and return the amount of fuel used. if fuel used is more than fuel, it can not operate.
	private double fuelUsed(double time){
		double fuel_used = efficiency * (speed * speed) * time;
		if (fuel_used >= fuel){ //If the fuel used is greater than the fuel in the tank, the boat can not operate
			System.out.println("Not enough fuel, cannot operate boat.");
			fuel_used = 0;
			return fuel_used;
		}
		else{
			return fuel_used;
		}	
	}	

	//Refuel the boat with some amount of fuel (if the total amount of fuel is greater than the capacity, set it to the capacity).
	public void addFuel(double fuel){
		if (this.fuel + fuel >= maxFuel && fuel > 0){
			this.fuel = maxFuel; //Limits Fuel to max fuel
		}else if(fuel < 0){
			System.out.println("error: Why add negative fuel?");
		}else
			this.fuel += fuel;
	}
	
	//Return the amount of fuel in the tank
	public double fuel(){
		return fuel;
	}
	
	//Return the distance traveled so far
	public double distance(){
		return distance;
	}
    
}