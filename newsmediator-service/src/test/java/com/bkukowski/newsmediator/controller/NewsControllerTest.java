package com.bkukowski.newsmediator.controller;

import com.bkukowski.newsmediator.model.internal.Article;
import com.bkukowski.newsmediator.model.internal.News;
import com.bkukowski.newsmediator.service.NewsMediatorServiceImpl;
import com.bkukowski.newsmediator.service.UrlProvider;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NewsController.class)
class NewsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewsMediatorServiceImpl newsMediatorService;

    @MockBean
    private UrlProvider urlProvider;

    @Value("${test.newscontrollertest.expectedJSON}")
    private String expectedJSON;

    @Value("${test.newscontrollertest.url}")
    private String url;

    @Value("${test.newscontrollertest.invalidUrl}")
    private String invalidUrl;

    @Test
    void whenValidURL_thenReturnsCorrectJSON() throws Exception {
        Mockito.when(newsMediatorService.getTransformedNewsByCountryAndCategory("pl", "technology")).thenReturn(getNewsMock("pl", "technology"));
        mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().json(expectedJSON));
    }

    @Test
    void whenInValidURL_thenReturnsCorrectJSON() throws Exception {
        mockMvc.perform(get(invalidUrl).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

    private News getNewsMock(String country, String category) throws ParseException {
        Article article = new Article();
        ReflectionTestUtils.setField(article, "author", "Bernard");
        ReflectionTestUtils.setField(article, "title", "Test");
        ReflectionTestUtils.setField(article, "description", "Test test");
        ReflectionTestUtils.setField(article, "date", getExampleDate());
        ReflectionTestUtils.setField(article, "sourceName", "Source");
        ReflectionTestUtils.setField(article, "articleUrl", "Url");
        ReflectionTestUtils.setField(article, "imageUrl", "ImageUrl");
        List<Article> articleList = new ArrayList<>();
        articleList.add(article);
        News news = new News();
        ReflectionTestUtils.setField(news, "articles", articleList);
        news.setCategory(category);
        news.setCountry(country);
        return news;
    }

    private Date getExampleDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2019-10-14";
        return sdf.parse(dateInString);
    }
}