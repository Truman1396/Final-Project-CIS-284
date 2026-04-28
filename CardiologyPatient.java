public class CardiologyPatient extends Patient {

    // creates a cardiology patient (constructor)
    public CardiologyPatient(String name, int id, int age, String medicalIssue, String condition, String assignedDoctor) {
        super(name, id, age, medicalIssue, condition, assignedDoctor);
    }

    // returns cardiology 
    // patient information
    @Override
    public String getInfo() {
        return "[Cardiology] " + super.getInfo();
    }

    //prepares info for file writing
    public String txtPrep(){
        return name + "," + this.getId() + "," + age + "," + medicalIssue + "," + condition + "," + assignedDoctor;
    }
}
