package ui;

import service.MessageService;

import java.util.Scanner;

public class UIMessage {
    public static void menu(){
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        MessageService messageService = new MessageService();

        do{
            System.out.println("------------");
            System.out.println("1. crear mensaje");
            System.out.println("2. listar mensajes");
            System.out.println("3. editar mensaje");
            System.out.println("4. eliminar mensaje");
            System.out.println("5. salir");
            opcion = scanner.nextInt();

            switch(opcion){
                case 1:
                    messageService.createMessage();
                    break;
                case 2:
                    messageService.listMessage();
                    break;
                case 3:
                    messageService.updateMessage();
                    break;
                case 4:
                    messageService.deleteMessage();
                    break;
            }

        }while( opcion != 5 );

    }
}
