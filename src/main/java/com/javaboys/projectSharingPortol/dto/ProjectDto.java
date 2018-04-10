package com.javaboys.projectSharingPortol.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.javaboys.projectSharingPortol.model.User;

public class ProjectDto implements Serializable{
	private String title; 
	private String projectLocation;
	private String description;
	private String screenshots;
	private String documentation;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProjectLocation() {
		return projectLocation;
	}
	public void setProjectLocation(String project) {
		this.projectLocation = project;
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
}
