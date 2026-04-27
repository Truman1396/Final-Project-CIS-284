public class CardiologyPatient extends Patient {

    // creates a cardiology patient and 
    //    assigns a cardiologist
    public CardiologyPatient(String name, int id, int age, String medicalIssue) {
        super(name, id, age, medicalIssue);
        this.patientType = 2;
        this.doctorType = "Cardiologist";
    }

    // returns cardiology 
    //     patient information
    @Override
    public String getInfo() {
        return "[Cardiology] " + super.getInfo();
    }

    public String txtPrep(){
        return name + "," + this.getId() + "," + age + "," + medicalIssue + "," + patientType + "," + doctorType;
    }
}
