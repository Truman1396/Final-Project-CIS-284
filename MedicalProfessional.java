public abstract class MedicalProfessional {

    //Class Variables
    private int docID;
    private String docName;
    public int availability;
    public String specialty;

    //empty constructor
    public MedicalProfessional(){
    }

    //Constructor
    public MedicalProfessional(int docID, String docName, String specialty, int availability){

        this.docID = docID;
        this.docName = docName;
        this.specialty = specialty;
        this.availability = availability;
    }

    //getter methods
    public int getDocID(){
        return docID;
    }

    public String getDocName(){
        return docName;
    }

    public int getAvailability(){
        return availability;
    }

    public String getSpecialty(){
        return specialty;
    }

    //Checks if a doctor is available
    public void checkAvailable(){
        if (availability == 1){
            System.out.println("Doctor " + docName + " is available");
        } else{
            System.out.println("Doctor " + docName + " is not available");
        }
    }

    //Changes doctor's availability
    public void changeAvailable(){
        if (availability == 1){
            availability = 0;
        } else if (availability == 0){
            availability = 1;
        }
    }

    //Abstract methods
    public abstract void performAction();

    public abstract String txtPrep();

    //Display doctor info
    public void displayInfo(){
        System.out.println("Doctor ID: " + docID + ", Doctor Name: " + docName + " (" + specialty + ")");
        this.checkAvailable();
    }
}
