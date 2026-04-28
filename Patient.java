public abstract class Patient {

    //class variables
    protected String name;
    private int id;
    protected int age;
    protected String medicalIssue;
    protected String condition;
    protected String assignedDoctor;


    // creates a patient with basic info
    public Patient(String name, int id, int age, String medicalIssue, String condition, String assignedDoctor) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.medicalIssue = medicalIssue;
        this.condition = condition;
        this.assignedDoctor = assignedDoctor;
    }

    // updates patient's conditions.
    public void updateCondition(String newCondition) {
        condition = newCondition;
    }

    //Assigns doctor's name to the patient
    public void assignDoctor(String doctor){
        assignedDoctor = doctor;
    }

    // returns all patient info as text
    public String getInfo() {
        return "Name: " + name +
               ", ID: " + id +
               ", Age: " + age +
               ", Issue: " + medicalIssue +
               ", Condition: " + condition;
    }

    //getter methods
    public int getId() {
        return id;
    }

    public int getAge(){
        return age;
    }

    public String getMedicalIssue(){
        return medicalIssue;
    }

    public String getAssignedDoctor(){
        return assignedDoctor;
    }

    public String getCondition(){
        return condition;
    }

    //abstract method
    public abstract String txtPrep();
}
