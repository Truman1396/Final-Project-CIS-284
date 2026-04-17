public class Cardiologist extends MedicalProfessional {
    
    public String specialty;

    public Cardiologist(int docID, String docName, int availability){
        super(docID, docName, availability);
        specialty = "Cardiologist";
    }

    public void performAction(){
    }

    public String txtPrep(){
        return docID + "," + docName + "," + specialty + "," + availability
    }
}