package it.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.mappings.ResObj;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class SimplePostTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        final HashMap<String, String> values = new HashMap<>();
        values.put("John","Doe");
        values.put("Mike","Bollman");

        final ObjectMapper objectMapper = new ObjectMapper();
        final String requestBody = objectMapper.writeValueAsString(values);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/post"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        final ResObj resObj = objectMapper.readValue(response.body(), ResObj.class);
        System.out.println(resObj.getHeaders().getxAmznTraceId());
    }

}
