public abstract class MedicalProfessional {

    private int docID;
    private String docName;
    public int availability;

    // empty constructor
    public MedicalProfessional() {
    }

    // sets the doctor's ID, name, and availability
    public MedicalProfessional(int docID, String docName, int availability) {
        this.docID = docID;
        this.docName = docName;
        this.availability = availability;
    }

    // returns the doctor's ID
    public int getDocID() {
        return docID;
    }

    // returns the doctor's name
    public String getDocName() {
        return docName;
    }

    // prints if the doctor is available or not
    public void isAvailable() {
        if (availability == 1) {
            System.out.println("Doctor " + docName + " is available");
        } else {
            System.out.println("Doctor " + docName + " is not available");
        }
    }

    // changes availability between available and not available
    public void changeAvailable() {
        if (availability == 1) {
            availability = 0;
        } else if (availability == 0) {
            availability = 1;
        }
    }

    // each doctor class must define its own action
    public abstract void performAction();

    // each doctor class must prepare its info for text storage
    public abstract String txtPrep();

    // prints the doctor's basic information
    public void displayInfo() {
        System.out.println("Doctor ID: " + docID);
        System.out.println("Doctor Name: " + docName);
        this.isAvailable();
    }
}
