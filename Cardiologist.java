public class Cardiologist extends MedicalProfessional {

    public String specialty;

    // Creates a cardiologist and sets the specialty
    public Cardiologist(int docID, String docName, int availability) {
        super(docID, docName, availability);
        specialty = "Cardiologist";
    }

    // Shows what the cardiologist does
    public void performAction() {
        System.out.println(getDocName() + " checks heart-related problems.");
    }

    // Prepares cardiologist information for saving
    //txtprep Compile
    public String txtPrep() {
        return getDocID() + "," + getDocName() + "," + specialty + "," + availability;
    }
}
