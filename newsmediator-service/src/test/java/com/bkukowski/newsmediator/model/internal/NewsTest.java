package com.bkukowski.newsmediator.model.internal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NewsTest {

    @Test
    void whenSetCountryAndCategory_thenExpectedCountryAndCategory() {
        // when
        final News news = News.builder().category("technology").country("pl").build();

        // then
        assertThat(news.getCountry()).isEqualTo("pl");
        assertThat(news.getCategory()).isEqualTo("technology");
        assertThat(news.getArticles()).isNull();
    }

}