public class Faculty extends Employee{
    private String title;

    public Faculty(String initialName, String initialID, float initialSalary, int initialYear, String initialTitle){
        super(initialName, initialID, initialSalary, initialYear);
        this.title = initialTitle;
    }

    public void reset(String newName, String newID, float newSalary, int newYear, String newTitle){
        reset(newName, newID, newSalary, newYear);
        this.title = newTitle;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String newTitle){
        title = newTitle;
    }

    public void writeOutput(){
        super.writeOutput();
        System.out.println("Title: " + title);
    }

    public boolean equals(Faculty otherFaculty){
        return super.equals(otherFaculty) && (this.title.equalsIgnoreCase(otherFaculty.title));
    }
}