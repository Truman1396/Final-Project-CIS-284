public class EmergencyPatient extends Patient {

    // creates the emergency patient and assigns a surgeon
    public EmergencyPatient(String name, int id, int age, String medicalIssue, String condition, String assignedDoctor) {
        super(name, id, age, medicalIssue, condition, assignedDoctor);
    }

    // returns emergency patient info
    @Override
    public String getInfo() {
        return "[Emergency] " + super.getInfo();
    }

    public String txtPrep(){
        return name + "," + this.getId() + "," + age + "," + medicalIssue + "," + condition + "," + assignedDoctor;
    }
}
