public abstract class Patient {

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

    // uptade on patients conditions.
    public void updateCondition(String newCondition) {
        condition = newCondition;
    }

    // makes sure if the patient is ready to leave.
    public boolean canBeDischarged() {
        return condition.equalsIgnoreCase("Discharge");
    }

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

    // Returns the patient's
    //ID
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

    public abstract String txtPrep();
}
