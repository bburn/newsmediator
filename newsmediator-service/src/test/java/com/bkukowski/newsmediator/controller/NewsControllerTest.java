package com.bkukowski.newsmediator.controller;

import com.bkukowski.newsmediator.model.internal.Article;
import com.bkukowski.newsmediator.model.internal.News;
import com.bkukowski.newsmediator.service.NewsMediatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NewsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewsMediatorServiceImpl newsMediatorService;

    @Value("${test.newscontrollertest.expectedJSON}")
    private String expectedJSON;

    @Value("${test.newscontrollertest.url}")
    private String url;

    @Value("${test.newscontrollertest.invalidUrl}")
    private String invalidUrl;

    @Test
    void whenValidURL_thenReturnsCorrectJSON() throws Exception {
        // given
        Mockito.when(newsMediatorService.getTransformedNewsByCountryAndCategory(any(), any())).thenReturn(news());

        // when
        mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }

    @Test
    void whenInValidURL_thenReturnsCorrectJSON() throws Exception {
        // when
        mockMvc.perform(get(invalidUrl).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    private News news() {
        return News.builder()
                .articles(Collections.singletonList(article()))
                .category("technology")
                .country("pl")
                .build();
    }

    private Article article() {
        return Article.builder()
                .author("Bernard")
                .title("Test")
                .description("Test test")
                .date(date())
                .sourceName("Source")
                .articleUrl("Url")
                .imageUrl("ImageUrl")
                .build();
    }

    private Date date() {
        final Calendar instance = Calendar.getInstance();
        instance.set(2019, 9, 13);
        return instance.getTime();
    }
}