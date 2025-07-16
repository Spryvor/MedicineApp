import java.time.LocalTime;

public class Medication {
    private int id;
    private String name;
    private String dosage;
    private LocalTime time;
    private int frequencyHours;

    // Full constructor
    public Medication(int id, String name, String dosage, LocalTime time, int frequencyHours) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.time = time;
        this.frequencyHours = frequencyHours;
    }

    // Constructor without ID (e.g., before DB assigns it)
    public Medication(String name, String dosage, LocalTime time, int frequencyHours) {
        this(0, name, dosage, time, frequencyHours);
    }

    // Constructor with name and dosage only
    public Medication(String name, String dosage) {
        this(0, name, dosage, LocalTime.of(8, 0), 24); // default time: 8:00 AM, every 24 hrs
    }

    // Constructor with name only
    public Medication(String name) {
        this(name, "1 pill");
    }

    // Constructor with no arguments (default values)
    public Medication() {
        this("Unknown");
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDosage() {
        return dosage;
    }
    public LocalTime getTime() {
        return time;
    }
    public getFrequencyHours() {
        return frequencyHours;
    }
    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }   
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public void setFrequencyHours(int frequencyHours) {
        this.frequencyHours = frequencyHours;
    }   
    
}

public class PrescriptionMed extends Medication {
    private String prescribingDoctor;
    private String prescriptionDate;
    private String pharmacyName;

    // Full constructor
    public PrescriptionMed(int id, String name, String dosage, LocalTime time, int frequencyHours,
                           String prescribingDoctor, String prescriptionDate, String pharmacyName) {
        super(id, name, dosage, time, frequencyHours);
        this.prescribingDoctor = prescribingDoctor;
        this.prescriptionDate = prescriptionDate;
        this.pharmacyName = pharmacyName;
    }
    // Constructor without ID
    public PrescriptionMed(String name, String dosage, LocalTime time, int frequencyHours,
                           String prescribingDoctor, String prescriptionDate, String pharmacyName) {
        this(0, name, dosage, time, frequencyHours, prescribingDoctor, prescriptionDate, pharmacyName);
    }
    // Constructor with name and dosage only
    public PrescriptionMed(String name, String dosage) {
        this(name, dosage, LocalTime.of(8, 0), 24, "Unknown Doctor", "Unknown Date", "Unknown Pharmacy");
    }
    // Constructor with name only
    public PrescriptionMed(String name) {
        this(name, "1 pill");
    }
    // Constructor with no arguments (default values)
    public PrescriptionMed() {
        this("Unknown");
    }

    // Getters
    public String getPrescribingDoctor() {
        return prescribingDoctor;
    }
    public String getPrescriptionDate() {
        return prescriptionDate;
    }
    public String getPharmacyName() {
        return pharmacyName;
    }
    // Setters
    public void setPrescribingDoctor(String prescribingDoctor) {
        this.prescribingDoctor = prescribingDoctor;
    }
    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }
    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

public class OverTheCounterMed extends Medication {
    private String manufacturer;
    private String expirationDate;
    private String activeIngredients;

    // Full constructor
    public OverTheCounterMed(int id, String name, String dosage, LocalTime time, int frequencyHours,
                             String manufacturer, String expirationDate, String activeIngredients) {
        super(id, name, dosage, time, frequencyHours);
        this.manufacturer = manufacturer;
        this.expirationDate = expirationDate;
        this.activeIngredients = activeIngredients;
    }
    // Constructor without ID
    public OverTheCounterMed(String name, String dosage, LocalTime time, int frequencyHours,
                             String manufacturer, String expirationDate, String activeIngredients) {
        this(0, name, dosage, time, frequencyHours, manufacturer, expirationDate, activeIngredients);
    }
    // Constructor with name and dosage only
    public OverTheCounterMed(String name, String dosage) {
        this(name, dosage, LocalTime.of(8, 0), 24, "Unknown Manufacturer", "Unknown Date", "Unknown Ingredients");
    }
    // Constructor with name only
    public OverTheCounterMed(String name) {
        this(name, "1 pill");
    }
    // Constructor with no arguments (default values)
    public OverTheCounterMed() {
        this("Unknown");
    }
    
    // Getters
    public String getManufacturer() {
        return manufacturer;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public String getActiveIngredients() {
        return activeIngredients;
    }

    // Setters
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public void setActiveIngredients(String activeIngredients) {
        this.activeIngredients = activeIngredients;
    }

    @Override public String toString() {
        return "OverTheCounterMed{" +
                "name='" + getName() + '\'' +
                ", dosage='" + getDosage() + '\'' +
                ", time=" + getTime() +
                ", frequencyHours=" + getFrequencyHours() +
                ", manufacturer='" + manufacturer + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", activeIngredients='" + activeIngredients + '\'' +
                '}';
    }
}