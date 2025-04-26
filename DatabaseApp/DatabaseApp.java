import java.sql.*;

public class DatabaseApp {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            // 1. Connect ke database (otomatis buat file database baru jika belum ada)
            String url = "jdbc:sqlite:mahasiswa.db"; // file database: mahasiswa.db
            conn = DriverManager.getConnection(url);

            if (conn != null) {
                System.out.println("Koneksi berhasil ke database.");

                // 2. Membuat table (hanya sekali saja buat)
                String sqlCreateTable = "CREATE TABLE IF NOT EXISTS mahasiswa ("
                        + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + " nim TEXT NOT NULL,"
                        + " nama TEXT NOT NULL,"
                        + " nilai REAL"
                        + ");";
                Statement stmt = conn.createStatement();
                stmt.execute(sqlCreateTable);

                // 3. Insert data
                String sqlInsert = "INSERT INTO mahasiswa (nim, nama, nilai) VALUES ('221078967', 'Rama Pranata', 90.0)";
                stmt.execute(sqlInsert);

                // 4. Query data
                String sqlSelect = "SELECT * FROM mahasiswa";
                ResultSet rs = stmt.executeQuery(sqlSelect);

                System.out.println("\nData Mahasiswa:");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " | "
                            + rs.getString("nim") + " | "
                            + rs.getString("nama") + " | "
                            + rs.getDouble("nilai"));
                }

                rs.close();
                stmt.close();
            }

        } catch (SQLException e) {
            System.out.println("Error koneksi: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Koneksi ditutup.");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
