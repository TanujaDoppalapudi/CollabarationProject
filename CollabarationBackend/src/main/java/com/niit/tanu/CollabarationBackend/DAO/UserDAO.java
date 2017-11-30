package com.niit.tanu.CollabarationBackend.DAO;


import java.util.List;
import com.niit.tanu.CollabarationBackend.Model.*;

public interface UserDAO 
{

public boolean addUser(UserPart userPart);
	
	public boolean validateUser(String userName, String password);
	
	public UserPart getUser(String userName);
	
	public List<UserPart> getUserList();
	
	public boolean deleteUser(UserPart userPart);
	
}