package com.ccuk.test.pms;

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
        // Requirement 1. Create a simple order management system for ABC online shop, where customer should be able to purchase items online.
        RestAssuredMockMvc.webAppContextSetup(this.context);
    }

    // Requirement 5. The System should be able to list all orders for a customer
    @Test
    public void shouldFetchAllOrderForCustomer() {
        // when:
        ResponseOptions response = given().get("/v1/com/abc/customers/001/orders/");
        // then:
        assertThat(response.statusCode()).isEqualTo(204);
        // and:
        final JsonPathAssertionUtil jsonPathUtil = new JsonPathAssertionUtil(response.getBody().asString());
        jsonPathUtil.assertJsonPathHasValue("$.customer.id", "001");
        jsonPathUtil.assertJsonPathHasValues("$.customer.orders", "[]");
    }

    //Requirement 4. The System should allow user to create a new order
    @Test
    public void shouldCreateNewOrder() {
        // when:
        ResponseOptions response = given().post("/v1/com/abc/customers/001/orders/");
        // then:
        assertThat(response.statusCode()).isEqualTo(201);
        assertThat(response.header("Location")).isEqualTo(001);
    }

    // Requirement 6. The System should be able to fetch a specific order
    @Test
    public void shouldFetchASpecificOrder() {
        // when:
        ResponseOptions response = given().get("/v1/com/abc/customers/001/orders/001");
        // then:
        assertThat(response.statusCode()).isEqualTo(200);
        // and:
        final JsonPathAssertionUtil jsonPathUtil = new JsonPathAssertionUtil(response.getBody().asString());
        jsonPathUtil.assertJsonPathHasValue("$.order.id", "001");
        jsonPathUtil.assertJsonPathHasValue("$.order.customerId", "001");
        jsonPathUtil.assertJsonPathHasValue("$.order.items", "[]");
    }

    // Requirement 2. The System should allow user to add items to a basket.
    @Test
    public void shouldAddItemAnOrder() {
        // when:
        ResponseOptions response = given().post("/v1/com/abc/customers/001/orders/001/items");
        // then:
        assertThat(response.statusCode()).isEqualTo(201);
        assertThat(response.header("Location")).isEqualTo(001);
    }

    // Requirements 3. The System should allow user to delete items from a basket.
    @Test
    public void shouldDeleteItemToOrder() {
        // when:
        ResponseOptions response = given().delete("/v1/com/abc/customers/001/orders/001/items/001");
        // then:
        assertThat(response.statusCode()).isEqualTo(204);
    }
}