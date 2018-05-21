package com.abhijith.restapp.bugdb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhijith.restapp.model.User;
import com.abhijith.restapp.service.SecurityService;
import com.abhijith.restapp.service.UserService;
import com.abhijith.restapp.util.Util;


@RestController
@RequestMapping(value="/user")
public class BugdbUserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SecurityService securityService;
	
	@ResponseBody
	@RequestMapping("")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/register/customer", method=RequestMethod.POST)
	public Map<String, Object> registerCustomer(@RequestParam(value="username") String username,
												@RequestParam(value="password") String password){
		userService.createUser(username, password, 1);
		
		return Util.getSuccessResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "/register/admin", method = RequestMethod.POST)
	public Map<String, Object> registerAdmin(			
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password
		) {
		
		userService.createUser(username, password, 3);
		
		return Util.getSuccessResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "/register/csr", method = RequestMethod.POST)
	public Map<String, Object> registerCSR(			
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password
		) {		
		
		userService.createUser(username, password, 2);
		return Util.getSuccessResult();
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/login/customer", method = RequestMethod.POST)
	public Map<String, Object> loginCustomer(			
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password
		) {

		User user = userService.getUser(username, password, 1);
		
		if(user == null){
			return Util.getUserNotAvailableError();
		}
		
		String subject = user.getUserid()+"="+user.getUsertype();
		String token = securityService.createToken(subject, (15 * 1000 * 60)); // 15 mins expiry time
		
		return Util.getSuccessResult(token);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/login/admin", method = RequestMethod.POST)
	public Map<String, Object> loginAdmin(			
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password
		) {
		
		User user = userService.getUser(username, password, 3);
		
		if(user == null){						
			return Util.getUserNotAvailableError();
		}
		
		String subject = user.getUserid()+"="+user.getUsertype();
		String token = securityService.createToken(subject, (15 * 1000 * 60)); // 15 mins expiry time
		
		return Util.getSuccessResult(token);		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/login/csr", method = RequestMethod.POST)
	public Map<String, Object> loginCSR(			
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password
		) {
		
		User user = userService.getUser(username, password, 2);
		
		if(user == null){
			return Util.getUserNotAvailableError();
		}
		
		String subject = user.getUserid()+"="+user.getUsertype();
		String token = securityService.createToken(subject, (15 * 1000 * 60)); // 15 mins expiry time

		return Util.getSuccessResult(token);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
