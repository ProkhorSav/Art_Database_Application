package com.artcollection.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Collection collection;
    private Integer yearCreated;
    private String technique;
    private String genre;
    private Double widthCm;
    private Double heightCm;
    private String status;
    private Double estimatedValue;
    private String imageUrl;
    private java.time.LocalDate addedAt = java.time.LocalDate.now();
}