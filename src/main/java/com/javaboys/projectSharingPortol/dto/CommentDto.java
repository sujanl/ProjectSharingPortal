package com.javaboys.projectSharingPortol.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CommentDto implements Serializable {
	private String comment;

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
