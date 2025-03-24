package com.epam.training.gen.ai.config;

import com.azure.ai.openai.OpenAIAsyncClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.core.credential.AzureKeyCredential;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfiguration {
    @Bean
    public OpenAIAsyncClient openAIAsyncClient(OpenAIClientProperties openAIClientProperties) {
        return new OpenAIClientBuilder()
                .credential(new AzureKeyCredential(openAIClientProperties.getKey()))
                .endpoint(openAIClientProperties.getEndpoint())
                .buildAsyncClient();
    }
}
