package com.javaboys.projectSharingPortol.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.javaboys.projectSharingPortol.model.Comment;
import com.javaboys.projectSharingPortol.model.User;

public class ProjectResponse implements Serializable {
	private String title; 
	private String project;
	private String description;
	private String screenshots;
	private String documentation;
	private Date addedDateTime;
	private Date updatedDateTime;
	private String user;
	private List<Long> comment;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getScreenshots() {
		return screenshots;
	}
	public void setScreenshots(String screenshots) {
		this.screenshots = screenshots;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	public Date getAddedDateTime() {
		return addedDateTime;
	}
	public void setAddedDateTime(Date addedDateTime) {
		this.addedDateTime = addedDateTime;
	}
	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public List<Long> getComment() {
		return comment;
	}
	public void setComment(List<Long> comment) {
		this.comment = comment;
	}
}
