package com.javaboys.projectSharingPortol.controller;

import java.util.HashMap;
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

import com.javaboys.projectSharingPortol.dto.UserDto;
import com.javaboys.projectSharingPortol.dto.UserUpdateDto;
import com.javaboys.projectSharingPortol.response.UserResponse;
import com.javaboys.projectSharingPortol.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	
	UserService userService;
	
	@RequestMapping(method =RequestMethod.POST)
	public ResponseEntity<Object> postUser(@RequestBody UserDto userDto){
		userService.addUser(userDto);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{userId}", method =RequestMethod.GET)
	public ResponseEntity<Object> getUser(@PathVariable Long userId){
		UserResponse response = userService.readUser(userId);
		Map<Object,Object> responseMap = new HashMap<Object,Object>();
		responseMap.put("User", response);
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{userId}", method =RequestMethod.PUT)
	public ResponseEntity<Object> putUser(@RequestParam Long userId, @RequestBody UserUpdateDto userUpdateDto){
		userService.updateUser(userId, userUpdateDto);
		return new ResponseEntity<Object>("updated",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{userId}", method =RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@RequestParam Long userId){
		userService.deleteUser(userId);
		return new ResponseEntity<Object>("DELETED",HttpStatus.OK);
	}
}
