package com.projects.codercommunity.objects;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Community")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Community {
	private String name;
	private String description;
	private String logo;
	private List<String> members;
	private List<Post> posts;

	public List<String> getMembers() {
		return this.members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
