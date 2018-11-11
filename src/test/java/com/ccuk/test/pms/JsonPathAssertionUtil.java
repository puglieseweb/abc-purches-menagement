package com.ccuk.test.pms;

import com.jayway.jsonpath.JsonPath;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathAssertionUtil {


    private final String jsonString;

    public JsonPathAssertionUtil(final String jsonString) {
        this.jsonString = jsonString;

    }

    public void assertJsonPathHasValue(final String jsonPath, final String value) {
        assertThat((String) JsonPath.read(jsonString, jsonPath)).isEqualTo(value);
    }

    public void assertJsonPathHasValues(String jsonPath, String value) {
        assertThat((String) JsonPath.read(jsonString, jsonPath)).isEqualTo(value);
    }
}
