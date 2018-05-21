package com.abhijith.restapp.service;

import java.util.List;

import com.abhijith.restapp.model.Ticket;
import com.abhijith.restapp.model.User;

public interface TicketService {

	List<Ticket> getAllTickets();
	
	List<Ticket> getMyTickets(Integer creatorid);
	
	void deleteMyTicket(Integer userid, Integer ticketid);
	
	Ticket getTicket(Integer creatorid, Integer ticketid);
	
	Ticket getTicket(Integer ticketid);
	
	void addTicket(Integer creatorid, String content, Integer severity, Integer status);
	
	void updateTicket(Integer ticketid, String content, Integer severity, Integer status);
	
	void deleteTickets(User user, String ticketids);
}
