package com.projects.codercommunity.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projects.codercommunity.objects.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, ObjectId>{

}
