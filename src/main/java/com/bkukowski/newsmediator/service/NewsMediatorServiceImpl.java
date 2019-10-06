package com.bkukowski.newsmediator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsMediatorServiceImpl implements NewsMediatorService {

    @Override
    public String getTransformedNewsByCountryAndCategory(String country, String category) {
        final String url = String.format("https://newsapi.org/v2/top-headlines?country=%s&category=%s&apiKey=433c622e5dff4edaa34037db0ca93859", country, category);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
