package program.udpdatagrams;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Sender {
    public static void main(String[] args) {
        try {
            String message = "hello world";
            DatagramSocket dSocket = new DatagramSocket();
            DatagramPacket dPacket = new DatagramPacket(message.getBytes(), message.length(),
                    InetAddress.getLocalHost(), 3000);

            dSocket.send(dPacket);
            dSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
