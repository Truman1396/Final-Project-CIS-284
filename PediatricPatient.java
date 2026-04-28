public class PediatricPatient extends Patient {

    public PediatricPatient(String name, int id, int age, String medicalIssue, String condition, String assignedDoctor) {
        super(name, id, age, medicalIssue, condition, assignedDoctor);
    }

    @Override
    public String getInfo() {
        return "[Pediatric] " + super.getInfo();
    }

    public String txtPrep(){
        return name + "," + this.getId() + "," + age + "," + medicalIssue + "," + condition + "," + assignedDoctor;
    }
}
