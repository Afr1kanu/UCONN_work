import java.lang.Math;
 
public class Employee extends Person{ //making a class Employee that inherits
    private String id;
    private float salary;
    private int year_of_hire;
 
    public Employee(String name, String id, float salary, int year_of_hire){ //constructor
        super(name);
        this.id = id;
        this.salary = salary;
        this.year_of_hire = year_of_hire;
    }
 
    public void setId(String id){ //set id
        this.id = id;
    }
 
    public void setSalary(float salary){ //set the salary
        this.salary = salary;
    }
 
    public void setYearOfHire(int year_of_hire){  //set the year of hire
        this.year_of_hire = year_of_hire;
    }
 
    public boolean equals(Employee otherEmployee){ //check if the two employees are the same
           return (this.id.equals(otherEmployee.id)) && ( this.hasSameName(otherEmployee)) && (this.salary == otherEmployee.salary) && (this.year_of_hire == otherEmployee.year_of_hire);
    }
 
    public void writeOutput(){ //write the output
        System.out.println("Name: " + getName());
        System.out.println("Employee ID: " + id);
        System.out.printf("Salary: %.1f\n", salary); //print the salary with 1 decimal places
        System.out.println("Year of Hire: " + year_of_hire);
    }
}
