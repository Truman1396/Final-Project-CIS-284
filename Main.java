import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Doctors
        ArrayList<MedicalProfessional> doctors = new ArrayList<>();
        doctors.add(new Surgeon(101, "John", 1));
        doctors.add(new Nurse(102, "Sarah", 1));
        doctors.add(new Cardiologist(103, "Mike", 0));

        System.out.println("=== Doctors ===");
        for (MedicalProfessional d : doctors) {
            d.displayInfo();
            d.performAction();
            System.out.println();
        }

        // Patients
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new PediatricPatient("Liam", 201, 8, "Fever"));
        patients.add(new EmergencyPatient("Carlos", 203, 30, "Accident"));

        System.out.println("=== Patients ===");
        for (Patient p : patients) {
            System.out.println(p.getInfo());
        }
    }
}
