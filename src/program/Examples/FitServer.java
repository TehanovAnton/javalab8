package program.Examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FitServer {
    public static void main(java.lang.String[] args){
        Socket client = null;
        BufferedReader inbound = null;
        OutputStream outbound = null;

        List<String> gr3 = new ArrayList<String>();
        gr3.add( "Mikhail");
        gr3.add("Aleksander");
        gr3.add( "Lena");
        gr3.add("Nikita");

        try(ServerSocket serverSocket = new ServerSocket(3000);) {
            System.out.println("Waiting for a student request...");

            while (true){
                client = serverSocket.accept();

                inbound = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                outbound = client.getOutputStream();

                String symbol = inbound.readLine();
                String student = gr3.get((int)Math.random() * 3);

                outbound.write(
                        ("\n The top student of " + symbol + " is " + student + "\n").getBytes());
                System.out.println("Request for " + symbol + " has been processed - the top student of "
                        + symbol+  " is " + student + "\n" );

                outbound.write(("End\n").getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try{
                inbound.close();
                outbound.close();
            } catch(Exception e){
                System.out.println("FitServer: can't close streams" + e.getMessage());
            }
        }

    }
}
