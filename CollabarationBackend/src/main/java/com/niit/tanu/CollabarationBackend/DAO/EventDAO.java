package com.niit.tanu.CollabarationBackend.DAO;

import java.util.List;

import com.niit.tanu.CollabarationBackend.Model.*;

public interface EventDAO
{
	public boolean addEvent(Event event);
	
	public boolean deleteEvent(int id);
	
	public Event getEvent(int id);
	
	public List<Event> listEvent();
	
}
