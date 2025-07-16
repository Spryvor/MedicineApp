public class ReminderApp {
    public static void main(String[] args) {
        MedicationDatabase db = new MedicationDatabase("meds.db");
        db.createTable();
        List<Medication> meds = db.getAllMedications();

        ReminderScheduler scheduler = new ReminderScheduler();
        scheduler.scheduleReminders(meds);

        // Open JavaFX GUI (e.g., new MedicationForm())
    }
}
