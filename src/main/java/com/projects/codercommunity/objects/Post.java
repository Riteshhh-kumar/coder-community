package com.projects.codercommunity.objects;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	private Boolean ispublic;
	private String user;
	private String description;
	@Id
	private String id;
	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	private List<Comment> comments;
	private List<String> tags;
	private LocalDateTime date;
	public Boolean getIspublic() {
		return ispublic;
	}

	public void setIspublic(Boolean ispublic) {
		this.ispublic = ispublic;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	public Boolean isIspublic() {
		return this.ispublic;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<String> getTags() {
		return this.tags;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String Id) {
		this.id = Id;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
}

