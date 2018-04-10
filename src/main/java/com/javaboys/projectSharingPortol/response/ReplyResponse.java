package com.javaboys.projectSharingPortol.response;

import java.io.Serializable;
import java.util.Date;

public class ReplyResponse implements Serializable {
	private String reply;
	private Date addedDate;
	private String addedBy;
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
}
