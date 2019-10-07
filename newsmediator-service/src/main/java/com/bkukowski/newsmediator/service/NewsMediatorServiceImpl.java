package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.internal.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsMediatorServiceImpl implements NewsMediatorService {

    private static final String MAIN_URL = "https://newsapi.org/v2/";
    private static final String TOP_HEADLINES = "top-headlines";
    private static final String API_KEY = "&apiKey=433c622e5dff4edaa34037db0ca93859";

    @Autowired
    private NewsConverter newsConverter;

    @Override
    public News getTransformedNewsByCountryAndCategory(String country, String category) {
        final String url = String.format("%s%s?country=%s&category=%s%s", MAIN_URL, TOP_HEADLINES, country, category, API_KEY);
        RestTemplate restTemplate = new RestTemplate();

        String newsApiNewsResult = restTemplate.getForObject(url, String.class);
        return newsConverter.convertExternalNewsToInternal(newsApiNewsResult).addCategory(category).addCountry(country);
    }
}
