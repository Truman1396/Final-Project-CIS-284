public class Surgeon extends MedicalProfessional {
    
    public Surgeon(int docID, String docName, String specialty, int availability){

        super(docID, docName, specialty, availability);
    }

    public void performAction(){
    }

    public String txtPrep(){
        return this.getDocID() + "," + this.getDocName() + "," + specialty + "," + availability;
    }
}
