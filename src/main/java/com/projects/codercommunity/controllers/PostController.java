package com.projects.codercommunity.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.projects.codercommunity.objects.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.projects.codercommunity.objects.Post;
import com.projects.codercommunity.services.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {

	@Autowired
	PostService pService;

	@GetMapping("/allpost")
	public ResponseEntity<List<Post>> allPost() {

		return new ResponseEntity<List<Post>>(pService.allPost(), HttpStatus.OK);
	}

	@GetMapping("/{Id}")
	public ResponseEntity<Optional<Post>> postById(@PathVariable String Id) {

		return new ResponseEntity<Optional<Post>>(pService.postById(Id), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Post> createPost(@RequestBody Map<String,String> payload) {
		
		
		return new ResponseEntity<Post>(pService.createPost(payload),HttpStatus.CREATED);
	}

	@PostMapping("/addComment")
	public ResponseEntity<Comment> addComment(@RequestBody Map<String,String> payload) {


		return new ResponseEntity<Comment>(pService.addComment(payload),HttpStatus.CREATED);
	}

	
}
