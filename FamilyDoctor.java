public class FamilyDoctor extends MedicalProfessional {
    
    public String specialty;

    public FamilyDoctor(int docID, String docName, int availability){
        super(docID, docName, availability);
        specialty = "Family Doctor";
    }

    public void performAction(){
    }

    public String txtPrep(){
        return docID + "," + docName + "," + specialty + "," + availability
    }
}