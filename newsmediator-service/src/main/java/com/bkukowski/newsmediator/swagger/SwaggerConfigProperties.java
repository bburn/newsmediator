package com.bkukowski.newsmediator.swagger;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class SwaggerConfigProperties {

    @Value("${swagger.apiVersion}")
    private String apiVersion;

    @Value("${swagger.enabled}")
    private boolean enabled;

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.useDefaultResponseMessages}")
    private boolean useDefaultResponseMessages;

    @Value("${swagger.enableUrlTemplating}")
    private boolean enableUrlTemplating;
}