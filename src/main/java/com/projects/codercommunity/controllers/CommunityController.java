package com.projects.codercommunity.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.codercommunity.objects.Community;
import com.projects.codercommunity.services.CommunityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/community")
@CrossOrigin
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @GetMapping("/{name}")    
    public ResponseEntity<Community> getCommunity(@PathVariable String name) {
        
        return new ResponseEntity<Community>(communityService.getCommunity(name), HttpStatus.OK);
    }


    @GetMapping("/getall")    
    public ResponseEntity<List<Community>> getAllCommunity() {
        return new ResponseEntity<List<Community>>(communityService.getAllCommunity(), HttpStatus.OK);
    }

    @PostMapping("/join")    
    public ResponseEntity<String> joinCommuntity(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<String>(communityService.joinCommunity(payload), HttpStatus.OK);
    }

    @PostMapping("/posts/create")    
    public ResponseEntity<String> createPost(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<String>(communityService.createPost(payload), HttpStatus.OK);
    }
}
