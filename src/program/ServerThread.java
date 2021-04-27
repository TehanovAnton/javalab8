package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread {
    private PrintStream os;
    private BufferedReader is;
    private InetAddress addr;
    public ServerThread(Socket s) throws IOException {
        os  =  new PrintStream(s.getOutputStream());
        is  =  new BufferedReader(
                new InputStreamReader(s.getInputStream()));
        addr = s.getInetAddress();
    }

    public void run(){
        String str;
        try{
            for (int i = 0; i < 3; i++){
                os.println("message" + i);
                System.out.println("sent" + i);
            }
            os.println("END");

//            while ((str = is.readLine()) !=  null){
//                if ("P".equals(Character.toString(str.charAt(0)))){
//                    os.println("PONG" + str + ++i);
//                    System.out.println("PING-PONG " + i + " with " + addr.getHostName());
//                }
//            }
        } finally {
            disconnect();
        }
    }

    public void disconnect(){
        try{
            if (os != null){
                os.close();
            }

            if (is != null){
                is.close();
            }

            System.out.println(addr.getHostName() + " disconnecting");

        } catch (IOException e){
            e.printStackTrace();
        } finally{
            this.interrupt();
        }
    }
}
