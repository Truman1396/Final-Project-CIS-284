import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // create list of doctors
        ArrayList<MedicalProfessional> doctors = new ArrayList<>();

        // add different doctors
        doctors.add(new Surgeon(101, "John", 1));
        doctors.add(new Nurse(102, "Sarah", 1));
        doctors.add(new Cardiologist(103, "Mike", 0));

        // loop through list
        for (MedicalProfessional d : doctors){
            d.displayInfo();     // show info
            d.performAction();  // show action
            System.out.println();
        }
        
    }
}