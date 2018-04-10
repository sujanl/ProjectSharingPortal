package com.javaboys.projectSharingPortol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaboys.projectSharingPortol.model.Comment;
import com.javaboys.projectSharingPortol.model.Project;
import com.javaboys.projectSharingPortol.model.User;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	List<Project> findByUser(User user);

	Project findByComment(Comment comment);

}
