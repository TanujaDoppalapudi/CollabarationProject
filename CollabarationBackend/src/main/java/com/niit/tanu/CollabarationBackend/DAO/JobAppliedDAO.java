package com.niit.tanu.CollabarationBackend.DAO;

import java.util.List;

import com.niit.tanu.CollabarationBackend.Model.*;



public interface JobAppliedDAO 
{
	
	public boolean applyNew(JobApplied jobApplied);
	
	public List<JobApplied> listByUser(String username);
	
	public List<JobApplied> listByCompany();
	
}
