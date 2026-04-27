public class PediatricPatient extends Patient {

    public PediatricPatient(String name, int id, int age, String medicalIssue) {
        super(name, id, age, medicalIssue);
        this.patientType = 1;             // assign type number
        this.doctorType = "Pediatrician"; // assign doctor
    }

    @Override
    public String getInfo() {
        return "[Pediatric] " + super.getInfo();
    }

    public String txtPrep(){
        return name + "," + this.getId() + "," + age + "," + medicalIssue + "," + patientType + "," + doctorType;
    }
}
