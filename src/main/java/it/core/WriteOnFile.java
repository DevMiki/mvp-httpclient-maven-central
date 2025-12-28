package it.core;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class WriteOnFile {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://zetcode.com/java/httpclient/"))
                .GET()
                .build();

        String fileName = "/Users/michelemarino/Desktop/output/output.html";

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get(fileName)));
        System.out.println(response.statusCode());
    }


}
