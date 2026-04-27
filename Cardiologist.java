public class Cardiologist extends MedicalProfessional {

    public Cardiologist(int docID, String docName, String specialty, int availability){

        super(docID, docName, specialty, availability);
    }

    public void performAction(){
    }

    public String txtPrep(){
        return this.getDocID() + "," + this.getDocName() + "," + specialty + "," + availability;
    }
}
