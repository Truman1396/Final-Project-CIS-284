public class Surgeon extends MedicalProfessional {
    
    //Constructor
    public Surgeon(int docID, String docName, String specialty, int availability){
        super(docID, docName, specialty, availability);
    }

    //Surgeon action (abstract method)
    public void performAction(){
        System.out.println(this.getDocName() + " performed a successful surgery, set a cast, and prescribed pain medication");
    }

    //Prepare info for file writing
    public String txtPrep(){
        return this.getDocID() + "," + this.getDocName() + "," + specialty + "," + availability;
    }
}
