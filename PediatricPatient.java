public class PediatricPatient extends Patient {

    // creates pediatric patient (constructor)
    public PediatricPatient(String name, int id, int age, String medicalIssue, String condition, String assignedDoctor) {
        super(name, id, age, medicalIssue, condition, assignedDoctor);
    }

    @Override
    // provides info
    public String getInfo() {
        return "[Pediatric] " + super.getInfo();
    }

    //prepares info for file writing
    public String txtPrep(){
        return name + "," + this.getId() + "," + age + "," + medicalIssue + "," + condition + "," + assignedDoctor;
    }
}
