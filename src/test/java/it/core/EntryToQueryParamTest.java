package it.core;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;


class EntryToQueryParamTest {

    @Test
    void apply() {
        Map<String,String> query = new HashMap<>();
        query.put("John"," &");

        final String got = query.entrySet().stream().map(new EntryToQueryParam()).findFirst().get();
        String expected = "John=+%26";

        Assert.assertEquals(expected,got);
    }
}