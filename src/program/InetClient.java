package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class InetClient extends Thread {
    public Socket socket;
    public BufferedReader inbound;
    public PrintStream outbound;
    public String name;
    public int timeout;

    public InetClient(Socket socket, String name, int timeout) throws IOException {
        this.socket = socket;
        this.inbound = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.outbound = new PrintStream(socket.getOutputStream());
        this.name = name;
        this.timeout = timeout;
    }

    public void Go() throws InterruptedException, IOException {
        while (true){
            String s = inbound.readLine();
            if (s.equals("END")){
                System.out.println(s + " with" + name);
                break;
            }

            System.out.println(s);
            Thread.sleep(timeout);
        }
    }

    @Override
    public void run() {
        try {
            Go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
