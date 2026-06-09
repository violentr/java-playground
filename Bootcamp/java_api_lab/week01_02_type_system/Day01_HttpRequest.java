package java_api_lab.week01_02_type_system;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Day01_HttpRequest {
    public static void main(String[] args) {
        try{
            URI uri = URI.create("https://httpbin.org/get");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri).header("User-Agent", "Mozilla/5.0")
                    .GET()
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}