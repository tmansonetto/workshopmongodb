package com.tmansonetto.workshopmongo.services;

import com.tmansonetto.workshopmongo.domain.Post;
import com.tmansonetto.workshopmongo.repository.PostRepository;
import com.tmansonetto.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        String.format("Post with id %s not found", id)));
    }

    public List<Post> findByTitleContaining(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }

    public List<Post> fullSearch(String title, Date minDate, Date maxDate) {
        maxDate = new  Date(maxDate.getTime()+24*60*60*1000);
        return repo.fullSearch(title, minDate, maxDate);
    }

}
