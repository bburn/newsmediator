package com.bkukowski.newsmediator.model.internal;

import com.bkukowski.newsmediator.model.newsapi.NewsApiArticle;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class Article {

    private String author;
    private String title;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String sourceName;
    private String articleUrl;
    private String imageUrl;

    Article(NewsApiArticle newsApiArticle) {
        if (newsApiArticle != null) {
            this.author = newsApiArticle.getAuthor();
            this.title = newsApiArticle.getTitle();
            this.description = newsApiArticle.getDescription();
            this.date = newsApiArticle.getPublishedAt();
            this.sourceName = newsApiArticle.getSource().getName();
            this.articleUrl = newsApiArticle.getUrl();
            this.imageUrl = newsApiArticle.getUrlToImage();
        }
    }
}