public abstract class MedicalProfessional {

    private int docID;
    private String docName;
    public int availability;

    public MedicalProfessional(){
    }

    public MedicalProfessional(int docID, String docName, int availability){

        this.docID = docID;
        this.docName = docName;
        this.availability = 1;
    }

    public int getDocID(){
        return docID;
    }

    public String getDocName(){
        return docName;
    }

    public void isAvailable(){
        if (availability == 1){
            System.out.println("Doctor " + docName + " is available");
        } else{
            System.out.println("Doctor " + docName + " is not available");
        }
    }

    public void changeAvailable(){
        if (availability == 1){
            availability = 0;
        } else if (availability == 0){
            availability = 1;
        }
    }

    public abstract void performAction();

    public abstract String txtPrep();

    public void displayInfo(){
        System.out.println("Doctor ID: " + docID);
        System.out.println("Doctor Name: " + docName);
        this.isAvailable();
    }
}