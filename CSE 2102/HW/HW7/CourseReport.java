import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class CourseReport{
    static void printlist(){ //prints the list of options
        System.out.println("What Would you like to know?");
        System.out.println("1. Name of the course.");
        System.out.println("2. Number of the course.");
        System.out.println("3. How many employees?");
        System.out.println("4. Who are the instructors?");
        System.out.println("5. Who are the teaching assistants?");
        System.out.println("6. How many instructors?");
        System.out.println("7. How many teaching assistants?");
        System.out.println("8. How many students?");
        System.out.println("9. How many graduate students?");
        System.out.println("10. How many undergraduate students?");
        System.out.println("11. How many freshman/sophomore/juniors/seniors?");
        System.out.println("12. How many masters/doctoral students?");
        System.out.println("13. Find a specific student, either based on the student's name or student number.");
        System.out.println("Type 14 to quit the program.");
        System.out.println("");
    }
    
    public static void main(String[] args){
        ArrayList<Faculty> Instructors = new ArrayList<Faculty>();
        ArrayList<Staff> TeachingAssistants = new ArrayList<Staff>();
        ArrayList<Undergraduate> Undergraduates = new ArrayList<Undergraduate>();
        ArrayList<Graduate> Graduates = new ArrayList<Graduate>(); //create lists for each type of employee
        String course_number = "";
        String course_name = "";

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the file name: ");
        String filename = keyboard.nextLine();

        try{ //try to open the file
            File file = new File(filename);
            Scanner file_input = new Scanner(file);
            while(file_input.hasNextLine()){
                String line = file_input.nextLine();
                line = line.trim();
                String[] token = line.split(": "); //split the line into tokens
                if (token[0].equals("Number")){
                    course_number = token[1];
                }
                else if (token[0].equals("Name")){
                    course_name = token[1];
                }
                else if (token[0].equals("Instructor")){ //if the line is an instructor
                    String[] entry = token[1].split("; ");
                    String name = entry[0];
                    String ID = entry[1];
                    float salary = Float.parseFloat(entry[2].replace(",",""));
                    int hire = Integer.parseInt(entry[3]);
                    String title = entry[4];
                    Faculty current = new Faculty(name, ID, salary, hire, title);
                    boolean flag = false;
                    for(Faculty person : Instructors){
                        if(person.equals(current)){
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        if(Instructors.size() < 2){ //limit instructors to 2
                            Instructors.add(current);
                        }
                        else{
                            System.out.println("There are already two instructors in the list."); //if there are already 2 instructors, don't add the new one
                        }
                    }
                }

                else if (token[0].equals("Staff")){ //if the line is a teaching assistant
                    String[] entry = token[1].split("; ");
                    String name = entry[0];
                    String ID = entry[1];
                    float salary = Float.parseFloat(entry[2].replace(",",""));
                    int hire = Integer.parseInt(entry[3]);
                    int grade = Integer.parseInt(entry[4]);
                    Staff TA = new Staff(name, ID, salary, hire, grade);
                    boolean flag = false;
                    for(Staff person : TeachingAssistants){ //check if the TA is already in the list
                        if(person.equals(TA)){
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        if(TeachingAssistants.size() < 5){ //limit TAs to 5
                            TeachingAssistants.add(TA); //add the TA to the list
                        }
                        else{
                            System.out.println("There are already 5 teaching assistants in the list.");
                        }
                    }
                }
                else if (token[0].equals("Undergraduate")){ //  if the line is an undergraduate student
                    String[] entry = token[1].split("; ");
                    String name = entry[0];
                    int ID = Integer.parseInt(entry[1]);
                    String level = entry[2];
                    Undergraduate person = new Undergraduate(name, ID, level); //create an undergraduate student object
                    boolean flag = false;
                    for(Undergraduate student : Undergraduates){
                        if(student.equals(person)){ //if the student is already in the list, don't add it again
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        Undergraduates.add(person); //add the student to the list
                    }
                }
                else if (token[0].equals("Graduate")){ //if the line is a graduate student
                    String[] entry = token[1].split("; ");
                    String name = entry[0];
                    int ID = Integer.parseInt(entry[1]);
                    String program = entry[2]; 
                    Graduate person = new Graduate(name, ID, program); //create a graduate student object
                    boolean flag = false;
                    for(Graduate student : Graduates){
                        if(student.equals(person)){ //if the student is already in the list, don't add it again
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        Graduates.add(person); //add the student to the list
                    }
                }
                else{
                    System.out.println("Invalid input");
                }
            }
            file_input.close();
        }catch(FileNotFoundException e){ //if the file is not found
            System.out.println("File not found"); 
            System.exit(0);
        }

        Course course = new Course(course_name, course_number, Instructors, TeachingAssistants, Undergraduates, Graduates); //create a course object
        while(true){
            printlist();
            int choice = keyboard.nextInt();
            if(choice == 14){
                break;
            }
            switch(choice){
                case 1:
                    System.out.println("Name of the course: " + course.getName());
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Number of the course: " + course.getNumber());
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("How many employees: " + course.getNumberOfEmployees());
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Who are the instructors: ");
                    course.getInstructors();
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("Who are the teaching assistants: ");
                    course.getTeachingAssistants();
                    System.out.println("");
                    break;
                case 6:
                    System.out.println("How many instructors: " + course.getNumberOfInstructors());
                    System.out.println("");
                    break;
                case 7:
                    System.out.println("How many teaching assistants: " + course.getNumberOfTeachingAssistants());
                    System.out.println("");
                    break;
                case 8:
                    System.out.println("How many students: " + course.getNumberOfStudents());
                    System.out.println("");
                    break;
                case 9:
                    System.out.println("How many graduate students: " + course.getNumberOfGraduateStudents());
                    System.out.println("");
                    break;
                case 10:
                    System.out.println("How many undergraduate students: " + course.getNumberOfUndergraduateStudents());
                    System.out.println("");
                    break;
                case 11:
                    System.out.println("How many freshman/sophomore/juniors/seniors: " + course.getNumberOfFreshman() + "/" + course.getNumberOfSophomore() + "/" + course.getNumberOfJunior() + "/" + course.getNumberOfSenior());
                    System.out.println("");
                    break;
                case 12:
                    System.out.println("How many masters/doctoral students: " + course.getNumberOfMasters() + "/" + course.getNumberOfDoctoral());
                    System.out.println("");
                    break;
                case 13:
                    System.out.println("Find a specific student, either based on the student's name or student number.");
                    System.out.println("1. Name");
                    System.out.println("2. Student Number");
                    int choice2 = keyboard.nextInt();
                    switch(choice2){
                        case 1:
                            System.out.println("Enter the name of the student: ");
                            String name = keyboard.nextLine();
                            System.out.println("The student is: ");
                            course.findStudentByName(name);
                            System.out.println("");
                            break;
                        case 2:
                            System.out.println("Enter the student number of the student: ");
                            int number = keyboard.nextInt();
                            System.out.println("The student is: ");
                            course.findStudentByNumber(number);
                            System.out.println("");
                            break;
                    }
                    break;
            }
        }
        //close scanner
        keyboard.close();
    }
}