package com.javaboys.projectSharingPortol.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.javaboys.projectSharingPortol.model.Project;

public class CommentResponse implements Serializable {
	private Long id;
	private Long projectId;
	private String comment;
	private String addedBy;
	private Date addedDate;
	private Date updateDate;
	private List<Long> replies;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long project) {
		this.projectId = project;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public List<Long> getReplies() {
		return replies;
	}
	public void setReplies(List<Long> replies) {
		this.replies = replies;
	}
	
	
}
