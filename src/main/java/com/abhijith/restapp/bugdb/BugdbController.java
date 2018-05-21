package com.abhijith.restapp.bugdb;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhijith.restapp.aop.UserTokenRequired;
import com.abhijith.restapp.model.User;
import com.abhijith.restapp.service.TicketService;
import com.abhijith.restapp.service.UserService;
import com.abhijith.restapp.util.Util;

@RestController
@RequestMapping("/ticket")
public class BugdbController {
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	TicketService ticketService;
	
	
	@ResponseBody
	@UserTokenRequired
	@RequestMapping(value = "", method = RequestMethod.POST)
	public <T> T addTicket(			
			@RequestParam(value="content") String content,			
			HttpServletRequest request
			) {
		User user = userService.getUserByToken(request.getHeader("token"));		
		ticketService.addTicket(user.getUserid(), content, 2, 1);		
		
		return Util.getSuccessResult(); 
	}
	
	
	@ResponseBody
	@RequestMapping("/my/tickets")
	public Map<String, Object> getMyTickets(
			HttpServletRequest request
			) {
		User user = userService.getUserByToken(request.getHeader("token"));
		if(user == null){
			return Util.getUserNotAvailableError();
		}
		return Util.getSuccessResult(ticketService.getMyTickets(user.getUserid()));
	}
	
	

}
