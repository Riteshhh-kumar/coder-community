package com.projects.codercommunity.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.projects.codercommunity.objects.Comment;
import com.projects.codercommunity.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.projects.codercommunity.objects.Post;
import com.projects.codercommunity.objects.UserProfile;
import com.projects.codercommunity.repositories.PostRepository;
import com.projects.codercommunity.repositories.UserProfileRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    MongoTemplate momgoTemplate;

    @Autowired
    UserProfileRepository userProfile;

    public List<Post> allPost() {
        return postRepository.findPostByIspublic(true);
    }

    public Optional<Post> postById(String Id) {
        return postRepository.findPostById(Id);
    }

    public Post createPost(Map<String, String> payload) {
        Post post = new Post();
        post.setUser(payload.get("username"));
        post.setDescription(payload.get("description"));
        post.setIspublic(Boolean.valueOf(payload.get("isPublic")));
        post.setTags(Arrays.asList(payload.get("tags").split(";")));
        post.setDate(LocalDateTime.now());
        post.setComments(new ArrayList<>());
        String postId = String.valueOf(Long.parseLong(payload.get("username"), 32))
        +String.valueOf(System.currentTimeMillis());
        post.setId(postId);

        
        momgoTemplate.update(UserProfile.class)
                .matching(Criteria.where("username")
                        .is(payload.get("username")))
                .apply(new Update().addToSet("posts")
                        .value(post))
                        .first();
        postRepository.insert(post);
        
        return post;
    }
    
    public Comment addComment(Map<String,String> payload){
        Comment comment = new Comment();
        comment.setUser(payload.get("username"));
        comment.setBody(payload.get("body"));
        comment.setDate(LocalDateTime.now());
        comment.setVotes("0");

        comment = commentRepository.insert(comment);

        momgoTemplate.update(Post.class)
                .matching(Criteria.where("id")
                        .is(payload.get("id")))
                .apply(new Update().push("comments")
                        .value(comment))
                .first();
        
        return comment;
    }
}
