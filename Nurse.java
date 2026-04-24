public class Nurse extends MedicalProfessional {

    public String specialty;

    // creates a nurse and sets the specialty
    public Nurse(int docID, String docName, int availability) {
        super(docID, docName, availability);
        specialty = "Nurse";
    }

    // shows   what the nurse do
    public void performAction() {
        System.out.println(getDocName() + " assists patients and doctors.");
    }

    // it  prepares nurse information for saving
    public String txtPrep() {
        return getDocID() + "," + getDocName() + "," + specialty + "," + availability;
    }
}
