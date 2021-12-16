package kata5p1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
    public static void crearTabla() {
        String url = "jdbc:sqlite:KATA5.db";
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
            + " Id integer PRIMARY KEY AUTOINCREMENT,\n"
            + " Mail text NOT NULL);";
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }
    private static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:KATA5.db";
            conn = DriverManager.getConnection(url);
            String sql = "SELECT * FROM PEOPLE";
            try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("Name") + "\t" +
                    rs.getString("Apellidos") + "\t" +
                    rs.getString("Departamento") + "\t");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            crearTabla();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}