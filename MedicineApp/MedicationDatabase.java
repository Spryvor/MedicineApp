public class MedicationDatabase {
    private Connection conn;

    public MedicationDatabase(String dbFile) {
        // Initialize Database connection
    }

    public void createTable() {
        // SQL to create medications table
    }

    public void addMedication(Medication med) {
        // Insert med into DB
    }

    public List<Medication> getAllMedications() {
        // Return all the meds from dataabse
    }
}

