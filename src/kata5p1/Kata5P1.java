
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    private static Connection connect() {
    // SQLite connection string
        String url = "jdbc:sqlite:Kata5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        
        try (Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
        // Bucle sobre el conjunto de registros.
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" +
            rs.getString("Name") + "\t" +
            rs.getString("Apellidos") + "\t" +
            rs.getString("Departamento") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createNewTable() {
        // Cadena de conexión SQLite
        String url = "jdbc:sqlite:KATA5.db";
        // Instrucción SQL para crear nueva tabla
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " Mail text NOT NULL);";
        
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            // Se crea la nueva tabla
            stmt.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
       selectAll();
       createNewTable();
    }
    
}
