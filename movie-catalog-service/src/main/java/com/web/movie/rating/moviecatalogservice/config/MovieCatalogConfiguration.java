package com.web.movie.rating.moviecatalogservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MovieCatalogConfiguration {

    @Bean
    public WebClient.Builder getWebClient(){
        return WebClient.builder();
        }

}
