public class Cardiologist extends MedicalProfessional {

    public String specialty;

    // this creates a   cardiologist and sets the specialty
    public Cardiologist(int docID, String docName, int availability) {
        super(docID, docName, availability);
        specialty = "Cardiologist";
    }

    // shows what the cardiologist do
    public void performAction() {
        System.out.println(getDocName() + " checks heart-related problems.");
    }

    // prepares cardiologist information for saving
    //txtprep Compile
    public String txtPrep() {
        return getDocID() + "," + getDocName() + "," + specialty + "," + availability;
    }
}
