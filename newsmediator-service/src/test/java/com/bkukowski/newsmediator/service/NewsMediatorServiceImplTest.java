package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.internal.News;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;

@SpringBootTest
class NewsMediatorServiceImplTest {

    private static final String RESPONSE_BODY = "{ \n" +
            "   \"status\":\"ok\",\n" +
            "   \"totalResults\":70,\n" +
            "   \"articles\":[ \n" +
            "      { \n" +
            "         \"source\":{ \n" +
            "            \"id\":null,\n" +
            "            \"name\":\"Tabletowo.pl\"\n" +
            "         },\n" +
            "         \"author\":\"Krzysztof Swoboda\",\n" +
            "         \"title\":\"Jaki smartfon do 1200 złotych warto kupić? (listopad 2019) - Tabletowo.pl\",\n" +
            "         \"description\":\"\",\n" +
            "         \"url\":\"https://www.tabletowo.pl/jaki-smartfon-do-1200-zlotych-warto-kupic-listopad-2019/\",\n" +
            "         \"urlToImage\":\"https://www.tabletowo.pl/wp-content/uploads/2018/08/smartfony-do-600-złotych-tabletowo-sierpień-2018-07.jpg\",\n" +
            "         \"publishedAt\":\"2019-11-10T13:22:08Z\",\n" +
            "         \"content\":\"Nie raz i nie dwa pisaem, e rynek telefonów ze redniej póki cenowej przeszed na przestrzeni ostatnich dwóch lat wielk metamorfoz. Koronnym przykadem s polecane smartfony do 1200 zotych, które dzi dla Was przygotowaem. Zaczynajmy!\\r\\nPartnerem wpisu jest Media E… [+9452 chars]\"\n" +
            "      },\n" +
            "      { \n" +
            "         \"source\":{ \n" +
            "            \"id\":null,\n" +
            "            \"name\":\"Chip.pl\"\n" +
            "         },\n" +
            "         \"author\":\"Wintermute\",\n" +
            "         \"title\":\"Jesienna ofensywa AMD: nowe procesory i chipsety - CHIP\",\n" +
            "         \"description\":\"AMD jest obecnie na fali wznoszącej i jeżeli wierzyć planom, które firma przedstawiła ostatnio w kwestii kolejnych modeli procesorów, zamierza na tej fali pozostać.. Niebawem w ofercie AMD pojawią się zarówno najnowsze i najbardziej wydajne CPU w historii tej…\",\n" +
            "         \"url\":\"https://www.chip.pl/2019/11/jesienna-ofensywa-amd-nowe-procesory-i-chipsety/\",\n" +
            "         \"urlToImage\":\"https://www.chip.pl/uploads/2019/08/rgGol3v8kkBHsKGwdZpT90XFYw4F9pSS.jpg\",\n" +
            "         \"publishedAt\":\"2019-11-10T12:15:00Z\",\n" +
            "         \"content\":\"Zacznijmy od krótkiej listy wyjaniajcej, co nowego pojawi si niebawem, jeszcze w tym miesicu, w ofercie detalicznej AMD:\\r\\n<ul><li>16-rdzeniowy, topowy procesor dla komputerów stacjonarnych: AMD Ryzen 9 3950X</li><li>Trzecia generacja rodziny ukadów AMD Ryzen … [+3903 chars]\"\n" +
            "      }\n" +
            "   ]\n" +
            "}";

    private static final String EMPTY_RESPONSE_BODY = "{ \n" +
            "   \"status\":\"ok\",\n" +
            "   \"totalResults\":0,\n" +
            "   \"articles\":[]\n" +
            "}";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NewsMediatorServiceImpl newsMediatorService;

    private MockRestServiceServer mockServer;

    @BeforeEach
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }


    @Test
    void whenValidCountryAndCategory_thenNewsShouldBeReturned() throws URISyntaxException {
        // given
        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("https://newsapi.org/v2/top-headlines?country=pl&category=technology&pageSize=100&apiKey=dummy-key")))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withSuccess(RESPONSE_BODY, MediaType.APPLICATION_JSON_UTF8));


        // when
        final News news = newsMediatorService.getTransformedNewsByCountryAndCategory("pl", "technology");

        // then
        assertThat(news.getCountry()).isEqualTo("pl");
        assertThat(news.getCategory()).isEqualTo("technology");
        assertThat(news.getArticles()).hasSize(2);
    }

    @Test
    void whenInValidCountryAndCategory_thenNewsShouldBeReturnedWithEmptyArticles() throws URISyntaxException {
        // given
        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("https://newsapi.org/v2/top-headlines?country=polska&category=technologia&pageSize=100&apiKey=dummy-key")))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withSuccess(EMPTY_RESPONSE_BODY, MediaType.APPLICATION_JSON_UTF8));

        // when
        final News news = newsMediatorService.getTransformedNewsByCountryAndCategory("polska",
                "technologia");

        // then
        assertThat(news.getCountry()).isNotEqualTo("pl");
        assertThat(news.getCategory()).isNotEqualTo("technology");
        assertThat(news.getArticles()).hasSize(0);
    }
}