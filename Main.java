import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<MedicalProfessional> doctors = new ArrayList<>();
        loadDoctorsFromFile(doctors);
        ArrayList<Patient> patients = new ArrayList<>();
        loadPatientsFromFile(patients);


        saveDoctorsToFile(doctors);
        savePatientsToFile(patients);
    }


//File Reading and Writing

    //Reading Patient File
    static void loadPatientsFromFile(ArrayList<Patient> patients) {
        try (BufferedReader br = new BufferedReader(new FileReader("Patients.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int id = Integer.parseInt(data[1]);
                int age = Integer.parseInt(data[2]);
                String medicalIssue = data[3];

                if (age <= 18){
                    patients.add(new PediatricPatient(name, id, age, medicalIssue));
                } else if (medicalIssue.equals("Chest Pain")){
                    patients.add(new CardiologyPatient(name, id, age, medicalIssue));
                } else if (medicalIssue.equals("Broken Bone")){
                    patients.add(new EmergencyPatient(name, id, age, medicalIssue));
                } else{
                    patients.add(new GeneralPatient(name, id, age, medicalIssue));
                }

            }
        } catch (IOException e) {
            System.out.println("No existing file found. Starting fresh.");
        }
    }

    //Writing to Patient file
    static void savePatientsToFile(ArrayList<Patient> patients){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Patients.txt"))) {
            for (Patient pat : patients) {
                bw.write(pat.txtPrep());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    //Reading Doctor File
    static void loadDoctorsFromFile(ArrayList<MedicalProfessional> doctors) {
        try (BufferedReader br = new BufferedReader(new FileReader("Doctors.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int docID = Integer.parseInt(data[0]);
                String docName = data[1];
                String specialty = data[2];
                int availability = Integer.parseInt(data[3]);

                if (specialty.equals("Cardiologist")){
                    doctors.add(new Cardiologist(docID, docName, specialty, availability));
                } else if (specialty.equals("Family Doctor")){
                    doctors.add(new FamilyDoctor(docID, docName, specialty, availability));
                } else if (specialty.equals("Nurse")){
                    doctors.add(new Nurse(docID, docName, specialty, availability));
                } else if (specialty.equals("Pediatrician")){
                    doctors.add(new Pediatrician(docID, docName, specialty, availability));
                } else if (specialty.equals("Surgeon")){
                    doctors.add(new Surgeon(docID, docName, specialty, availability));
                }
            }
        } catch (IOException e) {
            System.out.println("No existing file found. Starting fresh.");
        }
    }

    //Writing to Doctor File
    static void saveDoctorsToFile(ArrayList<MedicalProfessional> doctors){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Doctors.txt"))) {
            for (MedicalProfessional doc : doctors) {
                bw.write(doc.txtPrep());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}
