package com.bkukowski.newsmediator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UrlProviderTest {

    @Value("${test.urlprovidertest.url}")
    private String expectedURL;

    @Autowired
    private UrlProvider urlProvider;

    @Test
    void whenValidCountryAndCategory_thenValidURL() {
        // when
        final String url = urlProvider.getUrl("pl", "technology");

        // then
        assertThat(url).isEqualTo(expectedURL);
    }

    @Test
    void whenInValidCountryAndCategory_thenValidURL() {
        // when
        final String url = urlProvider.getUrl("polska", "technologia");

        // then
        assertThat(url).isNotEqualTo(expectedURL);
    }
}