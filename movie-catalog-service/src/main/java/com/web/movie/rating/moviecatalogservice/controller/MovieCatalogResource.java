package com.web.movie.rating.moviecatalogservice.controller;

import com.web.movie.rating.moviecatalogservice.dto.CatalogItem;
import com.web.movie.rating.moviecatalogservice.dto.MovieDto;
import com.web.movie.rating.moviecatalogservice.dto.RatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/catalog")
public class MovieCatalogResource {

    @Autowired
    private WebClient.Builder webClientBuilder;


    @GetMapping(path = "/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID) {

        List<RatingDto> ratingList = new ArrayList<>();
//        ratingList.add(new RatingDto("123", 9));
//        ratingList.add(new RatingDto("124", 7));
//        ratingList.add(new RatingDto("126", 8));

        RatingDto rating = webClientBuilder.build()
                .get().uri("http://localhost:8083/ratingsdata/{movieID}")
                .retrieve().bodyToMono(RatingDto.class).block();
//k

        List<CatalogItem> catalogItemList = new ArrayList<>();
        for (RatingDto ratingDto : ratingList) {

            MovieDto movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/" + ratingDto.getMovieID())
                    .retrieve()
                    .bodyToMono(MovieDto.class)
                    .block();

//            MovieDto movie = restTemplate.getForObject("http://localhost:8082/movies/" + ratingDto.getMovieID(), MovieDto.class);
            catalogItemList.add(new CatalogItem(movie.getMovieName(), "descrition", ratingDto.getRating()));
        }
        return catalogItemList;
    }


}
