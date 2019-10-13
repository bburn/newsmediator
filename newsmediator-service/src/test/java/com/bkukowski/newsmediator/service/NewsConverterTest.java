package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.internal.News;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NewsConverterTest {

    @Value("${test.jsonExample}")
    private String downloadedJSONFromNewsApi;

    @Value("${test.sourceFromJsonExample}")
    private String sourceFromJsonExample;

    @Autowired
    private NewsConverter newsConverter;

    @Test
    void convertExternalNewsToInternalTest() {
        News news = newsConverter.getNewsByNewsApiNews(downloadedJSONFromNewsApi);
        assertEquals(1, news.getArticles().size());
        assertEquals(sourceFromJsonExample, news.getArticles().get(0).getSourceName());
    }
}