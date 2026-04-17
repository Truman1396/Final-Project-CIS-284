public class Surgeon extends MedicalProfessional {
    
    public String specialty;

    public Surgeon(int docID, String docName, int availability){
        super(docID, docName, availability);
        specialty = "Surgeon";
    }

    public void performAction(){ 
    }

    public String txtPrep(){
        return docID + "," + docName + "," + specialty + "," + availability
    }
}