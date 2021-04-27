package program;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class NetClient {
    public static void main(String[] args) {
        try {
            List<InetClient> inetClients = new ArrayList<InetClient>();
            inetClients.add(new InetClient(new Socket(InetAddress.getLocalHost(), 7071), "Anton", 1000));
            inetClients.add(new InetClient(new Socket(InetAddress.getLocalHost(), 7071), "Arsen", 3000));
            inetClients.add(new InetClient(new Socket(InetAddress.getLocalHost(), 7071), "Andrew", 9000));

            for (var i : inetClients ) {
                i.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
