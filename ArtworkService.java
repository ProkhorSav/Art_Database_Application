package com.artcollection.service;

import com.artcollection.model.Artwork;
import com.artcollection.repository.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtworkService {
    @Autowired
    private ArtworkRepository artworkRepository;
    public List<Artwork> getAllArtworks() {
        return artworkRepository.findAll();
    }
    public Artwork createArtwork(Artwork artwork) {
        return artworkRepository.save(artwork);
    }
    public void deleteArtwork(Long id) {
        artworkRepository.deleteById(id);
    }
}