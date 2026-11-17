package com.tmansonetto.workshopmongo.resources;

import com.tmansonetto.workshopmongo.domain.Post;
import com.tmansonetto.workshopmongo.domain.User;
import com.tmansonetto.workshopmongo.dto.UserDTO;
import com.tmansonetto.workshopmongo.resources.util.URL;
import com.tmansonetto.workshopmongo.services.PostService;
import com.tmansonetto.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping (value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value="/{id}" , method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/titlesearch" , method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam (value="text",defaultValue = "")String text) throws UnsupportedEncodingException {
        text = URL.decodeParam(text);
        List<Post> obj = service.findByTitleContaining(text);
        return ResponseEntity.ok().body(obj);
    }

}
