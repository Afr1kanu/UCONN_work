import java.util.Scanner;
 
public class EmployeeTest{
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); //create a scanner object
       System.out.println("Employee 1"); //ask for the first employee's information
       System.out.print("Please Enter Employee 1 Name: ");
       String e1Name = sc.nextLine();
       System.out.print("Please Enter Employee 1 ID: ");
       String e1ID = sc.nextLine();
       System.out.print("Please Enter Employee 1 Salary: ");
       Float e1Salary = sc.nextFloat();
       System.out.print("Please Enter Employee 1 year hired: ");
       int e1Hired = sc.nextInt();
       sc.nextLine();
 
 
       Employee E1 = new Employee(e1Name, e1ID, e1Salary, e1Hired); //create an employee object for the first employee
       System.out.println("");
       E1.writeOutput(); //print the information of the first employee
       sc = new Scanner(System.in);
       System.out.println("");
       System.out.print("Please Enter new name for Employee 1 Name: ");
       e1Name = sc.nextLine();
       E1.setName(e1Name);
       System.out.print("Please enter new name for Employee 1 salary: ");
       e1Salary = sc.nextFloat();
       sc.nextLine();
       E1.setSalary(e1Salary);
       System.out.println("");
       E1.writeOutput();
       System.out.println("");
 
 
       System.out.println("Employee 2"); //ask for the second employee's information
       System.out.print("Please Enter Employee Name: ");
       String e2Name = sc.nextLine();
       System.out.print("Please Enter Employee ID: ");
       String e2ID = sc.nextLine();
       System.out.print("Please Enter Employee Salary: ");
       Float e2Salary = sc.nextFloat();
       System.out.print("Please Enter Employee year hired: ");
       int e2Hired = sc.nextInt();
       sc.nextLine();
 
       Employee E2 = new Employee(e2Name, e2ID, e2Salary, e2Hired); //create an employee object for the second employee

       System.out.println("");
 
       System.out.println("Employee 1");
       E1.writeOutput();
       System.out.println("");
       System.out.println("Employee 2");
       E2.writeOutput();
       System.out.println("");
 
       if (E1.equals(E2)){
           System.out.println("The two Employees are the same.");
       }
       else{
           System.out.println("The two Employees are not the same.");
       }
 
   }
}
