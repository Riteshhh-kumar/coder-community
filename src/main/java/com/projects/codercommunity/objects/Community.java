package com.projects.codercommunity.objects;

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
	private String[] members;
	private Chat[] chats;
	private Post[] posts;
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
	public String[] getMembers() {
		return members;
	}
	public void setMembers(String[] members) {
		this.members = members;
	}
	public Chat[] getChats() {
		return chats;
	}
	public void setChats(Chat[] chats) {
		this.chats = chats;
	}
	public Post[] getPosts() {
		return posts;
	}
	public void setPosts(Post[] posts) {
		this.posts = posts;
	}
	
}
