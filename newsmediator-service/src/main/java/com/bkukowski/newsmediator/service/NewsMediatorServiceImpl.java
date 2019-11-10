package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.internal.Article;
import com.bkukowski.newsmediator.model.internal.News;
import com.bkukowski.newsmediator.model.newsapi.NewsApiNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsMediatorServiceImpl implements NewsMediatorService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UrlProvider urlProvider;

    @Override
    public News getTransformedNewsByCountryAndCategory(String country, String category) {
        final String url = url(country, category);
        final NewsApiNews newsApiNews = get(url);

        return News.builder()
                .articles(articles(newsApiNews))
                .country(country)
                .category(category)
                .build();
    }

    private NewsApiNews get(String url) {
        return restTemplate.getForObject(url, NewsApiNews.class);
    }

    private String url(String country, String category) {
        return urlProvider.getUrl(country, category);
    }

    private List<Article> articles(NewsApiNews response) {
        return response.getArticles().stream()
                .map(Article::new)
                .collect(Collectors.toList());
    }
}
