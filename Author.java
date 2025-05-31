package com.artcollection.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer birthYear;
    private Integer deathYear;
    private String country;
    private String artStyle;
    @Column(columnDefinition = "TEXT")
    private String biography;
}