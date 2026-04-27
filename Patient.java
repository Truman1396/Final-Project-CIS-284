public abstract class Patient {

    protected String name;
    private int id;
    protected int age;
    protected String medicalIssue;
    protected String condition;

    protected int patientType;
    protected String doctorType;

    // creates a patient with basic info
    public Patient(String name, int id, int age, String medicalIssue) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.medicalIssue = medicalIssue;
        this.condition = "Checkup";
    }

    // uptade on patients conditions.
    public void updateCondition(String newCondition) {
        this.condition = newCondition;
    }

    // makes sure if the patient is ready to leave.
    public boolean canBeDischarged() {
        return condition.equalsIgnoreCase("Discharge");
    }

    // returns all patient info as text
    public String getInfo() {
        return "Name: " + name +
               ", ID: " + id +
               ", Age: " + age +
               ", Issue: " + medicalIssue +
               ", Condition: " + condition +
               ", Type#: " + patientType +
               ", Doctor: " + doctorType;
    }

    // Returns the patient's
    //ID
    public int getId() {
        return id;
    }

    // this checks if 
    //needed doctor type is available
    public boolean assignDoctorIfAvailable(int pediatricians,
                                           int cardiologists,
                                           int surgeons,
                                           int familyDoctors,
                                           int nurses) {

        if (doctorType.equals("Pediatrician") && pediatricians > 0) {
            return true;
        } else if (doctorType.equals("Cardiologist") && cardiologists > 0) {
            return true;
        } else if (doctorType.equals("Surgeon") && surgeons > 0) {
            return true;
        } else if (doctorType.equals("Family Doctor") && familyDoctors > 0) {
            return true;
        } else if (doctorType.equals("Nurse") && nurses > 0) {
            return true;
        }

        return false;
    }

    public abstract String txtPrep();
}
