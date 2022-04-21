package com.web.movie.rating.moviecatalogservice.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RatingDto {

    private String movieID;
    private int rating;

}
