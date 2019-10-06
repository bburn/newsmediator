package com.bkukowski.newsmediator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @GetMapping(value = "/news/{country}/{category}/")
    public String getNews(@PathVariable(name = "country") String country, @PathVariable(name = "category") String category) {
        return String.format("country = %s and category = %s", country, category);
    }
}
