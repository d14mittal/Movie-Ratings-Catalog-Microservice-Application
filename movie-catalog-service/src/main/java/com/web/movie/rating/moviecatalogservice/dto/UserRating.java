package com.web.movie.rating.moviecatalogservice.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRating {

    private List<RatingDto> ratingDtoList;
}
