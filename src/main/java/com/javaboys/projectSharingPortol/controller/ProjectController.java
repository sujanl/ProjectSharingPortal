package com.javaboys.projectSharingPortol.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaboys.projectSharingPortol.dto.ProjectDto;
import com.javaboys.projectSharingPortol.model.Project;
import com.javaboys.projectSharingPortol.response.ProjectResponse;
import com.javaboys.projectSharingPortol.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/{userId}/addproject", method = RequestMethod.POST)
	public ResponseEntity<Object> createProject(@RequestBody ProjectDto projectDto, @PathVariable Long userId){
		projectService.addProject(projectDto, userId);
		return new ResponseEntity<Object>("Project added",HttpStatus.CREATED);
	}
	

	@RequestMapping(value="/deleteproject", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProject(@RequestParam Long projectId){
		projectService.deleteProject(projectId);
		return new ResponseEntity<Object>("Deleted",HttpStatus.OK);
	}
	
	@RequestMapping(value="/{projectId}", method = RequestMethod.GET)
	public ResponseEntity<Object> readProject(@RequestParam Long projectId){
		ProjectResponse response = projectService.getProject(projectId);
		Map<Object,Object> responseMap = new HashMap<Object,Object>();
		responseMap.put("Project", response);
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
	}
	
	@RequestMapping(value="/viewallproject", method = RequestMethod.GET)
	public ResponseEntity<Object> readAllProject(){
		List<ProjectResponse> project = projectService.getAllProject();
		Map<Object,Object> responseMap = new HashMap<Object,Object>();
		responseMap.put("Project", project);
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
	}
	
	@RequestMapping(value="/viewproject/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Object> readProjectByUser(@RequestParam Long userId){
		List<ProjectResponse> project = projectService.getProjectByUser(userId);
		Map<Object,Object> responseMap = new HashMap<Object,Object>();
		responseMap.put("Project", project);
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
	}
}
