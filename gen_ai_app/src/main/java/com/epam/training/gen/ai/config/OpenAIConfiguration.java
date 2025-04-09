package com.epam.training.gen.ai.config;

import com.azure.ai.openai.OpenAIAsyncClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.core.credential.AzureKeyCredential;
import org.springframework.beans.factory.annotation.Value;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@Getter
public class OpenAIConfiguration {

    @Value("${client.openai.deploymentName}")
    private String deploymentName;


    public static final String API_KEY = "Api-Key";

    @Value("${client.openai.key}")
    private String AZURE_CLIENT_KEY;

    @Bean
    public OpenAIAsyncClient openAIAsyncClient(OpenAIClientProperties openAIClientProperties) {
        return new OpenAIClientBuilder()
                .credential(new AzureKeyCredential(openAIClientProperties.getKey()))
                .endpoint(openAIClientProperties.getEndpoint())
                .buildAsyncClient();
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(
                List.of(
                        (request, body, execution) -> {
                            request.getHeaders().set(API_KEY, AZURE_CLIENT_KEY);
                            return execution.execute(request, body);
                        }));
        return restTemplate;
    }
}
