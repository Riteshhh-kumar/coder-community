package com.projects.codercommunity.controllers;

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

@RestController
@RequestMapping("/community")
@CrossOrigin
public class CommunityController {

    @Autowired
    CommunityService communityService;

    public ResponseEntity<Community> getCommunity(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Community>(communityService.getCommunity(payload),HttpStatus.OK);
    }
}
