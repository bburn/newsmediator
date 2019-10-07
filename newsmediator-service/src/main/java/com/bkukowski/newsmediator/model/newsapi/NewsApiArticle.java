package com.bkukowski.newsmediator.model.newsapi;

import lombok.Getter;

@Getter
public class NewsApiArticle {

    private NewsApiSource source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
}