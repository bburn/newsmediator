package com.bkukowski.newsmediator.model.internal;

import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@Builder
public class News {

    private String country;
    private String category;
    private List<Article> articles;

    public News setCountry(String country) {
        this.country = country;
        return this;
    }

    public News setCategory(String category) {
        this.category = category;
        return this;
    }
}