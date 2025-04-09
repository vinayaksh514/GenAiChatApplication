package com.epam.training.gen.ai.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
public class HTTPClientConfiguration {

    @Bean
    public HttpClient httpClient(@Value("${client.openai.key}") String openaiKey,
                                 @Value("${client.openai.endpoint}") String openaiEndpoint){
        return HttpClient.newHttpClient();
    }

}
