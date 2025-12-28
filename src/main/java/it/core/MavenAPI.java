package it.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.mappings.MvnRespObj;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static it.core.Console.lineReader;

public class MavenAPI {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("What's the groupId?");
        String groupId = lineReader();
        System.out.println("What's the ArtifactId?");
        String artifactId = lineReader();
        final Map<String, String> hashMap = paramsToMap(groupId,artifactId);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://search.maven.org/solrsearch/select?%s", mapToUrl(hashMap))))
                .GET()
                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
//        gli faccio ignorare le proprietà che non conosce
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        final MvnRespObj resObj = objectMapper.readValue(response.body(), MvnRespObj.class);

        IntStream.range(0,resObj.getResponse().getDocs().size()).forEach(i -> System.out.println(resObj.getResponse().getDocs().get(i)));
    }

    private static Map<String, String> paramsToMap(String groupId, String ArtifactId) {
        return new HashMap<>() {{
                put("q", "g:\""+groupId+"\" AND a:\""+ArtifactId+"\"");
                put("core", "gav");
                put("rows", "20");
                put("wt", "json");
            }};
    }

    private static String mapToUrl(Map<String, String> map) {
        final List<String> params = map
                .entrySet()
                .stream()
                .map(new EntryToQueryParam())
                .collect(Collectors.toList());


        return String.join("&", params);
    }

}
