package com.bkukowski.newsmediator.model.internal;

import com.bkukowski.newsmediator.model.newsapi.NewsApiNews;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class News {

    private String country;
    private String category;
    private List<Article> articles;

    public News(NewsApiNews newsApiNews) {
        this.articles = new ArrayList<>();
        this.articles = newsApiNews.getArticles().stream().map(newsApiArticle -> new Article(newsApiArticle)).collect(Collectors.toList());
    }

    public News addCountry(String country) {
        this.country = country;
        return this;
    }

    public News addCategory(String category) {
        this.category = category;
        return this;
    }
}