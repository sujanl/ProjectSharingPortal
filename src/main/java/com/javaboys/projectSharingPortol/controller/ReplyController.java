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

import com.javaboys.projectSharingPortol.dto.ReplyDto;
import com.javaboys.projectSharingPortol.response.ReplyResponse;
import com.javaboys.projectSharingPortol.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	/*@RequestMapping(method = RequestMethod.)
	public ResponseEntity<Object> Replies(){
		return new ResponseEntity<Object>(HttpStatus.OK);
	}*/
	@Autowired
	ReplyService replyService;

	@RequestMapping(value = "/{commentId}/{userId}", method = RequestMethod.POST)
	public ResponseEntity<Object> postReplies(@RequestBody ReplyDto replyDto, @RequestParam Long commentId, @RequestParam Long userId){
		replyService.addReply(replyDto, commentId,userId );
		return new ResponseEntity<Object>("reply posted", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{replyId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getReplies(@PathVariable Long replyId){
		ReplyResponse response = replyService.getReply(replyId);
		Map<Object,Object> responseMap = new HashMap<Object,Object>();
		responseMap.put("reply id:"+replyId, response);
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/of{commentId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getRepliesOfComment(@PathVariable Long commentId){
		List<ReplyResponse> response = replyService.getRepliesOfComment(commentId);
		Map<Object,Object> responseMap = new HashMap<Object,Object>();
		responseMap.put("Replies of comment:"+commentId, response);
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{replyId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteReply(@PathVariable long replyId){
		replyService.deleteReply(replyId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
