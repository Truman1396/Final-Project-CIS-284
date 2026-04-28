public class Pediatrician extends MedicalProfessional {

    //Constructor
    public Pediatrician(int docID, String docName, String specialty, int availability){
        super(docID, docName, specialty, availability);
    }

    //Pediatrician action (abstract method)
    public void performAction(){
        System.out.println(this.getDocName() + " ran vitals and gave patient a lollipop");
    }

    //Prepare info for file writing
    public String txtPrep(){
        return this.getDocID() + "," + this.getDocName() + "," + specialty + "," + availability;
    }
}
