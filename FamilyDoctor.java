public class FamilyDoctor extends MedicalProfessional {

    public String specialty;

    //  family doctor and sets the specialty
    public FamilyDoctor(int docID, String docName, int availability) {
        super(docID, docName, availability);
        specialty = "Family Doctor";
    }

    // shows what the family doctor does
    public void performAction() {
        System.out.println(getDocName() + " treats general health problems.");
    }

    // prepares family doctor information for saving
    public String txtPrep() {
        return getDocID() + "," + getDocName() + "," + specialty + "," + availability;
    }
}
