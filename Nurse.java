public class Nurse extends MedicalProfessional {
    
    public String specialty;

    public Nurse(int docID, String docName, int availability){
        super(docID, docName, availability);
        specialty = "Nurse";
    }

    public void performAction(){
    }

    public String txtPrep(){
        return docID + "," + docName + "," + specialty + "," + availability
    }
}