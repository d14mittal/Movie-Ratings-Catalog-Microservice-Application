package com.web.movie.rating.moviecatalogservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CatalogItem {

    private String name;
    private String description;
    private int rating;

}
