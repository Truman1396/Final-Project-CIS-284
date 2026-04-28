public class FamilyDoctor extends MedicalProfessional {

    //Constructor
    public FamilyDoctor(int docID, String docName, String specialty, int availability){
        super(docID, docName, specialty, availability);
    }

    //Family Doctor Action (abstract method)
    public void performAction(){
        System.out.println(this.getDocName() + " ran vitals and prescribed painkillers");
    }

    //Prepare info for file writing
    public String txtPrep(){
        return this.getDocID() + "," + this.getDocName() + "," + specialty + "," + availability;
    }
}
