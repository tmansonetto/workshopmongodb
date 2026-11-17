package com.tmansonetto.workshopmongo.services;

import com.tmansonetto.workshopmongo.domain.Post;
import com.tmansonetto.workshopmongo.repository.PostRepository;
import com.tmansonetto.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        String.format("Post with id %s not found", id)));
    }

}
