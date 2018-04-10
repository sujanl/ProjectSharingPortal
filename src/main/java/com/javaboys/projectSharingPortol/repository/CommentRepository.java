package com.javaboys.projectSharingPortol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaboys.projectSharingPortol.model.Comment;
import com.javaboys.projectSharingPortol.model.Project;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByProject(Project project);

}
