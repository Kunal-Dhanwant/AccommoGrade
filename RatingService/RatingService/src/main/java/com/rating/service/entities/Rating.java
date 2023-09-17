package com.rating.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table
public class Rating {

    @Id
    private String ratingId;
    private  String userId;
    private  String hotelId;
    private String feedback;
    private  int rating;
}

