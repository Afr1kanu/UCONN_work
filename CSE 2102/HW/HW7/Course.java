import java.util.ArrayList;

public class Course {
    private String courseNumber;
    private String name;
    private ArrayList<Faculty> instructors;
    private ArrayList<Staff> teachingAssistants;
    private ArrayList<Undergraduate> undergraduates;
    private ArrayList<Graduate> graduates;
    public Course(String courseNumber,String name,ArrayList<Faculty> instructors,ArrayList<Staff> teachingAssistants, 
                  ArrayList<Undergraduate> undergraduates, ArrayList<Graduate> graduates){ //constructor
        this.courseNumber=courseNumber;
        this.name=name;
        this.instructors=instructors;
        this.teachingAssistants=teachingAssistants;
        this.undergraduates=undergraduates;
        this.graduates=graduates;
    }


    public void findStudentByNumber(int number) { //finds student by number
        boolean found = false;
        for (int i = 0; i <= this.graduates.size()-1; i++) {
            if (this.graduates.get(i).getStudentNumber() == number) {
                found = true;
                this.graduates.get(i).writeOutput();
            }
        }

        for(int i = 0; i<=this.undergraduates.size()-1; i++){
            if (this.undergraduates.get(i).getStudentNumber() == number){
                found = true;
                this.undergraduates.get(i).writeOutput();
            }
        }
        if (found == false){
            System.out.println("Student cannot be found.");
        }
    }

    public void findStudentByName(String name) { //finds student by name
        boolean found = false;
        for (int i = 0; i <= this.graduates.size()-1; i++) {
            if (this.graduates.get(i).getName() == name) {
                found = true;
                this.graduates.get(i).writeOutput();
            }
        }

        for(int i = 0; i<=this.undergraduates.size()-1; i++){
            if (this.undergraduates.get(i).getName() == name){
                found = true;
                this.undergraduates.get(i).writeOutput();
            }
        }
        if (found == false){
            System.out.println("Student cannot be found.");
        }
    }

    public int getNumberOfDoctoral() { //returns number of doctoral students
        int numDoct = 0;
        for(int i = 0; i<=this.graduates.size()-1; i++){
            if (this.graduates.get(i).getProgram() == Graduate.Program.DOCTORAL){
                numDoct ++;
            }
        }
        return numDoct;
    }


    public int getNumberOfMasters() { //returns number of masters students
        int numMast = 0;
        for(int i = 0; i<=this.graduates.size()-1; i++){
            if (this.graduates.get(i).getProgram() == Graduate.Program.MASTERS){
                numMast ++;
            }
        }
        return numMast;
    }

    public int getNumberOfSenior() { //returns number of senior students
        int numSeni = 0;
        for(int i = 0; i<=this.undergraduates.size()-1; i++){
            if (this.undergraduates.get(i).getLevel() == Undergraduate.Level.SENIOR){
                numSeni ++;
            }
        }
        return numSeni;
    }

    public int getNumberOfJunior() { // returns number of junior students
        int numJuni = 0;
        for(int i = 0; i<=this.undergraduates.size()-1; i++){
            if (this.undergraduates.get(i).getLevel() == Undergraduate.Level.JUNIOR){
                numJuni ++;
            }
        }
        return numJuni;
    }

    public int getNumberOfSophomore() {
        int numSoph = 0;
        for(int i = 0; i<=this.undergraduates.size()-1; i++){
            if (this.undergraduates.get(i).getLevel() == Undergraduate.Level.SOPHOMORE){
                numSoph ++;
            }
        }
        return numSoph;
    }

    public int getNumberOfFreshman() {
        int numFresh = 0;
        for(int i = 0; i<=this.undergraduates.size()-1; i++){
            if (this.undergraduates.get(i).getLevel() == Undergraduate.Level.FRESHMAN){
                numFresh ++;
            }
        }
        return numFresh;
    }

    public int getNumberOfUndergraduateStudents() {
        return this.undergraduates.size();
    }

    public int getNumberOfGraduateStudents() {
        return this.graduates.size();
    }

    public int getNumberOfStudents() {
        return this.graduates.size() + this.undergraduates.size();
    }

    public int getNumberOfTeachingAssistants() {
        return this.teachingAssistants.size();
    }

    public int getNumberOfInstructors() {
        return this.instructors.size();
    }

    public void getTeachingAssistants() {
        for (int i = 0; i <= this.teachingAssistants.size()-1; i++){
            System.out.println(this.teachingAssistants.get(i).getName());
        }
    }

    public void getInstructors() {
        for (int i = 0; i <= this.instructors.size()-1; i++){
            System.out.println(this.instructors.get(i).getName());
        }
    }

    public int getNumberOfEmployees() {
        return (this.instructors.size() + this.teachingAssistants.size());
    }

    public String getNumber() {
        String courseNumber1 = this.courseNumber;
        return courseNumber1;
    }

    public void changeCourseNumber(String newCourse) {
        this.courseNumber = newCourse;
    }
    public String getName() {
        String name1 = this.name;
        return name1;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
    public ArrayList<Faculty> getFaculty() {
        return this.instructors;
    }

    public void changeInstructors(ArrayList<Faculty> newFaculty) {
        this.instructors = newFaculty;
    }
    public ArrayList<Staff> getStaff() {
        return this.teachingAssistants;
    }

    public void changeStaff(ArrayList<Staff> newStaff) {
        this.teachingAssistants = newStaff;
    }
    public ArrayList<Undergraduate> getUndergraduates() {
        return this.undergraduates;
    }
    public void changeUndergraduates(ArrayList<Undergraduate> newUndergraduates) {
        this.undergraduates = newUndergraduates;
    }
    public int numUndergraduates() {
        return this.undergraduates.size();
    }
    public ArrayList<Graduate> getGraduates() {
        return this.graduates;
    }
    public void changeGraduates(ArrayList<Graduate> newGraduates) {
        this.graduates = newGraduates;
    }
    public int numGraduates() {
        return this.graduates.size();
    }

}
