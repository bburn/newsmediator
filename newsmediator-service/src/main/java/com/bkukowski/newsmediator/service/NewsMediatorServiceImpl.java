package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.internal.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsMediatorServiceImpl implements NewsMediatorService {

    @Autowired
    private NewsConverter newsConverter;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UrlProvider urlProvider;

    @Override
    public News getTransformedNewsByCountryAndCategory(String country, String category) {
        return newsConverter.getNewsByNewsApiNews(restTemplate.getForObject(urlProvider.getUrl(country, category),
                String.class)).setCategory(category).setCountry(country);
    }
}
