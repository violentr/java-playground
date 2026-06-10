package java_api_lab.week01_02_type_system;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Day01_HttpRequest {
    public static void makeRequest(HttpClient httpClient, String url) {
        try{
            HttpRequest http = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(http, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            System.out.println(response.statusCode());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();
        makeRequest(httpClient, "https://www.httpbin.org/get");
    }
}