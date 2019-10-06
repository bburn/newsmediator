package com.bkukowski.newsmediator.controller;

import com.bkukowski.newsmediator.service.NewsMediatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    private NewsMediatorServiceImpl newsMediatorService;

    @GetMapping(value = "/news/{country}/{category}/")
    public String getNews(@PathVariable(name = "country") String country, @PathVariable(name = "category") String category) {
        return newsMediatorService.getTransformedNewsByCountryAndCategory(country, category);
    }
}
