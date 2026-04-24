public class GeneralPatient extends Patient {

    public GeneralPatient(String name, int id, int age, String medicalIssue) {
        super(name, id, age, medicalIssue);
        this.patientType = 4;
        this.doctorType = "Family Doctor"; // could also be Nurse
    }

    @Override
    public String getInfo() {
        return "[General] " + super.getInfo();
    }
}