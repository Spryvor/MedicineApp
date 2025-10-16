import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class MedicationDatabase {

    private static final String DB_URL = "jdbc:sqlite:medications.db";

    public MedicationDatabase() {
        createTableIfNotExists();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void createTableIfNotExists() {
        String sql = """
        CREATE TABLE IF NOT EXISTS medications (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            dosage TEXT NOT NULL,
            time TEXT NOT NULL,
            frequencyHours INTEGER NOT NULL
        );
        """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    public void addMedication(Medication med) {
        String sql = "INSERT INTO medications (name, dosage, time, frequencyHours) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, med.getName());
            pstmt.setString(2, med.getDosage());
            pstmt.setString(3, med.getTime().toString());  // Store LocalTime as string
            pstmt.setInt(4, med.getFrequencyHours());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error adding medication: " + e.getMessage());
        }
    }

    public List<Medication> getAllMedications() {
        List<Medication> meds = new ArrayList<>();
        String sql = "SELECT * FROM medications";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dosage = rs.getString("dosage");
                LocalTime time = LocalTime.parse(rs.getString("time"));
                int freq = rs.getInt("frequencyHours");

                Medication med = new Medication(id, name, dosage, time, freq);
                meds.add(med);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving medications: " + e.getMessage());
        }

        return meds;
    }
}
