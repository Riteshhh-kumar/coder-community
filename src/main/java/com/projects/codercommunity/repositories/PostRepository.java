package com.projects.codercommunity.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projects.codercommunity.objects.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    Optional<Post> findPostById(String postId);
    List<Post> findPostByIspublic(Boolean ispublic);
}
