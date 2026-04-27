import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // doctors

        Scanner scanner = new Scanner(System.in);

        ArrayList<MedicalProfessional> doctors = new ArrayList<>();
        doctors.add(new Surgeon(101, "Dr. Smith", 1));
        doctors.add(new Pediatrician(102, "Dr. Johnson", 1));
        doctors.add(new Cardiologist(103, "Dr. Lee", 0));
        doctors.add(new FamilyDoctor(104, "Dr. Brown", 1));
        doctors.add(new Nurse(105, "Nurse Sarah", 1));

        

        // display doctors
        for (MedicalProfessional d : doctors) {
            d.displayInfo();
            d.performAction();
            System.out.println();
        }

        // admit patients
        ArrayList<Patient> patients = new ArrayList<>();

        patients.add(new PediatricPatient("Liam", 201, 8, "Fever"));
        patients.add(new EmergencyPatient("Carlos", 203, 30, "Accident"));
        patients.add(new GeneralPatient("Ana", 204, 45, "Checkup"));

        // update condition
        patients.get(0).updateCondition("Available for discharge");

        // process patients
        for (Patient p : patients) {

            System.out.println(p.getInfo());

            // discharge
            if (p.canBeDischarged()) {
                System.out.println("Patient discharged");
            }

            // assign doctor
            else if (p.assignDoctorIfAvailable(1, 1, 0, 1, 1)) {
                System.out.println("Doctor assigned: " + p.getDoctorType());
            }

            // airlift

            else {
                System.out.println("No doctor is available → Airlift patient");
            }

            System.out.println();
        }
        scanner.close();
    }
}
