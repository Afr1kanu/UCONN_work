public class Undergraduate extends Student{
    public enum Level{
        FRESHMAN,
        SOPHOMORE,
        JUNIOR,
        SENIOR
    }
    private Level level;

    public Undergraduate(String initialName, int initialStudentNumber, String initialLevel){
        super(initialName, initialStudentNumber);
        this.level = Level.valueOf(initialLevel);
    }
    public void reset(String newName, int newStudentNumber, level newLevel){
        reset(newName, newStudentNumber);
        this.level = newLevel;
    }
    public Level getLevel(){
        return this.level;
    }

    public void setLevel(level newLevel){
        this.level = newLevel;
    }
    public void writeOutput(){
        super.writeOutput();
        System.out.println("Level: " + level);
    }
    public boolean equals(Undergraduate otherUndergraduate){
        return super.equals(otherUndergraduate) && (this.level == otherUndergraduate.level);
    }

}