public class ReminderApp {
    public static void main(String[] args) {
        MedicationDatabase db = new MedicationDatabase("meds.db");
        db.createTable();
        List<Medication> meds = db.getAllMedications();

        ReminderScheduler scheduler = new ReminderScheduler();
        scheduler.scheduleReminders(meds);

        // Make JavaFX Gui like new MedicationForm()
        // Do this later focus on main program first
        // Priority level 3
    }
}

