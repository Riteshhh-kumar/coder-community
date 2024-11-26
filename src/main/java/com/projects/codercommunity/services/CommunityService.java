package com.projects.codercommunity.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.projects.codercommunity.objects.Community;
import com.projects.codercommunity.objects.Post;
import com.projects.codercommunity.objects.UserProfile;
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

    @Autowired
    PostService postService;

    public Community getCommunity(String name) {
        return communityRepository.findCommunityByName(name);
    }


    public List<Community> getAllCommunity() {
        return communityRepository.findAll();
    }



    public String joinCommunity(Map<String, String> payload) {
        mongoTemplate.update(Community.class)
                .matching(Criteria.where("name")
                        .is(payload.get("communityname")))
                .apply(new Update().push("members")
                        .value(payload.get("username")))
                .first();
                        
        mongoTemplate.update(UserProfile.class)
                .matching(Criteria.where("username")
                        .is(payload.get("username")))
                .apply(new Update().push("communities")
                        .value(payload.get("communityname")))
                        .first();
        return "Success";
    }


    public String createPost(Map<String, String> payload) {
            Post post = postService.createPost(payload);
                        
        mongoTemplate.update(Community.class)
                .matching(Criteria.where("name")
                        .is(payload.get("communityname")))
                .apply(new Update().push("posts")
                        .value(post))
                        .first();
        return "Success";
    }
    


}
