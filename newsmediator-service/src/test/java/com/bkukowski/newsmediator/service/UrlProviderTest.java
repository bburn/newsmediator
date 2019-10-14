package com.bkukowski.newsmediator.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UrlProviderTest {

    @Value("${test.urlprovidertest.url}")
    private String expectedURL;

    @Autowired
    private UrlProvider urlProvider;

    @Test
    void whenValidCountryAndCategory_thenValidURL() {
        String url = urlProvider.getUrl("pl", "technology");
        assertEquals(expectedURL, url);
    }

    @Test
    void whenInValidCountryAndCategory_thenValidURL() {
        String url = urlProvider.getUrl("polska", "technologia");
        assertNotEquals(expectedURL, url);
    }
}