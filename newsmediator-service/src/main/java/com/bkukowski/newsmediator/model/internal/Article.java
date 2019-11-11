package com.bkukowski.newsmediator.model.internal;

import com.bkukowski.newsmediator.model.newsapi.NewsApiArticle;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@Builder
public class Article {

    private String author;
    private String title;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String sourceName;
    private String articleUrl;
    private String imageUrl;

    public static Article of(NewsApiArticle newsApiArticle) {
        if (newsApiArticle != null) {
            return Article.builder()
                    .author(newsApiArticle.getAuthor())
                    .title(newsApiArticle.getTitle())
                    .description(newsApiArticle.getDescription())
                    .date(newsApiArticle.getPublishedAt())
                    .sourceName(newsApiArticle.getSource().getName())
                    .articleUrl(newsApiArticle.getUrl())
                    .imageUrl(newsApiArticle.getUrlToImage())
                    .build();
        }
        return Article.builder().build();
    }
}