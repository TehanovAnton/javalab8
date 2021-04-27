package program;

import program.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServerThread {
    public static void main(java.lang.String[] args){
        try {
            ServerSocket server = new ServerSocket(7071);

            while (true){
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress().getHostName() + " connected");

                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
