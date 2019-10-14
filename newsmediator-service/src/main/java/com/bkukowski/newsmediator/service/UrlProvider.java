package com.bkukowski.newsmediator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlProvider {

    @Value("${service.mainUrl}")
    private String mainUrl;

    @Value("${service.topHeadlines}")
    private String topHeadlines;

    @Value("${service.apiKey}")
    private String apiKey;

    @Value("${service.pageSize}")
    private String pageSize;

    String getUrl(String country, String category) {
        return String.format("%s%s?country=%s&category=%s&%s&%s", mainUrl, topHeadlines, country, category,
                pageSize, apiKey);
    }
}
