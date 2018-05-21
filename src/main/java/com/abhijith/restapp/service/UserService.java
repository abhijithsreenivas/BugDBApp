package com.abhijith.restapp.service;

import java.util.List;

import com.abhijith.restapp.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	User getUser(Integer userid);
	
	User getUser(String username, String password, Integer usertype);
	
	void createUser(String username, String password, Integer usertype);
	
	void createUser(Integer userid, String username, Integer usertype);
	
	void updateUser(Integer userid, String username);
	
	void deleteUser(Integer userid);
	
	
	
	
	User getUserByToken(String token);

}
