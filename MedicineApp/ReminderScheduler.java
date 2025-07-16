public class ReminderScheduler {
    private Timer timer;

    public void scheduleReminders(List<Medication> meds) {
        for (Medication med : meds) {
            scheduleSingleReminder(med);
        }
    }

    private void scheduleSingleReminder(Medication med) {
        // Use java.util.Timer or ScheduledExecutorService
        // Show JOptionPane popup or system tray notification
    }
}
