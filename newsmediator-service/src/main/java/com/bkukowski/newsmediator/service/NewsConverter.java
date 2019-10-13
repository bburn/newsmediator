package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.internal.News;
import com.bkukowski.newsmediator.model.newsapi.NewsApiNews;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Component
@Slf4j
class NewsConverter {

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${json.simpledateformat}")
    private String dateFormat;

    @PostConstruct
    void init() {
        objectMapper.setDateFormat(new SimpleDateFormat(dateFormat));
    }

    News getNewsByNewsApiNews(String response) {
        NewsApiNews newsApiNews = null;

        try {
            newsApiNews = objectMapper.readValue(response, NewsApiNews.class);
        } catch (IOException e) {
            log.error("Mapping: Error found: {}", e);
        }
        if (newsApiNews != null) {
            return new News(newsApiNews);
        }
        return new News();
    }
}