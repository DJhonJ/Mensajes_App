package service;

import dao.MessageDAO;
import modelo.Message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MessageService {
    private Message message;
    private MessageDAO messageDAO;

    public MessageService() {
        message = new Message();
        messageDAO = new MessageDAO();
    }

    public void createMessage(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribir mensaje");
        message.setMensaje(scanner.nextLine());

        System.out.println("Escribir nombre");
        message.setAutor(scanner.nextLine());

        messageDAO.createMessageDB(message);
    }

    public void listMessage(){
        try{
            ResultSet resultSet = messageDAO.listMessageDB();
            while(resultSet.next()){
                System.out.println("Id : " + resultSet.getInt("Id"));
                System.out.println("Mensaje : " + resultSet.getString("Mensaje"));
                System.out.println("Autor : " + resultSet.getString("Autor"));
                System.out.println("Fecha : " + resultSet.getString("Fecha"));
                System.out.println("");
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    public void deleteMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id para eliminar el mensaje");
        messageDAO.deleteMessageDB(scanner.nextInt());
    }

    public void updateMessage(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribir nuevo mensaje");
        message.setMensaje(scanner.nextLine());

        System.out.println("Escribir id");
        message.setId(scanner.nextInt());

        messageDAO.updateMessageDB(message);
    }
}