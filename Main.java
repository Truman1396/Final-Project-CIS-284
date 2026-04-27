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
        int choice = 0;

        ArrayList<MedicalProfessional> doctors = new ArrayList<>();
        loadDoctorsFromFile(doctors);
        ArrayList<Patient> patients = new ArrayList<>();
        loadPatientsFromFile(patients);


        do{

            System.out.println();
            System.out.println("====Select Action====");
            System.out.println("1.) Admit a Patient \n2.) Assign Patient a Doctor \n3.) Update Patient Condition \n4.) Discharge Patient \n5.) Display Patient Info \n6.) Exit");
            System.out.println();
            System.out.print("Enter the action you would like to perform: ");
            choice = Integer.parseInt(in.nextLine());
            System.out.println();

            if (choice == 1){
                System.out.print("Patient ID: ");
                int tempID = Integer.parseInt(in.nextLine());
                System.out.print("Patient Name: ");
                String tempName = in.nextLine();
                System.out.print("Patient Age: ");
                int tempAge = Integer.parseInt(in.nextLine());
                System.out.println("---Select Medical Issue---");
                System.out.println("1.) Chest Pain \n2.) Broken Bone \n3.) Other");
                System.out.println();
                System.out.print("Enter Patient's Medical Issue: ");
                String tempMedicalIssue = "Other";
                int selection = Integer.parseInt(in.nextLine());
                if ((selection >= 1) && (selection <= 3)){
                    if (tempAge <= 18){
                        if (selection == 1){
                            tempMedicalIssue = "Chest Pain";
                        } else if (selection == 2){
                            tempMedicalIssue = "Broken Bone";
                        } else if (selection == 3){
                            tempMedicalIssue = "Other";
                        }
                        patients.add(new PediatricPatient(tempName, tempID, tempAge, tempMedicalIssue));
                    } else if (selection == 1){
                        tempMedicalIssue = "Chest Pain";
                        patients.add(new CardiologyPatient(tempName, tempID, tempAge, tempMedicalIssue));
                    } else if (selection == 2){
                        tempMedicalIssue = "Broken Bone";
                        patients.add(new EmergencyPatient(tempName, tempID, tempAge, tempMedicalIssue));
                    } else if (selection == 3){
                        tempMedicalIssue = "Other";
                        patients.add(new GeneralPatient(tempName, tempID, tempAge, tempMedicalIssue));
                    }
                } else {
                    System.out.println("Incorrect Information Provided");
                }
            } else if (choice == 2){
                //Assign a doctor
            } else if (choice == 3){
                //Update Condition
            } else if (choice == 4){
                //Discharge Patient
            } else if (choice == 5){
                System.out.println("---Patient Info---");
                for (Patient p : patients){
                    System.out.println(p.getInfo());
                }
            } else if (choice == 6){
                System.out.println("Program Exited");

            //Catch everything else
            } else {
                System.out.println("Not a valid option. Please select a valid action.");
                System.out.println();
            }


        } while (choice != 6);

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
