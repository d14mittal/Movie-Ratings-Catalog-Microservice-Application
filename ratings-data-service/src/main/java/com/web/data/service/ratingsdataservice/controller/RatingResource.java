package com.web.data.service.ratingsdataservice.controller;


import com.web.data.service.ratingsdataservice.dto.RatingDto;
import com.web.data.service.ratingsdataservice.dto.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/ratingsdata")
public class RatingResource {

    @GetMapping(path = "/{movieID}")
    public RatingDto getCatalog(@PathVariable("movieID") String movieID) {
        return new RatingDto(movieID, 5);
    }

    @GetMapping(path = "/users/{userID}")
    public UserRating getUserRatings(@PathVariable("userID") String userID){
        List<RatingDto> ratingList = Arrays.asList(
                new RatingDto("123", 9),
                new RatingDto("124", 7),
                new RatingDto("126", 8));
        UserRating userRating = new UserRating();
        userRating.setRatingDtoList(ratingList);
        return userRating;
    }

}
