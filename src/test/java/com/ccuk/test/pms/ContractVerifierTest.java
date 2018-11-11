package com.ccuk.test.pms;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.revinate.assertj.json.JsonPathAssert;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.response.ResponseOptions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.withJsonPath;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
public class ContractVerifierTest {

    @Autowired
    WebApplicationContext context;

    @Before
    public void setUp() {
        RestAssuredMockMvc.webAppContextSetup(this.context);
    }

    @Test
    public void validate_shouldReturnEvenWhenRequestParamIsEven() {
        // when:
        ResponseOptions response = given().get("/purchase-management-system/item/10001");
        // then:
        assertThat(response.statusCode()).isEqualTo(200);
        // and:
        DocumentContext responseBody = JsonPath.parse(response.getBody().asString());
        JsonPathAssert.assertThat(responseBody).jsonPathAsString("$.itemId").contains("10001");
        JsonPathAssert.assertThat(responseBody).jsonPathAsString("$.itemName").contains("100 Watt");
        JsonPathAssert.assertThat(responseBody).jsonPathAsString("$.itemDescription").contains("Bulb");


    }
}