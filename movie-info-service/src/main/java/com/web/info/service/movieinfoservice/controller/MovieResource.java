package com.web.info.service.movieinfoservice.controller;

import com.web.info.service.movieinfoservice.dto.MovieDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/movies")
public class MovieResource {

    @GetMapping(path = "/{movieID}")
    public MovieDto getMovieInfo(@PathVariable("movieID") String movieID) {

        return new MovieDto("3000","Endgame");

//        return Collections.singletonList(
//                new CatalogItem("Dark","Sci-fi","9")
//        );
    }
}
