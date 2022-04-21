package com.web.data.service.ratingsdataservice.controller;


import com.web.data.service.ratingsdataservice.dto.RatingDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ratingsdata")
public class RatingResource {

    @GetMapping(path = "/{movieID}")
    public RatingDto getCatalog(@PathVariable("movieID") String movieID) {
        return new RatingDto(movieID, "5");


    }

}
