package program.udpdatagrams;

import java.io.IOException;
import java.net.*;

public class Receiver {
    public static void main(String[] args) {
        try {
            byte[] buf = new byte[1024];
            DatagramSocket dsReceiver = new DatagramSocket(3000, InetAddress.getLocalHost());
            DatagramPacket dPacketReceiver = new DatagramPacket(buf, buf.length);

            dsReceiver.receive(dPacketReceiver);
            String str = new String(dPacketReceiver.getData(), 0, dPacketReceiver.getLength());
            System.out.println(str);
            dsReceiver.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
