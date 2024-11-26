package com.projects.codercommunity.objects;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "UserProfile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
	private String username;
	private String name;
	private String email;
	private String phone;
	private String bio;
	private String website;
	private List<String> posts;
	private List<String> communities;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public List<String> getPosts() {
		return posts;
	}
	public void setPosts(List<String> posts) {
		this.posts = posts;
	}
	public List<String> getCommunities() {
		return communities;
	}
	public void setCommunities(List<String> communities) {
		this.communities = communities;
	}

}
