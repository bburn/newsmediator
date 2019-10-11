package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.internal.News;
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

    News getNewsByNewsApiNews(String response) {
        NewsApiNews newsApiNews = null;

        try {
            newsApiNews = objectMapper.readValue(response, NewsApiNews.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (newsApiNews != null) {
            return new News(newsApiNews);
        }
        return new News();
    }
}