package com.web.data.service.ratingsdataservice.dto;


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
