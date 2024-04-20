package com.projects.codercommunity.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.projects.codercommunity.objects.Community;
import com.projects.codercommunity.repositories.CommunityRepository;
import com.projects.codercommunity.repositories.UserProfileRepository;


@Service
public class CommunityService {

    @Autowired
    CommunityRepository communityRepository;
    @Autowired
    UserProfileRepository UserProfileRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public Community getCommunity(Map<String, String> payload) {
        return communityRepository.findCommunityByName(payload.get("name"));
    }

    public void joinCommunity(Map<String, String> payload) {
        
        return ;
    }
    


}
