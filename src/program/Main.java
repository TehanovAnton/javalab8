package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    static void ReadHtmlPage(){
        URL tut = null;
        String urlName = "http://www.tut.by";

        try {
            tut  =  new URL(urlName);
        } catch (MalformedURLException e) {
            // некорректно заданы протокол, доменное имя или путь к файлу
            e.printStackTrace();
        }

        if (tut == null) {
            throw new RuntimeException();
        }

        try (BufferedReader d = new BufferedReader (new InputStreamReader(tut.openStream()))) {
            String line = "";
            while ((line = d.readLine()) != null) {
                System.out.println(line);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void InfoAboutConnection(){
        String urlName = "http://www.onliner.com";
        int timeout = 10_000;
        URL url;

        try {
            url = new URL(urlName);
            final URLConnection connection = url.openConnection();
            connection.setConnectTimeout(timeout);

            System.out.println(urlName + " content type: "+ "\n" + connection.getContentType() +
                    "\n" + connection.getClass() + "\n" + connection.getContentLength());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //ReadHtmlPage();

        InfoAboutConnection();
    }
}
