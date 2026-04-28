public class GeneralPatient extends Patient {

    //  general patient and assigns a family doctor
    public GeneralPatient(String name, int id, int age, String medicalIssue, String condition, String assignedDoctor) {
        super(name, id, age, medicalIssue, condition, assignedDoctor);
    }

    // returns the general patient information
    @Override
    public String getInfo() {
        return "[General] " + super.getInfo();
    }

    public String txtPrep(){
        return name + "," + this.getId() + "," + age + "," + medicalIssue + "," + condition + "," + assignedDoctor;
    }
}
