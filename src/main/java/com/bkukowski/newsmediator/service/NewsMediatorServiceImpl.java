package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.newsapi.NewsApiNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsMediatorServiceImpl implements NewsMediatorService {

    @Autowired
    private NewsConverter newsConverter;

    @Override
    public String getTransformedNewsByCountryAndCategory(String country, String category) {
        final String url = String.format("https://newsapi.org/v2/top-headlines?country=%s&category=%s&apiKey=433c622e5dff4edaa34037db0ca93859", country, category);
        RestTemplate restTemplate = new RestTemplate();

        String newsApiNewsResult = restTemplate.getForObject(url, String.class);
        NewsApiNews newsApiNews = newsConverter.convertExternalNewsToInternal(newsApiNewsResult);
        return newsApiNews.getArticles().get(0).getTitle();
    }
}
