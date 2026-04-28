public class Cardiologist extends MedicalProfessional {

    //Constructor
    public Cardiologist(int docID, String docName, String specialty, int availability){
        super(docID, docName, specialty, availability);
    }

    //Cardiologist action (abstract method)
    public void performAction(){
        System.out.println(this.getDocName() + " ran an EKG and prescribed blood pressure medicine");
    }

    //Preparing info for file writing
    public String txtPrep(){
        return this.getDocID() + "," + this.getDocName() + "," + specialty + "," + availability;
    }
}
