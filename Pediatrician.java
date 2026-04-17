public class Pediatrician extends MedicalProfessional {
    
    public String specialty;

    public Pediatrician(int docID, String docName, int availability){
        super(docID, docName, availability);
        specialty = "Pediatrician";
    }

    public void performAction(){
    }

    public String txtPrep(){
        return docID + "," + docName + "," + specialty + "," + availability
    }
}
