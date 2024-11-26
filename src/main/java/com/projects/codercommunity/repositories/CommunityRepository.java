package com.projects.codercommunity.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projects.codercommunity.objects.Community;

@Repository
public interface CommunityRepository extends MongoRepository<Community,String >{
    public Community findCommunityByName(String name);
}
