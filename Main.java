//Import statements
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Creates scanner for user input
        Scanner in = new Scanner(System.in);
        int choice = 0;

        //Creates arraylists and populates them with info from text files
        ArrayList<MedicalProfessional> doctors = new ArrayList<>();
        loadDoctorsFromFile(doctors);
        ArrayList<Patient> patients = new ArrayList<>();
        loadPatientsFromFile(patients);


        //User interaction (always runs at least once)
        do{

            //Selection screen: choose an option
            System.out.println();
            System.out.println("====Select Action====");
            System.out.println("1.) Admit a Patient \n2.) Assign Patient a Doctor \n3.) Discharge Patient \n4.) Display Patient Info \n5.) Display Doctor Info\n6.) Exit");
            System.out.println();
            System.out.print("Enter the action you would like to perform: ");
            choice = Integer.parseInt(in.nextLine());
            System.out.println();


            //Admit a patient
            if (choice == 1){
                //Collecting patient information
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
                    //Assigning patient to a subclass depending on medical needs
                    if (tempAge <= 18){
                        if (selection == 1){
                            tempMedicalIssue = "Chest Pain";
                        } else if (selection == 2){
                            tempMedicalIssue = "Broken Bone";
                        } else if (selection == 3){
                            tempMedicalIssue = "Other";
                        }
                        patients.add(new PediatricPatient(tempName, tempID, tempAge, tempMedicalIssue, "Checkup", "No Doctor"));
                        System.out.println("Patient " + tempID + " admitted to the pediatrics unit");
                    } else if (selection == 1){
                        tempMedicalIssue = "Chest Pain";
                        patients.add(new CardiologyPatient(tempName, tempID, tempAge, tempMedicalIssue, "Checkup", "No Doctor"));
                        System.out.println("Patient " + tempID + " admitted to the cardiology unit");
                    } else if (selection == 2){
                        tempMedicalIssue = "Broken Bone";
                        patients.add(new EmergencyPatient(tempName, tempID, tempAge, tempMedicalIssue, "Emergency", "No Doctor"));
                        System.out.println("Patient " + tempID + " admitted to the emergency unit");
                    } else if (selection == 3){
                        tempMedicalIssue = "Other";
                        patients.add(new GeneralPatient(tempName, tempID, tempAge, tempMedicalIssue, "Checkup", "No Doctor"));
                        System.out.println("Patient " + tempID + " admitted to the general unit");
                    } else {
                        System.out.println("Incorrect Information Provided");
                    }
                } else {
                    System.out.println("Incorrect Information Provided");
                }
                System.out.println();


            //Assign Patient to Doctor
            } else if (choice == 2){
                //Choosing patient
                System.out.print("Please enter Patient's ID number: ");
                int number = Integer.parseInt(in.nextLine());
                if (findPatient(number, patients) != null){
                    Patient tempPatient = findPatient(number, patients);
                    System.out.println("---Patient Info---");
                    System.out.println(tempPatient.getInfo());
                    System.out.println();

                    //Assigning a correct and available doctor
                    //Airlifts patient and removes from system if no doctor is available
                    if ((tempPatient.getAssignedDoctor()).equals("No Doctor")){
                        if (tempPatient.getAge() <= 18){
                            for (MedicalProfessional p : doctors){
                                if ((p.getSpecialty()).equals("Pediatrician")){
                                    if (p.getAvailability() == 1){
                                        System.out.println(p.getDocName() + " has been assigned to Patient " + tempPatient.getId());
                                        tempPatient.assignDoctor(p.getDocName());
                                        p.changeAvailable();
                                        p.performAction();
                                        tempPatient.updateCondition("Available for Discharge");
                                        System.out.println("Patient " + tempPatient.getId() + " is available for discharge");
                                        break;
                                    } else {
                                        System.out.println("No Available Doctors: Patient " + tempPatient.getId() + " recommended for airlift \n--Proceed?-- \n1.) Yes \n2.) No");
                                        int airlift = Integer.parseInt(in.nextLine());
                                        if (airlift == 1){
                                            System.out.println("Patient " + tempPatient.getId() + " airlifted to another hospital");
                                            patients.remove(tempPatient);
                                        } else if (airlift != 0){
                                            System.out.println("Invalid Information");
                                        }
                                        break;
                                    }
                                }
                            }
                        } else if ((tempPatient.getMedicalIssue()).equals("Chest Pain")){
                            for (MedicalProfessional p : doctors){
                                if ((p.getSpecialty()).equals("Cardiologist")){
                                    if (p.getAvailability() == 1){
                                        System.out.println(p.getDocName() + " has been assigned to Patient " + tempPatient.getId());
                                        tempPatient.assignDoctor(p.getDocName());
                                        p.changeAvailable();
                                        p.performAction();
                                        tempPatient.updateCondition("Available for Discharge");
                                        System.out.println("Patient " + tempPatient.getId() + " is available for discharge");
                                        break;
                                    } else {
                                        System.out.println("No Available Doctors: Patient " + tempPatient.getId() + " recommended for airlift \n--Proceed?-- \n1.) Yes \n2.) No");
                                        int airlift = Integer.parseInt(in.nextLine());
                                        if (airlift == 1){
                                            System.out.println("Patient " + tempPatient.getId() + " airlifted to another hospital");
                                            patients.remove(tempPatient);
                                        } else if (airlift != 0){
                                            System.out.println("Invalid Information");
                                        }
                                        break;
                                    }
                                }
                            }
                        } else if ((tempPatient.getMedicalIssue()).equals("Broken Bone")){
                            for (MedicalProfessional p : doctors){
                                if ((p.getSpecialty()).equals("Surgeon")){
                                    if (p.getAvailability() == 1){
                                        System.out.println(p.getDocName() + " has been assigned to Patient " + tempPatient.getId());
                                        tempPatient.assignDoctor(p.getDocName());
                                        p.changeAvailable();
                                        p.performAction();
                                        tempPatient.updateCondition("Available for Discharge");
                                        System.out.println("Patient " + tempPatient.getId() + " is available for discharge");
                                        break;
                                    } else {
                                        System.out.println("No Available Doctors: Patient " + tempPatient.getId() + " recommended for airlift \n--Proceed?-- \n1.) Yes \n2.) No");
                                        int airlift = Integer.parseInt(in.nextLine());
                                        if (airlift == 1){
                                            System.out.println("Patient " + tempPatient.getId() + " airlifted to another hospital");
                                            patients.remove(tempPatient);
                                        } else if (airlift != 0){
                                            System.out.println("Invalid Information");
                                        }
                                        break;
                                    }
                                }
                            }
                        } else if ((tempPatient.getMedicalIssue()).equals("Other")){
                            for (MedicalProfessional p : doctors){
                                if ((p.getSpecialty()).equals("Family Doctor")){
                                    if (p.getAvailability() == 1){
                                        System.out.println(p.getDocName() + " has been assigned to Patient " + tempPatient.getId());
                                        tempPatient.assignDoctor(p.getDocName());
                                        p.changeAvailable();
                                        p.performAction();
                                        tempPatient.updateCondition("Available for Discharge");
                                        System.out.println("Patient " + tempPatient.getId() + " is available for discharge");
                                        break;
                                    } else {
                                        System.out.println("No Available Doctors: Patient " + tempPatient.getId() + " recommended for airlift \n--Proceed?-- \n1.) Yes \n2.) No");
                                        int airlift = Integer.parseInt(in.nextLine());
                                        if (airlift == 1){
                                            System.out.println("Patient " + tempPatient.getId() + " airlifted to another hospital");
                                            patients.remove(tempPatient);
                                        } else if (airlift != 0){
                                            System.out.println("Invalid Information");
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Patient already has a doctor assigned");
                    }
                } else {
                    System.out.println("Patient not found: Please select another action");
                    System.out.println();
                }
                System.out.println();


            //Discharge Patient
            } else if (choice == 3){
                //Choosing patient
                //Discharing patient if able
                System.out.print("Please enter Patient's ID number: ");
                int number = Integer.parseInt(in.nextLine());
                if (findPatient(number, patients) != null){
                    Patient tempPatient = findPatient(number, patients);
                    if ((tempPatient.getCondition()).equals("Available for Discharge")){
                        System.out.print("Patient " + tempPatient.getId() + " is available for discharge: \n--Proceed?-- \n1.) Yes \n2.) No \n-> ");
                        int decision = Integer.parseInt(in.nextLine());
                        if (decision == 1){
                            MedicalProfessional finalCheck = findDoctor("Nurse Thompson", doctors);
                            finalCheck.performAction();
                            System.out.println("Patient " + tempPatient.getId() + " has been discharged");
                            MedicalProfessional switchDoc = findDoctor(tempPatient.getAssignedDoctor(), doctors);
                            switchDoc.changeAvailable();
                            switchDoc.checkAvailable();
                            patients.remove(tempPatient);
                        } else if (decision != 2){
                            System.out.println("Incorrect Information");
                        }
                    } else {
                        System.out.println("Patient " + tempPatient.getId() + " is not available for discharge");
                    }
                } else {
                    System.out.println("Patient not found: Please select another action");
                    System.out.println();
                }
                System.out.println();


            //Display info of current patients
            } else if (choice == 4){
                System.out.println("---Patient Info---");
                for (Patient p : patients){
                    System.out.println(p.getInfo());
                }
                System.out.println();


            //Display info of current doctors
            } else if (choice == 5){
                System.out.println("---Doctor Info---");
                for (MedicalProfessional d : doctors){
                    d.displayInfo();
                    System.out.println();
                }
                System.out.println();


            //Exit Program
            } else if (choice == 6){
                System.out.println("Program Exited");


            //Catch everything else
            } else {
                System.out.println("Not a valid option. Please select a valid action.");
                System.out.println();
            }


        } while (choice != 6);

        //Save information to the text files
        saveDoctorsToFile(doctors);
        savePatientsToFile(patients);
    }


    //Confirm if a Patient Exists
    public static Patient findPatient(int id, ArrayList<Patient> patients){
        for (Patient pat : patients){
            if (pat.getId() == id){
                return pat;
            }
        }
        return null;
    }

    //Find Doctor by Name
    public static MedicalProfessional findDoctor(String docName, ArrayList<MedicalProfessional> doctors){
        for (MedicalProfessional doc : doctors){
            if ((doc.getDocName()).equals(docName)){
                return doc;
            }
        }
        return null;
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
                String condition = data[4];
                String assignedDoctor = data[5];

                if (age <= 18){
                    patients.add(new PediatricPatient(name, id, age, medicalIssue, condition, assignedDoctor));
                } else if (medicalIssue.equals("Chest Pain")){
                    patients.add(new CardiologyPatient(name, id, age, medicalIssue, condition, assignedDoctor));
                } else if (medicalIssue.equals("Broken Bone")){
                    patients.add(new EmergencyPatient(name, id, age, medicalIssue, condition, assignedDoctor));
                } else{
                    patients.add(new GeneralPatient(name, id, age, medicalIssue, condition, assignedDoctor));
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
