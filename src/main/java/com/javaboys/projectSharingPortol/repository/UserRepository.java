package com.javaboys.projectSharingPortol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaboys.projectSharingPortol.model.Comment;
import com.javaboys.projectSharingPortol.model.Project;
import com.javaboys.projectSharingPortol.model.Reply;
import com.javaboys.projectSharingPortol.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	User findByProject(Project project);

	User findByReply(Reply reply);

	User findByComment(Comment comment);

}
