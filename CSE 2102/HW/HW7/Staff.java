public class Staff extends Employee{
    private int grade;

    public Staff(String initialName, String initialID, Float initialSalary, int initialYear, int initialGrade){
        super(initialName, initialID, initialSalary, initialYear);
        this.grade = initialGrade;
    }
    public void reset(String newName, String newID, Float newSalary, int newYear, int newGrade){
        reset(newName, newID, newSalary, newYear);
        this.grade = newGrade;
    }
    public int getGrade(){
        return grade;
    }
    public void setGrade(int newGrade){
        grade = newGrade;
    }
    public void writeOutput(){
        super.writeOutput();
        System.out.println("Grade: " + grade);
    }
    public boolean equals(Staff otherStaff){
        return super.equals(otherStaff) && (this.grade == otherStaff.grade);
    }

}