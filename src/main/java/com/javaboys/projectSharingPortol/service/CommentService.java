package com.javaboys.projectSharingPortol.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaboys.projectSharingPortol.dto.CommentDto;
import com.javaboys.projectSharingPortol.model.Comment;
import com.javaboys.projectSharingPortol.model.Project;
import com.javaboys.projectSharingPortol.model.Reply;
import com.javaboys.projectSharingPortol.repository.CommentRepository;
import com.javaboys.projectSharingPortol.repository.ProjectRepository;
import com.javaboys.projectSharingPortol.repository.ReplyRepository;
import com.javaboys.projectSharingPortol.repository.UserRepository;
import com.javaboys.projectSharingPortol.response.CommentResponse;
import com.javaboys.projectSharingPortol.response.CommentUpdateResponse;

@Service
public class CommentService {
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	ReplyRepository replyRepository;
	@Autowired
	UserRepository userRepository;
	
	public void addComment(Long userId, Long projectId, CommentDto commentDto) {
		Project project = projectRepository.getOne(projectId);
		Comment comment = new Comment();
		comment.setComment(commentDto.getComment());
		comment.setUser(userRepository.getOne(userId));
		comment.setProject(project);
		
		commentRepository.save(comment);
	}
	
	public CommentResponse getComment(Long commentId) {
		Comment comment = commentRepository.getOne(commentId);
		CommentResponse commentResponse = new CommentResponse();
		commentResponse.setAddedBy(userRepository.findByComment(comment).getUsername());
		commentResponse.setComment(comment.getComment());
		commentResponse.setAddedDate(comment.getAddedDate());
		commentResponse.setUpdateDate(comment.getUpdatedDate());
		commentResponse.setProjectId(projectRepository.findByComment(comment).getId());
		//get list  of reply id related to the comment 
		List<Long> replyIdList = new ArrayList<>();
		List<Reply> replyList = comment.getReply();
		for(Reply tempReplies:replyList) {
			replyIdList.add(tempReplies.getId());
		}
		commentResponse.setReplies(replyIdList);
		commentResponse.setId(commentId);
		
		return commentResponse;
	}

	public List<CommentResponse> getCommentOfProject(Long projectId) {
		Project project = projectRepository.getOne(projectId);
		List<Comment> commentList = commentRepository.findByProject(project);
		List<CommentResponse> commentResponseList = new ArrayList<>();
		for(Comment tempComment:commentList) {
			CommentResponse tempResponse = new CommentResponse();
			tempResponse.setAddedBy(userRepository.findByComment(tempComment).getUsername());
			tempResponse.setComment(tempComment.getComment());
			tempResponse.setAddedDate(tempComment.getAddedDate());
			tempResponse.setUpdateDate(tempComment.getUpdatedDate());
			tempResponse.setId(tempComment.getId());
			tempResponse.setProjectId(projectId);
				
			List<Long> replyIdList = new ArrayList<>();
			List<Reply> replyList = tempComment.getReply();
			for(Reply tempReplies:replyList) {
				replyIdList.add(tempReplies.getId());
			}
			tempResponse.setReplies(replyIdList);
				
			commentResponseList.add(tempResponse);
		}
		return commentResponseList;
	}

	public void deleteComment(Long commentId) {
		//delete replies related to comment of id 'commentId'
		List<Reply> replyList = replyRepository.findByComment(commentRepository.getOne(commentId));
		for(Reply tempReply:replyList) {
			replyRepository.deleteById(tempReply.getId());
		}
		//delete comment of id 'commentId'
		commentRepository.deleteById(commentId);
		
	}

	public CommentUpdateResponse updateComment(Long commentId, String newComment) {
		//update old comment with new comment
		Comment comment = commentRepository.getOne(commentId);
		comment.setComment(newComment);
		commentRepository.save(comment);
		
		CommentUpdateResponse commentResponse =new CommentUpdateResponse();
		commentResponse.setComment(comment.getComment());
		commentResponse.setAddedBy(userRepository.findByComment(comment).getUsername());
		commentResponse.setAddedDate(comment.getAddedDate());
		commentResponse.setUpdatedDate(comment.getUpdatedDate());
		
		return commentResponse;
	}


}
