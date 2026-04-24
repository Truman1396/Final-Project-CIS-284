public class GeneralPatient extends Patient {

    //  general patient and assigns a family doctor
    public GeneralPatient(String name, int id, int age, String medicalIssue) {
        super(name, id, age, medicalIssue);
        this.patientType = 4;
        this.doctorType = "Family Doctor";
    }

    // returns the general patient information
    @Override
    public String getInfo() {
        return "[General] " + super.getInfo();
    }
}
