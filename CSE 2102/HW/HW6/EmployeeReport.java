import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EmployeeReport{
    //make compute_statistics method but using arraylist

    
    static void compute_statistics(ArrayList<Employee> employees, float[] results){ //compute the statistics
        float sum = 0;
        float max = 0;
        for(int i = 0; i < employees.size(); i++){
            sum += employees.get(i).getSalary(); //get the salary of the employee and add it to the sum
            if(employees.get(i).getSalary() > max){ //if the salary is greater than the max
                max = employees.get(i).getSalary(); //set the max to the salary
            }
        }
        results[0] = sum / employees.size(); //set the average to the sum divided by the number of employees
        results[1] = max; //set the max to the max
        System.out.println("Average salary per employee is $" + results[0]);
        System.out.println("The highest salary is $" + results[1]);
        System.out.println("");
    }

    static void read_data_from_txt(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the file: "); //prompt the user to enter the name of the file
        String filename = input.nextLine();
        input.close();


        ArrayList<Employee> employees = new ArrayList<Employee>(); //make an arraylist of employees

        try{ //try to read the file
            File file = new File(filename); 
            Scanner file_input = new Scanner(file);
            while(file_input.hasNextLine()){
                String line = file_input.nextLine();
                line = line.trim();
                String[] tokens = line.split(","); //split the line into tokens
                String name = tokens[0];
                String id = tokens[1];
                float salary = Float.parseFloat(tokens[2]);
                int year_of_hire = Integer.parseInt(tokens[3]);
                employees.add(new Employee(name, id, salary, year_of_hire)); //add the employee to the arraylist
            }
            file_input.close();
        }catch(FileNotFoundException e){ //if the file is not found
            System.out.println("File not found");
        }

        float[] results = new float[2]; //create an array to store the results
        compute_statistics(employees, results);

        System.out.println("The following had the highest salary:");
        //use arrayList to print the employees with the highest salary
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).getSalary() == results[1]){
                employees.get(i).writeOutput();
                System.out.println("The salary is $" + (employees.get(i).getSalary() - results[0]) + " above the average.\n");
                employees.remove(i); //remove the employee from the arraylist
            }
        }

        System.out.println("\nThe rest performed as follows:");
        for(int i = 0; i < employees.size(); i++){ //print the rest of the employees
            employees.get(i).writeOutput(); //print the employee
            if(employees.get(i).getSalary() > results[0]){
                System.out.println("The salary is $" + (employees.get(i).getSalary() - results[0]) + " above the average.\n"); //print the salary above the average
            }
            else if(employees.get(i).getSalary() < results[0]){
                System.out.println("The salary is $" + (results[0] - employees.get(i).getSalary()) + " below the average.\n"); //print the salary below the average
            }
            else{
                System.out.println("The salary is average.\n"); //print that the salary is average
            }
        }
    }

    public static void main(String[] args){
        read_data_from_txt();
    } 
}
