package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.internal.News;

public interface NewsMediatorService {

    News getTransformedNewsByCountryAndCategory(String country, String category);
}