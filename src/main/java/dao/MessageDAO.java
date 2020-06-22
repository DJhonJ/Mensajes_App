package dao;

import modelo.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDAO {
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public MessageDAO() {
        connection = Conexion.getConexion();
    }

    public static void createMessageDB(Message message) {
        try {
            String query = "insert into Mensaje (Mensaje, Autor) values (?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, message.getMensaje());
            preparedStatement.setString(2, message.getAutor());
            preparedStatement.executeUpdate();
            System.out.println("mensaje creado");

        }catch (SQLException e){
           System.out.println(e);
        }
    }

    public static ResultSet listMessageDB(){
        ResultSet resultSet = null;
        try {
            String query = "select Id, Mensaje, Autor, Fecha from Mensaje";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        }catch (SQLException ex) {
            System.out.println(ex);
        }

        return resultSet;
    }

    public static void deleteMessageDB(int id) {
        try{
            String query = "delete from Mensaje where Id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Mensaje eliminado");
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    public static void updateMessageDB(Message message){
        try {
            String query = "update Mensaje set Mensaje = ? where Id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, message.getMensaje());
            preparedStatement.setInt(2, message.getId());
            preparedStatement.executeUpdate();
            System.out.println("Mensaje con el id " + message.getId() + " actualizado");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
