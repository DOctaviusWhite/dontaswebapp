package mobile.tiy.dontaswebapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Donta White on 5/11/2016.
 */
public class ChatClient {

    public void sendMessage(String message)throws Exception{

        Socket clientSocket = new Socket("172.168.4.14", 8005);


        while (true){
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Scanner lineScanner = new Scanner(System.in);



            System.out.println(">");

            if (message.equals("exit")) {
                clientSocket.close();
                //System.exit(0);
            }
            out.println(message);
            if (message.equals("history")) {
                String serverResponse;
                while ((serverResponse = input.readLine()) != null) {
                    System.out.println("server:" + serverResponse);
                    if (serverResponse.equals("Message received loud and clear"))
                        System.out.println(serverResponse);
                    {
                        break;
                    }
                }
            }


        }




    }



}
