package com.dkmaia.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dkmaia.mongo.doman.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
