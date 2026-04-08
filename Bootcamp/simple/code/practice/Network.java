package simple.code.practice;

import javax.net.ssl.SSLSocketFactory;
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
    private String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/120.0.0.0";

    public Network(String url) {
        this.url = url;
    }
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    private String buildRequest(String hostname) {
        return new StringBuilder()
                .append("GET / HTTP/1.1\r\n")
                .append("Host: ")
                .append(hostname)
                .append("\r\n")
                .append("User-Agent:").append(userAgent)
                .append("\r\n")
                .append("Connection: close\r\n")
                .append("\r\n").toString();
    }

    private String parseURL() {
        try {
            URL destinationUrl = new URL(this.url);
            String hostname = destinationUrl.getHost();
            if (destinationUrl.getProtocol().equals("https")) {
                port = 443;
            }
            return hostname;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL format", e);
        }
    }

    private void processResponse(BufferedReader buffer) {
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
    /* pure function does not depend on hidden state */
    private Socket createSocket(String hostname, int port) throws IOException {
        return (port == 443)
                ? SSLSocketFactory.getDefault().createSocket(hostname, port)
                : new Socket(hostname, port);
    }
    private void sendRequest(String hostname, String request) {
        try (Socket socket = createSocket(hostname, port);
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
        String hostname = parseURL();
        String request = buildRequest(hostname);
        /* Create a socket and send the request */
        sendRequest(hostname, request);
    }

}
