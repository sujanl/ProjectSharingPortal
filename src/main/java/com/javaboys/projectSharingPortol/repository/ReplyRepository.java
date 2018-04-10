package com.javaboys.projectSharingPortol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaboys.projectSharingPortol.model.Comment;
import com.javaboys.projectSharingPortol.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

	List<Reply> findByComment(Comment comment);

}
