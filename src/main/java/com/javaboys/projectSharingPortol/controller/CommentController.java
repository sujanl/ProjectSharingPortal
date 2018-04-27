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

import com.javaboys.projectSharingPortol.dto.CommentDto;
import com.javaboys.projectSharingPortol.response.CommentResponse;
import com.javaboys.projectSharingPortol.response.CommentUpdateResponse;
import com.javaboys.projectSharingPortol.service.CommentService;
//nothing
@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/{projectId}/{userId}", method = RequestMethod.POST)
	public ResponseEntity<Object> postComment(@PathVariable Long userId,@RequestBody CommentDto commentDto, @PathVariable Long projectId){
		commentService.addComment(userId, projectId,commentDto);
		return new ResponseEntity<Object>("Commented",HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/{commentId}",method = RequestMethod.GET)
	public ResponseEntity<Object> getComment(@PathVariable Long commentId){
		CommentResponse response = commentService.getComment(commentId);
		Map<Object,Object> responseMap = new HashMap<Object,Object>();
		responseMap.put("Comment of id:"+commentId, response);
		return new ResponseEntity<Object>(responseMap,HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/{projectId}/comment",method = RequestMethod.GET)
	public ResponseEntity<Object> getCommentOfProject(@PathVariable Long projectId){
		List<CommentResponse> response = commentService.getCommentOfProject(projectId);
		Map<Object,Object> responseMap = new HashMap<Object,Object>();
		responseMap.put("Comments of project:"+projectId, response);
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/{commentId}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteComment(@RequestParam Long commentId){
		commentService.deleteComment(commentId);
		return new ResponseEntity<Object>("Comment deleted",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{commentId}",method = RequestMethod.PUT)
	public ResponseEntity<Object> putComment(@PathVariable Long commentId, @RequestParam String newComment){
		CommentUpdateResponse response = commentService.updateComment(commentId, newComment);
		Map<Object,Object> responseMap = new HashMap<Object,Object>();
		responseMap.put("Comment updated", response);
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
}
