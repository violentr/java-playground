package simple.code.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

public class Network {
    private String url;
    private int port = 80;
    private String hostname;
    private String request;

    public Network(String url) {
        this.url = url;
    }

    public String buildRequest() {
        return "GET / HTTP/1.1\r\n" +
                "Host: " + hostname + "\r\n" +
                "Connection: close\r\n" +
                "\r\n";
    }

    public void parseURL() {
        try {
            URL destinationUrl = new URL(this.url);
            hostname = destinationUrl.getHost();
            if (destinationUrl.getProtocol().equals("https")) {
                port = 443;
            }


        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL format", e);
        }
    }

    public void processResponse(BufferedReader buffer) {
        try {
            StringBuilder headers = new StringBuilder();
            StringBuilder body = new StringBuilder();
            boolean isBody = false;
            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.isEmpty()) {
                    isBody = true;
                    continue;
                }
                if (isBody) {
                    body.append(line).append("\n");
                } else {
                    headers.append(line).append("\n");
                }

            }
            System.out.println("HEADERS:\n" + headers);
            System.out.println("Body:\n" + body);
        } catch (IOException e) {
            System.err.println("Error reading response: " + e.getMessage());
        }
    }

    public void sendRequest() {
        try (Socket socket = new Socket(hostname, port);
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader bufferedReader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {

            outputStream.write(request.getBytes());
            outputStream.flush();
            processResponse(bufferedReader);
        } catch (IOException e) {
            System.err.println("Request failed: " + e.getMessage());
        }
    }

    public void makeHTTPRequest() {
        parseURL();
        request = buildRequest();
        /* Create a socket and send the request */
        sendRequest();
    }

}
