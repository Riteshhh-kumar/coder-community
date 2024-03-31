package com.projects.codercommunity.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.Tag;

@Repository
public interface TagsRepository extends MongoRepository<Tag, ObjectId>{

}
