package com.web.movie.rating.moviecatalogservice.controller;

import com.web.movie.rating.moviecatalogservice.dto.CatalogItem;
import com.web.movie.rating.moviecatalogservice.dto.MovieDto;
import com.web.movie.rating.moviecatalogservice.dto.RatingDto;
import com.web.movie.rating.moviecatalogservice.dto.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/catalog")
public class MovieCatalogResource {

//    LogManager log = new LogManager(MovieCatalogResource.class);

    @Autowired
    private WebClient.Builder webClientBuilder;


    @GetMapping(path = "/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID) {

        Mono<UserRating> ratingList = webClientBuilder.build()
                .get().uri("http://ratings-data-service/ratingsdata/users/" + userID, UserRating.class)
                .retrieve()
                .bodyToMono(UserRating.class);

        List<CatalogItem> catalogItemList = new ArrayList<>();
        for (RatingDto ratingDto : ratingList.block().getRatingDtoList()) {

            Mono<MovieDto> movie = webClientBuilder.build()
                    .get()
                    .uri("http://movie-info-service/movies/" + ratingDto.getMovieID())
                    .retrieve()
                    .bodyToMono(MovieDto.class);

//            MovieDto movie = restTemplate.getForObject("http://localhost:8082/movies/" + ratingDto.getMovieID(), MovieDto.class);

            catalogItemList.add(new CatalogItem(movie.block().getMovieName(), "descrition", ratingDto.getRating()));
        }
        return catalogItemList;
    }
}
