package program.Examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(java.lang.String[] args){
        try(Socket clientSocket = new Socket("localhost", 3000);
            OutputStream outbound = clientSocket.getOutputStream();
            BufferedReader inbound = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));) {

            System.out.println("Client: " + clientSocket);

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter groupNumber: ");
            int group = scan.nextInt();
            outbound.write((group+"\n").getBytes());

            String topStudent;
            while (true){
                topStudent = inbound.readLine();

                if(topStudent.length() == 0)
                    continue;
                if(topStudent.equals("End"))
                    break;

                System.out.println("Got the student for " + group+":" + topStudent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
