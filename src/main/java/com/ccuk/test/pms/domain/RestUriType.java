package com.ccuk.test.pms.domain;

public enum RestUriType {
    CUSTOMER_ACCOUNTS_URI("/v1/com/abc/accounts"),
    ORDERS_URI("/orders"),
    ITEMS("/items");

    private final String uri;

    RestUriType(final String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public String concat(RestUriType uriType) {
        return this.getUri().concat(uriType.getUri());
    }
}
