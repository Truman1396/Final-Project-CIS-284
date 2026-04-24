// Base class for all patients
public class Patient {
    protected String name;
    protected int id;
    protected int age;
    protected String medicalIssue;
    protected String condition;

    protected int patientType;     // number for patient type
    protected String doctorType;   // assigned doctor type

    // Constructor
    public Patient(String name, int id, int age, String medicalIssue) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.medicalIssue = medicalIssue;
        this.condition = "Checkup"; // default condition
    }

    // Update patient's condition
    public void updateCondition(String newCondition) {
        this.condition = newCondition;
    }

    // Check if patient can be discharged
    public boolean canBeDischarged() {
        return condition.equalsIgnoreCase("Discharge");
    }

    // Get patient info
    public String getInfo() {
        return "Name: " + name +
               ", ID: " + id +
               ", Age: " + age +
               ", Issue: " + medicalIssue +
               ", Condition: " + condition +
               ", Type#: " + patientType +
               ", Doctor: " + doctorType;
    }

    public int getId() {
        return id;
    }

    // Check if a doctor is available for this patient
    public boolean assignDoctorIfAvailable(int pediatricians,
                                        int cardiologists,
                                        int surgeons,
                                        int familyDoctors,
                                        int nurses) {

    // Check based on doctor type
    if (doctorType.equals("Pediatrician") && pediatricians > 0) {
        return true;
    }
    else if (doctorType.equals("Cardiologist") && cardiologists > 0) {
        return true;
    }
    else if (doctorType.equals("Surgeon") && surgeons > 0) {
        return true;
    }
    else if (doctorType.equals("Family Doctor") && familyDoctors > 0) {
        return true;
    }
    else if (doctorType.equals("Nurse") && nurses > 0) {
        return true;
    }

    // No doctor available
    return false;
}
}