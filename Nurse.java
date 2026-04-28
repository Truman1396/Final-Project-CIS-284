public class Nurse extends MedicalProfessional {

    //Constructor
    public Nurse(int docID, String docName, String specialty, int availability){
        super(docID, docName, specialty, availability);
    }

    //Nurse Action (abstract method)
    public void performAction(){
        System.out.println(this.getDocName() + " confirmed patient's availability for discharge");
    }

    //Prepare info for file writing
    public String txtPrep(){
        return this.getDocID() + "," + this.getDocName() + "," + specialty + "," + availability;
    }
}
