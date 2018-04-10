package com.javaboys.projectSharingPortol.response;

import java.io.Serializable;
import java.util.List;

import com.javaboys.projectSharingPortol.utility.LoginStatus;
import com.javaboys.projectSharingPortol.utility.Role;

public class UserResponse implements Serializable {
	private Long id;
	private String fullname;
	private String email;
	private String contact;
	private String username;
	private String password;
	private String profilePic;
	private String token;
	private LoginStatus status;
	private Role role;
	private List<Long> project;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LoginStatus getStatus() {
		return status;
	}
	public void setStatus(LoginStatus status) {
		this.status = status;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Long> getProject() {
		return project;
	}
	public void setProject(List<Long> project) {
		this.project = project;
	}
}
