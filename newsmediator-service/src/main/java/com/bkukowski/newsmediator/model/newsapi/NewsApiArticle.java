package com.bkukowski.newsmediator.model.newsapi;

import lombok.Getter;

import java.util.Date;

@Getter
public class NewsApiArticle {

    private NewsApiSource source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private Date publishedAt;
    private String content;
}