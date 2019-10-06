package com.bkukowski.newsmediator.swagger;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class SwaggerConfigProperties {

    private String apiVersion = "0.1";
    private String enabled = "true";
    private String title = "NewsMediator";
    private String description = "Proxy between front-end app and NewsApi";
    private boolean useDefaultResponseMessages = false;
    private boolean enableUrlTemplating = false;
}