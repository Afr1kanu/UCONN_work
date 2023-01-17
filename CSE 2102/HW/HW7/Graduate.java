public class Graduate extends Student{
    public enum Program{
        MASTERS,
        DOCTORAL
    }
    private Program program;

    public Graduate(String initialName, int initialStudentNumber, String initialProgram){
        super(initialName, initialStudentNumber);
        this.program = Program.valueOf(initialProgram);
    }
    public void reset(String newName, int newStudentNumber, program newProgram){
        reset(newName, newStudentNumber);
        this.program = newProgram;
    }
    public Program getProgram(){
        return this.program;
    }
    public void setProgram(program newProgram){
        this.program = newProgram;
    }
    public void writeOutput(){
        super.writeOutput();
        System.out.println("Program: " + program);
    }
    public boolean equals(Graduate otherGraduate){
        return super.equals(otherGraduate) && (this.program == otherGraduate.program);
    }
}