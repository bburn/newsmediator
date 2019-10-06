package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.newsapi.NewsApiNews;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Component
class NewsConverter {

    private ObjectMapper objectMapper;

    @PostConstruct
    void init() {
        objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("(yyyy-MM-dd"));
    }

    NewsApiNews convertExternalNewsToInternal(String response) {
        NewsApiNews newsApiNews = null;

        try {
            newsApiNews = objectMapper.readValue(response, NewsApiNews.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newsApiNews;
    }
}