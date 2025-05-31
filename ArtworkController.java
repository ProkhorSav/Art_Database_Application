package com.artcollection.controller;

import com.artcollection.model.Artwork;
import com.artcollection.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artworks")
public class ArtworkController {
    @Autowired
    private ArtworkService artworkService;

    @GetMapping
    public List<Artwork> getAllArtworks() {
        return artworkService.getAllArtworks();
    }

    @PostMapping
    public Artwork createArtwork(@RequestBody Artwork artwork) {
        return artworkService.createArtwork(artwork);
    }

    @DeleteMapping("/{id}")
    public void deleteArtwork(@PathVariable Long id) {
        artworkService.deleteArtwork(id);
    }
}