import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conectar(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensaje_platzi?serverTimezone=UTC", "root", "");
            System.out.println("conexion exitosa");
        }catch (SQLException e) {
            System.out.println(e);
        }

        return connection;
    }
}
