package com.tmansonetto.workshopmongo.repository;


import com.tmansonetto.workshopmongo.domain.Post;
import com.tmansonetto.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

}
