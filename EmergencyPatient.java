public class EmergencyPatient extends Patient {

    // creates the emergency patient and assigns a surgeon
    public EmergencyPatient(String name, int id, int age, String medicalIssue) {
        super(name, id, age, medicalIssue);
        this.patientType = 3;
        this.doctorType = "Surgeon";
        this.condition = "Emergency"; //always emergency
    }

    // returns emergency patient info
    @Override
    public String getInfo() {
        return "[Emergency] " + super.getInfo();
    }
}
