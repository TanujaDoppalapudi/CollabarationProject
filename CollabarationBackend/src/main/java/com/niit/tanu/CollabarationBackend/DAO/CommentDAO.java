package com.niit.tanu.CollabarationBackend.DAO;

import java.util.List;

import com.niit.tanu.CollabarationBackend.Model.*;

public interface CommentDAO
{
	
	public boolean addBlogComment(BlogComment blogComment);

	public boolean deleteComment(int id);
	
	public List<BlogComment> getBlogComments(String blog_id);
}