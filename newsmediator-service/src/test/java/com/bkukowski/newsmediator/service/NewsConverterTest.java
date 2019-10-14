package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.internal.News;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class NewsConverterTest {

    @Value("${test.jsonExample}")
    private String downloadedJSONFromNewsApi;

    @Value("${test.sourceFromJsonExample}")
    private String sourceFromJsonExample;

    @Value("${test.invalidJsonExample}")
    private String invalidJSONExample;

    @Autowired
    private NewsConverter newsConverter;

    @Test
    void whenValidJSON_thenCorrectSourceNameAndArticles() {
        News news = newsConverter.getNewsByNewsApiNews(downloadedJSONFromNewsApi);
        assertEquals(1, news.getArticles().size());
        assertEquals(sourceFromJsonExample, news.getArticles().get(0).getSourceName());
    }

    @Test
    void whenInValidJSON_thenNoArticles() {
        News news = newsConverter.getNewsByNewsApiNews(invalidJSONExample);
        assertEquals(0, news.getArticles().size());
    }

    @Test
    void whenNull_thenThrowException() {
        assertThrows(NullPointerException.class, () -> newsConverter.getNewsByNewsApiNews(null));
    }
}