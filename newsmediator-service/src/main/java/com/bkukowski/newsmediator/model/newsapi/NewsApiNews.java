package com.bkukowski.newsmediator.model.newsapi;

import lombok.Getter;

import java.util.List;

@Getter
public class NewsApiNews {

    private String status;
    private Integer totalResults;
    private List<NewsApiArticle> articles;
}