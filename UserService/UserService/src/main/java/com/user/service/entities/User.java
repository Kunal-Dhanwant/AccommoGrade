package com.user.service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
@Entity
@Table

public class User {
   @Id
   private String userId;

   @Column(name = "NAME", length = 15)
   private  String name;
   @Column(name = "PASSWORD")
   private String password;
    @Column(name = "EMAIL")
    private String email;

    @Column(length = 200)
    private  String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
