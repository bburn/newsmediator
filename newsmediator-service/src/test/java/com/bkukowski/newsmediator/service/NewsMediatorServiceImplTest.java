package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.internal.News;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class NewsMediatorServiceImplTest {

    @TestConfiguration
    static class NewsMediatorServiceImplTestContextConfiguration {

        @Bean
        public NewsMediatorServiceImpl newsMediatorService() {
            return new NewsMediatorServiceImpl();
        }
    }

    @Autowired
    private NewsMediatorServiceImpl newsMediatorService;

    @Test
    void whenValidCountryAndCategory_thenNewsShouldBeReturned() {
        News newsByCountryAndCategory = newsMediatorService.getTransformedNewsByCountryAndCategory("pl", "technology");
        assertEquals("pl", newsByCountryAndCategory.getCountry());
        assertEquals("technology", newsByCountryAndCategory.getCategory());
        assertTrue(newsByCountryAndCategory.getArticles().size() > 0);
    }

    @Test
    void whenInValidCountryAndCategory_thenNewsShouldBeReturnedWithEmptyArticles() {
        News newsByCountryAndCategory = newsMediatorService.getTransformedNewsByCountryAndCategory("polska",
                "technologia");
        assertNotEquals("pl", newsByCountryAndCategory.getCountry());
        assertNotEquals("technology", newsByCountryAndCategory.getCategory());
        assertEquals(0, newsByCountryAndCategory.getArticles().size());
    }
}