package com.projects.codercommunity.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projects.codercommunity.objects.Chat;

@Repository
public interface ChatRepository extends MongoRepository<Chat, ObjectId>{

}
