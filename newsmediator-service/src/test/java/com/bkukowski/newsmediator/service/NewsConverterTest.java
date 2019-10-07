package com.bkukowski.newsmediator.service;

import com.bkukowski.newsmediator.model.internal.News;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NewsConverterTest {

    private static final String downloadedJSONFromNewsApi =
            "{\"status\":\"ok\",\"totalResults\":70," + "\"articles" + "\":[{\"source\":{\"id\":null," + "\"name" +
                    "\":\"Spidersweb.pl\"},\"author\":\"http://facebook" + ".com/pgkrzywy" + "\",\"title" +
                    "\":\"Huawei Mate 30 i Mate 30 Pro w Europie – znamy ceny - Spider's Web\"," + "\"description" +
                    "\":\"Huawei Mate 30 i Huawei Mate 30 Pro trafiają na Stary Kontynent. Wiemy już, w jakich " +
                    "cenach " + "będzie można kupić nowe smartfony chińskiej firmy.\",\"url\":\"https://www" +
                    ".spidersweb" + ".pl/2019/10" + "/huawei-mate-30-pro-ceny-gdzie-kupic.html\"," + "\"urlToImage" +
                    "\":\"https://ocs-pl.oktawave" + ".com/v1" + "/AUTH_2887234e-384a-4873-8bc5" + "-405211db13a2" +
                    "/spidersweb/2019/09/huawei-mate-30.jpg\"," + "\"publishedAt" + "\":\"2019-10-05T15" + ":01:50Z" +
                    "\",\"content\":\"Huawei Mate 30 i Huawei Mate 30 Pro trafiaj na " + "Stary " + "Kontynent" + ". " +
                    "Wiemy ju, w jakich cenach bdzie mona kupi nowe smartfony chiskiej firmy.\\r\\nWszystko " +
                    "wskazywao na to, e Huawei Mate 30 i Huawei Mate 30 Pro oka si hitami. W wyniku zaostrzenia si " + "wojny " + "handlowej po… [+1832 chars]\"}]}";

    @Autowired
    private NewsConverter newsConverter;

    @Test
    void convertExternalNewsToInternalTest() {
        News news = newsConverter.convertExternalNewsToInternal(downloadedJSONFromNewsApi);
        assertNotNull(news);
        assertFalse(news.getArticles().isEmpty());
        assertEquals(1, news.getArticles().size());
        assertEquals("Spidersweb.pl", news.getArticles().get(0).getSourceName());
    }
}