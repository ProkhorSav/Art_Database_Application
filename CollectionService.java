package com.artcollection.service;

import com.artcollection.model.Collection;
import com.artcollection.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {
    @Autowired
    private CollectionRepository collectionRepository;
    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }
    public Collection createCollection(Collection collection) {
        return collectionRepository.save(collection);
    }
}