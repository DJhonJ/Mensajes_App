package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion(){
        Connection connection = null;

        if(connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensaje_platzi?serverTimezone=UTC", "root", "");
            }catch (SQLException e) {
                System.out.println(e);
            }
        }

        return connection;
    }
}
