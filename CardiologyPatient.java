public class CardiologyPatient extends Patient {

    public CardiologyPatient(String name, int id, int age, String medicalIssue) {
        super(name, id, age, medicalIssue);
        this.patientType = 2;
        this.doctorType = "Cardiologist";
    }

    @Override
    public String getInfo() {
        return "[Cardiology] " + super.getInfo();
    }
}