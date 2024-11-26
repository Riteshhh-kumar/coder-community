package com.projects.codercommunity.repositories;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projects.codercommunity.objects.User;


@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findUserByUsername(String username);
    User findUserByEmail(String username);
}
