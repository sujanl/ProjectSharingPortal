package com.javaboys.projectSharingPortol.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaboys.projectSharingPortol.dto.ReplyDto;
import com.javaboys.projectSharingPortol.model.Reply;
import com.javaboys.projectSharingPortol.model.User;
import com.javaboys.projectSharingPortol.repository.CommentRepository;
import com.javaboys.projectSharingPortol.repository.ReplyRepository;
import com.javaboys.projectSharingPortol.repository.UserRepository;
import com.javaboys.projectSharingPortol.response.ReplyResponse;

@Service
public class ReplyService {
	@Autowired
	ReplyRepository replyRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CommentRepository commentRepository;

	public void addReply(ReplyDto replyDto, Long commentId, Long userId) {
		Reply reply = new Reply();
		reply.setReply(replyDto.getReply());
		reply.setUser(userRepository.getOne(userId));
		reply.setComment(commentRepository.getOne(commentId));
		
		replyRepository.save(reply);
	}

	public ReplyResponse getReply(Long replyId) {
		Reply reply = replyRepository.getOne(replyId);
		User user = userRepository.findByReply(reply);
		ReplyResponse replyResponse = new ReplyResponse();
		replyResponse.setAddedBy(user.getUsername());
		replyResponse.setAddedDate(reply.getDate());
		replyResponse.setReply(reply.getReply());
		
		return replyResponse;
	}

	public List<ReplyResponse> getRepliesOfComment(Long commentId) {
		List<ReplyResponse> replyResponseList = new ArrayList<>();
	
		List<Reply> replyList = replyRepository.findByComment(commentRepository.getOne(commentId));
		for(Reply tempReply:replyList) {
			ReplyResponse tempResponse = new ReplyResponse();
			tempResponse.setAddedBy(userRepository.getOne(tempReply.getUser().getId()).getUsername());
			tempResponse.setAddedDate(tempReply.getDate());
			tempResponse.setReply(tempReply.getReply());
			replyResponseList.add(tempResponse);
		}
		return replyResponseList;
	}

	public void deleteReply(long replyId) {
		replyRepository.deleteById(replyId);
	}

}
