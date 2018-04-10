package com.javaboys.projectSharingPortol.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaboys.projectSharingPortol.dto.UserDto;
import com.javaboys.projectSharingPortol.dto.UserUpdateDto;
import com.javaboys.projectSharingPortol.model.Project;
import com.javaboys.projectSharingPortol.model.User;
import com.javaboys.projectSharingPortol.repository.ProjectRepository;
import com.javaboys.projectSharingPortol.repository.UserRepository;
import com.javaboys.projectSharingPortol.response.UserResponse;
import com.javaboys.projectSharingPortol.utility.GenerateToken;
import com.javaboys.projectSharingPortol.utility.LoginStatus;
import com.javaboys.projectSharingPortol.utility.PasswordEncryptDecrypt;
import com.javaboys.projectSharingPortol.utility.Role;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProjectRepository projectRepository;
	
	public void addUser(UserDto userDto) {
		User user = new User();
		/*if(userRepository.findByUsername(userDto.getUsername()) != null) {
			throw new ExceptionHandler(userDto.getUsername()+", username already exist.");
		}*/
		user.setContact(userDto.getContact());
		user.setEmail(userDto.getEmail());
		user.setFullname(userDto.getFullname());
		user.setPassword(PasswordEncryptDecrypt.doEncrypt(userDto.getPassword()));
		user.setProfilePic(userDto.getProfilePic());
		user.setToken(GenerateToken.generateToken());
		user.setStatus(LoginStatus.LOGGED_OUT);
		user.setUsername(userDto.getUsername());
		user.setRole(Role.USER);
		
		userRepository.save(user);
	}

	public UserResponse readUser(Long userId) {
		User user = userRepository.getOne(userId);
		UserResponse userResponse = new UserResponse();
		userResponse.setContact(user.getContact());
		userResponse.setEmail(user.getEmail());
		userResponse.setFullname(user.getFullname());
		userResponse.setId(user.getId());
		userResponse.setPassword(user.getPassword());
		userResponse.setProfilePic(user.getProfilePic());
		userResponse.setRole(user.getRole());
		userResponse.setStatus(user.getStatus());
		userResponse.setToken(user.getToken());
		userResponse.setUsername(user.getUsername());
		
		List<Long> projectIdList  = new ArrayList<>();
		List<Project> projectList = projectRepository.findByUser(user);
		for(Project tempProject:projectList) {
			projectIdList.add(tempProject.getId());
		}
		userResponse.setProject(projectIdList);
		return userResponse;
	}


	public void updateUser(Long userId, UserUpdateDto userDto) {
		User user = userRepository.getOne(userId);
		
		user.setContact(userDto.getContact());
		user.setEmail(userDto.getEmail());
		user.setFullname(userDto.getFullname());
		user.setPassword(userDto.getPassword());
		user.setProfilePic(userDto.getProfilePic());
		userRepository.save(user);
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

}
