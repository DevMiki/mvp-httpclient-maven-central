package it.core;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.function.Function;

public class EntryToQueryParam implements Function<Map.Entry<String,String>,String> {

    @Override
    public String apply(Map.Entry<String, String> entry) {
        try {
            return URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8.toString()) +
                    "=" +
                    URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
