import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.time.LocalTime;

public class MedicationForm extends VBox {

    private TextField nameField;
    private TextField dosageField;
    private TextField frequencyField;
    private Spinner<Integer> hourSpinner;
    private Spinner<Integer> minuteSpinner;
    private Button submitButton;

    public MedicationForm() {
        // Spacing and Padding
        this.setSpacing(12);
        this.setPadding(new Insets(16));

        // Medication Name
        Label nameLabel = new Label("Medication Name:");
        nameField = new TextField();
        nameField.setPromptText("e.g., Ibuprofen");

        // Dosage
        Label dosageLabel = new Label("Dosage:");
        dosageField = new TextField();
        dosageField.setPromptText("e.g., 200 mg");

        // Frequency
        Label frequencyLabel = new Label("Frequency (hours):");
        frequencyField = new TextField();
        frequencyField.setPromptText("e.g., 8");

        // Time input using Spinners
        Label timeLabel = new Label("Time (HH:MM):");
        hourSpinner = new Spinner<>(0, 23, 8);
        minuteSpinner = new Spinner<>(0, 59, 0);
        hourSpinner.setEditable(true);
        minuteSpinner.setEditable(true);

        // Button
        submitButton = new Button("Add Medication");

        // Add everything to the layout
        this.getChildren().addAll(
            nameLabel, nameField,
            dosageLabel, dosageField,
            frequencyLabel, frequencyField,
            timeLabel, hourSpinner, minuteSpinner,
            submitButton
        );
    }

    // Getters for collected data:

    public String getMedicationName() {
        return nameField.getText();
    }

    public String getDosage() {
        return dosageField.getText();
    }

    public int getFrequencyHours() {
        try {
            return Integer.parseInt(frequencyField.getText());
        } catch (NumberFormatException e) {
            return 0; // default or handle differently if needed
        }
    }

    public LocalTime getTime() {
        return LocalTime.of(hourSpinner.getValue(), minuteSpinner.getValue());
    }

    public Button getSubmitButton() {
        return submitButton;
    }
}
