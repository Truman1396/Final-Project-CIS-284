public class CardiologyPatient extends Patient {

    // Creates a cardiology patient and assigns a cardiologist
    public CardiologyPatient(String name, int id, int age, String medicalIssue) {
        super(name, id, age, medicalIssue);
        this.patientType = 2;
        this.doctorType = "Cardiologist";
    }

    // Returns cardiology patient information
    @Override
    public String getInfo() {
        return "[Cardiology] " + super.getInfo();
    }
}
