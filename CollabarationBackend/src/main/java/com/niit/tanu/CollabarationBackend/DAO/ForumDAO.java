package com.niit.tanu.CollabarationBackend.DAO;


import java.util.List;

import com.niit.tanu.CollabarationBackend.Model.*;

public interface ForumDAO 
{
	public boolean addForum(ForumPart forumPart);
	public boolean updateForum(ForumPart forumPart);	
	public boolean deleteForum(ForumPart forumPart);
	public ForumPart getForum(String title);
	public List<ForumPart> getForumByUser(String username);
	public List<ForumPart> getAllForums();

}