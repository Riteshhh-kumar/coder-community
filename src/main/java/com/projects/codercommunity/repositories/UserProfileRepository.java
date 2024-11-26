package com.projects.codercommunity.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projects.codercommunity.objects.UserProfile;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, ObjectId>{
	UserProfile findUserByUsername(String username);

}
