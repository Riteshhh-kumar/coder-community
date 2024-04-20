package com.projects.codercommunity.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.codercommunity.objects.User;
import com.projects.codercommunity.objects.UserProfile;
import com.projects.codercommunity.repositories.UserProfileRepository;
import com.projects.codercommunity.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserProfileRepository userProfileRepository;

	public User login(Map<String, String> payload) {
		User user;
		user = userRepository.findUserByUsername(payload.get("username"));
		if (user == null) {
			user = userRepository.findUserByEmail(payload.get("email"));
		}
		if (user != null) {
			if (payload.get("password").equals(user.getPassword())) {
				return user;
			}
		}
		return user = null;
	}

	public User register(Map<String, String> payload) {
		User user;
		user = userRepository.findUserByUsername(payload.get("username"));
		if (user == null) {
			user = userRepository.findUserByEmail(payload.get("email"));
		}
		if (user == null) {
			UserProfile userProfile = new UserProfile();
			user = new User();
			user.setEmail(payload.get("email"));
			user.setUsername(payload.get("username"));
			user.setPassword(payload.get("password"));
			userProfile.setUsername(payload.get("username"));
			userProfile.setName(payload.get("name"));
			userProfile.setEmail(payload.get("email"));
			userProfile.setPhone(payload.get("phone"));
			userProfile.setBio(payload.get("bio"));
			try {
				userProfile.setBio(payload.get("website"));				
			}
			catch(Exception e) {		
			}
			userProfileRepository.insert(userProfile);
			userRepository.insert(user);
			return user;
		}
		return user=null;
	}

}
