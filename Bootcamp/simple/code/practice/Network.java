package simple.code.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

public class Network {

    public static void makeHTTPRequest(String url) {
        try {
            URL destinationUrl = new URL(url);
            String hostname = destinationUrl.getHost();

            String request = "GET / HTTP/1.1\r\n" +
                    "Host: " + hostname + "\r\n" +
                    "Connection: close\r\n" +
                    "\r\n";

            try (Socket socket = new Socket(hostname, 80);
                 OutputStream outputStream = socket.getOutputStream();
                 BufferedReader bufferedReader = new BufferedReader(
                         new InputStreamReader(socket.getInputStream()))) {

                outputStream.write(request.getBytes());
                outputStream.flush();

                StringBuilder headers = new StringBuilder();
                StringBuilder body = new StringBuilder();
                boolean isBody = false;
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.isEmpty()){
                        isBody = true;
                        continue;
                    }
                    if (isBody) {
                        body.append(line).append("\n");
                    }else{
                        headers.append(line).append("\n");
                    }

                }
                System.out.println("HEADERS:\n" + headers);
                System.out.println("Body:\n" + body);
            }

        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Request failed: " + e.getMessage());
        }
    }
}
