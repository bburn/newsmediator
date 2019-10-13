package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.internal.News;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsMediatorServiceImpl implements NewsMediatorService {

    @Value("${service.mainUrl}")
    private String mainUrl;
    @Value("${service.topHeadlines}")
    private String topHeadlines;
    @Value("${service.apiKey}")
    private String apiKey;

    @Autowired
    private NewsConverter newsConverter;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public News getTransformedNewsByCountryAndCategory(String country, String category) {
        final String url = String.format("%s%s?country=%s&category=%s&%s", mainUrl, topHeadlines, country, category,
                apiKey);
        String newsApiNewsResult = restTemplate.getForObject(url, String.class);
        return newsConverter.getNewsByNewsApiNews(newsApiNewsResult).addCategory(category).addCountry(country);
    }
}
