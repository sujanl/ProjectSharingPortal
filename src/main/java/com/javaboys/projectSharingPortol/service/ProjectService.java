package com.javaboys.projectSharingPortol.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaboys.projectSharingPortol.dto.ProjectDto;
import com.javaboys.projectSharingPortol.model.Comment;
import com.javaboys.projectSharingPortol.model.Project;
import com.javaboys.projectSharingPortol.model.Reply;
import com.javaboys.projectSharingPortol.model.User;
import com.javaboys.projectSharingPortol.repository.CommentRepository;
import com.javaboys.projectSharingPortol.repository.ProjectRepository;
import com.javaboys.projectSharingPortol.repository.ReplyRepository;
import com.javaboys.projectSharingPortol.repository.UserRepository;
import com.javaboys.projectSharingPortol.response.ProjectResponse;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	ReplyRepository replyRepository;
	
	public void addProject(ProjectDto projectDto, Long userId) {
		Project project = new Project();
		project.setDescription(projectDto.getDescription());
		project.setDocumentation(projectDto.getDocumentation());
		project.setProjectLocation(projectDto.getProjectLocation());
		project.setScreenshots(projectDto.getScreenshots());
		project.setTitle(projectDto.getTitle());
		project.setUser(userRepository.getOne(userId));
		
		projectRepository.save(project);	
	}
	

	public void deleteProject(Long projectId) {
		List<Comment> commentList = commentRepository.findByProject(projectRepository.getOne(projectId));
		//delete the comments related to the project
		for(Comment tempComment:commentList) {
			List<Reply> replyList = replyRepository.findByComment(tempComment);
			//delete the replies of comments related to the project
			for(Reply tempReply:replyList) {
				replyRepository.delete(tempReply);
			}
			commentRepository.delete(tempComment);
		}
		projectRepository.deleteById(projectId);
		
	}
	

	public ProjectResponse getProject(Long projectId) {
		//get project of id 'projectId'
		Project project = projectRepository.getOne(projectId);
		//getting and setting data associated with project
		ProjectResponse projectResponse = new ProjectResponse();
		projectResponse.setAddedDateTime(project.getAddedDateTime());
		projectResponse.setDescription(project.getDescription());
		projectResponse.setDocumentation(project.getDocumentation());
		projectResponse.setProject(project.getProjectLocation());
		projectResponse.setScreenshots(project.getScreenshots());
		projectResponse.setTitle(project.getTitle());
		projectResponse.setUpdatedDateTime(project.getUpdatedDateTime());
		projectResponse.setUser(userRepository.findByProject(project).getUsername());
		//get comment IDs only associated with the project
		List<Long> comment = new ArrayList<>();
		List<Comment> commentList = commentRepository.findByProject(project);
		for(Comment tempComment:commentList) {
			comment.add(tempComment.getId());
		}
		projectResponse.setComment(comment);
		
		return projectResponse;
	}

	public List<ProjectResponse> getAllProject() {
		List<Project> projectList = projectRepository.findAll();
		List<ProjectResponse> projectResponseList = new ArrayList<>();
		for(Project tempProject:projectList) {
			ProjectResponse projectResponse = new ProjectResponse();
			projectResponse.setAddedDateTime(tempProject.getAddedDateTime());
			projectResponse.setDescription(tempProject.getDescription());
			projectResponse.setDocumentation(tempProject.getDocumentation());
			projectResponse.setProject(tempProject.getProjectLocation());
			projectResponse.setScreenshots(tempProject.getScreenshots());
			projectResponse.setTitle(tempProject.getTitle());
			projectResponse.setUpdatedDateTime(tempProject.getUpdatedDateTime());
			projectResponse.setUser(userRepository.findByProject(tempProject).getUsername());
			List<Long> comment = new ArrayList<>();
			List<Comment> commentList = commentRepository.findByProject(tempProject);
			for(Comment tempComment:commentList) {
				comment.add(tempComment.getId());
			}
			projectResponse.setComment(comment);
			
			projectResponseList.add(projectResponse);
		}
		return projectResponseList;
	}

	public List<ProjectResponse> getProjectByUser(Long userId) {
		User user = userRepository.getOne(userId);
		List<Project> projectList = projectRepository.findByUser(user);
		List<ProjectResponse> responseList = new ArrayList<>();
		for(Project tempProject: projectList) {
			ProjectResponse projectResponse = new ProjectResponse();
			projectResponse.setAddedDateTime(tempProject.getAddedDateTime());
			projectResponse.setDescription(tempProject.getDescription());
			projectResponse.setDocumentation(tempProject.getDocumentation());
			projectResponse.setProject(tempProject.getProjectLocation());
			projectResponse.setScreenshots(tempProject.getScreenshots());
			projectResponse.setTitle(tempProject.getTitle());
			projectResponse.setUpdatedDateTime(tempProject.getUpdatedDateTime());
			projectResponse.setUser(userRepository.findByProject(tempProject).getUsername());
			List<Long> comment = new ArrayList<>();
			List<Comment> commentList = commentRepository.findByProject(tempProject);
			for(Comment tempComment:commentList) {
				comment.add(tempComment.getId());
			}
			projectResponse.setComment(comment);
			
			responseList.add(projectResponse);
		}
		return responseList;
	}

}
